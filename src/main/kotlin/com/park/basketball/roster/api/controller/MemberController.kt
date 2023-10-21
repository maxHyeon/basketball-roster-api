package com.park.basketball.roster.api.controller

import com.park.basketball.roster.api.model.MemberDto
import com.park.basketball.roster.api.service.MemberService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

@RestController
class MemberController(
    private val memberService: MemberService,
) : AbstractController() {
    @GetMapping(value = ["/member/{id}"])
    fun getMemberById(
        @PathVariable(value = "id") id: String,
    ): MemberDto {
        return memberService.findById(id)
            .map { it.toDto() }
            .orElseThrow { Exception("NotFound") }
    }

    @PostMapping(value = ["/member"])
    fun postMember(
        @RequestBody memberDto: MemberDto,
    ): Boolean {
        memberService.save(memberDto)
        return true
    }

    @DeleteMapping(value = ["/member/{id}"])
    fun deleteMember(
        @PathVariable(value = "id") id: String,
    ): Boolean {
        memberService.delete(id)
        return true
    }
}
