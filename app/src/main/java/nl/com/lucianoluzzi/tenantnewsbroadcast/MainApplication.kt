package nl.com.lucianoluzzi.tenantnewsbroadcast

import android.app.Application
import nl.com.lucianoluzzi.navigationimpl.navigationModule
import nl.com.lucianoluzzi.timeline.ui.timelineUIModule
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin

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
                timelineUIModule
            )

            modules(modules)
        }
    }
}