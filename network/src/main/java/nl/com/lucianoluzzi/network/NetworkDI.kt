package nl.com.lucianoluzzi.network

import org.koin.dsl.module

val networkModule = module {
    single {
        NetworkClientProvider().retrofit
    }
}