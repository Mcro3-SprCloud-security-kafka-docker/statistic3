package com.viettel.statisticservice.service.mapper;

import com.viettel.statisticservice.entity.Statistic;
import com.viettel.statisticservice.service.dto.StatisticDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface StatisticMapper extends EntityMapper<Statistic, StatisticDTO> {
}
