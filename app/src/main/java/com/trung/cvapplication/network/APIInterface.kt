package com.trung.cvapplication.network

import com.trung.cvapplication.model.remote.Work
import retrofit2.Call
import retrofit2.http.GET

// Creating the API Interface able to send the request and get the response.
interface APIInterface {
    /*  annotation of @GET add into  base url, it's a HTTP annotation
    *  to specify the request type and the relative URL not the complete url. */
// Get the spacecraft is my request, So it's a get request with the relative url
    @GET("/work.json")
    fun  getWorks(): Call<List<Work>>
    /*Call -->  An invocation of a Retrofit method that sends a request to a webserver and returns a response.
     Each call yields its own HTTP request and response pair.*/

}