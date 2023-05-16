package com.example.btlsqa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mon_hoc")
public class MonHoc {

    @Id
    private String id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "so_tin_chi")
    private Integer soTinChi;
}
