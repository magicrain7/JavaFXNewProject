package teamProject;

import javafx.beans.property.SimpleStringProperty;

public class OrderStatus {
	private SimpleStringProperty orderNumber,orderdate,id,restId;
	
	public OrderStatus(String orderNumber, String orderdate,
			String id, String restId) {
		this.orderNumber = new SimpleStringProperty(orderNumber);
		this.orderdate = new SimpleStringProperty(orderdate);
		this.id = new SimpleStringProperty(id);
		this.restId = new SimpleStringProperty(restId);
	}
}
