package ru.hapmo.testapp.api;

import retrofit2.http.GET;
import ru.hapmo.testapp.models.ItemsResponse;
import rx.Observable;

public interface WebApi {

    @GET("v1/search-items")
    Observable<ItemsResponse> searchItems();

}
