package ru.hapmo.testapp;

import android.app.Application;

import ru.hapmo.testapp.di.component.AppComponent;
import ru.hapmo.testapp.di.component.DaggerAppComponent;
import ru.hapmo.testapp.di.module.ApiModule;
import ru.hapmo.testapp.di.module.ApplicationModule;

public class MainApplication extends Application {

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initInjector();
    }

    private void initInjector() {
        ApplicationModule applicationModule = new ApplicationModule(this);
        ApiModule apiModule = new ApiModule();
        appComponent = DaggerAppComponent.builder()
                .applicationModule(applicationModule)
                .apiModule(apiModule)
                .build();
    }

}
