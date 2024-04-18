package com.example.aspecttest.repository

import com.example.aspecttest.db.EquipmentDao
import com.example.aspecttest.db.EquipmentEntity
import com.example.aspecttest.network.Equipment

class RepositoryImpl(private val dao: EquipmentDao) : Repository {

    override fun getAll() = dao.getAll().map { it.toDto() }

    override fun saveAll(list: List<Equipment>) {
        val result = list.map {
            EquipmentEntity.fromDto(it)
        }
        dao.saveAll(result)
    }

    override fun getEquipmentById(id: String) = dao.getEquipmentById(id).toDto()
}