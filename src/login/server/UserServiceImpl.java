package login.server;

import static com.googlecode.objectify.ObjectifyService.ofy;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Key;

import login.client.UserService;
import login.shared.User;
import login.shared.UserSession;


public class UserServiceImpl extends CustomRemoteServiceServlet implements UserService{
	@Override
	public User addUser(User user) {
		com.googlecode.objectify.Key<User> key = ObjectifyService.ofy().save().entity(user).now();
		if (key != null) {
			createCookieAndSession(key);
			return getUser(key.getId() +"");
		}
		return null;
	}

	@Override
	public User getUser(String id) {
		User user = ObjectifyService.ofy().load().type(User.class).id(Long.parseLong(id)).now();
		if (user != null) {
			return user;
		}
		return null;
	}

	@Override
	public User login(String email, String password) {	
		com.googlecode.objectify.Key<User> key = ofy().load().type(User.class).filter("email", email).filter("password",password).keys().first().now();
		User user = ofy().load().type(User.class).filter("email", email).filter("password",password).first().now();
		if (key != null) {
			createCookieAndSession(key);
			return user;
		}
		return null;
	}
	
	@Override
	public User loginWithSession() {	
			HttpServletRequest request = this.getThreadLocalRequest();
			Cookie[] cookie = request.getCookies();
			String sessionId = null;
			if (cookie != null) {
				for(int i = 0 ; i< cookie.length; i++) {
					if(cookie[i].getName().equals("sessionId")) {
						sessionId = cookie[i].getValue();
						break;
					}
				}
			}	
			if (sessionId != null) {
				UserSession userSession = ofy().load().type(UserSession.class).filter("sessionId", sessionId).first().now();
				if ( userSession != null) {
					return getUser(userSession.getUserId());
				}
			}
			
		return null;
	}
	
	public void createCookieAndSession(com.googlecode.objectify.Key<User> key) {
		
		// create cookie and save session to cookie
		HttpServletRequest request = this.getThreadLocalRequest();
		HttpServletResponse reponse = this.getThreadLocalResponse();
		String sessionId = request.getSession().getId();
		Cookie loginCookie = new Cookie("sessionId", sessionId);
		loginCookie.setMaxAge(60*60);
		reponse.addCookie(loginCookie);
		
		// save session into database
		String keyStr = String.valueOf(key.getId());
		UserSession userSession = new UserSession(keyStr, sessionId);
		ObjectifyService.ofy().save().entity(userSession).now();
	}

	@Override
	public String logout() {
		HttpServletResponse reponse = this.getThreadLocalResponse();
		Cookie cookie = new Cookie("sessionId", "");
		cookie.setMaxAge(0);
		reponse.addCookie(cookie);
		return null;
	}
	
	public boolean isLogin(HttpServletRequest request) {
		Cookie[] cookie = request.getCookies();
		for(int i = 0 ; i< cookie.length; i++) {
			if(cookie[i].getName().equals("sessionId")) {
				return true;
			}
		}
		return false;
	}
}
