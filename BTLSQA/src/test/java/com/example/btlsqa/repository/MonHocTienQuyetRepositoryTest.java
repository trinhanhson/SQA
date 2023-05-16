/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.example.btlsqa.repository;

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
public class MonHocTienQuyetRepositoryTest {

    @Autowired
    private MonHocTienQuyetRepository monHocTienQuyetRepository;

    public MonHocTienQuyetRepositoryTest() {
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
    public void testFindByMonHocId_Success() {
        System.out.println("findByMonHocId_Success");
        String monHocId = "BAS1152";
        List<String> result = monHocTienQuyetRepository.findByMonHocId(monHocId);
        assertNotEquals(result.size(), 0);
    }
    @Test
    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindByMonHocId_Fall() {
        System.out.println("findByMonHocId_Fall");
        String monHocId = "FFFF";
        List<String> result = monHocTienQuyetRepository.findByMonHocId(monHocId);
        assertEquals(result.size(), 0);
    }

}
