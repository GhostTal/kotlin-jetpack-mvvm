package com.example.basicstructure.http

class BaseResponse<T> {
    var data: T? = null
    var errorMsg = ""
    var errorCode = 0
}