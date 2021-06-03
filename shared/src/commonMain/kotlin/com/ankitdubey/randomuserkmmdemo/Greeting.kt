package com.ankitdubey.randomuserkmmdemo

import com.ankitdubey.randomuserkmmdemo.data.RandomUserDao
import com.ankitdubey.randomuserkmmdemo.networking.DataState
import com.ankitdubey.randomuserkmmdemo.networking.RandomUserRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class Greeting {
    fun greeting(resCallback : (RandomUserDao?, Exception?) -> Unit) {

        GlobalScope.launch {
            RandomUserRepository().fetchUserData().collect {
                when (it) {
                    is DataState.Error -> resCallback(null, it.exception)
                    is DataState.Success -> { resCallback(it.data, null) }
                }
            }
        }
    }
}