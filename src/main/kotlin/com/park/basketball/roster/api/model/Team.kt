package com.park.basketball.roster.api.model

import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import java.time.LocalDateTime

@DynamoDbBean
data class Team(
    @get:DynamoDbPartitionKey
    var id: String,
    var name: String,
    var created: LocalDateTime,
    var modified: LocalDateTime,
) : RosterEntity {
    companion object {
        val TABLE_SCHEMA = TableSchema.fromBean(Team::class.java)
        val TABLE_NAME = "Team"
    }

    fun toDto() = TeamMapper.INSTANCE.toDto(this)
}

data class TeamDto(
    var id: String,
    var name: String,
    var created: LocalDateTime,
    var modified: LocalDateTime,
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
