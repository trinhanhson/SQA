package com.example.btlsqa.repository;

import com.example.btlsqa.model.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Integer> {
    SinhVien findById(int id);
    @Query("SELECT sv FROM SinhVien sv WHERE sv.tenDangNhap = :tenDangNhap AND sv.matKhau = :matKhau")
    SinhVien findByTenDangNhapVaMatKhau(@Param("tenDangNhap") String tenDangNhap, @Param("matKhau") String matKhau);
}