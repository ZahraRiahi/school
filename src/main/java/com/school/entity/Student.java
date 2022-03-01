package com.school.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Table(name = "school", indexes = {
        @Index(name = "email_idx", columnList = "email")
})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 40)
    private String firstName;

    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    private String secret;
}
