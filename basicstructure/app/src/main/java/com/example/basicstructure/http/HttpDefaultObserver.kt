package com.example.basicstructure.http

import com.example.baselib.http.ApiException
import com.google.gson.JsonParseException
import org.json.JSONException
import java.lang.reflect.ParameterizedType
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * des 给Response脱壳,对服务器错误统一处理
 *
 */
abstract class HttpDefaultObserver<T> : io.reactivex.Observer<ApiResponse<T>> {

    override fun onComplete() {
    }


    override fun onNext(t: ApiResponse<T>) {
        if (t.errorCode==0) {

            if (t.data==null){
                val tClass = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<T>
                t.data = tClass.newInstance()
            }
            t.data?.let { onSuccess(it) }
        }
        //code!=0代表业务出错，进行过滤
        else{
            filterCode(t.errorMsg,t.errorCode)
        }
    }

    override fun onError(e: Throwable) {
        val errorMsg = if (e is UnknownHostException) {
            "网络异常"
        } else if (e is JSONException || e is JsonParseException) {
            "数据异常"
        } else if (e is SocketTimeoutException) {
            "连接超时"
        } else if (e is ConnectException) {
            "连接错误"
        } else if (e is ApiException){
            e.errorMessage
        } else{
            "未知错误"
        }
        onError(errorMsg)
    }

    private fun filterCode(msg: String, code: Int) {
        when (code) {
            //登录失败
            -1001 -> {
                //AppManager.resetUser()
                onError(ApiException(msg, code))
            }
            //未知code,将errorMsg封装成异常,由onError()处理
            else -> onError(ApiException(msg, code))
        }
    }

    abstract fun onSuccess(t:T)
    abstract fun onError(errorMsg:String)

}