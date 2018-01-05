package ru.hapmo.testapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import ru.hapmo.testapp.adapters.ItemsAdapter;
import ru.hapmo.testapp.models.Item;
import ru.hapmo.testapp.viewmodels.ItemsViewModel;

public class MainActivity extends AppCompatActivity {

    private final String BUNDLE_RECYCLER_LAYOUT = "BUNDLE_RECYCLER_LAYOUT";

    private RecyclerView recyclerView;
    private ItemsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainApplication.getAppComponent().inject(this);

        setContentView(R.layout.activity_main);

        adapter = new ItemsAdapter(this);

        ItemsViewModel viewModel = ViewModelProviders.of(this).get(ItemsViewModel.class);
        viewModel.getItems().observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(@Nullable List<Item> items) {
                adapter.setList(items);
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        if (savedInstanceState != null) {
            Parcelable savedRecyclerLayoutState = savedInstanceState.getParcelable(BUNDLE_RECYCLER_LAYOUT);
            recyclerView.getLayoutManager().onRestoreInstanceState(savedRecyclerLayoutState);
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(BUNDLE_RECYCLER_LAYOUT, recyclerView.getLayoutManager().onSaveInstanceState());
    }

}
