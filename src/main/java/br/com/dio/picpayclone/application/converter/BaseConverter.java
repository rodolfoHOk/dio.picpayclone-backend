package br.com.dio.picpayclone.application.converter;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseConverter<E, D> {

    public abstract D entityToDtoConverter(E entity);

    public abstract E dtoToEntityConverter(D dto);

    public List<D> entitiesToDtosConverter(List<E> entities) {
        List<D> dtos = new ArrayList<>();
        entities.forEach(entity -> dtos.add(entityToDtoConverter(entity)));
        return dtos;
    }

    public List<E> dtosToEntitiesConverter(List<D> dtos) {
        List<E> entities = new ArrayList<>();
        dtos.forEach(dto -> entities.add(dtoToEntityConverter(dto)));
        return entities;
    }

}
