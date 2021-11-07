package nl.com.lucianoluzzi.timeline.data

import nl.com.lucianoluzzi.timeline.data.repository.TimelineRepository
import nl.com.lucianoluzzi.timeline.data.repository.TimelineRepositoryImpl
import nl.com.lucianoluzzi.timeline.data.service.TimelineService
import org.koin.dsl.module
import retrofit2.Retrofit

val timelineDataModule = module {
    single<TimelineService> {
        (get() as Retrofit).create(TimelineService::class.java)
    }

    single<TimelineRepository> {
        TimelineRepositoryImpl(
            service = get()
        )
    }
}