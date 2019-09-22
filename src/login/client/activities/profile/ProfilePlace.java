package login.client.activities.profile;

import com.google.gwt.place.shared.PlaceTokenizer;

import login.shared.User;

import com.google.gwt.place.shared.Place;
public class ProfilePlace extends Place{
	private String token;
	private User user;
	
	public ProfilePlace(String token) {
        this.token = token;
    }

    public ProfilePlace(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }
    public User getUser() {
        return user;
    }
    public static class Tokenizer implements PlaceTokenizer<ProfilePlace> {
        @Override
        public String getToken(ProfilePlace place) {
            return place.getToken();
        }

        @Override
        public ProfilePlace getPlace(String token) {
            return new ProfilePlace(token);
        }
    }
}
