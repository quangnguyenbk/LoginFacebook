package login.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import login.shared.User;

@RemoteServiceRelativePath("addUser")
public interface UserService extends RemoteService {
	User addUser(User user);
	
	User getUser(String id);
	
	User login(String email, String password);
	
	User loginWithSession();
	
	String logout();
}
