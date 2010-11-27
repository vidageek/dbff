package net.vidageek.dbff.sql;

/**
 * @author jonasabreu
 * 
 */
public interface SQLExecutor {

	void execute(SQLStatement sqlStatement);

	void beforeExecution();

	void afterExecution();

}
