package com.linderaredux.api.service

import com.google.gson.JsonObject
import com.linderaredux.api.response.AppUser
import com.linderaredux.api.response.BaseResponse
import com.linderaredux.api.response.UserHome
import com.linderaredux.api.response.patient.Patient
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

interface LinderaApi {

    @POST("users")
    fun userRegister(@Body registerReq: JsonObject): Observable<Response<BaseResponse<AppUser>>>

    @POST("session")
    fun userLogin(@Body loginReq: JsonObject): Observable<Response<BaseResponse<AppUser>>>

    @GET("homes/{homeId}")
    fun userHome(@Path("homeId") homeId: String): Observable<Response<BaseResponse<UserHome>>>

    @GET("patients")
    fun userPatients(): Observable<Response<BaseResponse<List<Patient>>>>

    @POST("patients")
    fun userCreatePatient(@Body patientReq: JsonObject): Observable<Response<BaseResponse<Patient>>>

    @DELETE("patients/{patientId}")
    fun deletePatient(@Path("patientId") patientId: String): Observable<Response<BaseResponse<Patient>>>

    @DELETE("users/{userId}")
    fun deleteUser(@Path("userId") userId: String): Observable<Response<BaseResponse<AppUser>>>
}