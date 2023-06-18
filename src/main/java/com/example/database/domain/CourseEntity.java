package com.example.database.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity(name = "COURSE")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity {

    @Id
    @Column(name = "CNO")
    private String cno;

    @Column(name = "CNAME")
    private String cname;

    @Column(name = "CREDIT")
    private int credit;

    @Column(name = "SESSIONS")
    private int sessions;

}