package net.vidageek.dbff.manager;

import net.vidageek.dbff.DBFFManager;
import net.vidageek.dbff.sql.SQLExecutor;
import net.vidageek.dbff.sql.hibernate.HibernateSQLExecutor;
import net.vidageek.dbff.sql.statement.DefaultSQLStatement;
import net.vidageek.dbff.test.DBAsserts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author jonasabreu
 * 
 */
final public class DefaultDBFFManagerIntegrationTest {

	private DBAsserts assertThat;
	private DBFFManager manager;
	private SQLExecutor executor;

	@Before
	public void setup() {
		executor = new HibernateSQLExecutor();
		assertThat = new DBAsserts(executor);
		manager = new DefaultDBFFManager(executor);
	}

	@After
	public void tearDown() {
		executor.execute(new DefaultSQLStatement("drop table dbff_version;"));
	}

	@Test
	public void testThatCreatesTableIfItDoesNotExists() {
		assertThat.thereIsNoTable("dbff_version");

		Assert.assertNull(manager.lastVersion());

		assertThat.thereIsTable("dbff_version");
	}

	@Test
	public void testThatRecoversLastVersion() {
		setupDB();

		Assert.assertEquals(210, manager.lastVersion().intValue());

	}

	@Test
	public void testThatUpdatesVersion() {
		setupDB();

		manager.update(300);

		Assert.assertEquals(300, manager.lastVersion().intValue());
	}

	private void setupDB() {
		executor.execute(new DefaultSQLStatement("create table 'dbff_version' ('version' int);"));
		executor.execute(new DefaultSQLStatement("insert into dbff_version (version) value (210)"));
	}

}
