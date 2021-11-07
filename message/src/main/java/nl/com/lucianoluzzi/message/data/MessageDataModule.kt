package nl.com.lucianoluzzi.message.data

import nl.com.lucianoluzzi.message.data.repository.MessageRepository
import nl.com.lucianoluzzi.message.data.repository.MessageRepositoryImpl
import nl.com.lucianoluzzi.message.data.service.IsInterestedService
import org.koin.dsl.module
import retrofit2.Retrofit

val messageDataModule = module {
    single<IsInterestedService> {
        (get() as Retrofit).create(IsInterestedService::class.java)
    }

    single<MessageRepository> {
        MessageRepositoryImpl(
            isInterestedService = get()
        )
    }
}