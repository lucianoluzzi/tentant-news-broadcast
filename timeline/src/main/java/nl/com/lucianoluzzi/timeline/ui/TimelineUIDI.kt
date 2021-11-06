package nl.com.lucianoluzzi.timeline.ui

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
        TimelineViewModel()
    }
}