package sk.maha.postgre;

import java.sql.SQLException;
import java.sql.Statement;

public class TableFilling {

	private String queryUsers = "INSERT INTO dvd.User VALUES";
	private String queryRental = "INSERT INTO dvd.Rental VALUES";
	private String queryDvd = "INSERT INTO dvd.Dvd VALUES";

	private String[] valuesUser = new String[] {
			queryUsers
					+ "(1,'Marcel', 'Hanis', 'Gen. Svobodu 682/5', 'Svidnik', '08901', 'marcel.hanis@gmail.com', '0900 000 001');",
			queryUsers
					+ "(2,'Jozef', 'Velky', 'Sokolovska 19', 'Kosice', '04001', 'jozef.velky@gmail.com', '0900 000 002');",
			queryUsers
					+ "(3,'Katarina', 'Hrozna', 'Dominikanska 54/1', 'Zvolen', '96001', 'katarina.hrozna@gmail.com', '0900 000 003');",
			queryUsers
					+ "(4,'Gregor', 'Velky', 'Zriedlova 13', 'Kosice', '04001', 'gregor.velky@gmail.com', '0900 000 004');",
			queryUsers
					+ "(5,'Izak', 'Syrsky', 'Plynarenska 65', 'Bratislava', '81107', 'izak.syrsky@gmail.com', '0900 000 005');",
			queryUsers + "(6,'Tutmos', 'VI.', 'SNP 67/3', 'Zvolen', '96001', 'tutmos.vi@gmail.com', '0900 000 006');",
			queryUsers
					+ "(7,'Alenka', 'Divoka', 'Divna 4', 'Bratislava', '81107', 'alenka.divoka@gmail.com', '0900 000 007');",
			queryUsers
					+ "(8,'Jozko', 'Mrkvicka', 'Bernolakova 32', 'Kosice', '04001', 'jozko.mrkvicka@gmail.com', '0900 000 008');",
			queryUsers
					+ "(9,'Peter', 'Hrozny', '1.Maja 56/7', 'Svidnik', '08901', 'peter.hrozny@gmail.com', '0900 000 009');",
			queryUsers
					+ "(10,'Sabrina', 'Carovna', 'Slotova 5', 'Zilina', '01001', 'sabrina.carovna@gmail.com', '0900 000 010');" };

	private String[] valuesRental = new String[] { queryRental + "(1,10,'2005-01-02','2005-02-11');",
			queryRental + "(2,1,'2006-06-25','2006-07-30');", queryRental + "(3,1,'2007-07-21','2007-08-29');",
			queryRental + "(4,1,'2008-02-20','2008-03-10');", queryRental + "(5,2,'2008-04-15','2008-05-16');",
			queryRental + "(6,3,'2008-05-30','2008-06-23');", queryRental + "(7,4,'2009-02-15','2009-03-06');",
			queryRental + "(8,1,'2009-06-14','2009-07-18');", queryRental + "(9,5,'2010-09-02','2010-10-03');",
			queryRental + "(10,6,'2011-08-06','2011-09-09');", queryRental + "(11,6,'2012-05-14','2012-07-09');",
			queryRental + "(12,7,'2013-05-26','2013-06-30');", queryRental + "(13,8,'2014-07-01','20014-08-02');",
			queryRental + "(14,9,'2015-05-04','2015-07-05');", queryRental + "(15,10,'2017-02-01','2017-03-02');" };

	private String[] valuesDvd = new String[] { queryDvd + "(1,1,'Pirates of Caribbean 1','Action', 'C', 3, 1);",
			queryDvd + "(2,3,'Pride and Prejudice','Drama', 'A', 1, 1);",
			queryDvd + "(3,2,'Grizyly Man','Documentary', 'A', 2, 1);",
			queryDvd + "(4,4,'O Brother, Where Art Thou?','Comedy', 'B', 4, 2);",
			queryDvd + "(5,7,'The Mirrors','Horror', 'B', 5, 3);",
			queryDvd + "(6,8,'X-Men: The Last Stand','Sci-Fi', 'C', 1, 1);",
			queryDvd + "(7,5,'Borat','Comedy', 'C', 2, 1);", queryDvd + "(8,6,'NHL 2015','Sport', 'B', 1, 1);",
			queryDvd + "(9,11,'Oliver!','Musical', 'A', 4, 2);",
			queryDvd + "(10,11,'Harold and Kumar Go to White Castle','Comedy', 'C', 1, 1);",
			queryDvd + "(11,14,'Lolita','Adult', 'B', 1, 1);",
			queryDvd + "(12,15,'Pirates of Caribbean 5','Action', 'A', 4, 1);" };

	/**
	 * Insert values in the table 'User'.
	 * 
	 * @param stm
	 * @throws SQLException
	 */
	public void insertUserValues(Statement stm) throws SQLException {

		for (String s : valuesUser) {
			stm.executeUpdate(s);
		}
	}

	/**
	 * Insert values in the table 'Rental'.
	 * 
	 * @param stm
	 * @throws SQLException
	 */
	public void insertRentalValues(Statement stm) throws SQLException {

		for (String s : valuesRental) {
			stm.executeUpdate(s);
		}
	}

	/**
	 * Insert values in the table 'Dvd'.
	 * 
	 * @param stm
	 * @throws SQLException
	 */
	public void insertDvdValues(Statement stm) throws SQLException {

		for (String s : valuesDvd) {
			stm.executeUpdate(s);
		}
	}
}
