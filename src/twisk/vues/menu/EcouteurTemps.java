package twisk.vues.menu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import twisk.exceptions.TwiskException;
import twisk.mondeIG.MondeIG;

import java.util.Optional;

public class EcouteurTemps implements EventHandler<ActionEvent> {
    private MondeIG monde;
    public EcouteurTemps(MondeIG monde){
        this.monde = monde;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog();

        dialog.setTitle("Modifier le temps");
        dialog.setHeaderText("Temps choisi (supérieur à 0 et supérieur au temps):");
        dialog.setContentText("Temps:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(num -> {
            try {
                this.monde.setTemps(Integer.parseInt(num));
            } catch (TwiskException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur choix du temps !");

                alert.setHeaderText("Veuillez choisir une valeur d'écart-temps inférieure au temps et supérieure à 0 ! ");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        });

    }
}
