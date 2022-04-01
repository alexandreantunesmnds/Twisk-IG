package twisk;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import twisk.mondeIG.MondeIG;
import twisk.vues.*;

public class MainTwisk extends Application {
    MondeIG monde;
    @Override
    public void start (Stage primaryStage) {
        this.monde = new MondeIG();
        VueMenu menu = new VueMenu(this.monde);
        BorderPane root = new BorderPane() ;
        root.setStyle("-fx-background-color: #e3e4e6");
        root.setTop(menu.getMenuBar());
        root.setBottom(new VueOutils(this.monde));
        root.setCenter(new VueMondeIG(this.monde));
        primaryStage.setTitle("TwiskIG");
        primaryStage.setScene(new Scene(root, 900, 700));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
