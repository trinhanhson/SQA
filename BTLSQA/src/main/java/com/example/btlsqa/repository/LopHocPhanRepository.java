package com.example.btlsqa.repository;

import com.example.btlsqa.model.LopHocPhan;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface LopHocPhanRepository extends JpaRepository<LopHocPhan, Long> {
    @Transactional
    List<LopHocPhan> findByMonHocId(String maMonHoc);
           
    @Transactional
    @Query("SELECT CASE WHEN COUNT(lhp) > 0 THEN true ELSE false END FROM LopHocPhan lhp WHERE lhp.id = :id AND lhp.siSoToiDa>lhp.siSoThucTe")
    boolean checkSiSoThucTeById(@Param("id") int id);
    
    @Transactional
    @Modifying
    @Query("update LopHocPhan lhp set lhp.siSoThucTe = :siSoThucTe where lhp.id = :id")
    void setLopHocPhanById(@Param("id") int id,@Param("siSoThucTe") int siSoThucTe);
}
