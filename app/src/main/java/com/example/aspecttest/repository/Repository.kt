package com.example.aspecttest.repository

import com.example.aspecttest.network.Equipment

interface Repository {

    fun getAll(): List<Equipment>

    fun saveAll(list: List<Equipment>)

    fun getEquipmentById(id: String): Equipment
}