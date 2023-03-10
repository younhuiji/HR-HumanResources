package com.sohwakmo.hr.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;


@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity(name = "MESSAGE")
@SequenceGenerator(name = "MESSAGE_SEQ_GEN", sequenceName = "MESSAGE_SEQ", allocationSize = 1)
public class Message extends BaseTimeEntityMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MESSAGE_SEQ_GEN")
    private Integer messageNo;
    private String messageType;
    private String title;
    private String content;
    private String filePath1;
    private String fileName1;
    private String filePath2;
    private String fileName2;
    private String filePath3;
    private String fileName3;
    private String receiveNo;
    @ColumnDefault("0")
    private Integer receiveReadCheck;
    @ColumnDefault("0")
    private Integer receiveTrash;
    @ColumnDefault("0")
    private Integer receiveDelete;
    private String senderNo;
    @ColumnDefault("0")
    private Integer senderTrash;
    @ColumnDefault("0")
    private Integer senderDelete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "employeeNo")
    private Employee senderEmployee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "employeeNo")
    private Employee receiveEmployee;

}
