package com.example.btlsqa.repository;

import com.example.btlsqa.model.MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MonHocRepository extends JpaRepository<MonHoc, String> {
    @Override
    Optional<MonHoc> findById(String s);

    List<MonHoc> findAllById(String s);

    List<MonHoc> findByIdContainingIgnoreCaseOrTenContainingIgnoreCase(String id, String ten);
}
