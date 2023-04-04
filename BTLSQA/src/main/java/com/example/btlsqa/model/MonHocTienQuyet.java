package com.example.btlsqa.model;

import jakarta.persistence.*;

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

    // constructors, getters, setters, toString

    public MonHocTienQuyet() {
    }

    public MonHocTienQuyet(Integer id, MonHoc monHoc, MonHoc monHocTienQuyet) {
        this.id = id;
        this.monHoc = monHoc;
        this.monHocTienQuyet = monHocTienQuyet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public MonHoc getMonHocTienQuyet() {
        return monHocTienQuyet;
    }

    public void setMonHocTienQuyet(MonHoc monHocTienQuyet) {
        this.monHocTienQuyet = monHocTienQuyet;
    }

    @Override
    public String toString() {
        return "MonHocTienQuyet{" +
                "id=" + id +
                ", monHoc=" + monHoc +
                ", monHocTienQuyet=" + monHocTienQuyet +
                '}';
    }
}