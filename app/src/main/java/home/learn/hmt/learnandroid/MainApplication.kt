package home.learn.hmt.learnandroid

import android.app.Application
import home.learn.hmt.learnandroid.di.modules
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, modules)
    }
}