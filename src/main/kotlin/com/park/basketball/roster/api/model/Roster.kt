package com.park.basketball.roster.api.model

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@DynamoDBTable(tableName = "roster")
data class Roster(
    @DynamoDBHashKey(attributeName = "id")
    var id: String,
) {
    companion object

    fun toDto() = RosterMapper.INSTANCE.toDto(this)
}

data class RosterDto(
    var id: String,
) {
    companion object

    fun toEntity() = RosterMapper.INSTANCE.toEntity(this)
}

@Mapper
interface RosterMapper {
    companion object {
        val INSTANCE: RosterMapper = Mappers.getMapper(RosterMapper::class.java)
    }

    fun toDto(roster: Roster): RosterDto

    fun toEntity(rosterDto: RosterDto): Roster
}
