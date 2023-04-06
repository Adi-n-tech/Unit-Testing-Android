package com.github.unittestingandroid.utils

import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class PalindromeParameterizedExample(private val input: String, private val expected: Boolean) {

    @Test
    fun test() {
        val utility = Utility()
        val result = utility.checkPalindrome(input = input)
        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index} : {0} is result {1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("", true),
                arrayOf("hello", false),
                arrayOf("level", true),
                arrayOf("a", true)
            )
        }
    }
}