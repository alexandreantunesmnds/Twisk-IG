package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import twisk.mondeIG.MondeIG;

import java.util.Optional;

public class EcouteurEcart implements EventHandler<ActionEvent> {
    private MondeIG monde;
    public EcouteurEcart(MondeIG monde){
        this.monde = monde;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog();

        dialog.setTitle("Modifier l'écart-temps");
        dialog.setHeaderText("Ecart-temps choisi (supérieur à 0 et inférieur au temps):");
        dialog.setContentText("Ecart-temps:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(num -> {
            this.monde.setEcart(Integer.parseInt(num));
        });
    }
}
