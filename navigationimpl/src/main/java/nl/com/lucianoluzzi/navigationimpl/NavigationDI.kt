package nl.com.lucianoluzzi.navigationimpl

import nl.com.lucianoluzzi.navigation.Navigator
import org.koin.dsl.module

val navigationModule = module {
    single<Navigator> {
        NavigatorImpl()
    }
}