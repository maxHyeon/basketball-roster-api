package com.park.basketball.roster.api.repository

import com.park.basketball.roster.api.model.Roster
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Component
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient

@Component
class RosterRepository(
    private val rosterDbClient: DynamoDbEnhancedClient,
) : AbstractRepository<Roster>(), InitializingBean {
    override fun afterPropertiesSet() {
        table = rosterDbClient.table(Roster.TABLE_NAME, Roster.TABLE_SCHEMA)
    }
}
