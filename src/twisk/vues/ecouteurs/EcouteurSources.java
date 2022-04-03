package twisk.vues.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import jdk.jfr.Label;
import twisk.mondeIG.EtapeIG;
import twisk.vues.VueEtapeIG;

public class EcouteurSources implements EventHandler<MouseEvent> {
    private EtapeIG etape;
    private VueEtapeIG vue;
    public EcouteurSources(VueEtapeIG vue, EtapeIG etape){
        this.vue = vue;
        this.etape = etape;
    }

    @Override
    public void handle(MouseEvent t) {
        System.out.println("\nIdentifiant source : " + this.etape.getId());
        Dragboard board = this.vue.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent content = new ClipboardContent();
        this.vue.setId(this.etape.getId());
        DataFormat paintFormat = DataFormat.PLAIN_TEXT;
        content.put(paintFormat, this.etape.getId());

        final WritableImage capture = this.vue.snapshot(null, null);
        content.putImage(capture);
        board.setContent(content);
    }
}
