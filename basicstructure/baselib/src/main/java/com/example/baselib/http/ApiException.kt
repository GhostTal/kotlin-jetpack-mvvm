package com.example.baselib.http

import java.io.IOException

/**
 * used for logging error message
 * */
class ApiException(val businessMessage: String, val businessCode: Int) : IOException() {
}