package teamProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProjectMain extends Application{


	@Override
	public void start(Stage arg0) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml")); //login.fxml 불러와서 root에 담기
		Scene scene = new Scene(root); //root를 scene 인스턴스에 담기
		arg0.setScene(scene);  //arg0의 scene을 설정
		arg0.setTitle(" Delivery APP ");  //arg0의 타이틀이름 설정
		arg0.show();  //arg0을 보여주게하기
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
