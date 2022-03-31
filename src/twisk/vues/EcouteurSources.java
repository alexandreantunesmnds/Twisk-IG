package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import jdk.jfr.Label;
import twisk.mondeIG.EtapeIG;

public class EcouteurSources implements EventHandler<MouseEvent> {
    private EtapeIG etape;
    private HBox box;
    public EcouteurSources(HBox box){
        this.box = box;
    }

    @Override
    public void handle(MouseEvent t) {
        System.out.println("DnD detecté.");
        Circle circle = new Circle();
        final Dragboard dragBroard = this.box.startDragAndDrop(TransferMode.COPY);
        // Remlissage du contenu.
        final ClipboardContent content = new ClipboardContent();
        // Exporter en tant que texte.
        content.putString("Un rectangle rouge.");
        //
        dragBroard.setContent(content);
        t.consume();
    }
}
