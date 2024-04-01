package org.teamraccoon.dreamfusion.generic;

public interface IGenericGetService<T> {
    
    T getById(Long id) throws Exception;
}
