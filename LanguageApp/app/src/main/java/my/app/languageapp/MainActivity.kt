package my.app.languageapp

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import my.app.core.uikit.composable.button.MainButton
import my.app.core.uikit.theme.AppTheme
import my.app.core.uikit.theme.LanguageAppTheme

class MainActivity : AppCompatActivity() {
    private var navHostController: NavController? = null
    private var keepSplashScreenOn = true

    /**
     * Длительность "активной" части splash screen - дo fade out
     */
    private val splashScreenActiveDurationMs = 1500L
    override fun onCreate(savedInstanceState: Bundle?) {
        delegate.applyDayNight()
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.keepSplashScreenUntilEnds()
        setContent {

            val navHostController = rememberNavController()
            LanguageAppTheme {
                val view = LocalView.current
                if (!view.isInEditMode) {
                    val color = AppTheme.colors.purple
                    SideEffect {
                        val window = (view.context as Activity).window
                        window.statusBarColor = color.toArgb()
                        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = isLightColor(color)
                    }
                }
                AppNavGraph(navController = navHostController)
            }
        }
    }
    private fun SplashScreen.keepSplashScreenUntilEnds() {
        setKeepOnScreenCondition { keepSplashScreenOn }
        Handler(mainLooper).postDelayed(
            { keepSplashScreenOn = false },
            splashScreenActiveDurationMs
        )
    }
}

fun isLightColor(color: Color): Boolean {
    return (color.red * 0.299 + color.green * 0.587 + color.blue * 0.114) > 0.729411
}