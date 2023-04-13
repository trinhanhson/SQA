package com.example.btlsqa.model;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mon_hoc_tien_quyet")
public class MonHocTienQuyet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_mon_hoc")
    private MonHoc monHoc;

    @ManyToOne
    @JoinColumn(name = "id_mon_hoc_tien_quyet")
    private MonHoc monHocTienQuyet;

    @Override
    public String toString() {
        return "MonHocTienQuyet{" +
                "id=" + id +
                ", monHoc=" + monHoc +
                ", monHocTienQuyet=" + monHocTienQuyet +
                '}';
    }
}