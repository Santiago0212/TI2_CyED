package control;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;
import model.AVLTree;

public class PrincipalMenu<K extends Comparable<K>, V> {

    @FXML
    private Button autoGenerateDataBTN;

    @FXML
    private Button addDataBTN;

    @FXML
    private Button searchBTN;

    @FXML
    private TextField numDataAutoGeneTF;
    
    
    private AVLTree<K, V> nameData;
    
    public PrincipalMenu(AVLTree<K, V> nameData) {
    	this.nameData = nameData;
    }

    @FXML
    void addData(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/AddWindow.fxml"));
		loader.setController(new AddWindow());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setTitle("AVL Tree Search");
		stage.setScene(scene);
		stage.show();
		
		Stage stage1 = (Stage) addDataBTN.getScene().getWindow();
	    stage1.close();
    }

    @FXML
    void autoGenerate(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/AutoGenerateDataWindow.fxml"));
		loader.setController(new AutoGenerateDataWindow());
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setTitle("AVL Tree Search");
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void search(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/SearchWindow.fxml"));
		loader.setController(new SearchWindow<K, V>(this.nameData));
		Parent parent = (Parent) loader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setTitle("AVL Tree Search");
		stage.setScene(scene);
		stage.show();
		
		Stage stage1 = (Stage) searchBTN.getScene().getWindow();
	    stage1.close();
    }

}