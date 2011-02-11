package net.vidageek.dbff.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Assert;

/**
 * @author jonasabreu
 * 
 */
final public class DBAsserts {

	public DBAsserts() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void thereIsNoTable(final String tableName) {
		Assert.assertFalse(tableExists(tableName));
	}

	public void thereIsTable(final String tableName) {
		Assert.assertTrue(tableExists(tableName));
	}

	private boolean tableExists(final String tableName) {
		return new Integer(1)
				.equals(getConnection()
						.prepareStatement(
											"select count(*) from information_schema.tables where table_schema = 'dbff' and table_name = 'dbff_version';").e);
	}

	private Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/", "root", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
