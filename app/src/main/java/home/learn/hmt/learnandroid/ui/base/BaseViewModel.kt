package home.learn.hmt.learnandroid.ui.base

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import home.learn.hmt.data.remote.BaseException
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class BaseViewModel : ViewModel() {
    val isLoading = MutableLiveData<Boolean>().apply { value = false }
    val errorMessage = MutableLiveData<String>()

    //rx
    val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun onError(throwable: Throwable) {
        val unexpectedErrorMessage = "データの取得に失敗しました。再度時間を置いてから接続してください。"
        try {
            when (throwable) {
                is BaseException -> {
                    when (throwable.serverErrorCode) {
                        HttpURLConnection.HTTP_BAD_REQUEST -> {
                            errorMessage.value = unexpectedErrorMessage
                        }
                        HttpURLConnection.HTTP_UNAVAILABLE -> {
                            errorMessage.value = "システムメンテナンス中です。しばらくたってから接続してください。"
                        }

                        HttpURLConnection.HTTP_FORBIDDEN -> {
                            errorMessage.value = "アクセスが許可されていません。"
                        }
                        else -> {
                            when (throwable.cause) {
                                is UnknownHostException -> {
                                    errorMessage.value = "ネットワークに繋がっていません。\nネットワークに接続してもう一度お試しください。"
                                }
                                is SocketTimeoutException -> {
                                    errorMessage.value = "ネットワークに繋がっていません。\nネットワークに接続してもう一度お試しください。"
                                }
                                else -> {
                                    errorMessage.value =
                                        if (TextUtils.isEmpty(throwable.message)) unexpectedErrorMessage else throwable.message
                                }
                            }
                        }
                    }
                }
                else -> {
                    errorMessage.value =
                        if (TextUtils.isEmpty(throwable.message)) unexpectedErrorMessage else throwable.message
                }
            }
        } catch (e: Exception) {
            errorMessage.value = unexpectedErrorMessage
        }
    }

    open fun showError(e: Throwable) {
        errorMessage.value = e.message
    }

    fun onActivityDestroyed() {
        compositeDisposable.clear()
    }
}