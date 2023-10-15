package com.park.basketball.roster.api.model

import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import java.time.LocalDateTime

@DynamoDbBean
data class Member(
    @get:DynamoDbPartitionKey
    var id: String,
    var name: String,
    var positions: List<Position>,
    var quarters: Int,
    var teamId: String,
    var created: LocalDateTime,
    var modified: LocalDateTime,
) : RosterEntity {
    companion object {
        val TABLE_SCHEMA = TableSchema.fromBean(Member::class.java)
        val TABLE_NAME = "Member"
    }

    fun toDto() = MemberMapper.INSTANCE.toDto(this)
}

data class MemberDto(
    var id: String,
    var name: String,
    var positions: List<Position>,
    var quarters: Int,
    var teamId: String,
    var created: LocalDateTime,
    var modified: LocalDateTime,
) {
    companion object

    fun toEntity() = MemberMapper.INSTANCE.toEntity(this)
}

@Mapper
interface MemberMapper {
    companion object {
        val INSTANCE: MemberMapper = Mappers.getMapper(MemberMapper::class.java)
    }

    fun toDto(member: Member): MemberDto

    fun toEntity(memberDto: MemberDto): Member
}
