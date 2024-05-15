package com.ucne.myapplication.data.repository
import com.ucne.myapplication.data.local.dao.TecnicoDao
import com.ucne.myapplication.data.local.entities.TecnicoEntity

class TecnicoRepository(private val tecnicoDao: TecnicoDao) {
    suspend fun saveTecnico(tecnico: TecnicoEntity) = tecnicoDao.save(tecnico)

    fun getTecnico() = tecnicoDao.getAll()
}