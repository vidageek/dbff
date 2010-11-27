package net.vidageek.dbff.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.vidageek.dbff.DataBase;
import net.vidageek.dbff.sql.SQLExecutor;
import net.vidageek.dbff.sql.SQLExecutorFactory;
import net.vidageek.dbff.sql.finder.DefaultSQLStatementFinder;

/**
 * @author jonasabreu
 * 
 */
final public class DBFFContextListener implements ServletContextListener {

	private final String DBFF_EXECUTOR = SQLExecutor.class.getName();

	public void contextInitialized(final ServletContextEvent event) {
		new DataBase(SQLExecutorFactory.create((String) event.getServletContext().getAttribute(DBFF_EXECUTOR)),
				new DefaultSQLStatementFinder("/dbff")).fastForward();
	}

	public void contextDestroyed(final ServletContextEvent event) {
	}

}
