package com.example.aspecttest.network

data class EquipmentDetail(
    val id: String,
    val revision: Int,
    val name: String,
    val schema: String,
    val schemaId: String,
    val updater: String,
    val updateDate: String,
    val creator: String,
    val createDate: String,
    val schemaRev: Int,
    val state: String,
    val classification: String?,
    val lifetimeMax: String?,
    val rollupCostsPosition: Boolean,
    val normSpec: String?,
    val externalSystemAssets: String?,
    val designDrawing: String,
    val externalSystemEquipment: String?,
    val failureCycle: Boolean,
    val area: Area,
    val performanceMeasureUnit: String?,
    val strategy: Strategy,
    val damageType: DamageType,
    val costCode: CostCode,
    val ecology: Boolean,
    val ibo: Ibo,
    val responsible: String?,
    val vehicle: Boolean,
    val overhaulCostCode: CostCode,
    val rollupCostsSystem: Boolean,
    val dependToPosition: Boolean,
    val rollupCostsObject: Boolean,
    val dependToSystem: Boolean,
    val assetSignificance: String?,
    val redaction: String?,
    val lifecycle: Boolean,
    val assetTemplate: Boolean,
    val autoNum: Boolean,
    val approved: String?,
    val lifetimeMin: String?,
    val reason: String?,
    val regNumber: String?,
    val templateCode: String?,
    val redactionStatus: String?,
    val workOrderTemplate: String?,
    val dependToObject: Boolean,
    val HierarchyLevelType: HierarchyLevelType?,
    val editAssetConditionIndex: Boolean,
    val failureCurves: String?,
    val assetFunction: AssetFunction,
    val decommissDate: String?,
    val assetConditionIndex: String?,
    val parentObject: ParentObject,
    val rcmProject: String?,
    val useRcmAnalysis: Boolean,
    val assetCondition: Boolean,
    val equipmentFailureValue: String?,
    val department: Department,
    val item: String?,
    val riskLevel: RiskLevel,
    val editEquipmentFailure: Boolean,
    val warehouse: String?,
    val purchaseOrder: String?,
    val constructionObjectCode: String?,
    val areaCodeProdRep: String?,
    val currentValue: String?,
    val purchaseDate: String?,
    val model: String?,
    val ownershipType: String?,
    val gisMap: String?,
    val yLocation: String?,
    val status: Status,
    val dormantStartDate: String?,
    val objectGisId: String?,
    val notCreateWo: Boolean,
    val decommissCause: String?,
    val maxPerformance: String?,
    val minPerformance: String?,
    val normBase: String?,
    val xLocation: String?,
    val fuel: String?,
    val initialValue: String?,
    val gisLayer: String?,
    val dormantEndDate: String?,
    val production: Boolean,
    val suffixNum: String?,
    val installationDate: String?,
    val length: String?,
    val dormantCause: String?,
    val geoCoordinate: String?,
    val prevReductionObject: String?,
    val criticality: Criticality,
    val lengthMeasureUnit: String?,
    val primarySystem: String?,
    val prefixNum: String?,
    val lengthNum: String?,
    val parentPosition: ParentPosition?,
    val safety: Boolean,
    val serialNumber: String?,
    val code: String,
    val notUse: Boolean,
    val commissDate: String?,
    val inventoryNumber: String?,
    val supplier: String?,
    val manufacturer: String?,
    val location: Location,
    val linear: Boolean,
    val organization: Organization,
    val creatorUsername: String?,
    val updaterUsername: String,
    val characteristics: Map<String, Any>
)

data class Area(
    val id: String,
    val schemaId: String,
    val name: String,
    val _isReference_: Boolean
)

data class Strategy(
    val id: String,
    val schemaId: String,
    val name: String,
    val _isReference_: Boolean
)

data class DamageType(
    val id: String,
    val schemaId: String,
    val name: String,
    val _isReference_: Boolean
)

data class CostCode(
    val id: String,
    val schemaId: String,
    val name: String,
    val _isReference_: Boolean
)

data class Ibo(
    val id: String,
    val schemaId: String,
    val name: String,
    val _isReference_: Boolean
)

data class HierarchyLevelType(
    val id: String,
    val schemaId: String,
    val name: String,
    val _isReference_: Boolean
)

data class AssetFunction(
    val id: String,
    val schemaId: String,
    val name: String,
    val _isReference_: Boolean
)

data class ParentObject(
    val id: String,
    val schemaId: String,
    val name: String,
    val _isReference_: Boolean
)

data class Department(
    val id: String,
    val schemaId: String,
    val name: String,
    val _isReference_: Boolean
)

data class RiskLevel(
    val id: String,
    val schemaId: String,
    val name: String,
    val _isReference_: Boolean
)

data class Status(
    val id: String,
    val code: String,
    val value: String,
    val description: String?,
    val enumId: String
)

data class ParentPosition(
    val id: String,
    val schemaId: String,
    val name: String,
    val _isReference_: Boolean
)

data class Criticality(
    val id: String,
    val code: String,
    val value: String,
    val description: String?,
    val enumId: String
)

data class Location(
    val id: String,
    val schemaId: String,
    val name: String,
    val _isReference_: Boolean
)

data class Organization(
    val id: String,
    val schemaId: String,
    val name: String,
    val _isReference_: Boolean
)