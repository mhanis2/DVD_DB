package sk.maha.postgre;

import java.sql.SQLException;
import java.sql.Statement;

public class EnumTypeCreation {

	private String typeGenre = "CREATE TYPE dvd.Genre AS ENUM ('Comedy','Action','Horror',"
			+ "'Sci-Fi','Drama','Musical','Sport','Documentary','Adult')";

	private String typePrizeCategory = "CREATE TYPE dvd.PrizeCategory AS ENUM ('A', 'B','C')";

	/**
	 * Create enumerated type 'Genre'.
	 * 
	 * ('Comedy' 'Action' 'Horror' 'Sci-Fi' 'Drama' 'Musical' 'Sport',
	 * 'Documentary' 'Adult')
	 * 
	 * @param stmt
	 * @throws SQLException
	 */
	public void createGenreType(Statement stmt) throws SQLException {
		stmt.executeUpdate(typeGenre);
		System.out.println("Type 'Genre' created.");
		System.out.println();
	}

	/**
	 * Create enumerated type 'PrizeCategory'.
	 * 
	 * ('A', 'B','C')
	 * 
	 * @param stmt
	 * @throws SQLException
	 */
	public void createPrizeCategoryType(Statement stmt) throws SQLException {
		stmt.executeUpdate(typePrizeCategory);
		System.out.println("Type 'PrizeCategory' created.");
		System.out.println();
	}
}
