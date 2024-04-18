package com.example.aspecttest.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [EquipmentEntity::class], version = 1, exportSchema = false)
abstract class EquipmentDb : RoomDatabase() {

    abstract fun equipmentDao(): EquipmentDao

    companion object {
        @Volatile
        private var instance: EquipmentDb? = null

        fun getInstance(context: Context): EquipmentDb {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, EquipmentDb::class.java, "equipments.db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
    }
}