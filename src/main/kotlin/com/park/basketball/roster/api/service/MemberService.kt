package com.park.basketball.roster.api.service

import com.park.basketball.roster.api.model.MemberDto
import com.park.basketball.roster.api.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository,
) {
    fun findById(id: String) = memberRepository.findById(id)

    fun save(memberDto: MemberDto) = memberRepository.save(memberDto.toEntity())

    fun delete(id: String) = memberRepository.deleteById(id)
}
