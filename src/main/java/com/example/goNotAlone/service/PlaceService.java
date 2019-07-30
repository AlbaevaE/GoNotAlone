package com.example.goNotAlone.service;

import com.example.goNotAlone.model.Map;
import com.example.goNotAlone.model.Place;
import com.example.goNotAlone.model.User;

import java.util.List;

public interface PlaceService {
    List<Place> getPlaceByUser(User user);

    List<Place> getPlaceByMap(Map map);
}
