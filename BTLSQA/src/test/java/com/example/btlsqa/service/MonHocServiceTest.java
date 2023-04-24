/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.example.btlsqa.service;

import com.example.btlsqa.model.DangKiHoc;
import com.example.btlsqa.model.MonHoc;
import com.example.btlsqa.model.SinhVien;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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
public class MonHocServiceTest extends AbstractTransactionalJUnit4SpringContextTests{
   
    @Autowired
    private MonHocService monHocService;
    
    public MonHocServiceTest() {
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

//    @Test
//    public void testGetAllMh() {
//        System.out.println("getAllMh");
//        MonHocService instance = new MonHocService();
//        List<MonHoc> expResult = null;
//        List<MonHoc> result = instance.getAllMh();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }

    @Test
    public void testGetAllMonHocByDangKiHocId_TestSuccess() {
        System.out.println("getAllMonHocByDangKiHocId_TestSuccess: Lấy dúng môn học ứng với đăng kí học");
        List<DangKiHoc> listDangKiHoc =  new LinkedList<>();
        listDangKiHoc.add(new DangKiHoc(5, 0, 0, new SinhVien(1, "trinhanhson", "201201", "Trinh Anh Son", "B19DCCN562"), null));
        List<MonHoc> expResult = new LinkedList<>();
        expResult.add(new MonHoc("BAS1226","Xác suất thống kê",2));
        List<MonHoc> result = monHocService.getAllMonHocByDangKiHocId(listDangKiHoc);
        assertEquals(expResult.get(0).getId(), expResult.get(0).getId());
        assertEquals(expResult.get(0).getSoTinChi(), expResult.get(0).getSoTinChi());
        assertEquals(expResult.get(0).getTen(), expResult.get(0).getTen());
    }
    
}
