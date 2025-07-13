package com.example.composemvvm.api

import com.example.composemvvm.models.Item
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    // -------------------- GET Requests --------------------

    /**
     * GET request with query parameter
     */
    @GET("items")
    suspend fun getData(@Query("param") param: String): Response<List<Item>>

    /**
     * GET request with a dynamic header
     */
    @GET("items")
    suspend fun getDataWithDynamicHeader(@Header("Authorization") token: String): Response<List<Item>>

    /**
     * GET request with a static header
     */
    @GET("items")
    @Headers("Authorization: Bearer static_token_here")
    suspend fun getDataWithStaticHeader(@Query("param") param: String): Response<List<Item>>

    // -------------------- POST Requests --------------------

    /**
     * POST request with a JSON body
     */
    @POST("items")
    suspend fun postData(@Body item: Item): Response<Item>

    /**
     * POST request with form-encoded data (application/x-www-form-urlencoded)
     */
    @FormUrlEncoded
    @POST("form-submit")
    suspend fun postFormData(
        @Field("name") name: String,
        @Field("email") email: String
    ): Response<Unit>

    /**
     * POST request with multipart data (e.g., file upload)
     */
    @Multipart
    @POST("upload")
    suspend fun uploadFile(
        @Part file: MultipartBody.Part,
        @Part("description") description: RequestBody
    ): Response<Unit>

    // -------------------- PUT / PATCH Requests --------------------

    /**
     * PUT request to update an item
     */
    @PUT("items/{id}")
    suspend fun updateItem(
        @Path("id") id: String,
        @Body item: Item
    ): Response<Item>

    /**
     * PATCH request for partial update
     */
    @PATCH("items/{id}")
    suspend fun patchItem(
        @Path("id") id: String,
        @Body fields: Map<String, Any>
    ): Response<Item>

    // -------------------- DELETE Request --------------------

    /**
     * DELETE request to remove an item
     */
    @DELETE("items/{id}")
    suspend fun deleteItem(@Path("id") id: String): Response<Unit>
}
