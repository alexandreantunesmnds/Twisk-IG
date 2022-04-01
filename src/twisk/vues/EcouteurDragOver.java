package twisk.vues;

import javafx.event.EventHandler;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class EcouteurDragOver implements EventHandler<DragEvent> {
    public EcouteurDragOver() {
    }

    @Override
    public void handle(DragEvent dragEvent) {
        Dragboard dragBroard = dragEvent.getDragboard();
        DataFormat paintFormat = DataFormat.PLAIN_TEXT;
        if (dragBroard.hasContent(paintFormat)) {
            // Indique les modes de transfert autorisés sur cette destination.
            dragEvent.acceptTransferModes(TransferMode.MOVE);

        }
    }
}
