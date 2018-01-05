package ru.hapmo.testapp.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import ru.hapmo.testapp.MainApplication;
import ru.hapmo.testapp.api.WebApi;
import ru.hapmo.testapp.models.Item;
import ru.hapmo.testapp.models.ItemsResponse;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class ItemsViewModel extends ViewModel {

    @Inject
    WebApi webApi;

    private MutableLiveData<List<Item>> items = new MutableLiveData<>();

    public LiveData<List<Item>> getItems() {
        return items;
    }

    ItemsViewModel() {
        MainApplication.getAppComponent().inject(this);
        webApi.searchItems().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ItemsResponse>() {
                    @Override
                    public void call(ItemsResponse itemsResponse) {
                        items.setValue(itemsResponse.getMessage());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
    }
}
