package com.disenio.services.API.refugiosApi;

import com.disenio.services.API.refugiosApi.entities.ListadoDeRefugios;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RefugiosService {
    @Headers({"Authorization: Bearer 5EfqbMgizd5AUx8vRcQy5eHUUzwoPc54jmUiGhcGxZX4GARumFyLsFyHRLli"})
    @GET("hogares")
    Call<ListadoDeRefugios> hogares(@Query("offset") int offset);

}
