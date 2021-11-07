package nl.com.lucianoluzzi.network

import java.lang.Exception

sealed class Response {
    object Completed : Response()
    data class Error(val errorMessage: Exception) : Response()
}

