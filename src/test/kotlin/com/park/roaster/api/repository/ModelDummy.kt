package com.park.roaster.api.repository

import com.github.javafaker.Faker
import kotlin.random.Random

val faker = Faker.instance(java.util.Locale.ENGLISH)

fun generateRandomLong() = Random.nextLong()

fun generateRandomName() = faker.leagueOfLegends().champion()

fun SimpleTestModel.Companion.dummy(
    modelId: Long = generateRandomLong(),
    modelName: String = generateRandomName(),
) = SimpleTestModel(
    modelId = modelId,
    modelName = modelName,
)
