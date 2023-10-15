package com.park.basketball.roster.api.repository

import com.park.basketball.roster.api.model.Team
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Component
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient

@Component
class TeamRepository(
    private val rosterDbClient: DynamoDbEnhancedClient,
) : AbstractRepository<Team>(), InitializingBean {
    override fun afterPropertiesSet() {
        table = rosterDbClient.table(Team.TABLE_NAME, Team.TABLE_SCHEMA)
    }
}
