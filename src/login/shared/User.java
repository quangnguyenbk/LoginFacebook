package login.shared;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class User implements IsSerializable{
	@Id Long id;
	private String surName;
	private String lastName;
	private String phone;
	@Index private String email;
	@Index private String password;
	private String dateBirth;
	private String sex;
	
	
	public User() {
	}
	
	public User(String surName, String lastName, String phone, String email, String password, String dateBirth,
			String sex) {
		super();
		this.surName = surName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.dateBirth = dateBirth;
		this.sex = sex;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDateBirth() {
		return dateBirth;
	}
	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
