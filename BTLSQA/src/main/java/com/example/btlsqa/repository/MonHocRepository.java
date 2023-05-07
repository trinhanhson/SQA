package com.example.btlsqa.repository;

import com.example.btlsqa.model.MonHoc;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MonHocRepository extends JpaRepository<MonHoc, String> {
    @Transactional
    @Override
    Optional<MonHoc> findById(String s);
    
    @Transactional
    @Query(value = "SELECT DISTINCT mh.ten FROM MonHoc mh")
    List<String> getListMonHoc();
    
    @Transactional
    List<MonHoc> findByIdContainingIgnoreCaseOrTenContainingIgnoreCase(String id, String ten);
}
