package com.github.unittestingandroid.utils

import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test

class UtilityTest {

    lateinit var utility: Utility

    @Before
    fun beforeFun() {
        println("Before function")
        utility = Utility()
    }

    @After
    fun afterFun() {
        println("After function")
    }


    @Test
    fun isPalindromeInputStringLevelExpectedTrue() {
        // Arrange
        val utility = Utility()
        // Act
        val result = utility.checkPalindrome("level")
        // Assert
        assertEquals(true, result)
    }

 /*   @Test
    fun isPalindromeInputStringAdityaExpectedFalse() {
        // Arrange
       // val utility = Utility()
        // Act
        val result = utility.checkPalindrome("aditya")
        // Assert
        assertEquals(false, result)
    }*/
}