DROP TABLE IF EXISTS sqa.DangKiHoc;
DROP TABLE IF EXISTS sqa.LopHocPhan;
DROP TABLE IF EXISTS sqa.MonHocTienQuyet;
DROP TABLE IF EXISTS sqa.SinhVien; 
DROP TABLE IF EXISTS sqa.MonHoc; 

CREATE TABLE sqa.SinhVien (
    id int primary key,
    tenDangNhap varchar(255),
    matKhau varchar(255),
	hoTen varchar(255),
    maSinhVien varchar(255) unique
);

create table sqa.MonHoc(
	id varchar(255) primary key,
    ten varchar(255),
    soTinChi int
);

create table sqa.MonHocTienQuyet(
	idMonHoc varchar(255),
    idMonHocTienQuyet varchar(255),
	FOREIGN KEY (idMonHoc) REFERENCES sqa.MonHoc(id),
    FOREIGN KEY (idMonHocTienQuyet) REFERENCES sqa.MonHoc(id)
);

create table sqa.LopHocPhan(
	id int primary key,
    nhomMonHoc varchar(255),
    siSoToiDa int,
    siSoThucTe int,
    thu int,
    tietBatDau int,
    soTiet int,
    phong varchar(255),
    tenGiangVien varchar(255),
    monHocId varchar(255),
    FOREIGN KEY (monHocId) REFERENCES sqa.MonHoc(id)
);

create table sqa.DangKiHoc(
	id int primary key,
    diemTongKet float,
    soLanHoc int,
    maSinhVien varchar(255),
    lopHocPhanId int,
    FOREIGN KEY (maSinhVien) REFERENCES sqa.SinhVien(maSinhVien),
    FOREIGN KEY (lopHocPhanId) REFERENCES sqa.LopHocPhan(id)
);

INSERT INTO sqa.SinhVien (id, tenDangNhap, matKhau, hoTen, maSinhVien)
VALUES 
(1,"trinhanhson","201201","Trinh Anh Son","B19DCCN562"),
(2,"hoangcongtu","201201","Hoang Cong Tu","B19DCCN563"),
(3,"leminhtuan","201201","Le Minh Tuan","B19DCCN564"),
(4,"khongduytuan","201201","Khong Duy Tuan","B19DCCN565"),
(5,"vutruonggiang","201201","Vu Truong Giang","B19DCCN566");

INSERT INTO sqa.MonHoc (id,ten,soTinChi)
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

INSERT INTO sqa.MonHocTienQuyet(idMonHoc,idMonHocTienQuyet)
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

INSERT INTO sqa.LopHocPhan(id,nhomMonHoc,siSoToiDa,siSoThucTe,thu,tietBatDau,soTiet,phong,tenGiangVien,monHocId)
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

INSERT INTO sqa.DangKiHoc(id,diemTongKet,soLanHoc,maSinhVien,lopHocPhanId)
VALUES
(1,3.5,1,"B19DCCN562",1),
(2,3.2,1,"B19DCCN562",4),
(3,3.5,1,"B19DCCN562",7),
(4,3,1,"B19DCCN562",12),

(5,2,1,"B19DCCN563",1),
(6,4,1,"B19DCCN563",4),
(7,3.9,1,"B19DCCN563",8),
(8,3,1,"B19DCCN563",10),

(9,2,1,"B19DCCN564",13),
(10,1,1,"B19DCCN564",16),
(11,3.9,2,"B19DCCN564",19),
(12,3,1,"B19DCCN564",22),
(13,3.9,1,"B19DCCN564",25),
(14,3,1,"B19DCCN564",29),

(15,4,1,"B19DCCN565",13),
(16,2.6,1,"B19DCCN565",16),
(17,2.9,2,"B19DCCN565",19),
(18,3,1,"B19DCCN565",22),
(19,3.5,1,"B19DCCN565",25),
(20,4,1,"B19DCCN565",29),

(21,4,1,"B19DCCN566",13),
(22,4,1,"B19DCCN566",16),
(23,3.9,1,"B19DCCN566",19),
(24,4,1,"B19DCCN566",22),
(25,4,2,"B19DCCN566",25),
(26,3.6,1,"B19DCCN566",29);