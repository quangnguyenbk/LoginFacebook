package login.client.activities.profile;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import login.client.ClientFactory;
import login.client.UserService;
import login.client.UserServiceAsync;
import login.client.activities.login.LoginPlace;
import login.shared.User;

public class ProfileActivity extends AbstractActivity implements ProfileView.Presenter{
	private login.client.ClientFactory clientFactory;
	private static UserServiceAsync userSvc = GWT.create(UserService.class);
	private String userId;
	private User user;
	public ProfileActivity(ProfilePlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		this.userId = place.getToken();
		this.user = place.getUser();
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		ProfileView profileView = clientFactory.getProfileView();
		profileView.setPresenter(this);
		profileView.setUser(this.user);
		containerWidget.setWidget(profileView.asWidget());
//		AsyncCallback<User> callback = new AsyncCallback<User>() {
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//			}
//			@Override
//			public void onSuccess(User result) {
//				if (result !=null) {
//					profileView.setUser(result);
//					containerWidget.setWidget(profileView.asWidget());
//				}
//				else goTo(new LoginPlace(""));
//			}
//		};
//		userSvc.getUser(userId, callback);
	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
		
	}

	@Override
	public void logout() {
		AsyncCallback<String> callback = new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(String result) {
				goTo(new LoginPlace(""));
			}
		};
		userSvc.logout( callback);
		
	}
}
