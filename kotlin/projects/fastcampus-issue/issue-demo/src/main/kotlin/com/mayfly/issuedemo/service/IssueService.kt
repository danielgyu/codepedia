package com.mayfly.issuedemo.service

import com.mayfly.issuedemo.domain.Issue
import com.mayfly.issuedemo.domain.IssueRepository
import com.mayfly.issuedemo.domain.enums.IssueStatus
import com.mayfly.issuedemo.exception.NotFoundException
import com.mayfly.issuedemo.model.IssueRequest
import com.mayfly.issuedemo.model.IssueResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class IssueService(
    private val issueRepository: IssueRepository,
) {
    @Transactional
    fun create(userId: Long, request: IssueRequest): IssueResponse {
        val issue = Issue(
            summary = request.summary,
            description = request.description,
            userId = userId,
            type = request.type,
            priority = request.priority,
            status = request.status,
        )
        return IssueResponse(issueRepository.save(issue))
    }

    @Transactional
    fun getAll(userId: Long, status: IssueStatus): List<IssueResponse>? {
        return issueRepository.findAllByStatusOrderByCreatedAtDesc(status = status)
            ?.map { IssueResponse(it) }
    }

    @Transactional
    fun get(userId: Long, id: Long): IssueResponse {
        val issue: Issue = issueRepository.findByIdOrNull(id) ?: throw NotFoundException("Issue Not Found")
        return IssueResponse(issue)
    }

    @Transactional
    fun edit(userId: Long, id: Long, request: IssueRequest): IssueResponse {
        val issue: Issue = issueRepository.findByIdOrNull(id) ?: throw NotFoundException("Issue Not Found")
        return with(issue) {
            summary = request.summary
            description = request.description
            this.userId = userId
            type = request.type
            priority = request.priority
            status = request.status
            IssueResponse(issueRepository.save(this))
        }
    }

    @Transactional
    fun delete(id: Long): Unit {
        return issueRepository.deleteById(id)
    }
}