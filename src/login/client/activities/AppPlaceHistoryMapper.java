package login.client.activities;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

import login.client.activities.login.LoginPlace;
import login.client.activities.profile.ProfilePlace;


@WithTokenizers( { LoginPlace.Tokenizer.class, ProfilePlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}