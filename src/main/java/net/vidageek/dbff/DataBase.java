package net.vidageek.dbff;

import java.util.List;

import net.vidageek.dbff.sql.SQLExecutor;
import net.vidageek.dbff.sql.SQLStatement;
import net.vidageek.dbff.sql.SQLStatementFinder;

/**
 * @author jonasabreu
 * 
 */
final public class DataBase {

	private final SQLExecutor executor;
	private final SQLStatementFinder finder;

	public DataBase(final SQLExecutor executor, final SQLStatementFinder finder) {
		this.executor = executor;
		this.finder = finder;
	}

	public void fastForward() {
		List<SQLStatement> statements = finder.findAll();
		for (SQLStatement sqlStatement : statements) {
			executor.beforeExecution();
			executor.execute(sqlStatement);
			executor.afterExecution();
		}
	}
}
