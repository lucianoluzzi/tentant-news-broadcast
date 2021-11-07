package nl.com.lucianoluzzi.network

import nl.com.lucianoluzzi.network.client.NetworkClientProvider
import org.koin.dsl.module

val networkModule = module {
    single {
        NetworkClientProvider().retrofit
    }
}