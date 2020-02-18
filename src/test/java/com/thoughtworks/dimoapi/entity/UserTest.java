package com.thoughtworks.dimoapi.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserTest {

    @Test
    public void checkUserDetailIsnullIfNotGiven() {
        User user = new User();
        assertEquals(user.getUserId(), null);
        assertEquals(user.getName(), null);
        assertNotNull(user.getCreationDate());
        assertNotNull(user.getUserSettings());
    }

    @Test
    public void checkUserDetailIsnullIfDataGiven() {
        User user = new User("1234", "Mugil");
        assertEquals(user.getUserId(), "1234");
        assertEquals(user.getName(), "Mugil");
        assertNotNull(user.getCreationDate());
        assertNotNull(user.getUserSettings());
    }
}