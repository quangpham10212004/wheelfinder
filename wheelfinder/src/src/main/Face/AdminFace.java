package src.main.Face;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public class AdminFace extends JFrame {

    public AdminFace() {
        setTitle("Car Rental Admin");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo BackgroundPanel với ảnh nền
        JPanel backgroundPanel = new BackgroundPanel("/src/main/resources/BackGround.PNG");
        backgroundPanel.setLayout(new GridLayout(3, 2, 10, 10));
        backgroundPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Các nút bấm
        JButton viewCarsBtn = new JButton("Xem Danh Sách Xe");
        JButton addCarBtn = new JButton("Thêm Xe Mới");
        JButton updateCarBtn = new JButton("Cập Nhật Xe");
        JButton deleteCarBtn = new JButton("Xóa Xe");
        JButton viewAllRentsBtn = new JButton("Xe Đang Được Thuê");
        JButton viewUsersBtn = new JButton("Quản Lý Người Dùng");
        JButton changePassword = new JButton("Đổi Mật Khẩu");
        JButton logoutBtn = new JButton("Đăng Xuất");

        // Thêm các nút vào panel
        backgroundPanel.add(viewCarsBtn);
        backgroundPanel.add(addCarBtn);
        backgroundPanel.add(updateCarBtn);
        backgroundPanel.add(deleteCarBtn);
        backgroundPanel.add(viewAllRentsBtn);
        backgroundPanel.add(viewUsersBtn);
        backgroundPanel.add(changePassword);
        backgroundPanel.add(logoutBtn);

        // Thêm panel vào frame
        add(backgroundPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AdminFace().setVisible(true);
        });
    }
}

class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String resourcePath) {
        try {
            // Tải ảnh từ classpath
            var imageUrl = getClass().getResource(resourcePath);
            if (imageUrl != null) {
                backgroundImage = ImageIO.read(imageUrl);
            } else {
                throw new IOException("Ảnh không tồn tại trong classpath: " + resourcePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không thể tải ảnh: " + resourcePath, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
