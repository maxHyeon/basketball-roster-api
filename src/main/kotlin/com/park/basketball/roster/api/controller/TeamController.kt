package com.park.basketball.roster.api.controller

import com.park.basketball.roster.api.model.TeamDto
import com.park.basketball.roster.api.service.TeamService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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

    @PostMapping(value = ["/team"])
    fun postTeam(
        @RequestBody teamDto: TeamDto,
    ): Boolean {
        teamService.save(teamDto)
        return true
    }

    @DeleteMapping(value = ["/team/{id}"])
    fun deleteTeam(
        @PathVariable(value = "id") id: String,
    ): Boolean {
        teamService.delete(id)
        return true
    }
}
