package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import twisk.mondeIG.MondeIG;

import java.util.Optional;

public class EcouteurRenommer implements EventHandler<ActionEvent> {
    private MondeIG monde;
    public EcouteurRenommer(MondeIG monde){
        this.monde = monde;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog("Zoo");

        dialog.setTitle("Renommer l'activité");
        dialog.setHeaderText("Nom de l'activité choisi:");
        dialog.setContentText("Nom:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> {
            this.monde.renommerEtape(name);
        });
    }
}
