package my.app.feature.onboarding.impl.domain

import my.app.core.storage.api.delegates.booleanPreference
import my.app.core.storage.api.keyvalue.KeyValueStorage
import my.app.feature.onboarding.api.domain.OnboardingInteractor

internal class OnboardingInteractorImpl(kvStorage: KeyValueStorage): OnboardingInteractor {
    override var isOnboardingCompleted: Boolean by kvStorage.booleanPreference(COMPLETED_ONBOARDING)
}