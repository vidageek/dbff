package net.vidageek.dbff.sql;

/**
 * @author jonasabreu
 * 
 */
public interface SQLExecutor {

	void execute(SQLStatement statement);

	Integer executeAndReturnInteger(SQLStatement statement);

}
