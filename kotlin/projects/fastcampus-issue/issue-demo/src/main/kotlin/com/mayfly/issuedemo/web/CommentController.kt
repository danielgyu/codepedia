package com.mayfly.issuedemo.web

import com.mayfly.issuedemo.config.AuthUser
import com.mayfly.issuedemo.model.CommentRequest
import com.mayfly.issuedemo.model.CommentResponse
import com.mayfly.issuedemo.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/issues/{issueId}/comments")
class CommentController(
    private val commentService: CommentService,
) {
    @PostMapping
    fun create(
        authUser: AuthUser,
        @PathVariable issueId: Long,
        @RequestBody request: CommentRequest,
    ): CommentResponse {
        return commentService.create(issueId, authUser.userId, authUser.userName, request)
    }

    @PutMapping("/{commentsId}")
    fun edit(
        authUser: AuthUser,
        @PathVariable commentsId: Long,
        @RequestBody request: CommentRequest,
    ): CommentResponse? {
        return commentService.edit(authUser.userId, commentsId, request)
    }

    @DeleteMapping("/{commentsId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        authUser: AuthUser,
        @PathVariable issueId: Long,
        @PathVariable commentsId: Long,
    ) = commentService.delete(issueId, commentsId, authUser.userId)
}