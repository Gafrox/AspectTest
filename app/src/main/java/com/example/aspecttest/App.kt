package com.example.aspecttest

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import javax.inject.Inject

class App @Inject constructor() : Application() {
    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        internal lateinit var INSTANCE: App
            private set
    }
}