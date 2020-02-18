package com.thoughtworks.dimoapi.dao;

import com.thoughtworks.dimoapi.entity.User;
import com.thoughtworks.dimoapi.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = "test")
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    User popeye = new User("686892112871271fghfgh1676166", "Popeye");
    User pluto = new User("6896832234132nmbhg23q233", "Pluto");
    User tom = new User("323423423234234jbhjghg5656675", "Tom");
    User jerry = new User("78787875452332hghjghgh87787878", "Jerry");

    @Before
    public void setUp() throws Exception {
        userRepository.save(pluto);
        userRepository.save(tom);
        userRepository.save(jerry);
    }

    @Test
    public void testViewingAllUser() {
        assertEquals(userRepository.findAll().size(), 3);
    }

    @Test
    public void testSavingUser() {
        assertEquals(popeye.getName(), userRepository.save(popeye).getName());
    }


    @Test
    public void testBulkWriteUser() {
        assertEquals(popeye.getName(), userRepository.save(popeye).getName());
    }

    @After
    public void tearDown() throws Exception {
        userRepository.deleteAll();
    }
}