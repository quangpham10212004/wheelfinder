package src.main.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    
    // Thông tin kết nối
    private String url = "jdbc:mysql://127.0.0.1:3306/carrentalsystem";  // Sử dụng 127.0.0.1 thay vì localhost
    private String user = "root";  // Tên người dùng là 'root'
    private String password = "16092004";  // Mật khẩu của bạn

    private Statement statement;
    private Connection connection;

    // Constructor kết nối đến cơ sở dữ liệu
    public Database() throws ClassNotFoundException {
        try {
            //Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Cố gắng kết nối đến MySQL
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getter để lấy statement
    public Statement getStatement() {
        return statement;
    }

    // Phương thức đóng kết nối và statement
    public void close() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
