package twisk.vues;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import twisk.mondeIG.MondeIG;

import java.util.Optional;


public class VueMenu extends MenuBar implements Observateur {
    private MondeIG monde;
    private MenuBar menuBar;
    private MenuItem renommer;
    private MenuItem temps;
    private MenuItem ecartTemps;
    public VueMenu(MondeIG monde){
        super();
        this.monde = monde;
        // Create MenuBar
        this.menuBar = new MenuBar();
        // Create menus
        Menu fichier = new Menu("Fichier");
        Menu edition = new Menu("Edition");
        Menu menuMonde = new Menu("Monde");
        Menu param = new Menu("Paramètres");
        menuBar.getMenus().addAll(fichier,edition,menuMonde,param);

        // Create MenuItems
        //Items menu fichier
        MenuItem quitter = new MenuItem("Quitter");
        //Items menu edition
        MenuItem supprimer = new MenuItem("Supprimer");
        this.renommer = new MenuItem("Renommer la sélection");
        MenuItem effacer = new MenuItem("Effacer la sélection");
        //Items menuMonde
        MenuItem entree = new MenuItem("Entrée");
        MenuItem sortie = new MenuItem("Sortie");
        //Items menu param
        this.temps = new MenuItem("Changer le temps");
        this.ecartTemps = new MenuItem("Changer l'écart-temps");
        //Conditions sur les items
        System.out.println(this.monde.getNbEtapesSelect());
        if (this.monde.getNbEtapesSelect() == 1){
            this.renommer.setDisable(false);
            this.temps.setDisable(false);
            this.ecartTemps.setDisable(false);
        }
        else{
            this.renommer.setDisable(true);
            this.temps.setDisable(true);
            this.ecartTemps.setDisable(true);
        }
        //Ecouteurs clics sur les items
        quitter.setOnAction(new EcouteurQuitter());
        supprimer.setOnAction(new EcouteurSupprimer(this.monde));
        this.renommer.setOnAction(new EcouteurRenommer(monde));
        effacer.setOnAction(new EcouteurEffacer(monde));
        entree.setOnAction(new EcouteurEntree(monde));
        sortie.setOnAction(new EcouteurSortie(monde));
        this.ecartTemps.setOnAction(new EcouteurEcart(monde));
        this.temps.setOnAction(new EcouteurTemps(monde));

        // Add menuItems to the Menus
        fichier.getItems().addAll(quitter);
        edition.getItems().addAll(supprimer,this.renommer,effacer);
        menuMonde.getItems().addAll(entree,sortie);
        param.getItems().addAll(this.ecartTemps,this.temps);
        this.monde.ajouterObservateur(this);
    }
    public MenuBar getMenuBar(){
        return this.menuBar;
    }

    @Override
    public void reagir() {
        if (this.monde.getNbEtapesSelect() == 1){
            this.renommer.setDisable(false);
            this.temps.setDisable(false);
            this.ecartTemps.setDisable(false);
        }
        else{
            this.renommer.setDisable(true);
            this.temps.setDisable(true);
            this.ecartTemps.setDisable(true);
        }
    }
}
