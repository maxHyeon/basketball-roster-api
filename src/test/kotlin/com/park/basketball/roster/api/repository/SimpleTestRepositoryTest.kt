package com.park.basketball.roster.api.repository

import com.park.basketball.roster.api.config.RepositoryConfig
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.test.context.ContextConfiguration

@EnableJpaAuditing
@DataJpaTest
@Import(RepositoryConfig::class)
@ContextConfiguration(initializers = [RepositoryTestInitializer::class])
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SimpleTestRepositoryTest(
    @Autowired private val cut: SimpleTestRepository,
) {
    @Test
    fun test() {
        val expect = SimpleTestModel.dummy()

        cut.saveAndFlush(expect)
    }
}
