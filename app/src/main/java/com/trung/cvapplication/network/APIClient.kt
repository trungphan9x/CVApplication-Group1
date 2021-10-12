package com.trung.cvapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// To get response from the given url using Retrofit. It's Retrofit client class
class APIClient {
    // Make into static read from any class without using instance
    companion object{
        // Define the base url
        private const val  base_url:String = "https://trungphan9x.github.io/"
        // Get the client
        private fun getClient(): Retrofit {
            return Retrofit.Builder() // build your Retrofit Object
                .baseUrl(base_url) // hit the url
                .addConverterFactory(GsonConverterFactory.create()) // Perform serialization and deserialization
                .build() // Create an instance using the configured values
        }
        fun apiInterface() : APIInterface { // returns an instance of your interface
            // Create an implementation of the API endpoints defined by the interface using client
            return  getClient().create(APIInterface::class.java) // pass the interface name to get the response
        }
    }

}