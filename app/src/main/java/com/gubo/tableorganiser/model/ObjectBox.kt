package com.gubo.tableorganiser.model

import android.content.Context
import io.objectbox.Box
import io.objectbox.BoxStore

object ObjectBox {
    lateinit var store: BoxStore
        private set
    
    lateinit var itemBox: Box<Item>
    
    fun init(context: Context) {
        store = MyObjectBox.builder().androidContext(context).build()
    }
    
    fun getPersonBox(): Box<Item> {
        if (!this::itemBox.isInitialized) {
            itemBox = store.boxFor(Item::class.java)
        }
        return itemBox
    }
}