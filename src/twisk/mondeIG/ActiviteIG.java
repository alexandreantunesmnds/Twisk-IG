package twisk.mondeIG;

import twisk.outils.TailleComposants;

import java.util.ArrayList;
import java.util.Iterator;

public class ActiviteIG extends EtapeIG {
    public ActiviteIG(String nom, String idf, int larg, int haut){
        super(nom,idf,larg,haut);
        this.pcList = new ArrayList<>(4);
        this.pcList.add(new PointDeControleIG(this.getPosX()+larg/2,this.getPosY()-(int) TailleComposants.getInstance().getCircleSize(),"id1",this));
        this.pcList.add(new PointDeControleIG(this.getPosX()+larg/2,this.getPosY()+this.getHaut()*3/2,"id2",this));
        this.pcList.add(new PointDeControleIG(this.getPosX()-(int) TailleComposants.getInstance().getCircleSize()*2,this.getPosY()+haut/2,"id3",this));
        this.pcList.add(new PointDeControleIG(this.getPosX()+larg,this.getPosY()+haut/2,"id4",this));
    }

    @Override
    public Iterator<PointDeControleIG> iterator() {
        return this.pcList.iterator();
    }

    public String getNom(){
        return this.nom;
    }
    public String getId(){
        return this.identifiant;
    }
    public int getPosX(){
        return this.posX;
    }
    public int getPosY(){
        return this.posY;
    }
    public int getLarg(){
        return this.largeur;
    }
    public int getHaut(){
        return this.hauteur;
    }

    @Override
    public void etapeSelect() {
        this.selected = 1;
    }
    public void etapeDeSelect(){
        this.selected = -1;
    }
    public int getSelected(){
        return this.selected;
    }
    public void setPosX(int posX){
        this.posX = posX;
    }
    public void setPosY(int posY){
        this.posY = posY;
    }
    public ArrayList <PointDeControleIG> getPoint(){
        return this.pcList;
    }
}
