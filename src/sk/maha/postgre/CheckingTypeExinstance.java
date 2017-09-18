package sk.maha.postgre;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckingTypeExinstance {
	private String prizecategory = "prizecategory";
	private String genre = "genre";
	private String typeName = null;

	/**
	 * Checking if enumerated type 'Genre' exists in database.
	 * 
	 * @param rs
	 * @param dbm
	 * @return true if exists and false if does not exist
	 * @throws SQLException
	 */
	public boolean checkGenreType(ResultSet rs, DatabaseMetaData dbm) throws SQLException {
		boolean find = false;

		rs = dbm.getTypeInfo();
		while (rs.next()) {
			typeName = rs.getString("TYPE_NAME");
			if (typeName.equals(genre)) {
				find = true;
				break;
			}
		}
		return find;
	}

	/**
	 * Checking if enumerated type 'PrizeCategory' exists in database.
	 * 
	 * @param rs
	 * @param dbm
	 * @return true if exists and false if does not exist
	 * @throws SQLException
	 */
	public boolean checkPrizeCategoryType(ResultSet rs, DatabaseMetaData dbm) throws SQLException {
		boolean find = false;

		rs = dbm.getTypeInfo();
		while (rs.next()) {
			typeName = rs.getString("TYPE_NAME");
			if (typeName.equals(prizecategory)) {
				find = true;
				break;
			}
		}
		return find;
	}
}
