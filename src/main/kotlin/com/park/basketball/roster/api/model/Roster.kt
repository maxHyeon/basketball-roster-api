package com.park.basketball.roster.api.model

import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import java.time.LocalDateTime

@DynamoDbBean
data class Roster(
    @get:DynamoDbPartitionKey
    var id: String,
    var created: LocalDateTime,
    var modified: LocalDateTime,
) : RosterEntity {
    companion object {
        val TABLE_SCHEMA = TableSchema.fromBean(Roster::class.java)
        val TABLE_NAME = "Roster"
    }

    fun toDto() = RosterMapper.INSTANCE.toDto(this)
}

data class RosterDto(
    var id: String,
    var created: LocalDateTime,
    var modified: LocalDateTime,
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
