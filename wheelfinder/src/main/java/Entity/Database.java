package main.java.Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database implements AutoCloseable {  // Implement AutoCloseable

    private String user = "root";
    private String password = "dokiet999";
    private String url = "jdbc:mysql://localhost:3306/wheelfinder";
    private Connection connection;  // Thêm đối tượng Connection
    private Statement statement;

    public Database() {
        try {
            // Kết nối tới cơ sở dữ liệu
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            // System.out.println("Connected successfully"); // kiểm tra kết nối
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }
    public Statement getStatement() {
        return statement;
    }

    @Override
    public void close() throws SQLException {
        // Đảm bảo đóng kết nối và statement khi không sử dụng nữa
        if (statement != null && !statement.isClosed()) {
            statement.close();
        }
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
