package com.school.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BaseStudentDTO {
    @NotEmpty
    private String firstName;
    private String lastName;
}
