## Giua-Ky-Java-_-52000578
### I'm Lâm Bích Ngọc
### MSSV: 52000578
### 1. Các nguyên tắc, mẫu phát triển phần mềm
và thực tiễn đang được áp dụng.
Dependency Injection: Lớp AppController sử dụng Dependency Injection để đưa các thể hiện của các lớp ProductService và CartService vào hàm tạo của nó. Điều này làm cho lớp có nhiều mô-đun hơn và dễ kiểm tra hơn, vì nó có thể dễ dàng hoán đổi với các triển khai mô phỏng hoặc sơ khai.

Tách các mối quan tâm: Lớp AppController phân tách các mối quan tâm bằng cách có các phương thức riêng biệt để xử lý đăng nhập, thêm sản phẩm vào giỏ hàng, cập nhật các mặt hàng trong giỏ hàng và thực hiện thanh toán. Điều này làm cho mã dễ đọc, bảo trì và kiểm tra hơn.

### 2. Cấu trúc mã:
Mô hình bao gồm các thực thể (Sản phẩm và Cart) và các dịch vụ (ProductService,  và CartService) xử lý logic để truy xuất.

Các giao diện HTML gồm có(login.html, homepage.html, cart.html, addpro.html, showdetail.html).

lớp AppController xử lý các yêu cầu của người dùng và tương tác với Mô hình và Chế độ xem. AppController có các phương thức để truy xuất tất cả sản phẩm, đăng nhập, thêm sản phẩm vào giỏ hàng, cập nhật các mặt hàng trong giỏ hàng, thanh toán, thêm xóa sản phẩm mới, tìm kiếm sản phẩm, xem chi tiết sản phẩm.

Cấu trúc mã cũng bao gồm các cấu hình cần thiết cho Spring Boot, chẳng hạn như tệp application.properties để thiết lập kết nối cơ sở dữ liệu và tệp pom.xml để quản lý các phụ thuộc.
### 3. Các bước cần thiết để chạy ứng dụng:
- Bật xampp
- Run bài bằng ứng dụng Intellij.
- Bảng SDK: version 18.0.2 (nếu cần)
- Mở link http://localhost:8080/ bằng trình duyệt web
- Tài khoản để login:
      Tên tài khoản: bichngoc
      Password: 123
### 4. Entity-relationship diagram for the database. 
Link: https://drive.google.com/drive/folders/1Q7KGDlz2RTQLqp39eKduthZ_WjYxYB96?usp=share_link
### 5. Video demo: 
LInk: https://drive.google.com/drive/folders/1Q7KGDlz2RTQLqp39eKduthZ_WjYxYB96?usp=share_link
