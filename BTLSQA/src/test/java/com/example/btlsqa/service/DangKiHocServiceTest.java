/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.example.btlsqa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.btlsqa.model.DangKiHoc;
import com.example.btlsqa.model.LopHocPhan;
import com.example.btlsqa.model.MonHoc;
import com.example.btlsqa.model.SinhVien;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@SpringBootTest
public class DangKiHocServiceTest {

    @Autowired
    private DangKiHocService dangKiHocService;

    private static final List<DangKiHoc> listDangKyKhongDuTin = List.of(new DangKiHoc(1, 3.0f, 1, new SinhVien(), new LopHocPhan(new MonHoc("test", "test", 3))));
    private static final List<DangKiHoc> listDangKyThuaTin = List.of(new DangKiHoc(1, 3.0f, 1, new SinhVien(), new LopHocPhan(new MonHoc("test", "test", 3))),
        new DangKiHoc(1, 3.0f, 1, new SinhVien(), new LopHocPhan(new MonHoc("test", "test", 3))),
        new DangKiHoc(1, 3.0f, 1, new SinhVien(), new LopHocPhan(new MonHoc("test", "test", 3))),
        new DangKiHoc(1, 3.0f, 1, new SinhVien(), new LopHocPhan(new MonHoc("test", "test", 3))),
        new DangKiHoc(1, 3.0f, 1, new SinhVien(), new LopHocPhan(new MonHoc("test", "test", 3))),
        new DangKiHoc(1, 3.0f, 1, new SinhVien(), new LopHocPhan(new MonHoc("test", "test", 3))),
        new DangKiHoc(1, 3.0f, 1, new SinhVien(), new LopHocPhan(new MonHoc("test", "test", 3))));

    private static final List<DangKiHoc> listDangKyDuTin = List.of(new DangKiHoc(1, 3.0f, 1, new SinhVien(), new LopHocPhan(new MonHoc("test", "test", 3))),
        new DangKiHoc(1, 3.0f, 1, new SinhVien(), new LopHocPhan(new MonHoc("test", "test", 3))),
        new DangKiHoc(1, 3.0f, 1, new SinhVien(), new LopHocPhan(new MonHoc("test", "test", 3))),
        new DangKiHoc(1, 3.0f, 1, new SinhVien(), new LopHocPhan(new MonHoc("test", "test", 3))),
        new DangKiHoc(1, 3.0f, 1, new SinhVien(), new LopHocPhan(new MonHoc("test", "test", 3))));

    public DangKiHocServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Transactional
    @Test
    @org.junit.jupiter.api.Test
    public void testGetListDangKiHocBySinhVienId_TestSuccess() {
        System.out.println("getListDangKiHocBySinhVienId_TestSuccess: Lấy được danh sách đăng ký học đúng từ việc đăng nhập thành công");
        int sinhVienId = 1;
        List<DangKiHoc> expResult = new LinkedList<>();
        expResult.add(new DangKiHoc(5, 0, 0, new SinhVien(1, "trinhanhson", "201201", "Trinh Anh Son", "B19DCCN562"), null));
        List<DangKiHoc> result = dangKiHocService.getListDangKiHocBySinhVienId(sinhVienId);
        assertEquals(expResult.get(0).getDiemTongKet(), result.get(0).getDiemTongKet(), 0.0f);
        assertEquals(expResult.get(0).getSoLanHoc(), result.get(0).getSoLanHoc());
        assertEquals(expResult.get(0).getId(), result.get(0).getId());

        assertEquals(expResult.get(0).getSinhVien().getId(), result.get(0).getSinhVien().getId());
        assertEquals(expResult.get(0).getSinhVien().getTenDangNhap(), result.get(0).getSinhVien().getTenDangNhap());
        assertEquals(expResult.get(0).getSinhVien().getMatKhau(), result.get(0).getSinhVien().getMatKhau());
        assertEquals(expResult.get(0).getSinhVien().getHoTen(), result.get(0).getSinhVien().getHoTen());
        assertEquals(expResult.get(0).getSinhVien().getMaSinhVien(), result.get(0).getSinhVien().getMaSinhVien());

    }

    @org.junit.jupiter.api.Test
    public void testDangKyKhongDuTinChi() {
        boolean isValid = dangKiHocService.checkStcValid(listDangKyKhongDuTin);
        assertFalse(isValid);
    }

    @org.junit.jupiter.api.Test
    public void testDangKyThuaTinChi() {
        boolean isValid = dangKiHocService.checkStcValid(listDangKyThuaTin);
        assertFalse(isValid);
    }

    @org.junit.jupiter.api.Test
    public void testDangKyDuTinChi() {
        boolean isValid = dangKiHocService.checkStcValid(listDangKyDuTin);
        assertTrue(isValid);
    }
}
