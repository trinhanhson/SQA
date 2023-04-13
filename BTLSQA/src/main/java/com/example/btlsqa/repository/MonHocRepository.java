package com.example.btlsqa.repository;

import com.example.btlsqa.model.MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;



@Repository
public interface MonHocRepository extends JpaRepository<MonHoc, String> {
    @Override
    Optional<MonHoc> findById(String s);

//    @Query(value = "SELECT dk.lopHocPhan.id FROM DangKiHoc dk WHERE dk.sinhVien.id = :sinhVienId")
//    Optional<MonHoc> findByLopHocPhanId(@Param("lopHocPhanId") Integer lopHocPhanId);
    @Query(value = "SELECT DISTINCT mh.ten FROM MonHoc mh")
    List<String> getListMonHoc();
    List<MonHoc> findByIdContainingIgnoreCaseOrTenContainingIgnoreCase(String id, String ten);
}
