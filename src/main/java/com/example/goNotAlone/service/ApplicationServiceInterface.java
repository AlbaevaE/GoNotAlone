package com.example.goNotAlone.service;

import com.example.goNotAlone.model.Application;

public interface ApplicationServiceInterface {
    Application addApp(Long userId, Long eventId, String message);

    Application confirmApp(Long userId, Long appId);




}
