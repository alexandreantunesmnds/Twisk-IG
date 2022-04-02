package twisk.mondeIG;

import javafx.scene.shape.Arc;
import twisk.exceptions.TwiskException;
import twisk.outils.FabriqueIdentifiant;
import twisk.outils.TailleComposants;
import twisk.vues.Observateur;
import twisk.vues.VueArcIG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class MondeIG extends SujetObserve implements Iterable<EtapeIG>{
    private HashMap<String, EtapeIG> tableEtape = new HashMap<>(10) ;
    private ArrayList<ArcIG> arcList = new ArrayList<>(10);
    private PointDeControleIG point;
    private EtapeIG etape;
    private ArrayList<EtapeIG> etapes = new ArrayList<>(10); //étapes selectionnées
    private ArcIG arc;
    private ArrayList<ArcIG> arcs = new ArrayList<>(10); //arcs selectionnées
    private int relier = 0;

    public MondeIG(){
        this.ajouter("Activité");
    }
    public void ajouter(String type) {
        if (type.equals("Activité")) {
            String id = FabriqueIdentifiant.getInstance().getIdentifiantEtape();
            int larg = TailleComposants.getInstance().getLargBox();
            int haut = TailleComposants.getInstance().getHautBox();
            switch (id) {
                case "1":
                    EtapeIG act1 = new ActiviteIG("Piscine", id, larg, haut, 4, 6);
                    tableEtape.put(id, act1);
                    break;
                case "2":
                    EtapeIG act2 = new ActiviteIG("Toboggan", id, larg, haut,2,3);
                    tableEtape.put(id, act2);
                    break;
                case "3":
                    EtapeIG act3 = new ActiviteIG("Spa", id, larg, haut,3,4);
                    tableEtape.put(id, act3);
                    break;
                case "4":
                    EtapeIG act4 = new ActiviteIG("Boutique", id, larg, haut,1,2);
                    tableEtape.put(id, act4);
                    break;
                case "5":
                    EtapeIG act5 = new ActiviteIG("Restaurant", id, larg, haut,2,3);
                    tableEtape.put(id, act5);
                    break;
                default:
                    EtapeIG actDef = new ActiviteIG("Etape "+ id,id,larg,haut,3,4);
                    tableEtape.put(id, actDef);
                    break;
            }
            this.notifierObservateurs();
        }
    }

    @Override
    public Iterator<EtapeIG> iterator() {
        return tableEtape.values().iterator();
    }
    public Iterable<ArcIG> iteratorArc() {
        return arcList;
    }
    public int getSize(){
        return tableEtape.size();
    }
    public void ajouter(PointDeControleIG pt1, PointDeControleIG pt2) throws TwiskException {
        if (Objects.equals(pt1.getNomEtape(), pt2.getNomEtape())) {
            throw(new TwiskException("\nAjout de l'arc impossible : vous essayez de relier une étape à elle même\n"));
        }
        else{
            for (ArcIG arc : this.iteratorArc() ) {
                if (Objects.equals(arc.getPoint2().getNomEtape(), pt2.getNomEtape())){
                    throw(new TwiskException("\nAjout de l'arc impossible : vous essayez de relier 2 fois une étape\n"));
                }
            }
            this.arcList.add(new ArcIG(pt1, pt2));
            //quand l'arc est ajouté on informe que les deux points sont reliés
            this.relier = 1;
            this.point = null;
            notifierObservateurs();
        }
    }
    //les conditions à ajouter pour la validité des arcs : une etape ne peut être reliée que par un arc(ou aucun) avec une autre étape ; un point de controle doit relié un autre point de controle (+ d'une autre étape)
    public void selectionPoint(PointDeControleIG point) throws TwiskException {
        for (ArcIG arc : this.iteratorArc() ) {
            if (arc.getPoint1() == point || arc.getPoint2() == point){
                return;
            }
        }
        if (this.point != null && this.relier == 0){//si le point est initialisé et si la liaison est possible alors on peut ajouter l'arc
            ajouter(this.point,point);
        }
        else{
            this.point = point;
            this.relier = 0;
        }
    }
    public int getNbEtapesSelect(){
        return this.etapes.size();
    }
    public void selectionEtapes(EtapeIG etape) {
        if (this.etape != null && this.etape.equals(etape)) {
            this.etape.etapeDeSelect();
            this.etapes.remove(this.etape);
        } else {
            this.etape = etape;
            this.etape.etapeSelect();
            this.etapes.add(etape);
        }
        notifierObservateurs();
    }

    public void supprimerEtapes(){
        if (this.etapes.size() > 0) {
            for (EtapeIG etapes : this.etapes) {
                if (etapes.getSelected() == 1) {
                    this.tableEtape.remove(etapes.getId());
                    if (this.arcList.size() != 0) {
                        this.arcList.removeIf(arc -> arc.getPoint1().getNomEtape().equals(etapes.getNom()) || arc.getPoint2().getNomEtape().equals(etapes.getNom()));
                        for (ArcIG arc : this.iteratorArc()) {
                            if (arc.getPoint1().getNomEtape().equals(etapes.getNom())) {
                                this.arcList.remove(arc);
                            }
                        }
                    }
                }
            }
            this.etapes.clear();
        }
        notifierObservateurs();
    }
    public void renommerEtape(String nom){
        if(this.etapes != null && this.etapes.size() == 1) {
            this.etape.nom = nom;
        }
        this.etapes.clear();
        notifierObservateurs();
    }
    public HashMap<String, EtapeIG> getHash(){
        return this.tableEtape;
    }
    public void positionEtapes(int dragEventX, int dragEventY, EtapeIG etp){
        etp.setPosX(dragEventX - (etp.getLarg())/2);
        etp.setPosY(dragEventY - (etp.getHaut())/2);

        etp.getPoint().get(0).setX(etp.getPosX()+etp.getLarg()/2);
        etp.getPoint().get(0).setY(etp.getPosY()-(int) TailleComposants.getInstance().getCircleSize());

        etp.getPoint().get(1).setX(etp.getPosX()+etp.getLarg()/2);
        etp.getPoint().get(1).setY(etp.getPosY()+etp.getHaut()*3/2);

        etp.getPoint().get(2).setX(etp.getPosX()-(int) TailleComposants.getInstance().getCircleSize()*2);
        etp.getPoint().get(2).setY(etp.getPosY()+etp.getHaut()/2);

        etp.getPoint().get(3).setX(etp.getPosX()+etp.getLarg());
        etp.getPoint().get(3).setY(etp.getPosY()+etp.getHaut()/2);
        this.notifierObservateurs();
    }
    public void selectionArcs(ArcIG arc){
        if (this.arc != null && this.arc.equals(arc)) {
            this.arc.setDeSelect();
            this.arcs.remove(this.arc);
        }
        else {
            this.arc = arc;
            arc.setSelected();
            this.arcs.add(arc);
        }
        notifierObservateurs();
    }
    public void supprimerArcs() {
        if (this.arcs.size() > 0) {
            for (ArcIG arcs : this.arcs) {
                this.arcList.remove(arcs);
            }
            this.arcs.clear();
            notifierObservateurs();
        }
    }
    public void effacerSelect(){
        for(ArcIG arcs : this.arcs){
            arcs.setDeSelect();
        }
        for(EtapeIG etapes : this.etapes){
            etapes.etapeDeSelect();
        }
        this.etapes.clear();
        this.arcs.clear();
        notifierObservateurs();
    }
    public void selectEntree(){
        for(EtapeIG etapes : this.etapes) {
            if (etapes.getEstUneEntree() == 0) {
                etapes.setEstUneEntree(1); //on indique que l'étape est une entrée
            }
            else{ //sinon si l'étape est déjà comme une entrée alors ce n'est plus une entrée
                etapes.setEstUneEntree(0);
            }
        }
        this.notifierObservateurs();
    }
    public void selectSortie(){
        for(EtapeIG etapes : this.etapes) {
            if (etapes.getEstUneEntree() == 0) {
                etapes.setEstUneEntree(-1); //on indique que l'étape est une entrée
            }
            else{ //sinon si l'étape est déjà comme une sortie alors ce n'est plus une sortie
                etapes.setEstUneEntree(0);
            }
        }
        this.notifierObservateurs();
    }
    public void setEcart(int ecartTemps){
        this.etape.ecartTemps = ecartTemps;
    }
    public void setTemps(int temps){
        this.etape.temps = temps;
    }
}
