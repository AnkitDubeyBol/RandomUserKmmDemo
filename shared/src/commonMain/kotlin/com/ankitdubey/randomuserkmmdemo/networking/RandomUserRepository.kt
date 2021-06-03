package com.ankitdubey.randomuserkmmdemo.networking


import com.ankitdubey.randomuserkmmdemo.data.RandomUserDao
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

const val baseURL = "api.gravtee.com"

class RandomUserRepository (){

    suspend fun fetchUserData() : Flow<DataState<RandomUserDao>>  = flow {
        emit(DataState.Loading)
        try {
            val user = ktorHttpClient
                .get<RandomUserDao>("https://randomuser.me/api/")

            emit(DataState.Success(user))
        }catch (ex : Exception){
            ex.printStackTrace()
            //emit(DataState.Error(ex))
        }
    }.catch { e -> emit(DataState.Error(e as Exception)) }
}
