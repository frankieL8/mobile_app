package my.app.feature.onboarding.impl.presentation

import my.app.feature.onboarding.api.domain.OnboardingInteractor
import my.app.feature.onboarding.impl.presentation.model.OnboardingScreenAction
import my.app.feature.onboarding.impl.presentation.model.OnboardingScreenEvent
import my.app.feature.onboarding.impl.presentation.model.OnboardingScreenState
import my.app.feature.onboarding.impl.presentation.model.OnboardingStep
import my.app.core.architecture.mvi.MVIScreenModel
import my.app.core.architecture.mvi.models.MVIConfiguration

internal class OnboardingScreenViewModel(
    private val interactor: OnboardingInteractor
) : MVIScreenModel<OnboardingScreenEvent, OnboardingScreenState, OnboardingScreenAction>(
    config = MVIConfiguration(
        initial = OnboardingScreenState(OnboardingStep.STEP_1)
    )
) {
    override suspend fun onEvent(event: OnboardingScreenEvent) {
        when (event) {
            OnboardingScreenEvent.ClickClose -> onCloseOnboarding()
            OnboardingScreenEvent.ClickNext -> {
                withState {
                    when (currentStep) {
                        OnboardingStep.STEP_1 -> updateState { OnboardingScreenState(OnboardingStep.STEP_2) }
                        OnboardingStep.STEP_2 -> updateState { OnboardingScreenState(OnboardingStep.STEP_3) }
                        OnboardingStep.STEP_3 -> onCloseOnboarding()
                    }
                }
            }
        }

    }

    private suspend fun onCloseOnboarding(){
        interactor.isOnboardingCompleted = true
        action(OnboardingScreenAction.NavigateToEntrance)
    }
}