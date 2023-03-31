package com.esosaphilip.amphibians

import android.app.Application
import com.esosaphilip.amphibians.data.AppContainer
import com.esosaphilip.amphibians.data.DefaultAppContainer

class AmphibiansApplication: Application() {

        lateinit var container: AppContainer
        override fun onCreate() {
            super.onCreate()
            container = DefaultAppContainer()
        }

}