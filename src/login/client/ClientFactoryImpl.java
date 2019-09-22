package login.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

import login.client.activities.login.LoginView;
import login.client.activities.login.LoginViewImpl;
import login.client.activities.profile.ProfileView;
import login.client.activities.profile.ProfileViewImpl;

public class ClientFactoryImpl implements ClientFactory
{
	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(eventBus);
	private static final LoginView loginView = new LoginViewImpl();
	private static final ProfileView profileView = new ProfileViewImpl();

	@Override
	public LoginView getLoginView()
	{
		loginView.refreshView();
		return loginView;
	}

	@Override
	public PlaceController getPlaceController()
	{
		return placeController;
	}

	@Override
	public ProfileView getProfileView()
	{
		return profileView;
	}

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

}
