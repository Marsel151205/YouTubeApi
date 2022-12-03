package com.example.youtube.base

import androidx.lifecycle.liveData
import com.example.youtube.common.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.io.IOException

abstract class BaseRepository {

    fun <T> doRequest(result: suspend () -> Response<T>) = flow {
        emit(Resource.Loading())

        try {
            result().body()?.let {
                emit(Resource.Success(it))
            }
        } catch (ioException: IOException) {
            emit(ioException.localizedMessage?.let { Resource.Error(it, null) })
        }
    }
}