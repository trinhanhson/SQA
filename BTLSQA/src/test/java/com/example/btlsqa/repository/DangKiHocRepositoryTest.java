/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.example.btlsqa.repository;

import com.example.btlsqa.model.DangKiHoc;
import com.example.btlsqa.model.LopHocPhan;
import com.example.btlsqa.model.SinhVien;
import org.junit.*;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author ADMIN
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DangKiHocRepositoryTest {
    
    @Autowired
    private DangKiHocRepository dangKiHocRepository;
    
    public DangKiHocRepositoryTest() {
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

    @Test
    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindMonHocBySinhVienId_Success() {
        System.out.println("findMonHocBySinhVienId_Success");
        Integer sinhVienId = 1;
        List<String> result = dangKiHocRepository.findMonHocBySinhVienId(sinhVienId);
        assertNotNull(result);
    }
    @Test
    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindMonHocBySinhVienId_Fall() {
        System.out.println("findMonHocBySinhVienId_Fall");
        Integer sinhVienId = -1;
        List<String> result = dangKiHocRepository.findMonHocBySinhVienId(sinhVienId);
        assertEquals(result.size(), 0);
    }
    @Test
    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindAllLopHocPhanDangDangKiBySinhVienId_Success() {
        System.out.println("findAllLopHocPhanDangDangKiBySinhVienId_Success");
        Integer sinhVienId = 1;
        List<DangKiHoc> result = dangKiHocRepository.findAllLopHocPhanDangDangKiBySinhVienId(sinhVienId);
        assertNotNull(result);
    }
    @Test
    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindAllLopHocPhanDangDangKiBySinhVienId_Fall() {
        System.out.println("findAllLopHocPhanDangDangKiBySinhVienId_Fall");
        Integer sinhVienId = 0;
        List<DangKiHoc> result = dangKiHocRepository.findAllLopHocPhanDangDangKiBySinhVienId(sinhVienId);
        assertEquals(result.size(), 0);
    }
    @Test
    @Transactional
    @org.junit.jupiter.api.Test
    public void testDeleteBySinhVienAndSoLanHoc_Success() {
        System.out.println("deleteBySinhVien_Success");
        SinhVien sinhVien = new SinhVien(1, "trinhanhson", "201201", "Trinh Anh Son", "B19DCCN562");
        dangKiHocRepository.deleteBySinhVienAndSoLanHoc(sinhVien, 0);
        List<DangKiHoc> listDangKiHoc = dangKiHocRepository.findAllLopHocPhanDangDangKiBySinhVienId(1);
        assertEquals(listDangKiHoc.size(), 0);
    }
    @Test
    @Transactional
    @org.junit.jupiter.api.Test
    public void testSave_Success() {
        System.out.println("save_Success");
        DangKiHoc dangKiHoc = new DangKiHoc();
        dangKiHoc.setDiemTongKet(0);
        dangKiHoc.setSoLanHoc(0);
        SinhVien sinhVien = new SinhVien(1, "trinhanhson", "201201", "Trinh Anh Son", "B19DCCN562");
        LopHocPhan lopHocPhan = new LopHocPhan();
        lopHocPhan.setId(1);
        dangKiHoc.setSinhVien(sinhVien);
        dangKiHoc.setLopHocPhan(lopHocPhan);
        List<DangKiHoc> listDangKiHoc = dangKiHocRepository.findAllLopHocPhanDangDangKiBySinhVienId(1);
        assertNotEquals(listDangKiHoc.size(), 0);
    }
}
