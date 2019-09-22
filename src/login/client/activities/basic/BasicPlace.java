package login.client.activities.basic;

import com.google.gwt.place.shared.Place;

public class BasicPlace extends Place {

	protected String token = "";
	
	public BasicPlace() {
	}
	
	public BasicPlace(String token) {
		this();
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}
//	@Prefix("basic")
//	public static class Tokenizer implements PlaceTokenizer<BasicPlace> {
//        @Override
//        public String getToken(BasicPlace place) {
//            return place.getToken();
//        }
//
//        @Override
//        public BasicPlace getPlace(String token) {
//            return new BasicPlace(token);
//        }
//    }
}
