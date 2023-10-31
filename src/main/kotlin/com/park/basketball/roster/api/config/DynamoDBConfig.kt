package com.park.basketball.roster.api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient

@Configuration
class DynamoDBConfig {
    @Bean
    fun rosterDbClient(): DynamoDbEnhancedClient {
        return DynamoDbEnhancedClient.builder()
            .dynamoDbClient(
                DynamoDbClient.builder()
                    .credentialsProvider(DefaultCredentialsProvider.create())
                    .region(Region.AP_NORTHEAST_2)
                    .build(),
            )
            .build()
    }
}
