package login.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

import login.client.activities.login.LoginView;
import login.client.activities.profile.ProfileView;


public interface ClientFactory {
	PlaceController getPlaceController();
	ProfileView getProfileView();
	LoginView getLoginView();
	EventBus getEventBus();
}
