package com.linderaredux.api.service

import com.google.gson.JsonObject
import com.linderaredux.api.response.AppUser
import com.linderaredux.api.response.BaseResponse
import com.linderaredux.api.response.UserHome
import com.linderaredux.api.response.patient.Patient
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LinderaApi {

    @POST("user/login")
    fun userLogin(@Body loginReq: JsonObject): Observable<Response<BaseResponse<AppUser>>>

    @GET("home/image")
    fun userHome(): Observable<Response<BaseResponse<UserHome>>>

    @GET("patient/recent")
    fun userPatients(): Observable<Response<BaseResponse<List<Patient>>>>

    @POST("patient")
    fun userCreatePatient(@Body patientReq: JsonObject): Observable<Response<BaseResponse<Patient>>>
}