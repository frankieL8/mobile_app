package my.app.feature.mainscreen.impl.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import my.app.core.uikit.theme.AppTheme
import my.app.core.uikit.theme.LanguageAppTheme
import my.app.feature.mainscreen.impl.domain.Exercise
import my.app.feature.mainscreen.impl.domain.User
import my.app.feature.mainscreen.impl.presentation.ui.ExerciseType
import my.app.feature.mainscreen.impl.presentation.ui.TopUserItem

@Composable
internal fun MainScreen(
    modifier: Modifier = Modifier,
    exercises: List<Exercise>,
    users: List<User>
) {
    BackHandler { }
    Scaffold(
        modifier = modifier,
        containerColor = AppTheme.colors.background,
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(AppTheme.colors.purple)
                    .padding(horizontal = 24.dp)
            ) {
                Spacer(modifier = Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        .size(54.dp)
                        .clip(CircleShape)
                        .background(AppTheme.colors.grey)
                )
                Text(
                    text = "main_screen_hello",
                    style = AppTheme.typography.bodyLarge,
                    color = AppTheme.colors.textStatic
                )
                Text(
                    text = "Are you ready for learning today?",
                    style = AppTheme.typography.bodyLarge,
                    color = AppTheme.colors.textStatic
                )
                Spacer(modifier = Modifier.height(11.dp))
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(top = it.calculateTopPadding())
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(11.dp))
            Text(
                text = "Top users",
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                style = AppTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(5.dp))
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                users.forEach {
                    TopUserItem(
                        user = it,
                        modifier = Modifier
                            .padding(horizontal = 24.dp)
                            .fillMaxWidth()
                    )
                }
            }
            Spacer(modifier = Modifier.height(11.dp))
            Text(
                text = "Available exersises",
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                style = AppTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(9.dp))
            Column(
                modifier = Modifier.padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.spacedBy(21.dp)
            ) {
                repeat(1 + (exercises.size - 1) / 2) { rowIndex ->
                    Row(horizontalArrangement = Arrangement.spacedBy(21.dp)) {
                        repeat(2) { columnIndex ->
                            val itemIndex = rowIndex * 2 + columnIndex

                            if (itemIndex < exercises.size) {
                                ExerciseType(
                                    exercise = exercises[itemIndex],
                                    modifier = Modifier.weight(1f)
                                )
                            } else {
                                Spacer(
                                    Modifier
                                        .weight(1f)
                                        .fillMaxHeight()
                                )
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}

@Preview
@Composable
private fun EntranceLoginScreen() {
    LanguageAppTheme {
        MainScreen(
            exercises = Exercise.entries.drop(0), users = listOf(
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