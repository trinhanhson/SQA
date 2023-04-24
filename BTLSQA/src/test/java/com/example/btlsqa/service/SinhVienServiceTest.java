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

    @org.junit.jupiter.api.Test
    public void testLogin_TestFall7() {
        System.out.println("Login_TestFall7: Nhập sai tên đăng nhập và bỏ trống mật khẩu");
        String username = "trinhanhson1";
        String password = "";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }

    @org.junit.jupiter.api.Test
    public void testLogin_TestFall8() {
        System.out.println("Login_TestFall8: Bỏ trống tên đăng nhập và nhập sai mật khẩu");
        String username = "";
        String password = "201202";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }

    @org.junit.jupiter.api.Test
    public void testLogin_TestFall9() {
        System.out.println("Login_TestFall9: Nhập khoảng trắng vào tên đăng nhập và bỏ trống mật khẩu");
        String username = " ";
        String password = "";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }

    @org.junit.jupiter.api.Test
    public void testLogin_TestFall10() {
        System.out.println("Login_TestFall10: Bỏ trống tên đăng nhập và nhập khoảng trắng vào mật khẩu");
        String username = "";
        String password = " ";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }

    @org.junit.jupiter.api.Test
    public void testLogin_TestFall11() {
        System.out.println("Login_TestFall11: Nhập khoảng trắng vào tên đăng nhập và mật khẩu");
        String username = " ";
        String password = " ";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }

    @org.junit.jupiter.api.Test
    public void testLogin_TestFall12() {
        System.out.println("Login_TestFall12: Nhập đúng tên đăng nhập và khoảng trắng vào mật khẩu");
        String username = "trinhanhson";
        String password = " ";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }

    @org.junit.jupiter.api.Test
    public void testLogin_TestFall13() {
        System.out.println("Login_TestFall13: Nhập khoảng trắng vào tên đăng nhập và đúng mật khẩu");
        String username = " ";
        String password = "201201";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }

    @org.junit.jupiter.api.Test
    public void testLogin_TestFall14() {
        System.out.println("Login_TestFall14: Nhập sai tên đăng nhập và khoảng trắng vào mật khẩu");
        String username = "trinhanhson1";
        String password = " ";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }

    @org.junit.jupiter.api.Test
    public void testLogin_TestFall15() {
        System.out.println("Login_TestFall15: Nhập khoảng trắng vào tên đăng nhập và sai mật khẩu");
        String username = " ";
        String password = "201202";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall16() {
        System.out.println("Login_TestFall16: Nhập khoảng trắng vào trước tên đăng nhập đúng và đúng mật khẩu");
        String username = " trinhanhson";
        String password = "201201";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall17() {
        System.out.println("Login_TestFall17: Nhập khoảng trắng vào sau tên đăng nhập đúng và đúng mật khẩu");
        String username = "trinhanhson ";
        String password = "201201";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall18() {
        System.out.println("Login_TestFall18: Nhập khoảng trắng vào giữa tên đăng nhập đúng và đúng mật khẩu");
        String username = "t rinhanhson";
        String password = "201201";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall19() {
        System.out.println("Login_TestFall19: Nhập đúng tên đăng nhập và khoảng trắng vào trước mật khẩu đúng");
        String username = "trinhanhson";
        String password = " 201201";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall20() {
        System.out.println("Login_TestFall20: Nhập đúng tên đăng nhập và khoảng trắng vào sau mật khẩu đúng");
        String username = "trinhanhson";
        String password = "201201 ";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall21() {
        System.out.println("Login_TestFall21: Nhập đúng tên đăng nhập và khoảng trắng vào giữa mật khẩu đúng");
        String username = "trinhanhson";
        String password = "2 01201";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall22() {
        System.out.println("Login_TestFall22: Nhập khoảng trắng vào trước tên đăng nhập sai và đúng mật khẩu");
        String username = " trinhanhson1";
        String password = "201201";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall23() {
        System.out.println("Login_TestFall23: Nhập khoảng trắng vào sau tên đăng nhập sai và đúng mật khẩu");
        String username = "trinhanhson1 ";
        String password = "201201";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall24() {
        System.out.println("Login_TestFall24: Nhập khoảng trắng vào giữa tên đăng nhập sai và đúng mật khẩu");
        String username = "t rinhanhson1";
        String password = "201201";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall25() {
        System.out.println("Login_TestFall25: Nhập sai tên đăng nhập và khoảng trắng vào trước mật khẩu đúng");
        String username = "trinhanhson1";
        String password = " 201201";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall26() {
        System.out.println("Login_TestFall26: Nhập sai tên đăng nhập và khoảng trắng vào sau mật khẩu đúng");
        String username = "trinhanhson1";
        String password = "201201 ";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall27() {
        System.out.println("Login_TestFall27: Nhập sai tên đăng nhập và khoảng trắng vào giữa mật khẩu đúng");
        String username = "trinhanhson1";
        String password = "2 01201";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall28() {
        System.out.println("Login_TestFall28: Nhập khoảng trắng vào trước tên đăng nhập đúng và sai mật khẩu");
        String username = " trinhanhson";
        String password = "201202";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall29() {
        System.out.println("Login_TestFall29: Nhập khoảng trắng vào sau tên đăng nhập đúng và sai mật khẩu");
        String username = "trinhanhson ";
        String password = "201202";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall30() {
        System.out.println("Login_TestFall30: Nhập khoảng trắng vào giữa tên đăng nhập đúng và sai mật khẩu");
        String username = "t rinhanhson";
        String password = "201202";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall31() {
        System.out.println("Login_TestFall31: Nhập đúng tên đăng nhập và khoảng trắng vào trước mật khẩu sai");
        String username = "trinhanhson";
        String password = " 201202";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall32() {
        System.out.println("Login_TestFall32: Nhập đúng tên đăng nhập và khoảng trắng vào sau mật khẩu sai");
        String username = "trinhanhson";
        String password = "201202 ";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall33() {
        System.out.println("Login_TestFall33: Nhập đúng tên đăng nhập và khoảng trắng vào giữa mật khẩu sai");
        String username = "trinhanhson";
        String password = "2 01202";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall34() {
        System.out.println("Login_TestFall34: Nhập khoảng trắng vào trước tên đăng nhập sai và sai mật khẩu");
        String username = " trinhanhson1";
        String password = "201202";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall35() {
        System.out.println("Login_TestFall35: Nhập khoảng trắng vào sau tên đăng nhập sai và sai mật khẩu");
        String username = "trinhanhson1 ";
        String password = "201202";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall136() {
        System.out.println("Login_TestFall36: Nhập khoảng trắng vào giữa tên đăng nhập sai và sai mật khẩu");
        String username = "t rinhanhson1";
        String password = "201202";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall37() {
        System.out.println("Login_TestFall37: Nhập sai tên đăng nhập và khoảng trắng vào trước mật khẩu sai");
        String username = "trinhanhson";
        String password = " 201201";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall38() {
        System.out.println("Login_TestFall38: Nhập đúng tên đăng nhập và khoảng trắng vào sau mật khẩu đúng");
        String username = "trinhanhson1";
        String password = "201202 ";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
    
    @org.junit.jupiter.api.Test
    public void testLogin_TestFall39() {
        System.out.println("Login_TestFall39: Nhập sai tên đăng nhập và khoảng trắng vào giữa mật khẩu sai");
        String username = "trinhanhson1";
        String password = "2 01202";
        SinhVien result = sinhVienService.login(username, password);
        assertNull(result);
    }
}
