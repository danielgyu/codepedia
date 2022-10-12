package com.mayfly.issuedemo.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.mayfly.issuedemo.domain.Comment
import com.mayfly.issuedemo.domain.Issue
import com.mayfly.issuedemo.domain.enums.IssuePriority
import com.mayfly.issuedemo.domain.enums.IssueStatus
import com.mayfly.issuedemo.domain.enums.IssueType
import java.time.LocalDateTime

data class IssueRequest(
    val summary: String,
    val description: String,
    val type: IssueType,
    val priority: IssuePriority,
    val status: IssueStatus,
)

data class IssueResponse(
    val id: Long,
    val userId: Long,
    val comments: List<CommentResponse> = emptyList(),
    val summary: String,
    val description: String,
    val type: IssueType,
    val priority: IssuePriority,
    val status: IssueStatus,
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    val createdAt: LocalDateTime?,
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    val updatedAt: LocalDateTime?,
) {
    companion object {
        operator fun invoke(issue: Issue) =
            with(issue) {
                IssueResponse(
                    id = id!!,
                    summary = summary,
                    comments = comments.sortedByDescending(Comment::id).map(Comment::toResponse),
                    description = description,
                    userId = userId,
                    type = type,
                    priority = priority,
                    status = status,
                    createdAt = createdAt,
                    updatedAt = updatedAt,
                )
            }
    }
}