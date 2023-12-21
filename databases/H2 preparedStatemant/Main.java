import java.sql.*;
import java.util.Scanner;

public class Main {

	public static String url = "jdbc:h2:mem:";

	public static void doTheThing(Connection connection) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("insert into mytable (name) values (?);");
		preparedStatement.setString(1, "Some name");
		preparedStatement.executeUpdate();
	}



	public static void main(String[] args) throws Exception {
		Class.forName("org.h2.Driver");

		Connection connection = DriverManager.getConnection(url, "sa", "");
		Statement statement = connection.createStatement();

		createTableIfNotExists(statement);

		// Reading
		ResultSet resultSet = statement.executeQuery("select * from mytable;");
		System.out.println("=== Before update");
		System.out.println(resultSetToString(resultSet));

		// Updating
		doTheThing(connection);

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