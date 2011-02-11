package net.vidageek.dbff.sql;

import java.util.List;

/**
 * @author jonasabreu
 * 
 */
public interface SQLStatementFinder {

	List<SQLStatement> findAll(Integer integer);

}
