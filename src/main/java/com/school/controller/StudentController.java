package com.school.controller;

import com.school.dto.CreateStudentDTO;
import com.school.dto.StudentDTO;
import com.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    @PostMapping
    public ResponseEntity<StudentDTO> create(@Valid @RequestBody CreateStudentDTO createDTO) {
        log.info("REST request to create student with createDTO: {}", createDTO);
        StudentDTO dto = service.create(createDTO);
        return ResponseEntity.created(URI.create("/api/students")).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAll(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        log.info("Rest request to get all students, page: {}, size: {}", page, size);
        List<StudentDTO> dtos = service.getAll(page, size);
        return ResponseEntity.ok(dtos);
    }
}
