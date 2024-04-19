package my.app.core.storage.impl.usercontext

import my.app.core.storage.api.keyvalue.KeyValueStorageProvider
import my.app.core.storage.api.usercontext.UserContextStorage

object UserContextStorageProvider{
    fun get(kvsProvider: KeyValueStorageProvider): UserContextStorage {
        return UserContextStorageImpl(kvsProvider)
    }
}