package com.park.basketball.roster.api.model

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@DynamoDBTable(tableName = "member")
data class Member(
    @DynamoDBHashKey(attributeName = "id")
    var id: String,
    @DynamoDBAttribute(attributeName = "name")
    var name: String,
    @DynamoDBAttribute(attributeName = "positions")
    var positions: List<Position>,
    @DynamoDBAttribute(attributeName = "quarters")
    var quarters: Int,
    @DynamoDBAttribute(attributeName = "teamId")
    var teamId: String,
) {
    companion object

    fun toDto() = MemberMapper.INSTANCE.toDto(this)
}

data class MemberDto(
    var id: String,
    var name: String,
    var positions: List<Position>,
    var quarters: Int,
    var teamId: String,
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
