/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.example.btlsqa.service;

import com.example.btlsqa.model.SinhVien;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author ADMIN
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SinhVienServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private SinhVienService sinhVienService;

    public SinhVienServiceTest() {
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

    @org.junit.jupiter.api.Test
    public void testLogin_TestSuccess() {
        System.out.println("Login_TestSuccess: Nhập đúng tên đăng nhập và mật khẩu");
        String username = "trinhanhson";
        String password = "201201";
        SinhVien expResult = new SinhVien(1, username, password, "Trinh Anh Son", "B19DCCN562");
        SinhVien result = sinhVienService.login(username, password);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getTenDangNhap(), result.getTenDangNhap());
        assertEquals(expResult.getMatKhau(), result.getMatKhau());
        assertEquals(expResult.getHoTen(), result.getHoTen());
        assertEquals(expResult.getMaSinhVien(), result.getMaSinhVien());

    }

    @org.junit.jupiter.api.Test
    public void testLogin_TestFall1() {
        System.out.println("Login_TestFall1: Nhập mỗi tên đăng nhập");
        String username = "trinhanhson";
        String password = "";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }

    @org.junit.jupiter.api.Test
    public void testLogin_TestFall2() {
        System.out.println("Login_TestFall2: Nhập mỗi mật khẩu");
        String username = "";
        String password = "201201";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }

    @org.junit.jupiter.api.Test
    public void testLogin_TestFall3() {
        System.out.println("Login_TestFall3: Không nhập gì cả");
        String username = "";
        String password = "";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }

    @org.junit.jupiter.api.Test
    public void testLogin_TestFall4() {
        System.out.println("Login_TestFall4: Nhập đúng tên đăng nhập và sai mật khẩu");
        String username = "trinhanhson";
        String password = "201202";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }

    @org.junit.jupiter.api.Test
    public void testLogin_TestFall5() {
        System.out.println("Login_TestFall5: Nhập sai tên đăng nhập và đúng mật khẩu");
        String username = "trinhanhson1";
        String password = "201201";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }

    @org.junit.jupiter.api.Test
    public void testLogin_TestFall6() {
        System.out.println("Login_TestFall6: Nhập sai tên đăng nhập và sai mật khẩu");
        String username = "trinhanhson1";
        String password = "201202";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
}
