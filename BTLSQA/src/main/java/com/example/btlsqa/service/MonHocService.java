package com.example.btlsqa.service;

import com.example.btlsqa.model.MonHoc;
import com.example.btlsqa.repository.DangKiHocRepository;
import com.example.btlsqa.repository.MonHocRepository;


import com.example.btlsqa.repository.MonHocTienQuyetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MonHocService {
    @Autowired
    private MonHocTienQuyetRepository monHocTienQuyetRepository;

    @Autowired
    private DangKiHocRepository dangKiHocRepository;

    @Autowired
    private MonHocRepository monHocRepository;

//    public List<MonHoc> getAllMh() {
//        return monHocRepository.findAll();
//    }

    public List<MonHoc> searchByIdOrSubjectName(String keyWord) {
        List<MonHoc> list = monHocRepository.findByIdContainingIgnoreCaseOrTenContainingIgnoreCase(keyWord, keyWord);
        return list;
    }

    public Boolean checkPrerequisitesSubject(int idSinhVien, String idMonHoc) {
        // danh sách môn học sinh viên có id = idSinhVien đã hoàn thành
        List<String> finish = dangKiHocRepository.findMonHocBySinhVienId(idSinhVien);

        // danh sách môn học tiên quyết
        List<String> needToFinish = monHocTienQuyetRepository.findByMonHocId(idMonHoc);

        boolean flag = true;
        for (String x : needToFinish) {
            if (!finish.contains(x)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}