package com.park.basketball.roster.api.service

import com.park.basketball.roster.api.model.TeamDto
import com.park.basketball.roster.api.repository.TeamRepository
import org.springframework.stereotype.Service

@Service
class TeamService(
    private val teamRepository: TeamRepository,
) {
    fun findById(id: String) = teamRepository.findById(id)

    fun save(teamDto: TeamDto) = teamRepository.save(teamDto.toEntity())

    fun delete(id: String) = teamRepository.deleteById(id)
}
