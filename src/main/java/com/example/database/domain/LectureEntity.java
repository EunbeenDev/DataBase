package com.example.database.domain;

import lombok.*;

import javax.persistence.*;

@Entity(name = "LECTURE")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(LectureId.class)
public class LectureEntity  {

    @Id
    @Column(name = "CNO")
    private String cno;

    @Id
    @Column(name = "PNO")
    private int pno;

    @Column(name = "LEC_TIME")
    private String lecTime;

    @Column(name = "ROOM")
    private String room;

}
