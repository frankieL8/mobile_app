package my.app.feature.entrance.impl.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import my.app.feature.entrange.api.EntranceFeature
import my.app.feature.entrance.impl.presentation.EntranceScreen
import my.app.feature.mainscreen.api.MainScreenFeature
import org.koin.compose.koinInject

internal class EntranceFeatureImpl: EntranceFeature {
    override val route: String = "languageapp://entrance"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route){
            val mainScreenFeature = koinInject<MainScreenFeature>()
            EntranceScreen(
                modifier = modifier,
                onNavigateToMain = {
                    navController.navigate(mainScreenFeature.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                    }
                }
            )

        }
    }
}