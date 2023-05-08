/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.example.btlsqa.repository;

import com.example.btlsqa.model.DangKiHoc;
import com.example.btlsqa.model.SinhVien;
import jakarta.transaction.Transactional;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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

    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindMonHocBySinhVienId_Success() {
        System.out.println("findMonHocBySinhVienId_Success");
        Integer sinhVienId = 1;
        List<String> result = dangKiHocRepository.findMonHocBySinhVienId(sinhVienId);
        assertNotNull(result);
    }

    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindMonHocBySinhVienId_Fall() {
        System.out.println("findMonHocBySinhVienId_Fall");
        Integer sinhVienId = -1;
        List<String> result = dangKiHocRepository.findMonHocBySinhVienId(sinhVienId);
        assertEquals(result.size(), 0);
    }

    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindAllLopHocPhanDangDangKiBySinhVienId_Success() {
        System.out.println("findAllLopHocPhanDangDangKiBySinhVienId_Success");
        Integer sinhVienId = 1;
        List<DangKiHoc> result = dangKiHocRepository.findAllLopHocPhanDangDangKiBySinhVienId(sinhVienId);
        assertNotNull(result);
    }

    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindAllLopHocPhanDangDangKiBySinhVienId_Fall() {
        System.out.println("findAllLopHocPhanDangDangKiBySinhVienId_Fall");
        Integer sinhVienId = 0;
        List<DangKiHoc> result = dangKiHocRepository.findAllLopHocPhanDangDangKiBySinhVienId(sinhVienId);
        assertEquals(result.size(), 0);
    }

    @Transactional
    @org.junit.jupiter.api.Test
    public void testDeleteBySinhVienAndSoLanHoc_Success() {
        System.out.println("deleteBySinhVien_Success");
        SinhVien sinhVien = new SinhVien(1, "trinhanhson", "201201", "Trinh Anh Son", "B19DCCN562");
        Integer result = dangKiHocRepository.deleteBySinhVienAndSoLanHoc(sinhVien, 0);
        assertNotEquals((long) result, (long) 0);
    }

    @Transactional
    @org.junit.jupiter.api.Test
    public void testDeleteBySinhVienAndSoLanHoc_Fall() {
        System.out.println("deleteBySinhVien_Fall");
        SinhVien sinhVien = new SinhVien(0, "trinhanhson", "201201", "Trinh Anh Son", "B19DCCN562");
        Integer result = dangKiHocRepository.deleteBySinhVienAndSoLanHoc(sinhVien, 0);
        assertEquals((long) result, (long) 0);
    }
}
