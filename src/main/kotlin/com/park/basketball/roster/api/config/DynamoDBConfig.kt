package com.park.basketball.roster.api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient

@Configuration
class DynamoDBConfig {
    @Bean(value = ["rosterDbClient"])
    @Profile(value = ["local"])
    fun localRosterDbClient(): DynamoDbEnhancedClient {
        return DynamoDbEnhancedClient.builder()
            .dynamoDbClient(
                DynamoDbClient.builder()
                    .credentialsProvider(
                        StaticCredentialsProvider.create(
                            AwsBasicCredentials.create(
                                "",
                                "",
                            ),
                        ),
                    )
                    .region(Region.AP_NORTHEAST_1)
                    .build(),
            )
            .build()
    }

    @Bean(value = ["rosterDbClient"])
    @Profile(value = ["dev", "prod"])
    fun remoteRosterDbClient(): DynamoDbEnhancedClient {
        return DynamoDbEnhancedClient.builder()
            .dynamoDbClient(
                DynamoDbClient.builder()
                    .credentialsProvider(ProfileCredentialsProvider.create())
                    .region(Region.AP_NORTHEAST_1)
                    .build(),
            )
            .build()
    }
}
