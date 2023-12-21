import java.sql.*;
import java.util.Scanner;

public class Main {

	// next three url are equivalent (if psql server launched on this machine)
	public static String url = "jdbc:postgresql:test";
	//public static String url = "jdbc:postgresql://localhost/test";
	//public static String url = "jdbc:postgresql://localhost:5432/test";

	private static String user = "skillbox";
	private static String password = "skillbox";


	public static void main(String[] args) throws Exception {
		// next line only throws an Exception if Driver could not be found, but this line is not necessary
		Class.forName("org.postgresql.Driver");

		Connection connection = DriverManager.getConnection(url, user, password); // if database not exists on specified url, it will be created
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