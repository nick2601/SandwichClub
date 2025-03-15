package com.nikhil.sandwichclubproject

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SandwichClubApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize any necessary libraries or services here
    }
}