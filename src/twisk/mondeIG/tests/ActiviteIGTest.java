package twisk.mondeIG.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twisk.mondeIG.ActiviteIG;
import twisk.outils.FabriqueIdentifiant;

import static org.junit.jupiter.api.Assertions.*;

class ActiviteIGTest {
    ActiviteIG act;
    ActiviteIG act2;
    @BeforeEach
    void setUp() {
        String id = FabriqueIdentifiant.getInstance().getIdentifiantEtape();
        String id2 = FabriqueIdentifiant.getInstance().getIdentifiantEtape();
        this.act = new ActiviteIG("Dessin",id,10,10,3,4);
        this.act2 = new ActiviteIG("Danse",id2,20,40,1,2);
    }

    @Test
    void getNom() {
        assertEquals(this.act.getNom(),"Dessin");
        assertEquals(this.act2.getNom(),"Danse");
    }

    @Test
    void getId() {
        assertEquals(this.act.getId(),"1");
        assertEquals(this.act2.getId(),"2");
    }

    @Test
    void getPosX() {
        assertTrue(this.act.getPosX()>100);
        assertTrue(this.act.getPosX()<600);
        assertTrue(this.act2.getPosX()>100);
        assertTrue(this.act2.getPosX()<600);
        assertTrue(this.act.getPosX() != this.act2.getPosX());
    }

    @Test
    void getPosY() {
        assertTrue(this.act.getPosY()>100);
        assertTrue(this.act.getPosY()<600);
        assertTrue(this.act2.getPosY()>100);
        assertTrue(this.act2.getPosY()<600);
        assertTrue(this.act.getPosY() != this.act2.getPosY());
    }

    @Test
    void getLarg() {
        assertEquals(this.act.getLarg(),10);
        assertEquals(this.act2.getLarg(),20);
    }

    @Test
    void getHaut() {
        assertEquals(this.act.getHaut(),10);
        assertEquals(this.act2.getHaut(),40);
    }

    @Test
    void getTemps() {
        assertEquals(this.act.getTemps(),4);
        assertEquals(this.act2.getTemps(),2);
    }

    @Test
    void getEcartTemps() {
        assertEquals(this.act.getEcartTemps(),3);
        assertEquals(this.act2.getEcartTemps(),1);
    }

    @Test
    void getEstUneEntree() {
        this.act.setEstUneEntree(1);
        this.act2.setEstUneEntree(0);
        assertEquals(this.act.getEstUneEntree(),1);
        assertEquals(this.act2.getEstUneEntree(),0);
    }
}