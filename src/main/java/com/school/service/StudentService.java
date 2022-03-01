package com.school.service;

import com.school.dto.CreateStudentDTO;
import com.school.dto.StudentDTO;
import com.school.entity.Student;
import com.school.mapper.StudentMapper;
import com.school.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;
    private final StudentMapper mapper;

    public StudentDTO create(CreateStudentDTO createDTO) {
        log.debug("enter create, createDTO: {}", createDTO);

        Student student = mapper.fromCreateDTO(createDTO);
        UUID secret = UUID.randomUUID();
        student.setSecret(secret.toString());

        repository.save(student);

        StudentDTO dto = mapper.toDTO(student);

        log.debug("exit create, studentDTO: {}", dto);
        return dto;
    }

    public List<StudentDTO> getAll(int page, int size) {
        log.debug("enter getAll(), page: {}, size: {}", page, size);

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "id");
        Page<Student> studentPage = repository.findAll(pageable);
        log.debug("get students from DB, studentPages: {}", studentPage);

        List<StudentDTO> returnValue = studentPage.stream()
                .filter(Objects::nonNull)
                .map(mapper::toDTO)
                .collect(Collectors.toList());
        log.debug("exit getAll(), list studentDTO: {}", returnValue);
        return returnValue;
    }

    /*

    1- get all students from DB -----> Studnt (entity)

    2- filter students is null

    3- student ---> studentDTO

     */
}
