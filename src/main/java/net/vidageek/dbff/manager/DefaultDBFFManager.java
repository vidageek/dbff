package net.vidageek.dbff.manager;

import net.vidageek.dbff.DBFFManager;
import net.vidageek.dbff.sql.SQLExecutor;
import net.vidageek.dbff.sql.statement.DefaultSQLStatement;

/**
 * @author jonasabreu
 * 
 */
final public class DefaultDBFFManager implements DBFFManager {

	private final SQLExecutor executor;

	public DefaultDBFFManager(final SQLExecutor executor) {
		this.executor = executor;
	}

	public void update(final Integer version) {
		executor.execute(new DefaultSQLStatement("update dbff_version set version = " + version + ";"));
	}

	public Integer lastVersion() {
		executor.execute(new DefaultSQLStatement("create table 'dbff_version' if not exists ('version' int)"));
		return executor.executeAndReturnInteger(new DefaultSQLStatement("select version from dbff_version limit 1"));
	}

}
