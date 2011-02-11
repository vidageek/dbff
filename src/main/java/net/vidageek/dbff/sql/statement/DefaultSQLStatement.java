package net.vidageek.dbff.sql.statement;

import net.vidageek.dbff.sql.SQLStatement;

/**
 * @author jonasabreu
 * 
 */
final public class DefaultSQLStatement implements SQLStatement {

	private final String sql;

	public DefaultSQLStatement(final String sql) {
		this.sql = sql;
	}

	public String getName() {
		return "";
	}

	public String getSql() {
		return sql;
	}

	public Integer getVersion() {
		return -1;
	}

}
