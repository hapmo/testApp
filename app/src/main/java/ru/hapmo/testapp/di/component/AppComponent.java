package ru.hapmo.testapp.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import ru.hapmo.testapp.MainActivity;
import ru.hapmo.testapp.di.module.ApiModule;
import ru.hapmo.testapp.di.module.ApplicationModule;
import ru.hapmo.testapp.viewmodels.ItemsViewModel;

@Singleton
@Component(modules = {
        ApiModule.class,
        ApplicationModule.class})

public interface AppComponent {

    Application getApplication();

    Context getContext();

    void inject(MainActivity activity);

    void inject(ItemsViewModel viewModel);
}
