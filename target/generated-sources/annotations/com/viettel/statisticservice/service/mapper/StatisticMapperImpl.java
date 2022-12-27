package com.viettel.statisticservice.service.mapper;

import com.viettel.statisticservice.entity.Statistic;
import com.viettel.statisticservice.service.dto.StatisticDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-26T23:36:31+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_341 (Oracle Corporation)"
)
@Component
public class StatisticMapperImpl implements StatisticMapper {

    @Override
    public Statistic toEntity(StatisticDTO d) {
        if ( d == null ) {
            return null;
        }

        Statistic statistic = new Statistic();

        statistic.setId( d.getId() );
        statistic.setMessage( d.getMessage() );
        statistic.setCreateBy( d.getCreateBy() );
        statistic.setAccountId( d.getAccountId() );
        statistic.setClazz( d.getClazz() );

        return statistic;
    }

    @Override
    public StatisticDTO toDto(Statistic e) {
        if ( e == null ) {
            return null;
        }

        StatisticDTO statisticDTO = new StatisticDTO();

        statisticDTO.setId( e.getId() );
        statisticDTO.setMessage( e.getMessage() );
        statisticDTO.setCreateBy( e.getCreateBy() );
        statisticDTO.setAccountId( e.getAccountId() );
        statisticDTO.setClazz( e.getClazz() );

        return statisticDTO;
    }

    @Override
    public List<StatisticDTO> toDtos(List<Statistic> es) {
        if ( es == null ) {
            return null;
        }

        List<StatisticDTO> list = new ArrayList<StatisticDTO>( es.size() );
        for ( Statistic statistic : es ) {
            list.add( toDto( statistic ) );
        }

        return list;
    }

    @Override
    public List<Statistic> toEntities(List<StatisticDTO> ds) {
        if ( ds == null ) {
            return null;
        }

        List<Statistic> list = new ArrayList<Statistic>( ds.size() );
        for ( StatisticDTO statisticDTO : ds ) {
            list.add( toEntity( statisticDTO ) );
        }

        return list;
    }
}
