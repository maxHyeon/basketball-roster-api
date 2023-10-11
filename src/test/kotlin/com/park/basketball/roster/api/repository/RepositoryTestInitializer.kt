package com.park.basketball.roster.api.repository

import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.utility.DockerImageName

class RepositoryTestInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
    companion object {
        @JvmStatic
        val mySqlTestContainer =
            MySQLContainer<Nothing>(DockerImageName.parse("mysql:8.0.29"))
                .apply {
                    withDatabaseName("roster")
                    withInitScript("db/init.sql")
                    withReuse(true)
                }
    }

    override fun initialize(configurableApplicationContext: ConfigurableApplicationContext) {
        mySqlTestContainer.start()

        TestPropertyValues.of(
            "spring.datasource.jdbc-url=${mySqlTestContainer.jdbcUrl}",
            "spring.datasource.url=${mySqlTestContainer.jdbcUrl}",
            "spring.datasource.username=${mySqlTestContainer.username}",
            "spring.datasource.password=${mySqlTestContainer.password}",
            "spring.datasource.driver-class=${mySqlTestContainer.driverClassName}",
        ).applyTo(configurableApplicationContext.environment)
    }
}
