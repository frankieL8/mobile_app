package my.app.feature.mainscreen.impl.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import my.app.core.uikit.theme.AppTheme
import my.app.core.uikit.theme.LanguageAppTheme
import my.app.feature.mainscreen.impl.domain.User

@Composable
fun TopUserItem(
    modifier: Modifier = Modifier,
    user: User
) {

    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .background(AppTheme.colors.grey)
            .padding(17.dp)
    ) {
        Text(text = user.emoji)
        Spacer(modifier = Modifier.width(24.dp))
        Text(text = user.name)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "${user.points} points")
    }
}

@Preview
@Composable
private fun MainButtonPreview() {
    LanguageAppTheme {
        TopUserItem(
            user = User(
                emoji = "\uD83D\uDC68\uD83C\uDFFB\u200D\uD83C\uDFA8",
                name = "Vincent van Gogh",
                points = 12
            )
        )
    }
}