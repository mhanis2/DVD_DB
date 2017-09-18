package sk.maha.postgre;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbDemo {
	private static final String CONN = "jdbc:postgresql://localhost:5432/webinar26";
	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String USER_NAME = "marcel";
	private static final String PASSWD = "marcel";

	public static void main(String[] args) {

		TableCreation tableCreation = new TableCreation();
		EnumTypeCreation typeCreation = new EnumTypeCreation();
		SchemaCreation schemaCreation = new SchemaCreation();
		TableFilling fillingTables = new TableFilling();

		CheckingTableExistance checkingTable = new CheckingTableExistance();
		CheckingTypeExinstance checkingType = new CheckingTypeExinstance();
		CheckingSchemaExistance checkingSchema = new CheckingSchemaExistance();

		Connection connection = null;
		Statement statement = null;
		DatabaseMetaData databaseDate = null;
		ResultSet databaseResults = null;

		try {
			Class.forName(DB_DRIVER);
			connection = DriverManager.getConnection(CONN, USER_NAME, PASSWD);
			statement = connection.createStatement();
			databaseDate = connection.getMetaData();

			if (checkingSchema.checkDvdSchema(databaseResults, databaseDate)) {
				System.out.println("Schema 'dvd' exists.");
			} else {
				schemaCreation.createDvdSchema(statement);
			}

			if (checkingType.checkPrizeCategoryType(databaseResults, databaseDate)) {
				System.out.println("Type 'PrizeCategory' already exists.");
				System.out.println();
			} else {
				typeCreation.createPrizeCategoryType(statement);
			}

			if (checkingType.checkGenreType(databaseResults, databaseDate)) {
				System.out.println("Type 'Genre' already exists.");
				System.out.println();
			} else {
				typeCreation.createGenreType(statement);
			}

			if (checkingTable.checkUserTable(databaseResults, databaseDate)) {
				System.out.println("Table 'user' already exists.");
				System.out.println();
			} else {
				tableCreation.createUserTable(statement);
			}

			if (checkingTable.checkRentalTable(databaseResults, databaseDate)) {
				System.out.println("Table 'rental' already exists.");
				System.out.println();
			} else {
				tableCreation.createRentalTable(statement);
			}

			if (checkingTable.checkDvdTable(databaseResults, databaseDate)) {
				System.out.println("Table 'dvd' already exists.");
				System.out.println();
			} else {
				tableCreation.createDvdTable(statement);
			}

			fillingTables.insertUserValues(statement);
			fillingTables.insertRentalValues(statement);
			fillingTables.insertDvdValues(statement);

		} catch (ClassNotFoundException e) {
			System.err.println("Trieda PostgreSQL Drivera nebola najdena.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Nastala chyba pri pripajani k databaze " + CONN);
			e.printStackTrace();
		}

		System.out.println("---");
		System.out.println("PostgreSQL Driver uspesne inicializovany.");

		if (connection == null) {
			System.out.println("Nepodadilo sa otvorit spojenie.");
		} else {
			System.out.println("Spojenie s databazou bolo uspesne.");
		}

		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println("Pri zatvarani spojenia s DB prislo k chybe.");
			e.printStackTrace();
		}

		System.out.println("Spojenie s databazou bolo uspesne uzatvorene.");
	}
}
