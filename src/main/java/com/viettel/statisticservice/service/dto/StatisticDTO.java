package com.viettel.statisticservice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "id")
public class StatisticDTO {
    private Long id;
    private String message;
    private String createBy;
    private Long accountId;
    private String clazz;
}
