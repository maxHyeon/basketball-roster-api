package com.park.basketball.roster.api.model

import com.github.javafaker.Faker
import java.util.Locale
import java.util.UUID
import kotlin.random.Random

val faker: Faker = Faker.instance(Locale.ENGLISH)

fun generateRandomId() = UUID.randomUUID().toString()

fun generateRandomInt() = Random.nextInt()

fun generateRandomInt(until: Int) = Random.nextInt(until)

fun generateRandomName(): String = faker.leagueOfLegends().champion()

fun Member.Companion.dummy(
    id: String = generateRandomId(),
    name: String = generateRandomName(),
    teamId: String = generateRandomId(),
) = Member(
    id = id,
    name = name,
    positions = listOf(Position.entries.random()),
    quarters = generateRandomInt(4),
    teamId = teamId,
)

fun Roster.Companion.dummy(id: String = generateRandomId()) =
    Roster(
        id = id,
    )

fun Team.Companion.dummy(
    id: String = generateRandomId(),
    name: String = generateRandomName(),
) = Team(
    id = id,
    name = name,
)
