package twisk.vues.ecouteurs;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import twisk.exceptions.TwiskException;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class EcouteurPoint implements EventHandler<MouseEvent> {
    private MondeIG monde;
    private PointDeControleIG point;
    public EcouteurPoint (MondeIG monde, PointDeControleIG point){
        this.monde = monde;
        this.point = point;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        try {
            this.monde.selectionPoint(this.point);
        } catch (TwiskException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur choix du point de contrôle !");

            alert.setHeaderText("Veuillez choisir un autre point de contrôle !");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}
