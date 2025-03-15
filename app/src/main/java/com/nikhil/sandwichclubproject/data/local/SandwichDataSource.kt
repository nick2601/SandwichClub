package com.nikhil.sandwichclubproject.data.local
import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nikhil.sandwichclubproject.R
import com.nikhil.sandwichclubproject.data.model.Sandwich
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SandwichDataSource @Inject constructor(@ApplicationContext private val context: Context) {

    fun getSandwichList(): List<Sandwich> {
        val sandwichNames = context.resources.getStringArray(R.array.sandwich_names)
        val sandwichDetails = context.resources.getStringArray(R.array.sandwich_details)

        return sandwichNames.mapIndexed { index, name ->
            val sandwichJson = sandwichDetails[index]
            Gson().fromJson(sandwichJson, Sandwich::class.java)
        }
    }
    fun getSandwichListFromAssets(): List<Sandwich> {
        val jsonString = context.assets.open("sandwiches.json").bufferedReader().use {
            it.readText()
        }
        val gson = Gson()
        val listSandwichType = object : TypeToken<List<Sandwich>>() {}.type
        return gson.fromJson(jsonString, listSandwichType)
    }
}