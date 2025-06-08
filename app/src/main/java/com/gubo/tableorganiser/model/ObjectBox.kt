package com.gubo.tableorganiser.model

import android.content.Context
import io.objectbox.Box
import io.objectbox.BoxStore

object ObjectBox {
    lateinit var store: BoxStore
        private set
    
    lateinit var personBox: Box<Person>
    
    fun init(context: Context) {
        store = MyObjectBox.builder().androidContext(context).build()
    }
    
    fun getPersonBox(): Box<Person> {
        if (!this::personBox.isInitialized) {
            personBox = store.boxFor(Person::class.java)
        }
        return personBox
    }
}