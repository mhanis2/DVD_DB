package sk.maha.postgre;

import java.sql.SQLException;
import java.sql.Statement;

public class TableCreation {
	private String userTableQuery = "CREATE TABLE dvd.User(id numeric(10) not null,"
			+ " first_name varchar, last_name varchar,"
			+ " address_street varchar, address_city varchar,"
			+ " address_zip varchar, email varchar, tel_number varchar, primary key(id));";
	private String rentalTableQuery = "CREATE TABLE dvd.Rental(id numeric(10) not null,"
			+ " user_id numeric(10) not null references dvd.User(id), date_from Date,"
			+ " date_to Date, primary key(id));";

	private String dvdTableQuery = "CREATE TABLE dvd.DVD(id numeric(10) not null, "
			+ "rental_id numeric(10) not null references dvd.Rental(id), name varchar, genre dvd.genre,"
			+ " prize_category dvd.prizecategory, count numeric(3), rented_count numeric(3), primary key(id));";
	

	/**
	 * Create empty table 'User'.
	 * 
	 * @param stmt
	 * @throws SQLException
	 */
	public void createUserTable(Statement stmt) throws SQLException {

		stmt.executeUpdate(userTableQuery);
		System.out.println("Table 'User' created.");
		System.out.println();
	}

	/**
	 * Create empty table 'Rental'.
	 * 
	 * @param stmt
	 * @throws SQLException
	 */
	public void createRentalTable(Statement stmt) throws SQLException {

		stmt.executeUpdate(rentalTableQuery);
		System.out.println("Table 'Rental' created.");
		System.out.println();
	}

	/**
	 * Create empty table 'Dvd'.
	 * 
	 * @param stmt
	 * @throws SQLException
	 */
	public void createDvdTable(Statement stmt) throws SQLException {

		stmt.executeUpdate(dvdTableQuery);
		System.out.println("Table 'DVD' created.");
		System.out.println();
	}
}
