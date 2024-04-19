package my.app.feature.userinfo.impl

import my.app.core.storage.api.secret.SecretStorage
import my.app.feature.userinfo.api.AuthenticationStorage

internal class AuthenticationStorageImpl(
    private val secretStorage: SecretStorage
): AuthenticationStorage {
    override val isAuthenticated: Boolean
        get() = getPassword() != null

    override fun savePassword(password: String) {
        secretStorage.save(PASSWORD_KEY, password, blocking = true)
    }

    override fun clear() {
        secretStorage.remove(PASSWORD_KEY, blocking = true)
    }

    override fun checkPassword(password: String): Boolean = getPassword() == password

    private fun getPassword():String? = secretStorage.load(PASSWORD_KEY)

}