package twisk.vues;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import twisk.mondeIG.MondeIG;


public class VueMenu extends MenuBar {
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
        quitter.setOnAction(new EcouteurQuitter());

        // Add menuItems to the Menus
        fichier.getItems().addAll(quitter);
        edition.getItems().addAll(supprimer);
    }
    public MenuBar getMenuBar(){
        return this.menuBar;
    }
}
