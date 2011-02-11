package net.vidageek.dbff.sql.hibernate;

import net.vidageek.dbff.sql.statement.DefaultSQLStatement;

import org.junit.Before;
import org.junit.Test;

/**
 * @author jonasabreu
 * 
 */
final public class HibernateSQLExecutorTest {

	private HibernateSQLExecutor executor;

	@Before
	public void setup() {
		executor = new HibernateSQLExecutor();

	}

	@Test
	public void testThatExecutesStatement() {
		executor.execute(new DefaultSQLStatement(""));
	}

}
