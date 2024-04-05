package org.teamraccoon.dreamfusion.generic;

public interface IGenericEditService<T, R> {

    R update(T type, Long id);
    
}
