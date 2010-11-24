package net.vidageek.dbff;

import java.util.List;

import net.vidageek.dbff.sql.SQLExecutor;
import net.vidageek.dbff.sql.SqlStatement;
import net.vidageek.dbff.sql.SqlStatementFinder;
import net.vidageek.dbff.sql.finder.DefaultSqlStatementFinder;

/**
 * @author jonasabreu
 * 
 */
final public class DataBase {

	private final SQLExecutor executor;
	private final SqlStatementFinder finder;

	public DataBase(final SQLExecutor executor) {
		this.executor = executor;
		finder = new DefaultSqlStatementFinder();
	}

	public void fastForward() {
		List<SqlStatement> statements = finder.findAll();
		for (SqlStatement sqlStatement : statements) {
			executor.execute(sqlStatement);
		}
	}
}
