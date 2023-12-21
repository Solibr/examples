
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class Main {
    public static void main(String[] args) {

        //JSONObject obj = new JSONObject();

        //Class.forName("com.mysql.fabric.jdbc.Driver");

        // load and register JDBC driver for MySQL
        //Class.forName("com.mysql.cj.jdbc.Driver");

//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }

        String url = "jdbc:mysql://localhost:3306/skillbox?useUnicode=true&serverTimezone=UTC";
        String user = "root";
        String pass = "Testtest123";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("select course_name,\n" +
                    "count(*)/(max(month(subscription_date)) - min(month(subscription_date)) + 1)\n" +
                    "as average_month_purchase\n" +
                    "from purchaseList group by course_name order by course_name;");
            SQLResultFormat(res);

            res.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void SQLResultFormat(ResultSet res) throws SQLException {
        ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>();
        ArrayList<String> row;

        // Получим количество столбцов
        ResultSetMetaData metaData = res.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Присвоим первой строчке наименовния столбцов
        row = new ArrayList<String>();
        for (int i = 0; i < columnCount; i++) {
            row.add(metaData.getColumnLabel(i + 1));
        }
        grid.add(row);

        // Установим минимальную ширину столбцов
        ArrayList<Integer> widthList = new ArrayList<Integer>();
        for (int i = 0; i < columnCount; i++) {
            widthList.add(grid.get(0).get(i).length());
        }

        // Переберём результат запроса
        while (res.next()) {
            row = new ArrayList<String>();
            for (int i = 0; i < columnCount; i++) {
                row.add(res.getString(i + 1));
                if (row.get(i).length() > widthList.get(i)) {
                    widthList.set(i, row.get(i).length());
                }
            }
            grid.add(row);
        }

        // Форматированный вывод
        for (int i = 0; i < columnCount; i++) {
            System.out.print(" + " + "-".repeat(widthList.get(i)));
        }
        System.out.println(" +");
        for (int r = 0; r < grid.size(); r++) {
            for (int i = 0; i < columnCount; i++) {
                String item = grid.get(r).get(i);
                System.out.print(" | " + item + " ".repeat(widthList.get(i) - item.length()));
            }
            System.out.println(" |");
            if (r == 0) {
                for (int i = 0; i < columnCount; i++) {
                    System.out.print(" + " + "-".repeat(widthList.get(i)));
                }
                System.out.println(" |");
            }
        }
        for (int i = 0; i < columnCount; i++) {
            System.out.print(" + " + "-".repeat(widthList.get(i)));
        }
        System.out.println(" +");
    }
}
