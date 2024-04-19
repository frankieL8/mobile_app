package my.app.languageapp

import android.content.Context
import androidx.startup.Initializer
import my.app.core.storage.impl.keyvalue.di.KeyValueStorageModule
import my.app.core.storage.impl.secret.di.SecretsStorageModule
import my.app.core.storage.impl.usercontext.di.UserContextStorageModule
import my.app.feature.entrance.impl.di.EntranceModule
import my.app.feature.mainscreen.impl.di.MainScreenModule
import my.app.feature.onboarding.impl.di.OnboardingModule
import my.app.feature.userinfo.impl.di.UserInfoModule
import my.app.languageapp.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

class KoinInitializer: Initializer<KoinApplication> {
    override fun create(context: Context): KoinApplication =
        startKoin {
            androidContext(context)
            modules(
                OnboardingModule,
                KeyValueStorageModule,
                UserContextStorageModule,
                SecretsStorageModule,
                MainScreenModule,
                EntranceModule,
                AppModule,
                UserInfoModule
            )
        }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> = mutableListOf()

}