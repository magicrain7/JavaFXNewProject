package teamProject;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Basket {  //바스켓클래스선언
	private String myid; //같은클래스 내부에만 접근가능한 문자타입 myid 변수 선언
	private int myrest; //같은클래스 내부에만 접근가능한 int타입 myrest 변수 선언
	private int myfood; //같은클래스 내부에만 접근가능한 int타입 myfood 변수 선언
	
	public int getMyrest() {  //getMyrest() 생성자 생성
		return myrest;  // return값은 myrest
	}

	public void setMyrest(int myrest) {  //setMyrest(int myrest) 생성자생성
		this.myrest = myrest;  // myrest변수를 myrest전역변수에 넣음
	}

	public int getMyfood() {  //getMyfood() 생성자생성
		return myfood;  // return값은 myfood
	}

	public void setMyfood(int myfood) {  //setMyfood(int myfood) 생성자생성
		this.myfood = myfood;  // myfood변수를 myfood전역변수에 넣음
	}

	public String getMyid() {  //getMyid() 생성자생성
		return myid;  // return값은 myid
	}

	private SimpleStringProperty custId; //같은클래스 내부에만 접근가능한 문자타입 myid 변수 선언
	private SimpleStringProperty restId;
	private SimpleIntegerProperty foodId;
	
	public Basket(String custId, String restId, int foodId) {
		this.custId = new SimpleStringProperty(custId);
		this.restId = new SimpleStringProperty(restId);
		this.foodId = new SimpleIntegerProperty(foodId);
	}

	public Basket() {
	}

	public SimpleStringProperty getCustId() {
		return custId;
	}
	public void setCustId(SimpleStringProperty custId) {
		this.custId = custId;
	}

	public SimpleStringProperty getRestId() {
		return restId;
	}

	public void setRestId(SimpleStringProperty restId) {
		this.restId = restId;
	}

	public SimpleIntegerProperty getFoodId() {
		return foodId;
	}

	public void setFoodId(SimpleIntegerProperty foodId) {
		this.foodId = foodId;
	}

	public void setMyid(String myid) {
		this.myid = myid;
		
	}
	
	

}
