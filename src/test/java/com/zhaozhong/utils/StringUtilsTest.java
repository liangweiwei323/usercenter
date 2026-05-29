package com.zhaozhong.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for custom StringUtils
 * Ensures isAnyBlank() works correctly
 * 
 */
public class StringUtilsTest {

    @Test
    public void testIsAnyBlank_AllBlank() {
        assertTrue(StringUtils.isAnyBlank("", null, "  "));
    }

    @Test
    public void testIsAnyBlank_SomeBlank() {
        assertTrue(StringUtils.isAnyBlank("valid", null, "test"));
    }

    @Test
    public void testIsAnyBlank_NoBlank() {
        assertFalse(StringUtils.isAnyBlank("hello", "world", "test"));
    }

    @Test
    public void testIsAnyBlank_EmptyArray() {
        assertFalse(StringUtils.isAnyBlank());
    }

    @Test
    public void testIsAnyBlank_NullArray() {
        assertTrue(StringUtils.isAnyBlank((String[]) null));
    }

    @Test
    public void testIsAnyBlank_SingleNull() {
        assertTrue(StringUtils.isAnyBlank((String) null));
    }

    @Test
    public void testIsAnyBlank_SingleEmpty() {
        assertTrue(StringUtils.isAnyBlank(""));
    }

    @Test
    public void testIsAnyBlank_SingleWhitespace() {
        assertTrue(StringUtils.isAnyBlank("   "));
    }

    @Test
    public void testIsAnyBlank_SingleValid() {
        assertFalse(StringUtils.isAnyBlank("valid"));
    }


    /**
     * Test the actual use case from UserController and UserServiceImpl
     */
    @Test
    public void testUserRegistrationValidation() {
        String userAccount = "testuser123";
        String userPassword = "password123";
        String checkPassword = "password123";
        String planetCode = "planet123";

        // Should not be blank
        assertFalse(StringUtils.isAnyBlank(userAccount, userPassword, checkPassword, planetCode));
    }

    @Test
    public void testUserRegistrationValidation_WithBlank() {
        String userAccount = "testuser123";
        String userPassword = "";
        String checkPassword = "password123";
        String planetCode = "planet123";

        // Should be blank (empty password)
        assertTrue(StringUtils.isAnyBlank(userAccount, userPassword, checkPassword, planetCode));
    }

    @Test
    public void testUserLoginValidation() {
        String userAccount = "testuser123";
        String userPassword = "password123";

        // Should not be blank
        assertFalse(StringUtils.isAnyBlank(userAccount, userPassword));
    }

    @Test
    public void testUserLoginValidation_WithBlank() {
        String userAccount = null;
        String userPassword = "password123";

        // Should be blank (null account)
        assertTrue(StringUtils.isAnyBlank(userAccount, userPassword));
    }
}

