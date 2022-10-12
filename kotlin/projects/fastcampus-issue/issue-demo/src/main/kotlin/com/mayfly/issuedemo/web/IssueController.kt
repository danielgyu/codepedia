package com.mayfly.issuedemo.web

import com.mayfly.issuedemo.config.AuthUser
import com.mayfly.issuedemo.domain.enums.IssueStatus
import com.mayfly.issuedemo.model.IssueRequest
import com.mayfly.issuedemo.service.IssueService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/issues")
class IssueController(
    private val issueService: IssueService
) {
    @PostMapping
    fun create(
        authUser: AuthUser,
        @RequestBody request: IssueRequest,
    ) = issueService.create(userId = authUser.userId, request = request)

    @GetMapping
    fun getAll(
        authUser: AuthUser,
        @RequestParam(required = false, defaultValue = "TODO") status: IssueStatus,
    ) = issueService.getAll(userId = authUser.userId, status = status)

    @GetMapping("/{id}")
    fun get(
        authUser: AuthUser,
        @PathVariable id: Long,
    ) = issueService.get(userId = authUser.userId, id = id)

    @PutMapping("/{id}")
    fun edit(
        authUser: AuthUser,
        @PathVariable id: Long,
        @RequestBody request: IssueRequest,
    ) = issueService.edit(userId = authUser.userId, id = id, request = request)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        authUser: AuthUser,
        @PathVariable id: Long,
    ) = issueService.delete(id = id)
}