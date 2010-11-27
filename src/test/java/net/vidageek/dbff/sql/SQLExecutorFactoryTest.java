package net.vidageek.dbff.sql;

import net.vidageek.dbff.test.TestSQLExecutor;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jonasabreu
 * 
 */
final public class SQLExecutorFactoryTest {

	@Test(expected = IllegalArgumentException.class)
	public void testThatThrowsExceptionIfClassnameIsNull() {
		SQLExecutorFactory.create(null);
	}

	@Test
	public void testThatReturnsExecutorPassed() {
		Assert.assertEquals(TestSQLExecutor.class, SQLExecutorFactory.create(TestSQLExecutor.class.getName())
				.getClass());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThatThrowsExceptionIfCantFindExecutor() {
		SQLExecutorFactory.create("some.class.that.does.not.exists");
	}

}
