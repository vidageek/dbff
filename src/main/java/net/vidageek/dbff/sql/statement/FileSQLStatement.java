package net.vidageek.dbff.sql.statement;

import java.util.Scanner;

import net.vidageek.dbff.exception.DBFFException;
import net.vidageek.dbff.sql.SQLStatement;

/**
 * @author jonasabreu
 * 
 */
final public class FileSQLStatement implements SQLStatement {

	private final String name;
	private final String sql;

	public FileSQLStatement(final String resourceName) {
		try {
			name = resourceName;
			sql = new Scanner(FileSQLStatement.class.getResourceAsStream(resourceName)).useDelimiter("$$").next();
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

	public Integer getVersion() {
		final String substring = name.substring(name.lastIndexOf("/") + 1);
		return new Integer(substring.substring(0, substring.indexOf("-")));
	}

}
