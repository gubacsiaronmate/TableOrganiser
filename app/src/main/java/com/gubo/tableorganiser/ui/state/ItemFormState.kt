package com.gubo.tableorganiser.ui.state

import androidx.compose.runtime.mutableStateOf

class ItemFormState(
    initialName: String,
    initialPros: List<String>,
    initialCons: List<String>
) {
    private val _name = mutableStateOf(initialName)
    val name: String get() = _name.value
    
    private val _pros = mutableStateOf(initialPros)
    val pros: List<String> get() = _pros.value
    
    private val _cons = mutableStateOf(initialCons)
    val cons: List<String> get() = _cons.value
    
    fun updateName(newName: String) {
        _name.value = newName
    }
    
    fun addPro(pro: String) {
        _pros.value = _pros.value + pro
    }
    
    fun removePro(pro: String) {
        _pros.value = _pros.value.filter { it != pro }
    }
    
    fun addCon(con: String) {
        _cons.value = _cons.value + con
    }
    
    fun removeCon(con: String) {
        _cons.value = _cons.value.filter { it != con }
    }
}
