package com.park.basketball.roster.api.controller

import com.park.basketball.roster.api.model.TeamDto
import com.park.basketball.roster.api.service.TeamService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

@RestController
class TeamController(
    private val teamService: TeamService,
) : AbstractController() {
    @GetMapping(value = ["/team/{id}"])
    fun getTeamById(
        @PathVariable(value = "id") id: String,
    ): TeamDto {
        return teamService.findById(id)
            .map { it.toDto() }
            .orElseThrow { Exception("NotFound") }
    }
}
