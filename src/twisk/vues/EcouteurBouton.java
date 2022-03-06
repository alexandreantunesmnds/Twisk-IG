package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.Iterator;

public class EcouteurBouton implements EventHandler<ActionEvent> {
    private MondeIG monde;
    public EcouteurBouton (MondeIG monde){
        this.monde = monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.monde.ajouter("Activité");
        for (EtapeIG etapeIG : monde) {
            System.out.println(etapeIG.getNom());
        }
        System.out.println("On ajoute une étape");

    }
}
