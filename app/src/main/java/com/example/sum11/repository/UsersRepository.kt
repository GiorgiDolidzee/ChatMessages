package com.example.sum11.repository

import com.example.sum11.model.Users
import com.example.sum11.network.ApiService
import com.example.sum11.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class UsersRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getUser() : Flow<Resource<Users>> = flow {
        try {
            val user = apiService.getUsers()
            val body = user.body()
            if(user.isSuccessful && body != null) {
                emit(Resource.Success(body))
            } else {
                emit(Resource.Error(user.message()))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?:""))
        }
    }


// ES VER GAVIGE MARTLA

//    private suspend fun <M> handleResponse(
//        request: suspend () -> Response<M>,
//        defaultMessage: String
//    ): Resource<M> {
//        return try {
//            val result = request.invoke()
//            val body = result.body()
//            if (result.isSuccessful && body != null) {
//                return Resource.Success(body)
//            } else {
//                Resource.Error(result.message() ?: defaultMessage)
//            }
//        } catch (e: Throwable) {
//            Resource.Error("Something went wrong!", null)
//        }
//    }


}