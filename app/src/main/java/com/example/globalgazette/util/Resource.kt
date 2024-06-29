package com.example.globalgazette.util

sealed class Resource<T>(
    val data: T? = null,
    val message: T? = null
)
{
    class Success<T>(data: T?): Resource<T>(data)
    class Error<T>(data: T? = null, message: T?): Resource<T>(data, message)
    class Loading<T>(): Resource<T>()
}