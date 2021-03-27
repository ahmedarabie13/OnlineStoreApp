package gov.iti.jets.team5.utils.mappers;

public abstract class AbstractDtoMapper<E,T> {
    public abstract E getDto(T entity);
}
