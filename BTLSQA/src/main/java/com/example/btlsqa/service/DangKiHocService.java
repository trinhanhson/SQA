/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.btlsqa.service;

import com.example.btlsqa.model.DangKiHoc;
import com.example.btlsqa.repository.DangKiHocRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class DangKiHocService {

    @Autowired
    private DangKiHocRepository dangKiHocRepository;

    public List<DangKiHoc> getListDangKiHocBySinhVienId(int sinhVienId) {
        return dangKiHocRepository.findAllLopHocPhanDangDangKiBySinhVienId(sinhVienId);
    }

    public boolean checkStcValid(List<DangKiHoc> listDangKiHocMoi) {
        int stc = 0;
        for (DangKiHoc i : listDangKiHocMoi) {
            stc += i.getLopHocPhan().getMonHoc().getSoTinChi();
        }
        return stc >= 14 && stc <= 20;
    }
}
