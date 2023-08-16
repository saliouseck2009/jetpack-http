package com.example.http_practice.utils

sealed class Results<R>(val data: R? = null, val message: String? = null){
    class Success<R>(data: R):Results<R>(data)
    class Error<R>(message: String, data: R? = null):Results<R>(data, message)
    class Loading<R>:Results<R>()
}
