package twisk.vues.menu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurEntree implements EventHandler<ActionEvent> {
    MondeIG monde;
    public EcouteurEntree(MondeIG monde){
        this.monde = monde;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        this.monde.selectEntree();
    }
}
