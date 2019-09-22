package login.client.activities.profile;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

import login.shared.User;

public interface ProfileView extends IsWidget{
	void setPresenter(Presenter presenter);
	void setUser(User user);
	public interface Presenter {
        void goTo(Place place);
        void logout();
    }
}
