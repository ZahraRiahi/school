package com.school.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class StudentDTO extends BaseStudentDTO {
    private Long id;
    private String email;
}
