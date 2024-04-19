package my.app.feature.mainscreen.api

import my.app.core.navigation.FeatureNavigationApi

interface MainScreenFeature: FeatureNavigationApi {
    val route: String
}