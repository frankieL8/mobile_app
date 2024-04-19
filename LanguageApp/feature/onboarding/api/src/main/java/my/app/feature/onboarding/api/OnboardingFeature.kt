package my.app.feature.onboarding.api

import my.app.core.navigation.FeatureNavigationApi

interface OnboardingFeature : FeatureNavigationApi {
    val route: String
}