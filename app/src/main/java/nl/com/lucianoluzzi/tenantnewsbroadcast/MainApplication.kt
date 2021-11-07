package nl.com.lucianoluzzi.tenantnewsbroadcast

import android.app.Application
import nl.com.lucianoluzzi.navigationimpl.navigationModule
import nl.com.lucianoluzzi.network.networkModule
import nl.com.lucianoluzzi.timeline.data.timelineDataModule
import nl.com.lucianoluzzi.timeline.ui.timelineUIModule
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.KoinExperimentalAPI
import org.koin.core.context.startKoin

@KoinExperimentalAPI
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initDependencyInjection()
    }

    private fun initDependencyInjection() {
        startKoin {
            fragmentFactory()
            val modules = listOf(
                navigationModule,
                networkModule,
                timelineUIModule,
                timelineDataModule
            )
            modules(modules)
        }
    }
}