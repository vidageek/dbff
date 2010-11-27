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

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testThatExecutesAllSqlFound() {
		when(finder.findAll()).thenReturn(Arrays.asList(statement, statement, statement));

		new DataBase(executor, finder).fastForward();

		verify(finder).findAll();
		verify(executor, times(3)).execute(statement);
	}
}
