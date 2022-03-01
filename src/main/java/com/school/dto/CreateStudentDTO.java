package com.school.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;

@EqualsAndHashCode(callSuper = true)
@Data
public class CreateStudentDTO extends BaseStudentDTO {
    @Email
    private String email;
}
