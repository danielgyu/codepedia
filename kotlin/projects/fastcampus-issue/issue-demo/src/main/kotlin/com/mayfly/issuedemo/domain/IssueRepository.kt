package com.mayfly.issuedemo.domain

import com.mayfly.issuedemo.domain.enums.IssueStatus
import org.springframework.data.jpa.repository.JpaRepository

interface IssueRepository: JpaRepository<Issue, Long> {
    fun findAllByStatusOrderByCreatedAtDesc(status: IssueStatus): List<Issue>?
}
