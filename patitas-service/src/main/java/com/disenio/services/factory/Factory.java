package com.disenio.services.factory;

public interface Factory<T, K> {
    public T createFromDTO(K dto);
}
