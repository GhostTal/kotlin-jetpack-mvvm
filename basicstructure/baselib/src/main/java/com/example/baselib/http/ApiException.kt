package com.example.baselib.http

import java.lang.Exception

/**
 * 用来封装业务错误信息
 * */
class ApiException(val errorMessage: String, val errorCode: Int) : Exception() {
}