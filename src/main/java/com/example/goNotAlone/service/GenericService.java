package com.example.goNotAlone.service;

import com.example.goNotAlone.model.Activity;

import java.util.List;

public interface GenericService<T> {
    Activity addG(T t);//save

    Activity getById(Long id);//get by id

    List<T> getAll();// get all

    void deleteById(Long id);// delete by id

    void deleteAll();// delete all

}
