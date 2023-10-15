package com.park.basketball.roster.api.repository

import com.park.basketball.roster.api.model.Member
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Component
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient

@Component
class MemberRepository(
    private val rosterDbClient: DynamoDbEnhancedClient,
) : AbstractRepository<Member>(), InitializingBean {
    override fun afterPropertiesSet() {
        table = rosterDbClient.table(Member.TABLE_NAME, Member.TABLE_SCHEMA)
    }
}
