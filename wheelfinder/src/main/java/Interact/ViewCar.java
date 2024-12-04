package main.java.Interact;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.java.Entity.Car;
import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;

public class ViewCar implements Operation {
    @Override
    public void operation(Database database,User user) {
        // Khởi tạo JFrame
        JFrame frame = new JFrame("Car List");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Tiêu đề
        JLabel titleLabel = new JLabel("List of Cars", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Tạo bảng dữ liệu
        String[] columnNames = {"ID", "Brand", "Model", "Color", "Year", "Price ($)", "Available"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable carTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(carTable);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Tải dữ liệu từ database
        String select = "SELECT * FROM car;";
        ArrayList<Car> cars = new ArrayList<>();
        try {
            ResultSet rs = database.getStatement().executeQuery(select);
            while (rs.next()) {
                Car car = new Car();
                car.setID(rs.getInt("ID"));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setColor(rs.getString("color"));
                car.setYear(rs.getInt("yearRelease"));
                car.setPrice(rs.getDouble("price"));
                car.setAvailable(rs.getInt("available"));
                cars.add(car);

                // Thêm dữ liệu vào bảng
                String status = car.getAvailable() > 0 ? String.valueOf(car.getAvailable()) : "Out of Stock";
                tableModel.addRow(new Object[]{
                        car.getID(),
                        car.getBrand(),
                        car.getModel(),
                        car.getColor(),
                        car.getYear(),
                        car.getPrice(),
                        status
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Error loading cars from database!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        // Hiển thị giao diện
        frame.setVisible(true);
    }
}
