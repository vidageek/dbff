package net.vidageek.dbff;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import net.vidageek.dbff.sql.SQLExecutor;
import net.vidageek.dbff.sql.SQLStatement;
import net.vidageek.dbff.sql.SQLStatementFinder;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author jonasabreu
 * 
 */
final public class DataBaseTest {

	@Mock
	private SQLExecutor executor;

	@Mock
	private SQLStatementFinder finder;

	@Mock
	private SQLStatement statement;

	@Mock
	private DBFFManager manager;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testThatExecutesAllSqlFound() {
		when(manager.lastVersion()).thenReturn(1);
		when(finder.findAll(1)).thenReturn(Arrays.asList(statement, statement, statement));
		when(statement.getVersion()).thenReturn(1);

		new DataBase(executor, finder, manager).fastForward();

		verify(finder).findAll(1);
		verify(executor, times(3)).execute(statement);
		verify(manager).update(1);
	}
}
