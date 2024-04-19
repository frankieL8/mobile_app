package my.app.feature.userinfo.impl

import my.app.core.storage.api.usercontext.UserContextStorage
import my.app.feature.userinfo.api.AuthenticationStorage
import my.app.feature.userinfo.api.UserRepository
import my.app.feature.userinfo.api.model.UserInfo

internal class UserRepositoryImpl(
    override val authentication: AuthenticationStorage,
    private val userContextStorage: UserContextStorage
): UserRepository {
    override fun getCurrentUser(): UserInfo? = with(userContextStorage.reader) {
        if (!contains(EMAIL_KEY)) return@with null
        UserInfo(
            firstName = getString(FIRST_NAME_KEY)!!,
            lastName = getString(LAST_NAME_KEY)!!,
            email = getString(EMAIL_KEY)!!
        )
    }

    override fun saveUser(user: UserInfo) {
        userContextStorage.writer.update {
            it.setString(FIRST_NAME_KEY, user.firstName)
            it.setString(LAST_NAME_KEY, user.lastName)
            it.setString(EMAIL_KEY, user.email)
        }
    }

    override fun clearAll() {
        authentication.clear()
        userContextStorage.clear()
    }
}