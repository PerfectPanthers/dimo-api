package com.thoughtworks.dimoapi.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void checkUserDetailIsnullIfNotGiven() {
        User user = new User();
        assertNull(user.getUserId());
        assertNull(user.getName());
    }

    @Test
    public void checkUserDetailIsnullIfDataGiven() {
        User user = new User("1234", "Mugil", "abc@gmail.com");
        assertEquals(user.getUserId(), "1234");
        assertEquals(user.getName(), "Mugil");
    }
}