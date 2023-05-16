/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.example.btlsqa.repository;

import com.example.btlsqa.model.MonHoc;
import static org.junit.Assert.*;

import org.junit.*;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

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
public class MonHocRepositoryTest {

    @Autowired
    private MonHocRepository monHocRepository;

    public MonHocRepositoryTest() {
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
    public void testFindByIdContainingIgnoreCaseFull_Success() {
        System.out.println("findByIdContainingIgnoreCaseFull_Success");
        String id = "BAS1150";
        List<MonHoc> result = monHocRepository.findByIdContainingIgnoreCaseOrTenContainingIgnoreCase(id, id);
        assertNotEquals(result.size(), 0);
    }
    @Test
    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindByIdContainingIgnoreCasePart_Success() {
        System.out.println("findByIdContainingIgnoreCasePart_Success");
        String id = "BAS";
        List<MonHoc> result = monHocRepository.findByIdContainingIgnoreCaseOrTenContainingIgnoreCase(id, id);
        assertNotEquals(result.size(), 0);
    }
    @Test
    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindByIdContainingIgnoreCase_Fall() {
        System.out.println("findByIdContainingIgnoreCase_Fall");
        String id = "FFFFF";
        List<MonHoc> result = monHocRepository.findByIdContainingIgnoreCaseOrTenContainingIgnoreCase(id, id);
        assertEquals(result.size(), 0);
    }
    @Test
    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindByTenContainingIgnoreCaseFull_Success() {
        System.out.println("findByTenContainingIgnoreCaseFull_Success");
        String ten = "Đại số";
        List<MonHoc> result = monHocRepository.findByIdContainingIgnoreCaseOrTenContainingIgnoreCase(ten, ten);
        assertNotEquals(result.size(), 0);
    }
    @Test
    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindByTenContainingIgnoreCasePart_Success() {
        System.out.println("findByTenContainingIgnoreCasePart_Success");
        String ten = "Đại";
        List<MonHoc> result = monHocRepository.findByIdContainingIgnoreCaseOrTenContainingIgnoreCase(ten, ten);
        assertNotEquals(result.size(), 0);
    }
    @Test
    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindByTenContainingIgnoreCase_Fall() {
        System.out.println("findByTenContainingIgnoreCase_Fall");
        String ten = "FFFF";
        List<MonHoc> result = monHocRepository.findByIdContainingIgnoreCaseOrTenContainingIgnoreCase(ten, ten);
        assertEquals(result.size(), 0);
    }

    @Test
    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindByNameOrIdContainingIgnoreCase_Success() {
        System.out.println("findByTenContainingIgnoreCase_Fall");
        String ten = "";
        List<MonHoc> result = monHocRepository.findByIdContainingIgnoreCaseOrTenContainingIgnoreCase(ten, ten);
        assertNotEquals(result.size(), 0);
    }
}
