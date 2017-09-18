package sk.maha.postgre;

import java.sql.SQLException;
import java.sql.Statement;

public class SchemaCreation {
	private String schema = "CREATE SCHEMA dvd;";

	/**
	 * Create schema 'Dvd' in database.
	 * 
	 * @param stm
	 * @throws SQLException
	 */
	public void createDvdSchema(Statement stm) throws SQLException {
		stm.executeUpdate(schema);
		System.out.println("Schema 'dvd' created.");
		System.out.println();
	}
}
