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
	private final DBFFManager manager;

	public DataBase(final SQLExecutor executor, final SQLStatementFinder finder, final DBFFManager manager) {
		this.executor = executor;
		this.finder = finder;
		this.manager = manager;
	}

	public void fastForward() {
		List<SQLStatement> statements = finder.findAll(manager.lastVersion());
		for (SQLStatement sqlStatement : statements) {
			executor.execute(sqlStatement);
		}
		manager.update(statements.get(statements.size() - 1).getVersion());
	}
}
