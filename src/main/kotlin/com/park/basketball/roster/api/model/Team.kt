package com.park.basketball.roster.api.model

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@DynamoDBTable(tableName = "team")
data class Team(
    @DynamoDBHashKey(attributeName = "id")
    var id: String,
    @DynamoDBAttribute(attributeName = "name")
    var name: String,
) {
    companion object

    fun toDto() = TeamMapper.INSTANCE.toDto(this)
}

data class TeamDto(
    var id: String,
    var name: String,
) {
    companion object

    fun toEntity() = TeamMapper.INSTANCE.toEntity(this)
}

@Mapper
interface TeamMapper {
    companion object {
        val INSTANCE: TeamMapper = Mappers.getMapper(TeamMapper::class.java)
    }

    fun toDto(team: Team): TeamDto

    fun toEntity(teamDto: TeamDto): Team
}
