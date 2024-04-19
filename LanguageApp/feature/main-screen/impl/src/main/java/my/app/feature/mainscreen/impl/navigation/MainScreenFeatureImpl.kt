package my.app.feature.mainscreen.impl.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import my.app.feature.mainscreen.api.MainScreenFeature
import my.app.feature.mainscreen.impl.domain.Exercise
import my.app.feature.mainscreen.impl.domain.User
import my.app.feature.mainscreen.impl.presentation.MainScreen

internal class MainScreenFeatureImpl : MainScreenFeature {
    override val route: String = "languageapp://main"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route) {
            MainScreen(
                modifier = modifier, exercises = Exercise.entries.drop(0), users = listOf(
                    User(
                        emoji = "\uD83D\uDC68\uD83C\uDFFB\u200D\uD83C\uDFA8",
                        name = "Vincent van Gogh",
                        points = 12
                    ), User(
                        emoji = "\uD83D\uDC68\uD83C\uDFFB\u200D\uD83C\uDFA8",
                        name = "Vincent van Gogh",
                        points = 12
                    ), User(
                        emoji = "\uD83D\uDC68\uD83C\uDFFB\u200D\uD83C\uDFA8",
                        name = "Vincent van Gogh",
                        points = 12
                    )
                )
            )
        }
    }
}