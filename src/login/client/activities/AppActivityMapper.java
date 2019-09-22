package login.client.activities;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import login.client.ClientFactory;
import login.client.activities.login.LoginActivity;
import login.client.activities.login.LoginPlace;
import login.client.activities.profile.ProfileActivity;
import login.client.activities.profile.ProfilePlace;

public class AppActivityMapper implements ActivityMapper {
    private ClientFactory clientFactory;

    public AppActivityMapper(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof LoginPlace)
            return new LoginActivity((LoginPlace) place, clientFactory);
        else if (place instanceof ProfilePlace)
            return new ProfileActivity((ProfilePlace) place, clientFactory);
        return null;
	}
}