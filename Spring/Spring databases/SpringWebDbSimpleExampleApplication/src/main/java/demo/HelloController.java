package demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;

@Controller
public class HelloController {

     private final DatabaseConnection databaseConnection;

    public HelloController(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }


    @GetMapping("/")
    public String getHomePage(Model model) {
        String text = getMessageFromDb();
        model.addAttribute("message", text);
        return "hello";
    }

    @PostMapping("/")
    public String setNewMessage(@RequestParam("message") String message) {
        setNewMessageToDb(message);
        System.out.println("new message has been sent to db: " + message);
        return "redirect:/";
    }

    private String getMessageFromDb() {
        StringBuilder sb = new StringBuilder();
        Connection connection = databaseConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM test;");
            while(rs.next()) {
                sb.append(rs.getString("message"));
                sb.append("\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    private void setNewMessageToDb(String message) {
        Connection connection = databaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update test set message = ? where id = 1;");
            preparedStatement.setString(1, message);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
