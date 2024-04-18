package com.example.aspecttest.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.aspecttest.network.Equipment

@Entity(tableName = "equipments")
data class EquipmentEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "code")
    val code: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "statusCode")
    val statusCode: String,
    @ColumnInfo(name = "status")
    val status: String,
    @ColumnInfo(name = "criticalityCode")
    val criticalityCode: String,
    @ColumnInfo(name = "criticality")
    val criticality: String
) {

    fun toDto() = Equipment(
        id = id,
        code = code,
        name = name,
        status_code = statusCode,
        ststus = status,
        criticality_code = criticalityCode,
        criticality = criticality
    )

    companion object {
        fun fromDto(dto: Equipment) = EquipmentEntity(
            id = dto.id ?: "",
            code = dto.code ?: "",
            name = dto.name ?: "",
            statusCode = dto.status_code ?: "",
            status = dto.ststus ?: "",
            criticalityCode = dto.criticality_code ?: "",
            criticality = dto.criticality ?: ""
        )
    }
}