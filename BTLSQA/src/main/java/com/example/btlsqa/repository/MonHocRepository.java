package com.example.btlsqa.repository;

import com.example.btlsqa.model.MonHoc;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MonHocRepository extends JpaRepository<MonHoc, String> {  
    @Transactional
    List<MonHoc> findByIdContainingIgnoreCaseOrTenContainingIgnoreCase(String id, String ten);
}
