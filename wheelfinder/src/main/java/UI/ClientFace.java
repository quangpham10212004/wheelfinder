package main.java.UI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ClientFace extends JFrame {

    public ClientFace() {
        setTitle("Car Rental Client");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo BackgroundPanel với ảnh nền
        JPanel backgroundPanel = new BackgroundPanel("/main/java/resources/BackGround.PNG");
        backgroundPanel.setLayout(new GridLayout(3, 2, 10, 10));
        backgroundPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Các nút bấm
        JButton viewCarsBtn = new JButton("Xem Danh Sách Xe");
        JButton rentCarBtn = new JButton("Mua Xe");
        JButton viewRentHistoryBtn = new JButton("Lịch Sử Mua Xe");
        JButton changePassword = new JButton("Đổi mật khẩu");
        JButton logoutBtn = new JButton("Đăng Xuất");

        // Thêm các nút vào panel
        backgroundPanel.add(viewCarsBtn);
        backgroundPanel.add(rentCarBtn);
        backgroundPanel.add(viewRentHistoryBtn);
        backgroundPanel.add(changePassword);
        backgroundPanel.add(logoutBtn);

        // Thêm panel vào frame
        add(backgroundPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ClientFace().setVisible(true);
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
