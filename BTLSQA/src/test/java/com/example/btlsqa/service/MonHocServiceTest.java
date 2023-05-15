package com.example.btlsqa.service;

import com.example.btlsqa.MocData;
import com.example.btlsqa.model.MonHoc;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class MonHocServiceTest {

    @Autowired
    private MonHocService monHocService;

    private List<MonHoc> mockMonHocList;

    @BeforeEach
    void setUp() {
        mockMonHocList = MocData.getMockDataMonHoc();
    }

    @AfterEach
    void tearDown() {
    }

    @Transactional
    @Test
    @DisplayName("tìm kiếm theo đúng id môn học")
    public void searchByIdOrSubjectName_withId() {
        String keyWord = "BAS1122";
        List<MonHoc> listExpected = List.of(mockMonHocList.get(0));
        List<MonHoc> listActual = monHocService.searchByIdOrSubjectName(keyWord);
        assertEquals(listExpected.size(), listActual.size());
        assertEquals(listExpected.get(0).getId(), listActual.get(0).getId());
        assertEquals(listExpected.get(0).getTen(), listActual.get(0).getTen());
        assertEquals(listExpected.get(0).getSoTinChi(), listActual.get(0).getSoTinChi());
    }

    @Transactional
    @Test
    @DisplayName("tìm kiếm theo id môn học chưa đầy đủ")
    public void searchByIdOrSubjectName_withIdIncomplete() {
        String keyWord = "INT";
        List<MonHoc> listExpected = List.of(mockMonHocList.get(11), mockMonHocList.get(12),
                mockMonHocList.get(13), mockMonHocList.get(14));
        List<MonHoc> listActual = monHocService.searchByIdOrSubjectName(keyWord);
        assertEquals(listExpected.size(), listActual.size());
        for (int i = 0; i < listActual.size(); i++) {
            assertEquals(listExpected.get(i).getId(), listActual.get(i).getId());
            assertEquals(listExpected.get(i).getTen(), listActual.get(i).getTen());
            assertEquals(listExpected.get(i).getSoTinChi(), listActual.get(i).getSoTinChi());
        }
    }

    @Transactional
    @Test
    @DisplayName("tìm kiếm theo đúng tên môn học")
    public void searchByIdOrSubjectName_withName() {
        String keyWord = "Kỹ thuật số";
        List<MonHoc> listExpected = List.of(mockMonHocList.get(10));
        List<MonHoc> listActual = monHocService.searchByIdOrSubjectName(keyWord);
        assertEquals(listExpected.size(), listActual.size());
        assertEquals(listExpected.get(0).getId(), listActual.get(0).getId());
        assertEquals(listExpected.get(0).getTen(), listActual.get(0).getTen());
        assertEquals(listExpected.get(0).getSoTinChi(), listActual.get(0).getSoTinChi());
    }

    @Transactional
    @Test
    @DisplayName("tìm kiếm theo tên môn học chưa đầy đủ")
    public void searchByIdOrSubjectName_withNameIncomplete() {
        String keyWord = "học";
        List<MonHoc> listExpected = List.of(mockMonHocList.get(1), mockMonHocList.get(3),
                mockMonHocList.get(11), mockMonHocList.get(12));
        List<MonHoc> listActual = monHocService.searchByIdOrSubjectName(keyWord);
        assertEquals(listExpected.size(), listActual.size());
        for (int i = 0; i < listActual.size(); i++) {
            assertEquals(listExpected.get(i).getId(), listActual.get(i).getId());
            assertEquals(listExpected.get(i).getTen(), listActual.get(i).getTen());
            assertEquals(listExpected.get(i).getSoTinChi(), listActual.get(i).getSoTinChi());
        }
    }

    @Transactional
    @Test
    @DisplayName("tìm kiếm theo từ khóa trống")
    public void searchByIdOrSubjectName_keyEmpty() {
        String keyWord = "";
        List<MonHoc> listExpected = mockMonHocList;
        List<MonHoc> listActual = monHocService.searchByIdOrSubjectName(keyWord);
        assertEquals(listExpected.size(), listActual.size());
        for (int i = 0; i < listActual.size(); i++) {
            assertEquals(listExpected.get(i).getId(), listActual.get(i).getId());
            assertEquals(listExpected.get(i).getTen(), listActual.get(i).getTen());
            assertEquals(listExpected.get(i).getSoTinChi(), listActual.get(i).getSoTinChi());
        }
    }

    @Transactional
    @Test
    @DisplayName("tìm kiếm theo từ khóa không tồn tại trong danh sách môn học")
    public void searchByIdOrSubjectName_listEmpty() {
        String keyWord = "FFFFF";
        List<MonHoc> listActual = monHocService.searchByIdOrSubjectName(keyWord);
        assertThat(listActual).isEmpty();
    }

    @Transactional
    @DisplayName("kiểm tra chọn môn học thành công")
    @Test
    public void checkPrerequisitesSubject_success() {
        int idSinhVien = 1;
        String idMonHoc = "BAS1150";
        boolean expected = true;
        boolean actual = monHocService.checkPrerequisitesSubject(idSinhVien, idMonHoc);
        assertEquals(expected, actual);
    }

    @Transactional
    @Test
    @DisplayName("kiểm tra chọn môn học thất bại")
    public void checkPrerequisitesSubject_fail() {
        int idSinhVien = 1;
        String idMonHoc = "BAS1122";
        boolean expected = false;
        boolean actual = monHocService.checkPrerequisitesSubject(idSinhVien, idMonHoc);
        assertEquals(expected, actual);
    }
}