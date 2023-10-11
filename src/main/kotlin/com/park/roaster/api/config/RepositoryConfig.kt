package com.park.roaster.api.config

import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories(
    basePackages = ["com.park.roaster.api"],
)
class RepositoryConfig
