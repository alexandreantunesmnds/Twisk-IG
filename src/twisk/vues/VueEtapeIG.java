package twisk.vues;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.vues.ecouteurs.EcouteurSources;

public abstract class VueEtapeIG extends VBox implements Observateur {
    protected MondeIG monde;
    protected EtapeIG etape;
    protected Label label;
    public VueEtapeIG(MondeIG monde,EtapeIG etape){
        super();
        this.monde = monde;
        this.etape = etape;
        this.label = new Label(this.etape.getNom() + " :  "+this.etape.getTemps() +" ± "+ this.etape.getEcartTemps()+ " temps");
        this.label.setStyle("-fx-text-fill: white");
        if (this.etape.getEstUneEntree() == 1) { //c'est une entrée
            Image img = new Image("twisk/ressources/images/entree.png");
            ImageView view = new ImageView(img);
            view.setFitWidth(20);
            view.setFitHeight(20);
            this.label.setGraphic(view);
        }
        else if(this.etape.getEstUneEntree()==-1){ //c'est une sortie
            Image image = new Image("twisk/ressources/images/sortie.png");
            ImageView viewSortie = new ImageView(image);
            viewSortie.setFitWidth(20);
            viewSortie.setFitHeight(20);
            this.label.setGraphic(viewSortie);
        }
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        this.setOnDragDetected(new EcouteurSources(this,this.etape));
    }
}
