package com.park.basketball.roster.api.config

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DynamoDBConfig {
    @Bean
    fun rosterDBMapper(): DynamoDBMapper {
        return DynamoDBMapper(
            AmazonDynamoDBClientBuilder
                .standard()
                .build(),
            DynamoDBMapperConfig.builder()
                .withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT)
                .build(),
        )
    }
}
