package com.example.aspecttest.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EquipmentDao {

    @Query("SELECT * FROM equipments")
    fun getAll(): List<EquipmentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(list: List<EquipmentEntity>)

    @Query("SELECT * FROM equipments WHERE id=:id")
    fun getEquipmentById(id: String): EquipmentEntity
}