package net.vidageek.dbff.sql.statement;

import net.vidageek.dbff.sql.SQLStatement;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jonasabreu
 * 
 */
final public class DefaultSQLStatementTest {

	@Test
	public void testThatReadsFromUrl() {
		SQLStatement statement = new DefaultSQLStatement("/dbff/1-dbff.dbff");

		Assert.assertEquals("/dbff/1-dbff.dbff", statement.getName());
		Assert.assertEquals("sql goes here", statement.getSql());

	}

}
