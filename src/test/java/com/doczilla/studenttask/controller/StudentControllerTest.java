package com.doczilla.studenttask.controller;

import com.doczilla.studenttask.service.StudentService;
import com.doczilla.studenttask.service.dto.StudentRequestDto;
import com.doczilla.studenttask.service.dto.StudentResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureJsonTesters
@JsonTest
class StudentControllerTest {

    private StudentController studentController;
    @Mock
    private StudentService studentService;
    private StudentResponseDto studentResponseDto;
    private StudentRequestDto studentRequestDto;
    private List<StudentResponseDto> response;
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        studentController = new StudentController(studentService);
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
        studentResponseDto = new StudentResponseDto(1L,"Sidor", "Sidorov", "Sidorovich", Date.valueOf("2000-5-1"), "a1");
        studentRequestDto = new StudentRequestDto("Ivan", "Ivanov", "Ivanovich", LocalDate.of(2000, 6, 2), "a1");
        response = List.of(studentResponseDto);
    }

    @Test
    void createTest() throws Exception {
        when(studentController.create(any())).thenReturn(1L);
        mockMvc.perform(post("/api/v1/students")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(studentRequestDto)))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void findAllTest() throws Exception {
        when(studentService.findAll()).thenReturn(response);
        mockMvc.perform(get("/api/v1/students")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(response)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName", equalTo("Sidor")))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void deleteTest() throws Exception {
        mockMvc.perform(delete("/api/v1/students/1")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(null)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}