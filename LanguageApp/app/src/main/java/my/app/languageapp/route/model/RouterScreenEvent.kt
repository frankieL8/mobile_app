package my.app.languageapp.route.model

sealed interface RouterScreenEvent {
    data object ScreenShown : RouterScreenEvent
}