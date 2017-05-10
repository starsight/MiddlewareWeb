package com.sinnowa.dao;


import com.sinnowa.entity.DsLisoutputEntity;
import com.sinnowa.entity.PlLisoutputEntity;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public interface DSPLDao<T> {
    T get(Class<T> entityclass, Serializable id);
    Serializable save(T t);
    void update(T t);
}
