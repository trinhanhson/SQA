package com.example.btlsqa.repository;

import com.example.btlsqa.model.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Integer> {

    SinhVien findById(int id);

}