package com.viettel.statisticservice.service.mapper;

import java.util.List;

public interface EntityMapper<E, D> {
    E toEntity(D d);
    D toDto(E e);

    List<D> toDtos(List<E> es);
    List<E> toEntities(List<D> ds);
}
