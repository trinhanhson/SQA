/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.example.btlsqa.repository;

import com.example.btlsqa.model.LopHocPhan;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.*;
import org.springframework.transaction.annotation.Transactional;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
public class LopHocPhanRepositoryTest {

    @Autowired
    private LopHocPhanRepository lopHocPhanRepository;

    public LopHocPhanRepositoryTest() {
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
    public void testFindByMonHocId_Success() {
        System.out.println("findByMonHocId_Success");
        String maMonHoc = "BAS1150";
        List<LopHocPhan> result = lopHocPhanRepository.findByMonHocId(maMonHoc);
        assertNotEquals(result.size(), 0);
    }

    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindByMonHocId_Fall() {
        System.out.println("findByMonHocIdFall");
        String maMonHoc = "FFF";
        List<LopHocPhan> result = lopHocPhanRepository.findByMonHocId(maMonHoc);
        assertEquals(result.size(), 0);
    }

    @Transactional
    @org.junit.jupiter.api.Test
    public void testCheckSiSoThucTeById_Success() {
        System.out.println("checkSiSoThucTeById_Success");
        int id = 1;
        boolean result = lopHocPhanRepository.checkSiSoThucTeById(id);
        assertEquals(result, true);
    }

    @Transactional
    @org.junit.jupiter.api.Test
    public void testSetLopHocPhanById_Success() {
        System.out.println("setLopHocPhanById");
        int id = 1;
        int siSoThucTe = 2;
        lopHocPhanRepository.setLopHocPhanById(id, siSoThucTe);
        Optional<LopHocPhan> lopHocPhan = lopHocPhanRepository.findById((long) id);

        assertEquals(lopHocPhan.get().getSiSoThucTe(), siSoThucTe);
    }

    @Transactional
    @org.junit.jupiter.api.Test
    public void testSetLopHocPhanById_Fall() {
        System.out.println("setLopHocPhanById_Fall");
        int id = 0;
        int siSoThucTe = 2;
        lopHocPhanRepository.setLopHocPhanById(id, siSoThucTe);
        Optional<LopHocPhan> lopHocPhan = lopHocPhanRepository.findById((long) id);

        assertTrue(lopHocPhan.isEmpty());
    }

    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindById_Success() {
        System.out.println("findById_Success");
        int id = 1;
        Optional<LopHocPhan> lopHocPhan = lopHocPhanRepository.findById((long) id);

        assertTrue(lopHocPhan.isPresent());
    }

    @Transactional
    @org.junit.jupiter.api.Test
    public void testFindById_Fall() {
        System.out.println("findById_Fall");
        int id = 0;
        Optional<LopHocPhan> lopHocPhan = lopHocPhanRepository.findById((long) id);

        assertTrue(lopHocPhan.isEmpty());
    }

}
