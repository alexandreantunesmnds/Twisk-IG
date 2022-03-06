package twisk.vues;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import twisk.mondeIG.MondeIG;

import java.util.Collection;

public class VueOutils extends TilePane implements Observateur{
    Button bouton;
    public VueOutils(MondeIG monde){
        super();
        this.bouton = new Button();
        Tooltip tooltip = new Tooltip("Ajouter une étape");
        Tooltip.install(bouton,tooltip);
        //Creating a graphic (image)
        Image img = new Image("/twisk/ressources/images/button_add.png");
        ImageView view = new ImageView(img);
        this.bouton.setGraphic(view);
        this.getChildren().add(bouton);
        this.bouton.setOnAction(new EcouteurBouton(monde));
        monde.ajouterObservateur(this);
    }
    public void reagir(){

    }
}
