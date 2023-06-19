package com.hamtary.myapplication.helpers

data class Resource<T>(
    var loading: Boolean = false,
    var error: Event<String>? = null,
    var data: Event<T>? = null,
    var message: String? = null, ){

    companion object {
        fun <T> loading(isLoading: Boolean): Resource<T> {
            return Resource(loading = isLoading)
        }

        fun <T> error(message: String?): Resource<T> {
            return Resource(error = Event.responseEvent(message))
        }

        fun <T> data(data: T? = null,message: String? = null): Resource<T> {
            return Resource(data = Event.dataEvent(data),message = message)
        }
    }

}


/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 * تُستخدم كغلاف للبيانات التي يتم عرضها عبر LiveData التي تمثل حدثًا
 */
open class Event<out T>(private val content: T) {
    private var hasBeenHandled = false

    /**
     * Returns the content and prevents its use again.
     * يعيد المحتوى ويمنع استخدامه مرة أخرى
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     * إرجاع المحتوى ، حتى لو تم التعامل معه بالفعل
     */
//    fun peekContent(): T = content

    override fun toString(): String {
        return "Event(content=$content, hasBeenHandled=$hasBeenHandled)"
    }

    companion object {
        private const val TAG: String = "AppDebug"

        // we don't want an event if the data is null
        // لا نريد حدثًا إذا كانت البيانات فارغة
        fun <T> dataEvent(data: T?): Event<T>? {
            data?.let {
                return Event(it)
            }
            return null
        }

        // we don't want an event if the response is null
        // لا نريد حدثًا إذا كانت الاستجابة فارغة
        fun responseEvent(response: String?): Event<String>? {
            response?.let {
                return Event(response)
            }
            return null
        }
    }
}