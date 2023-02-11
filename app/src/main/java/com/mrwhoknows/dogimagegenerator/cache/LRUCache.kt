package com.mrwhoknows.dogimagegenerator.cache

import kotlin.collections.set

class LRUCache<K, V>(private val maxSize: Int) : Cache<K, V> {

    private val cache: MutableMap<K, V> = LinkedHashMap()

    override fun put(key: K, value: V) {
        if (currentSize >= maxSize) {
            cache.remove(getAllKeys().last())
        }
        cache[key] = value
    }

    override fun get(key: K): V? = cache[key]

    override fun getAllKeys(): List<K> = cache.keys.toList().reversed()

    override fun getAllValues(): List<V> = cache.values.toList().reversed()

    override val currentSize get() = cache.size

    override fun clearAll() {
        cache.clear()
    }

}