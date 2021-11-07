package nl.com.lucianoluzzi.network.client

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkClientProvider {

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .addHeader("Authorization", "Bearer $BEARER_TOKEN")
                .build()
            chain.proceed(request)
        }
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()

    private companion object {
        private const val BASE_URL = "https://demo.chainels.com/api/v2/"
        private const val BEARER_TOKEN =
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiI0MzE0NDQwNTM2MDA3ODQ5NDIiLCJqdGkiOiJmN2U1MmZiMzRjZTZiY2U5NGNhZmQ0NWFhNjEyNzFhZmRkZDNkZmJkMDk0N2U4NDlhMDk0OWQ2Mzk4MDMwZmU4ZGMwZDJiN2EyZDQ0NTUwNSIsImlhdCI6MTYzNTkzMTMyNy45ODE0NzIwMiwibmJmIjoxNjM1OTMxMzI3Ljk4MTQ3NzAyLCJleHAiOjE2NTE1NjYxMjcuOTc1NTI3MDUsInN1YiI6IjEyMTYxODkxOTc4ODg1MjkwNiIsInNjb3BlcyI6WyJiYXNpYyIsIndyaXRlLm1lc3NhZ2VzIl19.dPmEZ-vtCRhIZIZwSOOD7awOefVlGFP2BjLnG33yKYG9zF-vsY09vw46-zwpKyS_2rPNp8m6TxlaktknySHyHIPwVTAeG0KTdW2CJCLp3N4n4YrSWXd2OTkYGXH-iP4VdXdrH2U6bkwcDtTGzPcXXU6bHYBiyd31LusABBStyELmO0-BpolCSvnxPwSM1ptD1wB8TWq2sxJdtfFwEWG5aE5vNAbdI61iXf4PiBJGvHmtrmg9TT-UFbGZjel0WtGW3b95qFckrhyxBxb6dPXl-oYJ_O5UaffzfN_6DzymT9RS3s6HjyOeRFKRCbDfQQOZslU4Id_SJ1I3xZDGPBmIkA"
    }
}