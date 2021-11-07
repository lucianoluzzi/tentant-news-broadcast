package nl.com.lucianoluzzi.message.ui

import nl.com.lucianoluzzi.message.ui.viewModel.MessageViewModel
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

val messageUImodule = module {
    single {
        MessageViewModel(
            messageRepository = get()
        )
    }

    fragment {
        MessageFragment(
            viewModel = get()
        )
    }
}