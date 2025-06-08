package com.gubo.tableorganiser.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import kotlinx.serialization.Serializable

@Serializable
@Entity data class Person(
    @Id val id: Long,
    val name: String,
    val pros: List<String>,
    val cons: List<String>
)
