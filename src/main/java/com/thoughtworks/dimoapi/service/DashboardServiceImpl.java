package com.thoughtworks.dimoapi.service;

import com.thoughtworks.dimoapi.repository.PreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    PreferenceRepository preferenceRepository;

    @Override
    public Map<String, List> getMovieTypes() {
        Map<String, List> movieTypesList = new HashMap<>();
        movieTypesList.put("production_companies", preferenceRepository.findByType("production_companies"));
        movieTypesList.put("genres", preferenceRepository.findByType("genres"));
        movieTypesList.put("spoken_languages", preferenceRepository.findByType("spoken_languages"));
        return movieTypesList;
    }
}
