package szgrc.flickrsearching;

import android.support.v7.widget.SearchView;
import android.view.View;

/**
 * Created by gonzalofernandez on 28/2/16.
 */
public class HomePresenter implements Presenter, View.OnClickListener, SearchView.OnQueryTextListener {

    HomeSearchView homeSearchView;

    HomePresenter(HomeSearchView view){
        this.homeSearchView = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }


    @Override
    public void onClick(View v) {
        homeSearchView.hideFAB();
        swichToolbarToSearchable();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        homeSearchView.showFAB();
        switchSearchableToToolbar();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    private void swichToolbarToSearchable(){
        homeSearchView.hideToolbar();
        homeSearchView.showToolbarSearchable();
    }

    private void switchSearchableToToolbar(){
        homeSearchView.hideToolbarSearchable();
        homeSearchView.showToolbar();
    }
}
