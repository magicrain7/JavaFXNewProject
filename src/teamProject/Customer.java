package teamProject;

import javafx.beans.property.SimpleStringProperty;

public class Customer {
	private SimpleStringProperty id;
	private SimpleStringProperty adress;
	private SimpleStringProperty name;
	private SimpleStringProperty phone;
	private SimpleStringProperty password;
	
	public Customer(String id, String adress,
			String name, String phone ,String password) {
		this.id = new SimpleStringProperty(id);
		this.adress = new SimpleStringProperty(adress);
		this.name = new SimpleStringProperty(name);
		this.phone = new SimpleStringProperty(phone);
		this.password = new SimpleStringProperty(password);
	}
	public Customer(String id,String password) {
		this.id = new SimpleStringProperty(id);
		this.password = new SimpleStringProperty(password);
	}
	
	public String getPassword() {
		return password.get();
	}
	public void setPassword(String password) {
		this.password.set(password);
	}
	public SimpleStringProperty passwordProperty() {
		return this.password;
	}
	public String getId() {
		return id.get();
	}
	public void setId(String id) {
		this.id.set(id);
	}
	public SimpleStringProperty idProperty() {
		return this.id;
	}
	public String getAdress() {
		return adress.get();
	}
	public void setAdress(String adress) {
		this.adress.set(adress);
	}
	public SimpleStringProperty adressProperty() {
		return this.adress;
	}
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public SimpleStringProperty nameProperty() {
		return this.name;
	}
	public String getPhone() {
		return phone.get();
	}
	public void setPhone(String phone) {
		this.phone.set(phone);
	}
	public SimpleStringProperty phoneProperty() {
		return this.phone;
	}

}
