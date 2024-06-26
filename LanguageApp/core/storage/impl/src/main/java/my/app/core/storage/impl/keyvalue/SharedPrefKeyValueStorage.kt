package my.app.core.storage.impl.keyvalue

import android.content.Context
import android.content.SharedPreferences
import my.app.core.storage.api.keyvalue.KeyValueStorage
import my.app.core.storage.api.keyvalue.KeyValueStorageReader
import my.app.core.storage.api.keyvalue.KeyValueStorageWriter

/**
 * An implementation of [KeyValueStorage] for Shared Preferences
 * @property context an app context for getting access to [SharedPreferences]
 * @property preferencesName an unique name for a preferences
 */
class SharedPrefKeyValueStorage(
    private val context: Context,
    private val preferencesName: String,
) : KeyValueStorage {

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE)
    }

    /**
     * An entity for reading data from a key-value storage
     */
    override val reader: KeyValueStorageReader by lazy {
        SharedPrefKeyValueStorageReader(sharedPreferences)
    }

    /**
     * An entity for updating data in a key-value storage
     */
    override val writer: KeyValueStorageWriter by lazy {
        SharedPrefKeyValueStorageWriter(reader, sharedPreferences)
    }
}
