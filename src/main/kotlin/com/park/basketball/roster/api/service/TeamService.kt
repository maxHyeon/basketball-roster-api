package com.park.basketball.roster.api.service

import com.park.basketball.roster.api.repository.TeamRepository
import org.springframework.stereotype.Service

@Service
class TeamService(
    private val teamRepository: TeamRepository,
) {
    fun findById(id: String) = teamRepository.findById(id)
}
