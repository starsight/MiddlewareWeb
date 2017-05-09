package com.sinnowa.dao;


import com.sinnowa.entity.DsLisoutputEntity;
import com.sinnowa.entity.PlLisoutputEntity;

import java.util.List;

public interface DSPLDao<T> {
	boolean createDSPL(T t);
	boolean updateDSPL(T t);
	List<T> getDSPL(String Time);
	//boolean deleteDSPL(String str);
}
