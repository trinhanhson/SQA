/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.btlsqa.service;

import com.example.btlsqa.model.SinhVien;
import com.example.btlsqa.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class SinhVienService {
    @Autowired
    private SinhVienRepository sinhVienRepository;
    
    public SinhVien login(String username, String password){
        return sinhVienRepository.findByTenDangNhapVaMatKhau(username, password);
    }
}
