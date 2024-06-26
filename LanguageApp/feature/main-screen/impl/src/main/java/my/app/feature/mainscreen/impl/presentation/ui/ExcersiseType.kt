package my.app.feature.mainscreen.impl.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import my.app.core.uikit.theme.AppTheme
import my.app.core.uikit.theme.LanguageAppTheme
import my.app.feature.mainscreen.impl.domain.Exercise

@Composable
fun ExerciseType(
    modifier: Modifier = Modifier,
    exercise: Exercise
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(exercise.color)
            .padding(12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = exercise.emoji, fontSize = 90.sp)
        Text(
            text = exercise.text,
            style = AppTheme.typography.bodyMedium,
            color = AppTheme.colors.textStatic
        )
    }
}

val Exercise.emoji: String
    get() = when (this) {
        Exercise.GUESS_ANIMAL -> "\uD83D\uDC3B\u200D❄\uFE0F"
        Exercise.WORD_PRACTICE -> "✏\uFE0F"
        Exercise.AUDITION -> "\uD83D\uDD0A"
        Exercise.GAME -> "\uD83C\uDFAE"
    }

val Exercise.color: Color
    @Composable
    @ReadOnlyComposable
    get() = when (this) {
        Exercise.GUESS_ANIMAL -> AppTheme.colors.blue
        Exercise.WORD_PRACTICE -> AppTheme.colors.pink
        Exercise.AUDITION -> AppTheme.colors.orange
        Exercise.GAME -> AppTheme.colors.green
    }

val Exercise.text: String
    get() = when (this) {
        Exercise.GUESS_ANIMAL -> "Guess the animal"
        Exercise.WORD_PRACTICE -> "Word practice"
        Exercise.AUDITION -> "Audition"
        Exercise.GAME -> "Game"
    }




@PreviewLightDark
@Composable
private fun MainButtonPreview() {
    LanguageAppTheme {
        ExerciseType(exercise = Exercise.AUDITION)
    }
}