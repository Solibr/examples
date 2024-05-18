import java.beans.Encoder;
import java.sql.*;
import java.util.Scanner;

public class Main {

	public static String url = "jdbc:h2:mem:";		// URL for in memory mode

	//public static String url = "jdbc:h2:./db/test";		// URL for embedded mode. Path could be relative to classpath

	// URL for server mode (server need to be started, path should be absolute)
	//public static String url = "jdbc:h2:tcp://localhost/~/YandexDisk/IdeaProjects/Examples/databases/H2/db/test";

	// same. port defined explicitly
	//public static String url = "jdbc:h2:tcp://localhost:9092/~/YandexDisk/IdeaProjects/Examples/databases/H2/db/test";

	// same. just another db file
	//public static String url = "jdbc:h2:tcp://localhost/~/h2db/test";


	public static void main(String[] args) throws Exception {
		// next line only throws an Exception if Driver could not be found, but this line is not necessary
		//Class.forName("org.h2.Driver");

		Connection connection = DriverManager.getConnection(url, "sa", ""); // if database not exists on specified url, it will be created
		Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY , ResultSet.CONCUR_UPDATABLE);

		createTableIfNotExists(statement);

		// Reading
		ResultSet resultSet = statement.executeQuery("select * from mytable;");
		System.out.println("=== Before update");
		System.out.println(resultSetToString(resultSet));

		// Updating
		statement.executeUpdate("insert into mytable (name) values ('Boris');");
		statement.executeUpdate("insert into another (name, mtId) values ('Sam', 1);");

		// Reading
		System.out.println("=== After update");
		resultSet = statement.executeQuery("select * from mytable;");
		System.out.println(resultSetToString(resultSet));
		resultSet = statement.executeQuery("select * from another;");
		System.out.println(resultSetToString(resultSet));

		// Join
		System.out.println("\nJoin");
		resultSet = statement.executeQuery("select mt.name, mt.id, an.id, an.name from mytable mt join another an on an.mtId = mt.id;");
		resultSet.next();
		//resultSet.deleteRow();
		//System.out.println(resultSetToString(resultSet));

		//resultSet.deleteRow();

		System.out.println("\nEND");
		resultSet = statement.executeQuery("select * from mytable;");
		System.out.println(resultSetToString(resultSet));
		resultSet = statement.executeQuery("select * from another;");
		System.out.println(resultSetToString(resultSet));

		// Next line pause application to check access to database if H2 started in embedded mode or server mode
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		connection.close();
	}

	private static boolean createTableIfNotExists(Statement statement) throws SQLException {
		try {
			statement.execute("CREATE TABLE IF NOT EXISTS mytable (id int generated always as identity primary key, name varchar)");
			statement.execute("CREATE TABLE IF NOT EXISTS another (id int generated always as identity primary key, name varchar, mtId int)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public static String resultSetToString(ResultSet resultSet) throws SQLException {
		StringBuilder text = new StringBuilder();
		int columnCount = resultSet.getMetaData().getColumnCount();
		while (resultSet.next()) {

			for (int i = 1; i <= columnCount; i++) {
				text.append(resultSet.getString(i));
				text.append("\t");
			}
			text.append("\n");
		}
		return text.toString();
	}
}