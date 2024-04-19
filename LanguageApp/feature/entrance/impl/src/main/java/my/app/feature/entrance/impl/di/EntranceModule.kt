package my.app.feature.entrance.impl.di

import my.app.feature.entrange.api.EntranceFeature
import my.app.feature.entrance.impl.navigation.EntranceFeatureImpl
import my.app.feature.entrance.impl.presentation.EntranceScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val EntranceModule = module {
    factory<EntranceFeature> { EntranceFeatureImpl() }
    viewModel { EntranceScreenViewModel(userRepository = get()) }
}