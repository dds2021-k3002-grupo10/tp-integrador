package services.refugiosApi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import services.refugiosApi.entities.ListadoDeRefugios;

public interface RefugiosService {
    @Headers({"Authorization: Bearer 5EfqbMgizd5AUx8vRcQy5eHUUzwoPc54jmUiGhcGxZX4GARumFyLsFyHRLli"})
    @GET("hogares")
    Call<ListadoDeRefugios> hogares(@Query("offset") int offset);

}
