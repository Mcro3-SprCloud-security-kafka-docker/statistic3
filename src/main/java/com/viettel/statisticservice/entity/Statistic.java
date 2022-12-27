package com.viettel.statisticservice.entity;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name = "logs")
@Data
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message")
    private String message;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "clazz")
    private String clazz;
}
