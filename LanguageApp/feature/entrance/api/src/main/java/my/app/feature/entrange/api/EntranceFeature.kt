package my.app.feature.entrange.api

import my.app.core.navigation.FeatureNavigationApi

interface EntranceFeature: FeatureNavigationApi {
    val route: String
}