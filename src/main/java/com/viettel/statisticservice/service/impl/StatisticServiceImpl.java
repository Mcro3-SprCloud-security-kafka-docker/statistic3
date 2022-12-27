package com.viettel.statisticservice.service.impl;

import com.viettel.statisticservice.comon.FileWriter;
import com.viettel.statisticservice.repository.StatisticRepository;
import com.viettel.statisticservice.service.StatisticService;
import com.viettel.statisticservice.service.dto.StatisticDTO;
import com.viettel.statisticservice.service.mapper.StatisticMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Repository
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    private StatisticMapper statisticMapper;

    @Autowired
    private StatisticRepository statisticRepository;

    @Override
    public List<StatisticDTO> getAllStatistic() {
        return statisticMapper.toDtos(statisticRepository.findAll());
    }

    @Override
    public Long addStatistic(StatisticDTO dto) throws Exception {
        if (Objects.isNull(dto)) {
            throw new Exception("Can not add null statistic");
        }

//        try{
//            TimeUnit.SECONDS.sleep(1);
//        }catch (Exception e){
//            throw e;
////            e.printStackTrace();
//        }
        FileWriter.writeDataToFile(dto);
        return statisticRepository.save(statisticMapper.toEntity(dto)).getId();
    }
}
