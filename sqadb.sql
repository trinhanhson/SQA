DROP DATABASE IF EXISTS sqadb;
create database sqadb;

DROP TABLE IF EXISTS sqadb.dang_ki_hoc;
DROP TABLE IF EXISTS sqadb.lop_hoc_phan;
DROP TABLE IF EXISTS sqadb.mon_hoc_tien_quyet;
DROP TABLE IF EXISTS sqadb.sinh_vien; 
DROP TABLE IF EXISTS sqadb.mon_hoc; 

CREATE TABLE sqadb.sinh_vien (
    id int primary key AUTO_INCREMENT,
    ten_dang_nhap varchar(255),
    mat_khau varchar(255),
	ho_ten varchar(255),
    ma_sinh_vien varchar(255)
);

create table sqadb.mon_hoc(
	id varchar(255) primary key,
    ten varchar(255),
    so_tin_chi int
);

create table sqadb.mon_hoc_tien_quyet(
	id_mon_hoc varchar(255),
    id_mon_hoc_tien_quyet varchar(255),
	FOREIGN KEY (id_mon_hoc) REFERENCES sqadb.mon_hoc(id),
    FOREIGN KEY (id_mon_hoc_tien_quyet) REFERENCES sqadb.mon_hoc(id)
);

create table sqadb.lop_hoc_phan(
	id int primary key AUTO_INCREMENT,
    nhom_mon_hoc varchar(255),
    si_so_toi_da int,
    si_so_thuc_te int,
    thu int,
    tiet_bat_dau int,
    so_tiet int,
    phong varchar(255),
    ten_giang_vien varchar(255),
    mon_hoc_id varchar(255),
    FOREIGN KEY (mon_hoc_id) REFERENCES sqadb.mon_hoc(id)
);

create table sqadb.dang_ki_hoc(
	id int primary key AUTO_INCREMENT,
    diem_tong_ket float,
    so_lan_hoc int,
    sinh_vien_id int,
    lop_hoc_phan_id int,
    FOREIGN KEY (sinh_vien_id) REFERENCES sqadb.sinh_vien(id),
    FOREIGN KEY (lop_hoc_phan_id) REFERENCES sqadb.lop_hoc_phan(id)
);

INSERT INTO sqadb.sinh_vien (id, ten_dang_nhap, mat_khau, ho_ten, ma_sinh_vien)
VALUES 
(1,"trinhanhson","201201","Trinh Anh Son","B19DCCN562"),
(2,"hoangcongtu","201201","Hoang Cong Tu","B19DCCN563"),
(3,"leminhtuan","201201","Le Minh Tuan","B19DCCN564"),
(4,"khongduytuan","201201","Khong Duy Tuan","B19DCCN565"),
(5,"vutruonggiang","201201","Vu Truong Giang","B19DCCN566");


INSERT INTO sqadb.mon_hoc (id,ten,so_tin_chi)
values
("BAS1150","Triết học Mác-Lenin",3),
("BAS1201","Đại số",3),
("BAS1203","Giải tích 1",3),
("INT1154","Tin học cơ sở 1",2),

("BAS1226","Xác suất thống kê",2),
("BAS1151","Kinh tế chính trị Mác-Lenin",2),
("BAS1152","Chủ nghĩa xã hội khoa học",2),
("BAS1204","Giải tích 2",3),
("BAS1224","Vật lý 1",3),
("INT1155","Tin học cơ sở 2",2),

("BAS1122","Tư tưởng Hồ Chí Minh",2),
("BAS1227","Vật lý 3",3),
("INT1358","Toán rời rạc",3),
("ELE1433","Kỹ thuật số",2),
("INT1339","Ngôn ngữ lập trình C++",3);

INSERT INTO sqadb.mon_hoc_tien_quyet(id_mon_hoc,id_mon_hoc_tien_quyet)
values
("BAS1226","BAS1201"),
("BAS1226","BAS1203"),
("BAS1151","BAS1150"),
("BAS1152","BAS1150"),
("BAS1204","BAS1203"),
("BAS1224","BAS1201"),
("BAS1224","BAS1203"),
("INT1155","INT1154"),
("BAS1122","BAS1151"),
("BAS1122","BAS1152"),
("BAS1227","BAS1224"),
("INT1358","INT1154"),
("INT1339","INT1155");

INSERT INTO sqadb.lop_hoc_phan(id,nhom_mon_hoc,si_so_toi_da,si_so_thuc_te,thu,tiet_bat_dau,so_tiet,phong,ten_giang_vien,mon_hoc_id)
values
(1,"01",40,30,2,1,4,"101","Trần Văn A","BAS1150"),
(2,"02",40,30,3,1,4,"101","Trần Văn B","BAS1150"),
(3,"03",40,30,4,1,4,"101","Trần Văn C","BAS1150"),

(4,"01",40,30,2,5,4,"102","Trần Hoàng A","BAS1201"),
(5,"02",40,30,3,5,4,"102","Trần Hoàng B","BAS1201"),
(6,"03",40,30,4,5,4,"102","Trần Hoàng C","BAS1201"),

(7,"01",40,30,4,1,4,"104","Nguyễn Văn A","BAS1203"),
(8,"02",40,30,5,1,4,"104","Nguyễn Văn B","BAS1203"),
(9,"03",40,30,6,1,4,"104","Nguyễn Văn C","BAS1203"),

(10,"01",40,35,3,3,2,"105","Trần Thị A","INT1154"),
(11,"02",40,39,4,3,2,"105","Trần Thị B","INT1154"),
(12,"03",40,36,5,3,2,"105","Trần Thị C","INT1154"),


(13,"01",40,26,3,5,2,"201","Trịnh Thanh A","BAS1226"),
(14,"02",40,31,4,5,2,"201","Trịnh Thanh B","BAS1226"),
(15,"03",40,40,5,5,2,"201","Trịnh Thanh C","BAS1226"),

(16,"01",40,33,3,1,2,"202","Nguyễn Công A","BAS1151"),
(17,"02",40,14,4,3,2,"202","Nguyễn Công B","BAS1151"),
(18,"03",40,32,5,1,2,"202","Nguyễn Công C","BAS1151"),

(19,"01",40,34,6,1,2,"203","Hoàng Anh A","BAS1152"),
(20,"02",40,28,6,3,2,"203","Hoàng Anh B","BAS1152"),
(21,"03",40,29,6,5,2,"203","Hoàng Anh B","BAS1152"),

(22,"01",40,31,4,5,4,"204","Vũ Thị A","BAS1204"),
(23,"02",40,32,5,5,4,"204","Vũ Thị B","BAS1204"),
(24,"03",40,34,6,5,4,"204","Vũ Thị C","BAS1204"),

(25,"01",40,36,2,1,4,"205","Nguyễn Mạnh A","BAS1224"),
(26,"02",40,38,2,5,4,"205","Nguyễn Mạnh B","BAS1224"),
(27,"03",40,29,3,1,4,"205","Nguyễn Mạnh C","BAS1224"),

(28,"01",40,35,4,1,2,"206","Đinh Mạnh A","INT1155"),
(29,"02",40,34,5,5,2,"206","Đinh Mạnh B","INT1155"),
(30,"03",40,33,6,1,2,"206","Đinh Mạnh C","INT1155"),


(31,"01",40,33,3,1,2,"301","Vũ Mạnh A","BAS1122"),
(32,"02",40,27,4,3,2,"301","Vũ Mạnh B","BAS1122"),
(33,"03",40,28,5,5,2,"301","Vũ Mạnh C","BAS1122"),

(34,"01",40,29,3,5,4,"302","Trần Công Mạnh A","BAS1227"),
(35,"02",40,29,4,1,4,"302","Trần Công Mạnh B","BAS1227"),
(36,"03",40,29,5,5,4,"302","Trần Công Mạnh C","BAS1227"),

(37,"01",40,35,4,5,4,"303","Trường Lê A","INT1358"),
(38,"02",40,35,5,5,4,"303","Trường Lê B","INT1358"),
(39,"03",40,35,6,5,4,"303","Trường Lê C","INT1358"),

(40,"01",40,35,2,1,2,"304","Trường Vũ A","ELE1433"),
(41,"02",40,32,3,1,2,"304","Trường Vũ B","ELE1433"),
(42,"03",40,31,6,1,2,"304","Trường Lê C","ELE1433"),

(43,"03",40,30,3,5,4,"305","Bùi Tùng A","INT1339"),
(44,"03",40,30,5,5,4,"305","Bùi Tùng B","INT1339"),
(45,"03",40,30,6,5,4,"305","Bùi Tùng C","INT1339");

INSERT INTO sqadb.dang_ki_hoc(diem_tong_ket,so_lan_hoc,sinh_vien_id,lop_hoc_phan_id)
VALUES
(3.5,1,1,1),
(3.2,1,1,4),
(3.5,1,1,7),
(3,1,1,12),

(0,0,1,13),


(2,1,2,1),
(4,1,2,4),
(3.9,1,2,8),
(3,1,2,10),


(3.5,1,3,1),
(3.2,1,3,4),
(3.5,1,3,7),
(3,1,3,12),

(2,1,3,13),
(1,1,3,16),
(3.9,2,3,19),
(3,1,3,22),
(3.9,1,3,25),
(3,1,3,29),

(3.5,1,4,1),
(3.2,1,4,4),
(3.5,1,4,7),
(3,1,4,12),

(4,1,4,13),
(2.6,1,4,16),
(2.9,2,4,19),
(3,1,4,22),
(3.5,1,4,25),
(4,1,4,29),

(3.5,1,5,1),
(3.2,1,5,4),
(3.5,1,5,7),
(3,1,5,12),

(4,1,5,13),
(4,1,5,16),
(3.9,1,5,19),
(4,1,5,22),
(4,2,5,25),
(3.6,1,5,29);