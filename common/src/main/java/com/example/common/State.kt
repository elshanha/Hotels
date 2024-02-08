package com.example.common

class State(
    val status: Status,
    var message : String? = null
) {
    companion object {
        fun success() : State = State(Status.SUCCESS)
        fun error(message: String?) : State = State(Status.ERROR, message)
        fun loading() : State = State(Status.LOADING)
    }

}

enum class Status {
    SUCCESS, ERROR, LOADING
}