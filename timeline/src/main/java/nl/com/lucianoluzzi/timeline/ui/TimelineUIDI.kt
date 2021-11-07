package nl.com.lucianoluzzi.timeline.ui

import nl.com.lucianoluzzi.timeline.domain.mapper.MessageMapper
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val timelineUIModule = module {
    fragment {
        TimelineFragment(
            navigator = get(),
            viewModel = get()
        )
    }
    viewModel {
        TimelineViewModel(
            timelineRepository = get(),
            messageMapper = MessageMapper()
        )
    }
}