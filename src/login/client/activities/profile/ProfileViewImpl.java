package login.client.activities.profile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import login.shared.User;

public class ProfileViewImpl extends Composite implements ProfileView{
	private Presenter presenter;
	private User user;
	private static ProfileViewImplUiBinder uiBinder = GWT.create(ProfileViewImplUiBinder.class);
	
	@UiField Button logoutButton;
	@UiField Label fullName;
	@UiField Label sex;
	@UiField Label phone;
	@UiField Label email;
	@UiField Label birthDate;
	interface ProfileViewImplUiBinder extends UiBinder<Widget, ProfileViewImpl> {
	}

	public ProfileViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		logoutButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				presenter.logout();
				
			}
		});
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		
	}
	
	public void setUser(User user) {
		if ( user != null) {
			fullName.setText(user.getSurName() +" " + user.getLastName());
			sex.setText(user.getSex());
			phone.setText(user.getPhone());
			email.setText(user.getEmail());
			birthDate.setText(user.getDateBirth());
		}
		
	}
}
