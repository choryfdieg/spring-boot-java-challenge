package com.busticket.infra.converter;

public interface EntityConverter<E, P> {

    P entityToDomain(E e);

    E domainToEntity(P p);
}
