package com.example.goNotAlone.service;

import java.util.List;

public interface GenericService<T> {
    T addG(T t);//save

    T getById(Long id);//get by id

    List<T> getAll();// get all

    void deleteById(Long id);// delete by id

    void deleteAll();// delete all

}
