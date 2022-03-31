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
    public VueMenu(MondeIG monde){
        super();
        this.monde = monde;
        // Create MenuBar
        this.menuBar = new MenuBar();
        // Create menus
        Menu fichier = new Menu("Fichier");
        Menu edition = new Menu("Edition");
        menuBar.getMenus().addAll(fichier,edition);

        // Create MenuItems
        MenuItem quitter = new MenuItem("Quitter");
        MenuItem supprimer = new MenuItem("Supprimer");
        MenuItem renommer = new MenuItem("Renommer la sélection");
        quitter.setOnAction(new EcouteurQuitter());
        supprimer.setOnAction(new EcouteurSupprimer(this.monde));
        renommer.setOnAction(new EcouteurRenommer(monde));
        this.reagir();

        // Add menuItems to the Menus
        fichier.getItems().addAll(quitter);
        edition.getItems().addAll(supprimer,renommer);
    }
    public MenuBar getMenuBar(){
        return this.menuBar;
    }

    @Override
    public void reagir() {
    }
}
