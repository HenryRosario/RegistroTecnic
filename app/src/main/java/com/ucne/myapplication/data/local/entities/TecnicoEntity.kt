package com.ucne.myapplication.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

//data/local/entities
@Entity(tableName = "Tecnicos")
data class TecnicoEntity(
    @PrimaryKey(autoGenerate = true)
    val tecnicoId: Int? = null,
    var nombre: String = "",
    var saldoHora:  String = "",
)