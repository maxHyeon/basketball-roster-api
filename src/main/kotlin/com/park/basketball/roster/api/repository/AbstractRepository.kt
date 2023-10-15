package com.park.basketball.roster.api.repository

import com.park.basketball.roster.api.model.RosterEntity
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.Key
import java.util.Optional

abstract class AbstractRepository<T : RosterEntity> {
    lateinit var table: DynamoDbTable<T>

    fun save(entity: T) {
        table.putItem(entity)
    }

    fun deleteById(id: String) {
        table.deleteItem(
            Key.builder()
                .partitionValue(id)
                .build(),
        )
    }

    fun findById(id: String): Optional<T> {
        return Optional.ofNullable(
            table.getItem(
                Key.builder()
                    .partitionValue(id)
                    .build(),
            ),
        )
    }
}
