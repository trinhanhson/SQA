package com.example.btlsqa;

import com.example.btlsqa.model.MonHoc;
import com.example.btlsqa.repository.MonHocRepository;
import com.example.btlsqa.service.MonHocService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BtlsqaApplicationTests {
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//    @InjectMocks
//    private MonHocService service;
//    @Mock
//    private MonHocRepository repository;
//    @Test
//    void contextLoads() {
//
//    }
//
//    @Test
//    public void getAllMonHoc(){
//        List<MonHoc> list = new ArrayList<>();
//        list.add(new MonHoc("b1","triet 1", 2));
//        list.add(new MonHoc("b2","triet 2", 3));
//        list.add(new MonHoc("b3","triet 3", 3));
//        list.add(new MonHoc("i1","iot 1", 2));
//        list.add(new MonHoc("i1","iot 2", 3));
//        Mockito.when(repository.findAll()).thenReturn(list);
//
//        // When
//        List<MonHoc> result = service.getAllMh();
//
//        // Then
//        assertNotNull(result);
//        assertEquals(5, result.size());
//        assertEquals("b1", result.get(0).getId());
//        assertEquals("triet 1", result.get(0).getTen());
//        assertEquals("b2", result.get(1).getId());
//        assertEquals("triet 2", result.get(1).getTen());
//
//    }

}
