package twisk.vues;

import javafx.scene.control.Label;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class VueActiviteIG extends VueEtapeIG implements  Observateur{
    Label label;
    public VueActiviteIG(MondeIG monde, EtapeIG etape) {
        super(monde, etape);
    }
    public void reagir(){}
}
