package my.app.feature.userinfo.api

import my.app.feature.userinfo.api.model.UserInfo

interface UserRepository {
    fun getCurrentUser(): UserInfo?
    fun saveUser(user: UserInfo)
    val authentication: AuthenticationStorage
    fun clearAll()
}