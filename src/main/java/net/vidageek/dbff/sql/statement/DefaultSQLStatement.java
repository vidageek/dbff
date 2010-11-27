package net.vidageek.dbff.sql.statement;

import java.util.Scanner;

import net.vidageek.dbff.exception.DBFFException;
import net.vidageek.dbff.sql.SQLStatement;

/**
 * @author jonasabreu
 * 
 */
final public class DefaultSQLStatement implements SQLStatement {

	private final String name;
	private final String sql;

	public DefaultSQLStatement(final String resourceName) {
		try {
			name = resourceName;
			sql = new Scanner(DefaultSQLStatement.class.getResourceAsStream(resourceName)).useDelimiter("$$").next();
		} catch (Exception e) {
			throw new DBFFException("Could not create SQLStatement.", e);
		}
	}

	public String getName() {
		return name;
	}

	public String getSql() {
		return sql;
	}

}
