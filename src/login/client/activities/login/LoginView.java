package login.client.activities.login;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

import login.client.activities.basic.BasicView;
import login.shared.User;

public interface LoginView extends IsWidget {
    void setPresenter(Presenter presenter);
    void refreshView();
    public interface Presenter {
        void goTo(Place place);
        User addUser(User user);
        void login(String email, String password);
    }
}