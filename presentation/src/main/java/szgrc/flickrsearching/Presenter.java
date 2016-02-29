package szgrc.flickrsearching;

/**
 * Created by gonzalofernandez on 28/2/16.
 */
public interface Presenter {

    /***
     * Method that control the lifecycle of the view. Activity/Fragment own's methods.
     */

    void resume();

    void pause();

    void destroy();
}
