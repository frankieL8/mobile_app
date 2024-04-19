package my.app.core.storage.impl.usercontext

import my.app.core.storage.api.keyvalue.KeyValueStorageProvider
import my.app.core.storage.api.keyvalue.KeyValueStorageReader
import my.app.core.storage.api.keyvalue.KeyValueStorageWriter
import my.app.core.storage.api.usercontext.UserContextStorage

internal class UserContextStorageImpl(kvsProvider: KeyValueStorageProvider) : UserContextStorage {

    private val storage = kvsProvider[STORAGE_NAME]

    override val reader: KeyValueStorageReader = storage.reader

    override val writer: KeyValueStorageWriter = storage.writer

    override fun clear() {
        storage.writer.update { it.clear() }
    }

    companion object {
        const val STORAGE_NAME = "UserContextStorage"
    }
}