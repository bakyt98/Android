package kz.mobile.listapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {

    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos();

    @GET("/users/9")
    Call<User> getUser();

    @GET("/photos")
    Call<List<RetroPhoto>> findPhotos(
            @Query("title") String title
    );

}