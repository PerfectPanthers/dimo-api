package com.thoughtworks.service;

import com.thoughtworks.dimoapi.entity.Preference;
import com.thoughtworks.dimoapi.repository.PreferenceRepository;
import com.thoughtworks.dimoapi.repository.UserRepository;
import com.thoughtworks.dimoapi.service.DashboardServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;
import java.util.Map;

public class DashboardServiceImplTest {

    @InjectMocks
    DashboardServiceImpl dashboardService = new DashboardServiceImpl();

    @Mock
    PreferenceRepository mockPreferenceRepository = Mockito.mock(PreferenceRepository.class);

    @Mock
    UserRepository userRepository = Mockito.mock(UserRepository.class);

    @Mock
    MongoTemplate mongoTemplate = Mockito.mock(MongoTemplate.class);

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPreferences(){

        Map<String, List<Preference>> preferenceMap = dashboardService.getPreferences();

        Assert.assertEquals(3,preferenceMap.size());

        Assert.assertTrue(preferenceMap.containsKey("production_companies"));
        Assert.assertTrue(preferenceMap.containsKey("genres"));
        Assert.assertTrue(preferenceMap.containsKey("spoken_languages"));
    }

//    @Test
//    public void testGetMoviesByPreferences() {
//        List<String> preferences = new ArrayList<>();
//        preferences.add("en");
//        User user = new User("test@gmail.com","Test");
//        user.setPreferences(preferences);
//        Mockito.when(userRepository.findByEmail("test@gmail.com")).thenReturn(user);
//        Preference preference =  new Preference();
//        preference.setType("spoken_languages");
//        Mockito.when(mockPreferenceRepository.findByCode("en")).thenReturn(preference);
//        Map<String, List<Movie>> moviePreferenceMap = dashboardService.getMoviesByPreferences(user.getEmail());
//        Assert.assertEquals(1, moviePreferenceMap.size());
//    }
}
