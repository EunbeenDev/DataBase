package com.example.database.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity(name = "PROFESSOR")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorEntity {

    @Id
    @Column(name = "PNO")
    private int pno;

    @Column(name = "PNAME")
    private String pname;

    @Column(name = "PMAJOR")
    private String pmajor;

    @Column(name = "PDEPT")
    private String pdept;

}