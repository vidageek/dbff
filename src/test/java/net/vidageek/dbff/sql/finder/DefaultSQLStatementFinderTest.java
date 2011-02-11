package net.vidageek.dbff.sql.finder;

import java.util.List;

import net.vidageek.dbff.sql.SQLStatement;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jonasabreu
 * 
 */
final public class DefaultSQLStatementFinderTest {

	@Test(expected = IllegalArgumentException.class)
	public void testThatThrowsExceptionIfPathDoesNotBeginWithSlash() {
		new DefaultSQLStatementFinder("anything");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThatThrowsExceptionIfPathIsNull() {
		new DefaultSQLStatementFinder(null);
	}

	@Test
	public void testThatFindAllStatements() {
		List<SQLStatement> list = new DefaultSQLStatementFinder("/dbff").findAll(null);

		Assert.assertEquals(3, list.size());
		Assert.assertEquals("/dbff/1-dbff.dbff", list.get(0).getName());
		Assert.assertEquals("sql goes here", list.get(0).getSql());
		Assert.assertEquals("/dbff/2-dbff.dbff", list.get(1).getName());
		Assert.assertEquals("and here too", list.get(1).getSql());
		Assert.assertEquals("/dbff/101-dbff.dbff", list.get(2).getName());
		Assert.assertEquals("somthing", list.get(2).getSql());
	}

	@Test
	public void testThatOrderUsingVersion() {

	}

}
