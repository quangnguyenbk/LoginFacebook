package login.client.activities.login;

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
import login.client.activities.profile.ProfilePlace;
import login.shared.User;

public class LoginActivity extends AbstractActivity implements LoginView.Presenter {
	private ClientFactory clientFactory;
	private static UserServiceAsync userSvc = GWT.create(UserService.class);
	public LoginActivity(LoginPlace place, ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		LoginView loginView = clientFactory.getLoginView();
		loginView.setPresenter(this);
		AsyncCallback<User> callback = new AsyncCallback<User>() {	
			@Override
			public void onSuccess(User result) {
				if ( result != null) {
					goTo(new ProfilePlace("test", result));
				}
				else panel.setWidget(loginView.asWidget());
			}
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
					
			}
		};
		userSvc.loginWithSession(callback);
	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
		
	}

	@Override
	public User addUser(User user) {
		AsyncCallback<User> callback = new AsyncCallback<User>() {
			
			@Override
			public void onSuccess(User result) {
				if ( result != null) {
					goTo(new ProfilePlace("test", result));
				}
				else Window.alert("Dang ky that bai");
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		};
		userSvc.addUser(user, callback);
		return null;
	}

	@Override
	public void login(String email, String password) {
		if (email != null && password != null) {
			AsyncCallback<User> callback = new AsyncCallback<User>() {
				
				@Override
				public void onSuccess(User result) {
					if ( result != null) {
						goTo(new ProfilePlace("test", result));
					}
					else Window.alert("Tên đăng nhập hoặc mật khẩu không đúng");
				}
				
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}
			};
			userSvc.login(email, password, callback);
		}
		
	}

}
