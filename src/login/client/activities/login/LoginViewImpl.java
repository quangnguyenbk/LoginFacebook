package login.client.activities.login;

import java.util.Date;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.PasswordTextBox;
import com.github.gwtbootstrap.client.ui.RadioButton;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

import login.shared.User;

public class LoginViewImpl extends Composite implements LoginView {

	private static LoginViewImplUiBinder uiBinder = GWT.create(LoginViewImplUiBinder.class);
	interface LoginViewImplUiBinder extends UiBinder<Widget, LoginViewImpl> {
	}
	private Presenter presenter;
	private String sex;
	private String dateString;
	@UiField TextBox firstName;
	@UiField TextBox lastName;
	@UiField TextBox contact;
	@UiField TextBox password;
	@UiField DateBox dateBirth;
	@UiField RadioButton femaleRadioButton;
	@UiField RadioButton maleRadioButton;
	@UiField RadioButton gayRadioButton;
	@UiField Button signUpButton;
	@UiField Button signInButton;
	@UiField TextBox usernameLogin;
	@UiField PasswordTextBox passwordLogin;
	RadioButton[] sexs = new RadioButton[] {};
	
	public LoginViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		firstName.getElement().setPropertyString("placeholder", "Họ");
		lastName.getElement().setPropertyString("placeholder", "Tên");
		contact.getElement().setPropertyString("placeholder", "Số di động hoặc email");
		password.getElement().setPropertyString("placeholder", "Mật khẩu mới");
		signUpButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				addUser();
			}
		});
		
		// handler radio button
		sexs = new RadioButton[] {femaleRadioButton , maleRadioButton, gayRadioButton};
		for (RadioButton radioButton : sexs) {
				radioButton.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
				
				@Override
				public void onValueChange(ValueChangeEvent<Boolean> event) {
					sex = radioButton.getText();
				}
			});
		}
		
		// handler date birth
		dateBirth.getDatePicker().addValueChangeHandler(new ValueChangeHandler<Date>() {

			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				dateString = DateTimeFormat.getMediumDateFormat().format(date);
			}
			
		});
		
		//login
		signInButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				String email = usernameLogin.getText();
				String password = passwordLogin.getText();
				presenter.login(email, password);
				
			}
		});
	}

	private void addUser() {
		//TODO: them xu ly phone, mail
		String surName = this.firstName.getText();
		String lastName = this.lastName.getText();
		String phone = this.contact.getText();
		String email = this.contact.getText();
		String password = this.password.getText();
		String sex = this.sex;
		String dateString = this.dateString;
		
		User user = new User(surName, lastName, phone, email, password, dateString, sex);
		presenter.addUser(user);
		
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		
	}
	
	@Override
	public void refreshView() {
		this.firstName.setText(null);
		this.lastName.setText(null);
		this.contact.setText(null);
		this.contact.setText(null);
		this.password.setText(null);
		this.password.setText(null);
		for( RadioButton button: sexs) {
			button.setChecked(false);
		}
		this.dateBirth.setValue(null);
	}
}
