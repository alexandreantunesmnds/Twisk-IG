package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
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
            this.monde.setTemps(Integer.parseInt(num));
        });

    }
}
