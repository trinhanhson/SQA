package com.example.btlsqa.repository;

import com.example.btlsqa.model.MonHocTienQuyet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MonHocTienQuyetRepository extends JpaRepository<MonHocTienQuyet, Integer> {

    List<MonHocTienQuyet> findByMonHoc_Id(String s);

    @Query("SELECT m.monHocTienQuyet.id FROM MonHocTienQuyet m WHERE m.monHoc.id = :monHocId")
    List<String> findByMonHocId(@Param("monHocId") String monHocId);

}
