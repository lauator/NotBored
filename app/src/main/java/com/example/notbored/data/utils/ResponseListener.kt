package com.example.notbored.data.utils

interface ResponseListener<T> {

    fun onResponse(response: RepositoryResponse<T>)

    fun onError(error: RepositoryError)

}