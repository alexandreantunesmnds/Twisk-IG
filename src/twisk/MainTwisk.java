package twisk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import twisk.mondeIG.MondeIG;
import twisk.vues.VueActiviteIG;
import twisk.vues.VueEtapeIG;
import twisk.vues.VueMondeIG;
import twisk.vues.VueOutils;

public class MainTwisk extends Application {
    MondeIG monde;
    @Override
    public void start (Stage primaryStage) {
        this.monde = new MondeIG();
        BorderPane root = new BorderPane() ;
        root.setBottom(new VueOutils(this.monde));
        root.setCenter(new VueMondeIG(this.monde));
        if(this.monde.iterator().hasNext()) {
            root.setCenter(new VueActiviteIG(this.monde, this.monde.iterator().next()));
        }
        primaryStage.setTitle("TwiskIG");
        primaryStage.setScene(new Scene(root, 900, 700));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}