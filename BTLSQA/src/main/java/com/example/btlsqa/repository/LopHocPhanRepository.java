package com.example.btlsqa.repository;

import com.example.btlsqa.model.LopHocPhan;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LopHocPhanRepository extends JpaRepository<LopHocPhan, Long> {
    @Transactional
    List<LopHocPhan> findByMonHocId(String maMonHoc);
//    List<LopHocPhan> findById(String id);
}
