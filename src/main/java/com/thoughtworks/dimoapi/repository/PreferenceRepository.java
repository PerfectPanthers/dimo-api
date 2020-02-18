package com.thoughtworks.dimoapi.repository;

import com.thoughtworks.dimoapi.entity.Preference;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PreferenceRepository extends MongoRepository<Preference, String> {

    List findByType(String type);
}
