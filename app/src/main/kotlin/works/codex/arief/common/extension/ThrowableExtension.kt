package works.codex.arief.common.extension

import retrofit2.HttpException
import java.io.IOException
import java.net.UnknownHostException

fun Throwable.isInternalServerError(): Boolean {
    return this is HttpException && message?.contains("500") ?: false
}

fun Throwable.isServerRequestBad(): Boolean {
    return this is HttpException && message?.contains("400") ?: false
}

fun Throwable.isServerRequestErrorUnauthorized(): Boolean {
    return this is HttpException && message?.contains("401") ?: false
}

fun Throwable.isNotFoundMessage(): Boolean {
    return this is HttpException && message?.contains("404") ?: false
}

fun Throwable.isServerRequestErrorNoInternet(): Boolean {
    return this is UnknownHostException
}

fun Throwable.isServerRequestErrorNetwork(): Boolean {
    return this is IOException || (this.message?.contains(other = "NetworkNotAvailable") ?: false)
}

fun Throwable.getHttpErrorMessage(): String? {
    if (this is HttpException) {
        return this.response()?.errorBody()?.string()
    }
    val throwableCause = this.cause
    if (throwableCause is HttpException) {
        return throwableCause.response()?.errorBody()?.string()
    }

    return null
}
