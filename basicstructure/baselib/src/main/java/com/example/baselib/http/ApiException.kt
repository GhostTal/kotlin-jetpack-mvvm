package com.example.baselib.http


/**
 * 用来封装业务错误信息
 * */
class ApiException(val errorMessage: String, val errorCode: Int) : Throwable() {
}