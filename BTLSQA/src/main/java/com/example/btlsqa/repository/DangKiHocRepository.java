package com.example.btlsqa.repository;

import com.example.btlsqa.model.DangKiHoc;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DangKiHocRepository extends JpaRepository<DangKiHoc, Integer> {
    @Transactional
    @Query("SELECT dk.lopHocPhan.monHoc.id FROM DangKiHoc dk WHERE dk.sinhVien.id = :sinhVienId AND dk.diemTongKet >= 1.6")
    List<String> findMonHocBySinhVienId(@Param("sinhVienId") Integer sinhVienId);
    
    @Transactional
    @Query("SELECT dk FROM DangKiHoc dk WHERE dk.sinhVien.id = :sinhVienId AND dk.soLanHoc=0")
    List<DangKiHoc> findAllLopHocPhanDangDangKiBySinhVienId(@Param("sinhVienId") Integer sinhVienId);
}

