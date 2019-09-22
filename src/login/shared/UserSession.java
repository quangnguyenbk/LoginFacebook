package login.shared;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
@Entity
public class UserSession implements IsSerializable{
	@Id Long id;
	@Index private String userId;
	@Index private String sessionId;
	
	public UserSession() {
		
	}
	public UserSession(String userId, String sessionId) {
		super();
		this.userId = userId;
		this.sessionId = sessionId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	
}
