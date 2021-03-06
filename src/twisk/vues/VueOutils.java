package twisk.vues;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import twisk.mondeIG.MondeIG;
import twisk.vues.ecouteurs.EcouteurBouton;

public class VueOutils extends TilePane implements Observateur{
    Button bouton;
    public VueOutils(MondeIG monde){
        super();
        this.bouton = new Button();
        Tooltip tooltip = new Tooltip("Ajouter une étape");
        Tooltip.install(bouton,tooltip);
        //Creating a graphic (image)
        Image img = new Image("twisk/ressources/images/add_button.png");
        ImageView view = new ImageView(img);
        view.setFitWidth(50);
        view.setFitHeight(50);
        this.bouton.setGraphic(view);
        this.getChildren().add(bouton);
        this.bouton.setOnAction(new EcouteurBouton(monde));
        monde.ajouterObservateur(this);
    }
    public void reagir(){

    }
}
