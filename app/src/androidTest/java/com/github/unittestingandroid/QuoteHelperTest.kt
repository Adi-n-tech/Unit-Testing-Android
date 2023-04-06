package com.github.unittestingandroid

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.io.FileNotFoundException

internal class QuoteHelperTest {

    @Test(expected = FileNotFoundException::class)
    fun populateQuoteFromAssetsExpectedException() {
        val quoteHelper = QuoteHelper()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteHelper.populateQuoteFromAssets(context, "")
    }

    @Test(expected = JsonSyntaxException::class)
    fun populateQuoteFromAssetsExpectedJsonSyntaxException() {
        val quoteHelper = QuoteHelper()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteHelper.populateQuoteFromAssets(context, "quotes_invalid.json")
    }

    @Test
    fun populateQuoteFromAssets() {
        val quoteHelper = QuoteHelper()
        val context =
            ApplicationProvider.getApplicationContext<Context>() // getting the context inside test class
        quoteHelper.populateQuoteFromAssets(context, "quotes.json")
        assertEquals(12, quoteHelper.quoteList.size)
    }

    @Test
    fun testPreviousQuote() {
        val quoteHelper = QuoteHelper()
        val context =
            ApplicationProvider.getApplicationContext<Context>() // getting the context inside test class
        quoteHelper.populateQuoteFromAssets(context, "quotes.json")
        val quote = quoteHelper.getPreviousQuote()
        assertEquals(quoteHelper.quoteList[0].author, quote.author)
    }

    @Test
    fun testNextQuote() {
        val quoteHelper = QuoteHelper()
        val context =
            ApplicationProvider.getApplicationContext<Context>() // getting the context inside test class
        quoteHelper.populateQuoteFromAssets(context, "quotes.json")
        val quote = quoteHelper.getNextQuote()
        assertEquals(quoteHelper.quoteList[1].author, quote.author)
    }
}
