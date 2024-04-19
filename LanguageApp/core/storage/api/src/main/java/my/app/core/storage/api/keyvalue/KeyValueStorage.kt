package my.app.core.storage.api.keyvalue

/**
 * An interface for access to a key-value storage
 */
interface KeyValueStorage {
    /**
     * An entity for reading data from a key-value storage
     */
    val reader: KeyValueStorageReader

    /**
     * An entity for updating data in a key-value storage
     */
    val writer: KeyValueStorageWriter
}
