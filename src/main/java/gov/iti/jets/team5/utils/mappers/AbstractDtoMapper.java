package gov.iti.jets.team5.utils.mappers;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractDtoMapper<E,T> {
    public abstract E getDto(T entity);
    public List<E> getListDto(List<T> entities){
        return entities.stream().map(this::getDto).collect(Collectors.toList());
    }
}
