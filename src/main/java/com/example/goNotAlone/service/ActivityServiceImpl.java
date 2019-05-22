package com.example.goNotAlone.service;

import com.example.goNotAlone.model.Activity;
import com.example.goNotAlone.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements GenericService<Activity> {
    @Autowired
    private ActivityRepository activityRepository;


    @Override
    public Activity addG(Activity activity) {
        return this.activityRepository.save(activity);
    }

    @Override
    public Activity getById(Long id) {
        return this.activityRepository.findById(id).get();
    }

    @Override
    public List getAll() {
        return this.activityRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.activityRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.activityRepository.deleteAll();
    }
}
