package sk.maha.postgre;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckingSchemaExistance {
	private String searchingSchema = "dvd";

	/**
	 * Checking if schema 'Dvd' exists in database.
	 * 
	 * @param rs
	 * @param dbm
	 * @return true if exists and false if does not exist
	 * @throws SQLException
	 */
	public boolean checkDvdSchema(ResultSet rs, DatabaseMetaData dbm) throws SQLException {
		boolean find = false;

		rs = dbm.getSchemas();
		while (rs.next()) {
			String schema1 = rs.getString(1);
			if (schema1.equals(searchingSchema)) {
				find = true;
				break;
			}
		}
		return find;
	}
}
