package com.example.btlsqa.service;

import com.example.btlsqa.model.MonHoc;
import com.example.btlsqa.repository.MonHocRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonHocService {
    private MonHocRepository repository;
    public List<MonHoc> getAllMh(){
        return repository.findAll();
    }
}
