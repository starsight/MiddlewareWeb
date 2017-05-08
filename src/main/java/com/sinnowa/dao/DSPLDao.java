package com.sinnowa.dao;


import com.sinnowa.entity.PlLisoutputEntity;

import java.util.List;

public interface DSPLDao<T> {
	boolean updateDSPL(T t);
	List<T> getDSPL(String Time);
}
