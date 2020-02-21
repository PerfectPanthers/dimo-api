package com.thoughtworks.dimoapi.service;

import com.thoughtworks.dimoapi.entity.Movie;
import com.thoughtworks.dimoapi.entity.Preference;
import com.thoughtworks.dimoapi.entity.User;
import com.thoughtworks.dimoapi.exception.InvalidUserException;
import com.thoughtworks.dimoapi.repository.MovieRepository;
import com.thoughtworks.dimoapi.repository.PreferenceRepository;
import com.thoughtworks.dimoapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    PreferenceRepository preferenceRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    UserRepository userRepository;

    @Override
    public Map<String, List<Preference>> getPreferences() {
        Map<String, List<Preference>> movieTypesList = new HashMap<>();
        movieTypesList.put("production_companies", preferenceRepository.findByType("production_companies"));
        movieTypesList.put("genres", preferenceRepository.findByType("genres"));
        movieTypesList.put("spoken_languages", preferenceRepository.findByType("spoken_languages"));
        return movieTypesList;
    }

    @Override
    public Map<String, List<Movie>> getMoviesByPreferences(String userEmail) throws InvalidUserException {
        Map<String, List<Movie>> movieListWithType = new HashMap<>();

        List<String> userPreferences;
        User user = userRepository.findByEmail(userEmail);

        if (user == null){
            throw new InvalidUserException("User Email is Invalid");
        }

        userPreferences = user.getPreferences();
        for (String code : userPreferences) {

            Preference preference = preferenceRepository.findByCode(code);
            if ("spoken_languages".equals(preference.getType())) {
                Query query = new Query();
                query.addCriteria(Criteria.where("spoken_languages.id").is(code))
                        .with(Sort.by(Sort.Direction.DESC, "vote_average")).limit(4);
                List<Movie> movieList = mongoTemplate.find(query, Movie.class);
                movieListWithType.put(preference.getItemName(), movieList);

            } else {
                Query query = new Query();
                query.addCriteria(Criteria.where(preference.getType() + ".id").is(Integer.parseInt(code)))
                        .with(Sort.by(Sort.Direction.DESC, "vote_average")).limit(4);
                List<Movie> movieList = mongoTemplate.find(query, Movie.class);
                movieListWithType.put(preference.getItemName(), movieList);
            }

        }
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "popularity")).limit(4);
        List<Movie> movieList = mongoTemplate.find(query, Movie.class);
        movieListWithType.put("Trending", movieList);

        return movieListWithType;
    }


}
