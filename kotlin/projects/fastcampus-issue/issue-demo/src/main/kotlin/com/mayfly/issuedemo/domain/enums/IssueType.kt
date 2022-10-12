package com.mayfly.issuedemo.domain.enums

enum class IssueType {
    BUG, TASK;

    companion object {
        operator fun invoke(type: String) = valueOf(type.uppercase())
    }
}
