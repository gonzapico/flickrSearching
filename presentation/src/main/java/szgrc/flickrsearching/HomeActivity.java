package szgrc.flickrsearching;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements HomeSearchView {

    HomePresenter homePresenter;
    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.fab) FloatingActionButton fab;
    @Bind(R.id.search) SearchView searchView;
    @Bind(R.id.appBarLayoutToolbar) android.support.design.widget.AppBarLayout appBarLayoutToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        homePresenter = new HomePresenter(this);

        setSupportActionBar(toolbar);

        fab.setOnClickListener(homePresenter);


        // Sets searchable configuration defined in searchable.xml for this SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(homePresenter);

    }

    @Override
    public void showToolbarSearchable() {
        searchView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideToolbarSearchable() {
        searchView.setVisibility(View.GONE);
    }

    @Override
    public void showFAB() {
        fab.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideFAB() {
        fab.setVisibility(View.GONE);
    }

    @Override
    public void showToolbar() {
        toolbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideToolbar() {
        toolbar.setVisibility(View.GONE);
    }
}
