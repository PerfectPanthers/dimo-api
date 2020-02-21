package com.thoughtworks.dimoapi.service;

import com.thoughtworks.dimoapi.entity.Movie;
import com.thoughtworks.dimoapi.entity.Preference;

import java.util.List;
import java.util.Map;

public interface DashboardService {

    Map<String, List<Preference>> getPreferences();

    Map<String, List<Movie>> getMoviesByPreferences(String userEmail);

}
