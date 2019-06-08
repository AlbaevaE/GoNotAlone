package com.example.goNotAlone.service;


import com.example.goNotAlone.model.Confirmation;

public interface GenService<T> {
    T confirm(Confirmation confirmation);
}
