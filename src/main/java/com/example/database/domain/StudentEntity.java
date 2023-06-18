package com.example.database.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity(name = "STUDENT")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {

    @Id
    @Column(name = "SNO")
    private int sno;

    @Column(name = "PNO")
    private int pno;

    @Column(name = "SNAME")
    private String sname;

    @Column(name = "YEAR")
    private int year;

    @Column(name = "DEPT")
    private String dept;
}