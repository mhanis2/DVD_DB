package sk.maha.postgre;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckingTableExistance {
	private String schema = "dvd";
	private String userTable = "user";
	private String rentalTable = "rental";
	private String dvdTable = "dvd";

	/**
	 * Checking if table 'User' exists in database.
	 * 
	 * @param rs
	 * @param dbm
	 * @return true if exists and false if does not exist
	 * @throws SQLException
	 */
	public boolean checkUserTable(ResultSet rs, DatabaseMetaData dbm) throws SQLException {
		boolean find = false;

		rs = dbm.getTables(null, schema, userTable, null);
		if (rs.next()) {
			find = true;
		}
		return find;
	}

	/**
	 * Checking if table 'Rental' exists in database.
	 * 
	 * @param rs
	 * @param dbm
	 * @return true if exists and false if does not exist
	 * @throws SQLException
	 */
	public boolean checkRentalTable(ResultSet rs, DatabaseMetaData dbm) throws SQLException {
		boolean find = false;

		rs = dbm.getTables(null, schema, rentalTable, null);
		if (rs.next()) {
			find = true;
		}
		return find;
	}

	/**
	 * Checking if table 'Dvd' exists in database.
	 * 
	 * @param rs
	 * @param dbm
	 * @return true if exists and false if does not exist
	 * @throws SQLException
	 */
	public boolean checkDvdTable(ResultSet rs, DatabaseMetaData dbm) throws SQLException {
		boolean find = false;

		rs = dbm.getTables(null, schema, dvdTable, null);
		if (rs.next()) {
			find = true;
		}
		return find;
	}
}
