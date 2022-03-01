package com.school.mapper;

import com.school.dto.CreateStudentDTO;
import com.school.dto.StudentDTO;
import com.school.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    /**
     * This method let us to map create dto to entity
     * @param createStudentDTO a dto for creating student
     * @return student entity
     */
    public Student fromCreateDTO(CreateStudentDTO createStudentDTO) {
        Student student = new Student();

        student.setFirstName(createStudentDTO.getFirstName());
        student.setLastName(createStudentDTO.getLastName() == null ? null : createStudentDTO.getLastName());
        student.setEmail(createStudentDTO.getEmail());

        return student;
    }

    public StudentDTO toDTO(Student entity) {
        StudentDTO dto = new StudentDTO();

        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());

        return dto;
    }
}
