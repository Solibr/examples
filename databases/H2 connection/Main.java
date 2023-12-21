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
		Class.forName("org.h2.Driver");

		Connection connection = DriverManager.getConnection(url, "sa", ""); // if database not exists on specified url, it will be created
		Statement statement = connection.createStatement();

		createTableIfNotExists(statement);

		// Reading
		ResultSet resultSet = statement.executeQuery("select * from mytable;");
		System.out.println("=== Before update");
		System.out.println(resultSetToString(resultSet));

		// Updating
		statement.executeUpdate("insert into mytable (name) values ('Boris');");

		// Reading
		resultSet = statement.executeQuery("select * from mytable;");
		System.out.println("=== After update");
		System.out.println(resultSetToString(resultSet));

		// Next line pause application to check access to database if H2 started in embedded mode or server mode
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		connection.close();
	}

	private static boolean createTableIfNotExists(Statement statement) throws SQLException {
		return statement.execute("CREATE TABLE IF NOT EXISTS mytable (id int generated always as identity primary key, name varchar)");
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