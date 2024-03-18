package org.teamraccoon.dreamfusion.generic;

public interface IGenericEditService<T, R> {

    R save(T type) throws Exception;
    R update(T type, Long id);
    
}
