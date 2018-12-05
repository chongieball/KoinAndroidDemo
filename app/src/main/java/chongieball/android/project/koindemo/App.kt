package chongieball.android.project.koindemo

import android.app.Application
import chongieball.android.project.koindemo.di.appModule
import chongieball.android.project.koindemo.di.viewModelModule
import net.abcargo.tms.koinviewmodeldemo.di.networkModule
import org.koin.android.ext.android.startKoin
import org.koin.android.logger.AndroidLogger

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule, networkModule, viewModelModule), logger = AndroidLogger(showDebug = true))
    }
}