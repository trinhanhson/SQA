package com.example.btlsqa;

import com.example.btlsqa.model.MonHoc;

import java.util.List;

public class MocData {
    public static List<MonHoc> getMockDataMonHoc() {
        return List.of(
            MonHoc.builder()
                    .id("BAS1122")
                    .ten("Tư tưởng Hồ Chí Minh")
                    .soTinChi(2)
                    .build(),
            MonHoc.builder()
                    .id("BAS1150")
                    .ten("Triết học Mác-Lenin")
                    .soTinChi(4)
                    .build(),
            MonHoc.builder()
                    .id("BAS1151")
                    .ten("Kinh tế chính trị Mác-Lenin")
                    .soTinChi(2)
                    .build(),
            MonHoc.builder()
                    .id("BAS1152")
                    .ten("Chủ nghĩa xã hội khoa học")
                    .soTinChi(2)
                    .build(),
            MonHoc.builder()
                    .id("BAS1201")
                    .ten("Đại số")
                    .soTinChi(4)
                    .build(),
            MonHoc.builder()
                    .id("BAS1203")
                    .ten("Giải tích 1")
                    .soTinChi(4)
                    .build(),
            MonHoc.builder()
                    .id("BAS1204")
                    .ten("Giải tích 2")
                    .soTinChi(4)
                    .build(),
            MonHoc.builder()
                    .id("BAS1224")
                    .ten("Vật lý 1")
                    .soTinChi(4)
                    .build(),
            MonHoc.builder()
                    .id("BAS1226")
                    .ten("Xác suất thống kê")
                    .soTinChi(2)
                    .build(),
            MonHoc.builder()
                    .id("BAS1227")
                    .ten("Vật lý 3")
                    .soTinChi(4)
                    .build(),
            MonHoc.builder()
                    .id("ELE1433")
                    .ten("Kỹ thuật số")
                    .soTinChi(2)
                    .build(),
            MonHoc.builder()
                    .id("INT1154")
                    .ten("Tin học cơ sở 1")
                    .soTinChi(2)
                    .build(),
            MonHoc.builder()
                    .id("INT1155")
                    .ten("Tin học cơ sở 2")
                    .soTinChi(2)
                    .build(),
            MonHoc.builder()
                    .id("INT1339")
                    .ten("Ngôn ngữ lập trình C++")
                    .soTinChi(4)
                    .build(),
            MonHoc.builder()
                    .id("INT1358")
                    .ten("Toán rời rạc")
                    .soTinChi(4)
                    .build()
        );
    }
}
