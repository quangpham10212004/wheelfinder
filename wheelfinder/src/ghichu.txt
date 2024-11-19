1, Cấu trúc thư mục:
src/
├── main/
│   ├── Face/  // Chứa phần code giao diện
│   ├── Model/       // Chứa các lớp mô hình (User, Car, Rental)
│   ├── resources/        // Chứa các hình nền hay nút bấm với setIcon
│   └── Database/    // Chứa kết nối cơ sở dữ liệu
└── 

2, các thông số chung : 
    setSize(600,400)
3, nếu set layout xấu và không muốn người dùng ấn phóng to thu nhỏ, thì thêm câu lệnh:
        setResizable(false); // Ngăn không cho thay đổi kích thước cửa sổ
4, set hình nền với đường dẫn tương đối:
    JPanel backgroundPanel = new BackgroundPanel("/src/main/resources/BackGround.PNG");
và 
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


