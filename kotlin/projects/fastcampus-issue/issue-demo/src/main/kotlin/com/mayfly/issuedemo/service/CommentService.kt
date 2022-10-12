package com.mayfly.issuedemo.service

import com.mayfly.issuedemo.domain.Comment
import com.mayfly.issuedemo.domain.CommentRepository
import com.mayfly.issuedemo.domain.IssueRepository
import com.mayfly.issuedemo.exception.NotFoundException
import com.mayfly.issuedemo.model.CommentRequest
import com.mayfly.issuedemo.model.CommentResponse
import com.mayfly.issuedemo.model.toResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class CommentService(
    private val commentRepository: CommentRepository,
    private val issueRepository: IssueRepository,
) {
    @Transactional
    fun create(issueId: Long, userId: Long, username: String, request: CommentRequest): CommentResponse {
        val issue = issueRepository.findByIdOrNull(issueId) ?: throw NotFoundException("Issue Not Found")

        val comment = Comment(
            issue = issue,
            userId = userId,
            username = username,
            body = request.body,
        )

        issue.comments.add(comment)
        return commentRepository.save(comment).toResponse()
    }

    @Transactional
    fun edit(userId: Long, commentsId: Long, request: CommentRequest): CommentResponse? {
        return commentRepository.findByIdOrNull(commentsId)?.run {
            body = request.body
            commentRepository.save(this).toResponse()
        }
    }

    @Transactional
    fun delete(issueId: Long,  commentsId: Long, userId: Long) {
        val issue = issueRepository.findByIdOrNull(issueId) ?: throw NotFoundException("Issue Not Found")
        commentRepository.findByIdAndUserId(commentsId, userId)?.let { comment ->
            issue.comments.remove(comment)
        }
    }
}