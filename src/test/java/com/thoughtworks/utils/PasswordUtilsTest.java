package com.thoughtworks.utils;

import com.thoughtworks.dimoapi.utils.PasswordUtils;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordUtilsTest {

    @Test
    public void testEncrypt() {
        assertEquals("a", PasswordUtils.decrypt(PasswordUtils.encrypt("a")));
    }


}
