package my.app.languageapp.route

import my.app.languageapp.route.model.RouterScreenAction
import my.app.languageapp.route.model.RouterScreenEvent
import my.app.feature.onboarding.api.domain.OnboardingInteractor
import my.app.feature.userinfo.api.UserRepository
import my.app.core.architecture.mvi.MVIScreenModel
import my.app.core.architecture.mvi.models.ActionShareBehavior
import my.app.core.architecture.mvi.models.MVIConfiguration

/**
 * VM стартового экрана, содержит логику навигации
 */
internal class RouteScreenViewModel(
    private val onboardingScreenInteractor: OnboardingInteractor,
    private val userRepository: UserRepository,
) : MVIScreenModel<RouterScreenEvent, Unit, RouterScreenAction>(
    MVIConfiguration(
        initial = Unit,
        actionShareBehavior = ActionShareBehavior.Distribute()
    )
) {


    private val isCompletedOnboarding: Boolean
        get() = onboardingScreenInteractor.isOnboardingCompleted


    override suspend fun onEvent(event: RouterScreenEvent) {
        when (event) {
            RouterScreenEvent.ScreenShown -> reroute()
        }
    }

    private suspend fun reroute() {

        when {
            !isCompletedOnboarding -> {
                action(RouterScreenAction.ShowOnboarding)
            }
            userRepository.authentication.isAuthenticated -> {
                action(RouterScreenAction.NavigateToMain)
            }

            else -> {
                action(RouterScreenAction.NavigateToEntrance)

            }
        }
    }
}