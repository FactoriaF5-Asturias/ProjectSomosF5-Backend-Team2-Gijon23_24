package org.teamraccoon.dreamfusion.generic;

import java.util.List;

public interface IGenericSearchService<T> {
    List<T> getManyByName(String name) throws Exception;
}