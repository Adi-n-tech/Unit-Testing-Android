package com.github.unittestingandroid

import android.content.Context
import com.github.unittestingandroid.model.Quote
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class QuoteHelper {

    var quoteList = emptyList<Quote>()
    var currentVisibleQuoteIndex = 0

    fun populateQuoteFromAssets(context: Context, file: String): List<Quote> {
        val jsonString: String
        try {
            jsonString = context.assets.open(file).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return emptyList()
        }
        val type = object : TypeToken<List<Quote>>() {}.type
        return Gson().fromJson(jsonString, type)
    }

    fun getCurrentQuote(): Quote {
        return quoteList[currentVisibleQuoteIndex]
    }

    fun getNextQuote(): Quote {
        return if (quoteList.size > currentVisibleQuoteIndex)
            quoteList[currentVisibleQuoteIndex] else quoteList[0]
    }

    fun getPreviousQuote(): Quote {
        return if (currentVisibleQuoteIndex == 0) quoteList[quoteList.size - 1] else
            quoteList[currentVisibleQuoteIndex - 1]
    }
}