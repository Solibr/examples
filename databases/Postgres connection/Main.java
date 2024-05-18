import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

	// next three url are equivalent (if psql server launched on this machine)
	public static String url = "jdbc:postgresql:postgres";
	//public static String url = "jdbc:postgresql://localhost/test";
	//public static String url = "jdbc:postgresql://localhost:5432/test";

	private static String user = "postgres";
	private static String password = "postgres";

	private static Random random = new Random();


	public static void main(String[] args) throws Exception {
		// next line only throws an Exception if Driver could not be found, but this line is not necessary
		Class.forName("org.postgresql.Driver");

		Connection connection = DriverManager.getConnection(url, user, password); // if database not exists on specified url, it will be created
		Statement statement = connection.createStatement();

		if (true) {
			createTestTable(connection);
			testActions(connection);
			System.out.println("Done");
			return;
		}

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

	private static void createTestTable(Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		statement.execute("""
				create table if not exists post (
				id serial,
				title varchar(50),
				text varchar(50),
				primary key (id)
				);""");
		statement.execute("create index if not exists title_index on post (title)");
	}

	private static void testActions(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("""
				insert into post (title, text) values (?, ?)
				;""");

		for (int i = 0; i < 100_000; i++) {
			if (i % 1_000 == 0) {
				System.out.println("Progress: " + i / 1_000. + "%");
			}
			ps.setString(1, getRandomString());
			ps.setString(2, getRandomString());
			ps.executeUpdate();
		}
		ps.setString(1, "shit1");
		ps.setString(2, "shit1");
		ps.executeUpdate();
	}

	private static String getRandomString() {
		int begin = 'a';
		int end = 'z' + 1;
		int length = random.nextInt(6) + 3;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			char c = (char) (random.nextInt(end - begin) + begin);
			sb.append(c);
		}
		return sb.toString();
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