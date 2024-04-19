package my.app.feature.mainscreen.impl.di

import my.app.feature.mainscreen.api.MainScreenFeature
import my.app.feature.mainscreen.impl.navigation.MainScreenFeatureImpl
import org.koin.dsl.module

val MainScreenModule = module {
    factory<MainScreenFeature> {
        MainScreenFeatureImpl()
    }
}

