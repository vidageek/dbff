package net.vidageek.dbff.sql;

/**
 * @author jonasabreu
 * 
 */
final public class SQLExecutorFactory {

	@SuppressWarnings("unchecked")
	public static SQLExecutor create(final String className) {
		if (className == null) {
			throw new IllegalArgumentException("classname cannot be null");
		}
		Class<? extends SQLExecutor> type = null;
		try {
			type = (Class<? extends SQLExecutor>) Class.forName(className);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Could not find class [" + className + "].", e);
		}
		try {
			return type.newInstance();
		} catch (InstantiationException e) {
			throw new IllegalArgumentException("Class [" + className + "] should have a no-arg accessible constructor.");
		} catch (IllegalAccessException e) {
			throw new IllegalArgumentException("Class [" + className + "] should have a no-arg accessible constructor.");
		}
	}
}
