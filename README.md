Cài đặt XAMPP và mở 
    - Apache cổng 3344, 8088
    - MySQL cổng 3306

Import database vào trang phpmyadmin

Thông tin tài khoản
    user - user1234 - USER
    manager - manager4321 - MANAGER
    admin - admin2345 - ADMIN
    npdkhang - npdkhang - ADMIN
    nminhtan - nminhtan - ADMIN
    buicthanh - buicthanh - ADMIN
    nphucduy - nphucduy - MANAGER
    nguyenminh - nguyenminh - MANAGER
    buiicong - buiicong - MANAGER
    nguyenphuc - nguyenphuc - USER

12344321
12345678

USER:
    - Được quyền vào trang home, menu, contact, services
	- User nếu cố tình vào các trang không được phép thì bị chuyển đến trang 403
	- Không được vào trang xem thông tin tài khoản, nhân viên

MANAGER:
    - Có đặc quyền như user
    - Ngoài ra được vào trang quản lý tài khoản, nhân viên và sản phẩm
    - Được thêm, xem và sửa thông tin nhân viên, sản phẩm

ADMIN:
    - Có đặc quyền cao nhất
    - Sở hữu đặc quyền như manager
    - Ngoài ra được quyền xóa thông tin nhân viên và sản phẩm
    - Được vào mọi trang mà không bị chặn

1. Thực hiện đăng ký tài khoản
2. Xác thực tài khoản đã đăng ký qua gmail
3. Thực hiện đăng nhập
4. Chuyển hướng đăng nhập theo role của tài khoản
5. Tự động gán role mặc định cho tài khoản mới đăng ký
6. Đăng xuất
7. Ngăn người dùng quay lại trang đăng nhập sau khi họ đã đăng nhập tài khoản
8. Ghi nhớ tài khoản (Remember me)
9. Tự động vô hiệu hóa tài khoản người dùng nếu nhập sai mật khẩu 3 lần
10. Tự động mở khóa tài khoản sau 1 khoảng thời gian nhất định
11. Xử lý trường hợp quên mật khẩu
12. Khôi phục mật khẩu bằng cách gửi email và người dùng click vào link để đổi mật khẩu
13. Đổi mật khẩu mới
14. Thực hiện Paging và Sorting account
15. Thực hiện xem và sửa thông tin user theo id (admin/manager)
16. Thực hiện tạo, xem, sửa thông tin nhân viên / sản phẩm (manager)
17. Thực hiện tạo, xem, sửa, xóa thông tin nhân viên / sản phẩm (admin)
18. Role USER / MANAGER không thể vào được trang admin
19. Giảm số lần nhập sai mật khẩu xuống nếu đăng nhập thành công