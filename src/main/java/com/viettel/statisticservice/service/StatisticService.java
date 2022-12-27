package com.viettel.statisticservice.service;

import com.viettel.statisticservice.service.dto.StatisticDTO;

import java.util.List;

public interface StatisticService {
    List<StatisticDTO> getAllStatistic();
    Long addStatistic(StatisticDTO dto) throws Exception;
}
