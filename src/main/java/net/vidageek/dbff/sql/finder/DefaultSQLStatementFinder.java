package net.vidageek.dbff.sql.finder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import net.vidageek.dbff.sql.SQLStatement;
import net.vidageek.dbff.sql.SQLStatementFinder;
import net.vidageek.dbff.sql.statement.DefaultSQLStatement;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;

/**
 * @author jonasabreu
 * 
 */
final public class DefaultSQLStatementFinder implements SQLStatementFinder {

	private final Pattern pattern;
	private final String path;

	public DefaultSQLStatementFinder(final String path) {
		if ((path == null) || !path.startsWith("/")) {
			throw new IllegalArgumentException("path cannot be null and must start with [/]");
		}
		this.path = path;
		pattern = Pattern.compile(".*?\\.dbff");
	}

	public List<SQLStatement> findAll() {
		List<SQLStatement> list = new ArrayList<SQLStatement>();
		final Reflections reflections = new Reflections("", new ResourcesScanner());
		Set<String> resources = reflections.getResources(pattern);

		for (String resourceName : resources) {
			final String normalizedResource = "/" + resourceName;

			if (normalizedResource.startsWith(path)) {
				list.add(new DefaultSQLStatement(normalizedResource));
			}
		}
		return list;
	}

}
