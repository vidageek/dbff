package net.vidageek.dbff.sql.statement;

import net.vidageek.dbff.sql.SQLStatement;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jonasabreu
 * 
 */
final public class FileSQLStatementTest {

	@Test
	public void testThatReadsFromUrl() {
		SQLStatement statement = new FileSQLStatement("/dbff/1-dbff.dbff");

		Assert.assertEquals("/dbff/1-dbff.dbff", statement.getName());
		Assert.assertEquals("sql goes here", statement.getSql());
	}

	@Test
	public void testThatExtractsVersionFromName() {
		SQLStatement statement = new FileSQLStatement("/dbff/101-dbff.dbff");
		Assert.assertEquals(101, statement.getVersion().intValue());
	}

}
