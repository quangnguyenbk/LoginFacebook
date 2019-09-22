package login.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import login.shared.User;

public interface UserServiceAsync {
	void addUser(User user, AsyncCallback<User> callback);

	void getUser(String id, AsyncCallback<User> callback);

	void login(String email, String password, AsyncCallback<User> callback);

	void loginWithSession(AsyncCallback<User> callback);

	void logout(AsyncCallback<String> callback);
}
