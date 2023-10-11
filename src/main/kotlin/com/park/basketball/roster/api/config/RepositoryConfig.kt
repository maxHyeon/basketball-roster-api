package com.park.basketball.roster.api.config

import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories(
    basePackages = ["com.park.basketball.roster.api"],
)
class RepositoryConfig
