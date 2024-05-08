package com.sown.dogapp.viewModels

import com.sown.dogapp.models.DogBreed
import com.sown.dogapp.models.DogsApi
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DogsApiService {
        private const val BASE_URL = "https://raw.githubusercontent.com/"

        private val api: DogsApi by lazy {
                createApi()
        }

        // Configure Retrofit to use RxJava3 and GSON converter factory
        private fun createApi(): DogsApi {
                return Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                        .build()
                        .create(DogsApi::class.java)
        }

        // Expose a method to get the list of DogBreed objects using Single from RxJava3
        fun getDogs(): Observable<List<DogBreed>> {
                return api.getDogs()
        }

}
