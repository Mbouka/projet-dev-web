package com.projetWeb.citwe.model.mapper;

import java.util.List;
import java.util.Set;

public interface EntityMapper<D, E> {

    static E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);

    Set<D> toDto(Set<E> entityList);
}
