package com.example.database.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity(name = "ENROLL")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(EnrollId.class)
public class EnrollEntity  {

    @Id
    @Column(name = "SNO")
    private int sno;
    @Id
    @Column(name = "CNO")
    private String cno;

    @Column(name = "GRADE")
    private String grade;

    @Column(name = "EXAM")
    private int exam;

}