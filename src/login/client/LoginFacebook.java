package login.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

import login.client.activities.AppActivityMapper;
import login.client.activities.AppPlaceHistoryMapper;
import login.client.activities.login.LoginPlace;
import login.client.activities.login.LoginViewImpl;
import login.client.activities.login.Test;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class LoginFacebook implements EntryPoint {
	private Place defaultPlace = new LoginPlace("login");
    private SimplePanel appWidget = new SimplePanel();
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
//		RootPanel.get().add(new Test());
		ClientFactory clientFactory = GWT.create(ClientFactory.class);
        PlaceController placeController = clientFactory.getPlaceController();
        EventBus eventBus = clientFactory.getEventBus();
        
        // Start ActivityManager for the main widget with our ActivityMapper
        ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
        activityManager.setDisplay(appWidget);

        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        AppPlaceHistoryMapper historyMapper= GWT.create(AppPlaceHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, defaultPlace);
        RootPanel.get().add(appWidget);
        // Goes to the place represented on URL else default place
        historyHandler.handleCurrentHistory();
	}
}
