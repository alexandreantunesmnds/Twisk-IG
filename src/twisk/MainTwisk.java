package twisk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import twisk.mondeIG.MondeIG;
import twisk.vues.VueOutils;

public class MainTwisk extends Application {
    MondeIG monde;
    @Override
    public void start (Stage primaryStage) {
        this.monde = new MondeIG();
        BorderPane root = new BorderPane() ;
        root.setBottom(new VueOutils(this.monde));
        primaryStage.setTitle("TwiskIG");
        primaryStage.setScene(new Scene(root, 900, 700));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
