package com.ucne.myapplication.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ucne.myapplication.data.local.dao.TecnicoDao
import com.ucne.myapplication.data.local.dao.TicketDao
import com.ucne.myapplication.data.local.entities.TecnicoEntity
import com.ucne.myapplication.data.local.entities.TicketEntity

//data/local/database
@Database(
    entities = [
        TecnicoEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class TecnicoDb : RoomDatabase() {
    abstract fun tecnicoDao(): TecnicoDao
}