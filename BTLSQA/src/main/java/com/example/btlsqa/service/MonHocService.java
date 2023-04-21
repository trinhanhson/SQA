package com.example.btlsqa.service;

import com.example.btlsqa.model.DangKiHoc;
import com.example.btlsqa.model.MonHoc;
import com.example.btlsqa.repository.MonHocRepository;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MonHocService {
    
    @Autowired
    private MonHocRepository repository;
    
    public List<MonHoc> getAllMh(){
        return repository.findAll();
    }
    
    public List<MonHoc> getAllMonHocByDangKiHocId(List<DangKiHoc> listDangKiHoc){
        List<MonHoc> listMonHoc = new ArrayList<>();

        for (DangKiHoc i : listDangKiHoc) {
            Optional<MonHoc> monHoc = repository.findByLopHocPhanId(i.getLopHocPhan().getId());
            listMonHoc.add(monHoc.get());
        }
        
        return listMonHoc;
    }
}
