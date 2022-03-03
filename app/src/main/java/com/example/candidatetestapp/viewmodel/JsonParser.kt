package com.example.candidatetestapp.viewmodel

import android.content.res.AssetManager
import android.util.Log
import com.example.candidatetestapp.api.ServiceApi
import com.example.candidatetestapp.models.Response
import com.example.candidatetestapp.models.User
import com.google.gson.Gson
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.nio.charset.StandardCharsets

class JsonParser : ServiceApi {
    override fun getData(): User {
        var json = ""
        val inpStr = this.javaClass.classLoader.getResourceAsStream("assets/candidate.json")
        val bOut = ByteArrayOutputStream()
        val b = ByteArray(1)
        try {
            while (inpStr.read(b) !== -1) {
                bOut.write(b)
            }
            json = bOut.toString()
            inpStr.close()
            bOut.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        Log.d("tag", json)
        val gson = Gson()
//        Log.d("tag", "${gson.fromJson(json, User::class.java)}")
        return gson.fromJson(json, Response::class.java).user
    }
}