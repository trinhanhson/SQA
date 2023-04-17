package com.example.btlsqa.repository;

import com.example.btlsqa.MocData;
import com.example.btlsqa.model.MonHoc;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@DisplayName("MonHocRepository Tests")
public class MonHocRepositoryTests {
    @Autowired private MonHocRepository monHocRepositoryrepository;

//    List<MonHoc> mockData = MocData.getMockDataMonHoc();
//
//    @BeforeAll
//    public static void initData(@Autowired MonHocRepository monHocRepository){
//        monHocRepository.saveAll(MocData.getMockDataMonHoc());
//    }
//
//    @Test
//    @DisplayName("getListMonHoc() should return unique monhoc name")
//    public void getListMonHoc_shouldReturnUniqueMonHocName() {
//        List<String> listMonHoc = monHocRepositoryrepository.getListMonHoc();
//        List<String> expectedListMonHoc = mockData.stream().map(MonHoc::getTen).distinct().toList();
//
//        Assertions
//                .assertThat(listMonHoc)
//                .isNotNull()
//                .hasSize(expectedListMonHoc.size())
//                .containsExactlyInAnyOrderElementsOf(expectedListMonHoc);
//    }


//    @ParameterizedTest
//    @DisplayName("getListDistrict() should return unique district name in given city")
//    @ValueSource(strings = {"Tỉnh Hưng Yên", "Thành phố Hà Nội", "Tỉnh Hải Dương"})
//    public void getListDistrict_shouldReturnUniqueDistrictNameInGivenCity(String city) {
//        List<String> listDistrict = monHocRepositoryrepository.getListMonHoc(city);
//        List<String> expectedListDistrict = mockData.stream().filter((d) -> d.getCity().equals(city)).map(BHYT::getDistrict).distinct().toList();
//
//        Assertions
//                .assertThat(listDistrict)
//                .isNotNull()
//                .hasSize(expectedListDistrict.size())
//                .containsExactlyInAnyOrderElementsOf(expectedListDistrict);
//    }
}
