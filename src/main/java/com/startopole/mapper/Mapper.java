package com.startopole.mapper;

public interface Mapper {

    <T> T map(Object source, Class<T> targetClass);
}
