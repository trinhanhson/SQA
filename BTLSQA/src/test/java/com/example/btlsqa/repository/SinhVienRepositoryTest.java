/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.example.btlsqa.repository;

import com.example.btlsqa.model.SinhVien;
import org.junit.*;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SinhVienRepositoryTest {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    public SinhVienRepositoryTest() {
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
    public void testFindByTenDangNhapVaMatKhau_Success() {
        System.out.println("findByTenDangNhapVaMatKhau_Success");
        String username = "trinhanhson";
        String password = "201201";
        SinhVien expResult = new SinhVien(1, username, password, "Trinh Anh Son", "B19DCCN562");
        SinhVien result = sinhVienRepository.findByTenDangNhapVaMatKhau(username, password);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getTenDangNhap(), result.getTenDangNhap());
        assertEquals(expResult.getMatKhau(), result.getMatKhau());
        assertEquals(expResult.getHoTen(), result.getHoTen());
        assertEquals(expResult.getMaSinhVien(), result.getMaSinhVien());

    }
    @Test
    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindByTenDangNhapVaMatKhau_Fall1() {
        System.out.println("findByTenDangNhapVaMatKhau_Fall1");
        String username = "trinhanhson";
        String password = "";
        SinhVien result = sinhVienRepository.findByTenDangNhapVaMatKhau(username, password);
        assertNull(result);
    }
    @Test
    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindByTenDangNhapVaMatKhau_Fall2() {
        System.out.println("findByTenDangNhapVaMatKhau_Fall2");
        String username = "";
        String password = "201201";
        SinhVien result = sinhVienRepository.findByTenDangNhapVaMatKhau(username, password);
        assertNull(result);
    }
    @Test
    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindByTenDangNhapVaMatKhau_Fall3() {
        System.out.println("findByTenDangNhapVaMatKhau_Fall3");
        String username = "";
        String password = "";
        SinhVien result = sinhVienRepository.findByTenDangNhapVaMatKhau(username, password);
        assertNull(result);
    }
    @Test
    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindByTenDangNhapVaMatKhau_Fall4() {
        System.out.println("findByTenDangNhapVaMatKhau_Fall4");
        String username = "trinhanhson";
        String password = "201202";
        SinhVien result = sinhVienRepository.findByTenDangNhapVaMatKhau(username, password);
        assertNull(result);
    }
    @Test
    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindByTenDangNhapVaMatKhau_Fall5() {
        System.out.println("findByTenDangNhapVaMatKhau_Fall5");
        String username = "trinhanhson1";
        String password = "201201";
        SinhVien result = sinhVienRepository.findByTenDangNhapVaMatKhau(username, password);
        assertNull(result);
    }
    @Test
    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindByTenDangNhapVaMatKhau_Fall6() {
        System.out.println("findByTenDangNhapVaMatKhau_Fall6");
        String username = "trinhanhson1";
        String password = "201202";
        SinhVien result = sinhVienRepository.findByTenDangNhapVaMatKhau(username, password);
        assertNull(result);
    }
}
