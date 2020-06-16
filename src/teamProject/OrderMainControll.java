package teamProject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OrderMainControll implements Initializable {
	@FXML
	Button login;
	@FXML
	Label registry;
	@FXML
	TextField id;
	@FXML
	PasswordField password;
	Database db = new Database();
	ProjectMain pm = new ProjectMain();
	ObservableList<Customer> customer = null;
	String myid;
	Basket bas = new Basket();
	int food =1;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		customer = FXCollections.observableArrayList();
		registry.setOnMouseClicked((e) -> register());


	}

	@FXML
	public void login(MouseEvent event) {
		Customer cus = new Customer(id.getText(), password.getText());
		boolean login = db.dbselect(cus);
		if (login == true) {
			this.myid = id.getText();
			Parent node = (Parent) event.getSource();
			Stage stage = (Stage) node.getScene().getWindow();
			stage.close();
//				om.ordermain(registry.getScene().getWindow());
			ordermain();

		}
	}

	public void ordermain() {

		Stage addStage = new Stage(StageStyle.UTILITY);
		addStage.initModality(Modality.WINDOW_MODAL);
		addStage.initOwner(login.getScene().getWindow());
		Parent parent;

		try {
			parent = FXMLLoader.load(getClass().getResource("OrderMain.fxml"));
			Scene scene = new Scene(parent);
			addStage.setScene(scene);
			addStage.show();
			ImageView order = (ImageView) parent.lookup("#order");
			ImageView basket = (ImageView) parent.lookup("#basket");
			ImageView mypage = (ImageView) parent.lookup("#mypage");
			order.setOnMouseClicked((e) -> {
				addStage.close();
				order(1);
			});
			basket.setOnMouseClicked((e) -> {
				addStage.close();
				order(2);
			});
			mypage.setOnMouseClicked((e) -> {
				addStage.close();
				order(3);
			});
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	private void order(int number) {
		Stage addStage = new Stage(StageStyle.UTILITY);
		addStage.initModality(Modality.WINDOW_MODAL);
		addStage.initOwner(login.getScene().getWindow());
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("MenuBorder.fxml"));
			Scene scene = new Scene(parent);
			addStage.setScene(scene);
			addStage.show();
			BorderPane bp = (BorderPane) parent.lookup("#bp");
			if (number == 1) {
				realorder(bp);
			}
			if (number == 2) {
				OrderBasket(bp,food);
			}
			if (number == 3) {
				mypage(bp);
			}
			MenuButton menuBtn = (MenuButton) parent.lookup("#menuBtn");
			menuBtn.getItems().get(0).setOnAction((e) -> {
				addStage.close();
				ordermain();
			});
			menuBtn.getItems().get(1).setOnAction((e) -> {
				realorder(bp);

			});
			menuBtn.getItems().get(2).setOnAction((e) -> {
				OrderBasket(bp,food);

			});
			menuBtn.getItems().get(3).setOnAction((e) -> {
				mypage(bp);

			});

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	private void realorder(BorderPane bp) {
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("restaurantFXML.fxml"));
			bp.setCenter(parent);
			ImageView ricecake = (ImageView) parent.lookup("#ricecake");
			ImageView chicken = (ImageView) parent.lookup("#chicken");
			ImageView pizza = (ImageView) parent.lookup("#pizza");
			ImageView china = (ImageView) parent.lookup("#zzazang");
			ImageView hamberger = (ImageView) parent.lookup("#hamburger");
			
			pizza.setOnMouseClicked((e) -> {
				pizza(bp);
			});
			china.setOnMouseClicked((e) -> {
				china(bp);
			});
			hamberger.setOnMouseClicked((e) -> {
				hamberger(bp);
			});
			ricecake.setOnMouseClicked((e) -> {
				rice(bp);
			});
			chicken.setOnMouseClicked((e) -> {
				chicken(bp);
			});

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void hamberger(BorderPane bp) {
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("OrderFXML5.fxml"));
			bp.setCenter(parent);
			RadioButton lotteria1 = (RadioButton) parent.lookup("#lotteria1");
			lotteria1.setOnAction((e) -> {
				bas.setMyid(myid);
				bas.setMyrest(5);
				bas.setMyfood(13);
			});
			
			RadioButton lotteria2 = (RadioButton) parent.lookup("#lotteria2");
			lotteria2.setOnAction((e) -> {
				bas.setMyid(myid);
			  	bas.setMyrest(5);
				bas.setMyfood(14);
			});
			
			RadioButton lotteria3 = (RadioButton) parent.lookup("#lotteria3");
			lotteria3.setOnAction((e) -> {
				bas.setMyid(myid);
				bas.setMyrest(5);
				bas.setMyfood(15);
			});
			
			Button basket = (Button) parent.lookup("#basket");
			basket.setOnAction((e) -> {
				food = db.dbbasket(bas);
				OrderBasket(bp,food);
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void china(BorderPane bp) {
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("OrderFXML4.fxml"));
			bp.setCenter(parent);
			RadioButton banjum1 = (RadioButton) parent.lookup("#banjum1");
			banjum1.setOnAction((e) -> {
				bas.setMyid(myid);
				bas.setMyrest(4);
				bas.setMyfood(10);
			});
			
			RadioButton banjum2 = (RadioButton) parent.lookup("#banjum2");
			banjum2.setOnAction((e) -> {
				bas.setMyid(myid);
			  	bas.setMyrest(4);
				bas.setMyfood(11);
			});
			
			RadioButton banjum3 = (RadioButton) parent.lookup("#banjum3");
			banjum3.setOnAction((e) -> {
				bas.setMyid(myid);
				bas.setMyrest(4);
				bas.setMyfood(12);
			});
			
			Button basket = (Button) parent.lookup("#basket");
			basket.setOnAction((e) -> {
				food = db.dbbasket(bas);
				OrderBasket(bp,food);
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 

	private void pizza(BorderPane bp) {
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("OrderFXML3.fxml"));
			bp.setCenter(parent);
			RadioButton pizzahut1 = (RadioButton) parent.lookup("#pizzahut1");
			pizzahut1.setOnAction((e) -> {
				bas.setMyid(myid);
				bas.setMyrest(3);
				bas.setMyfood(7);
			});
			
			RadioButton pizzahut2 = (RadioButton) parent.lookup("#pizzahut2");
			pizzahut2.setOnAction((e) -> {
				bas.setMyid(myid);
			  	bas.setMyrest(3);
				bas.setMyfood(8);
			});
			
			RadioButton pizzahut3 = (RadioButton) parent.lookup("#pizzahut3");
			pizzahut3.setOnAction((e) -> {
				bas.setMyid(myid);
				bas.setMyrest(3);
				bas.setMyfood(9);
			});
			
			Button basket = (Button) parent.lookup("#basket");
			basket.setOnAction((e) -> {
				food = db.dbbasket(bas);
				OrderBasket(bp,food);
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void chicken(BorderPane bp) {
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("OrderFXML2.fxml"));
			bp.setCenter(parent);
			RadioButton kyochon1 = (RadioButton) parent.lookup("#kyochon1");
			kyochon1.setOnAction((e) -> {
				bas.setMyid(myid);
				bas.setMyrest(2);
				bas.setMyfood(4);
			});
			
			RadioButton kyochon2 = (RadioButton) parent.lookup("#kyochon2");
			kyochon2.setOnAction((e) -> {
				bas.setMyid(myid);
			  	bas.setMyrest(2);
				bas.setMyfood(5);
			});
			
			RadioButton kyochon3 = (RadioButton) parent.lookup("#kyochon3");
			kyochon3.setOnAction((e) -> {
				bas.setMyid(myid);
				bas.setMyrest(2);
				bas.setMyfood(6);
			});
			
			Button basket = (Button) parent.lookup("#basket");
			basket.setOnAction((e) -> {
				food = db.dbbasket(bas);
				OrderBasket(bp,food);
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void rice(BorderPane bp) {
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("OrderFXML1.fxml"));
			bp.setCenter(parent);
			RadioButton dduck1 = (RadioButton) parent.lookup("#dduck1");
			dduck1.setOnAction((e) -> {
				bas.setMyid(myid);
				bas.setMyrest(1);
				bas.setMyfood(1);
			});
			
			RadioButton dduck2 = (RadioButton) parent.lookup("#dduck2");
			dduck2.setOnAction((e) -> {
				bas.setMyid(myid);
			  	bas.setMyrest(1);
				bas.setMyfood(2);
			});
			
			RadioButton dduck3 = (RadioButton) parent.lookup("#dduck3");
			dduck3.setOnAction((e) -> {
				bas.setMyid(myid);
				bas.setMyrest(1);
				bas.setMyfood(3);
			});
			
			Button basket = (Button) parent.lookup("#basket");
			basket.setOnAction((e) -> {
				food = db.dbbasket(bas);
				OrderBasket(bp,food);
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void OrderBasket(BorderPane bp,int food) {
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("BasketFXML.fxml"));
			bp.setCenter(parent);
			Basket bas = db.dbOrderBasket(food);
			TextField bas1 = (TextField) parent.lookup("#bas1");
			bas1.setText(bas.getCustId().get());
			
			TextField bas2 = (TextField) parent.lookup("#bas2");
			bas2.setText(bas.getRestId().get());
			
			TextField bas3 = (TextField) parent.lookup("#bas3");
			bas3.setText(String.valueOf(bas.getFoodId().get()));
			 
			Button acess = (Button) parent.lookup("#acess");
			acess.setOnAction((e)->{
				Orderstatus(bp,food);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	private void Orderstatus(BorderPane bp,int food) {
		Parent parent;
			try {
				parent = FXMLLoader.load(getClass().getResource("OrderStatusFXML.fxml"));
				bp.setCenter(parent);
				Basket bas = db.dbOrderBasket(food);
				TextField bas1 = (TextField) parent.lookup("#oder1");
				bas1.setText(bas.getCustId().get());
				
				TextField bas2 = (TextField) parent.lookup("#oder2");
				bas2.setText(bas.getRestId().get());
				
				TextField bas3 = (TextField) parent.lookup("#oder3");
				bas3.setText(String.valueOf(bas.getFoodId().get()));
				
				Button yes = (Button) parent.lookup("#yes");
				yes.setOnAction((e)->{
					ordermain();
				});
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

	private void mypage(BorderPane bp) {
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("MyinfoMain.fxml"));
			bp.setCenter(parent);
			Button bt = (Button) parent.lookup("#buttonmy");
			bt.setOnAction((e1) -> myinfo(bp));
			Button btn = (Button) parent.lookup("#mybutton");
			btn.setOnAction((e)->Orderstatus(bp,food));
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void myinfo(BorderPane bp) {
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("Myinfo.fxml"));
			bp.setCenter(parent);
			Customer cus = db.dbcustomer(myid);
			TextField infoid = (TextField) parent.lookup("#txtid");
			TextField infoname = (TextField) parent.lookup("#txtname");
			TextField infophone = (TextField) parent.lookup("#txtphone");
			PasswordField infopassword = (PasswordField) parent.lookup("#txtpassword");
			TextArea infoaddress = (TextArea) parent.lookup("#txtaddress");
			infoid.setText(cus.getId());
			infoname.setText(cus.getName());
			infophone.setText(cus.getPhone());
			infopassword.setText(cus.getPassword());
			infoaddress.setText(cus.getAdress());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	public void register() {
		Stage addStage = new Stage(StageStyle.UTILITY);
		addStage.initModality(Modality.WINDOW_MODAL);
		addStage.initOwner(login.getScene().getWindow());
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("signup.fxml"));
			Scene scene = new Scene(parent);
			addStage.setScene(scene);
			addStage.show();
			Button btnregistry = (Button) parent.lookup("#addbtn");
			btnregistry.setOnAction((e) -> {
				TextField txtId = (TextField) parent.lookup("#txtid");
				TextArea txtadress = (TextArea) parent.lookup("#txtadress");
				TextField txtname = (TextField) parent.lookup("#txtname");
				TextField txtphone = (TextField) parent.lookup("#txtphone");
				PasswordField txtpassword = (PasswordField) parent.lookup("#txtpassword");
				Customer cus = new Customer(txtId.getText(), txtadress.getText(), txtname.getText(), txtphone.getText(),
						txtpassword.getText());
				db.dbregistry(cus);
				addStage.close();
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
