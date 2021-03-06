package twisk.mondeIG.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.PointDeControleIG;

import static org.junit.jupiter.api.Assertions.*;

class PointDeControleIGTest {
    PointDeControleIG pc1;
    PointDeControleIG pc2;
    EtapeIG act1;
    EtapeIG act2;

    @BeforeEach
    void setUp() {
        this.act1 = new ActiviteIG("Toboggan","id1",12,12,6,3);
        this.act2 = new ActiviteIG("Zoo","id2",30,30,3,1);
        this.pc1 = new PointDeControleIG(200,300,"id1",act1);
        this.pc2 = new PointDeControleIG(400,600,"id2",act2);
    }

    @Test
    void getPosX() {
        assertEquals(this.pc1.getPosX(),200);
        assertEquals(this.pc2.getPosX(),400);
        this.pc1.setX(300);
        this.pc2.setX(500);
        assertEquals(this.pc1.getPosX(),300);
        assertEquals(this.pc2.getPosX(),500);
    }

    @Test
    void getPosY() {
        assertEquals(this.pc1.getPosY(),300);
        assertEquals(this.pc2.getPosY(),600);
        this.pc1.setY(400);
        this.pc2.setY(500);
        assertEquals(this.pc1.getPosY(),400);
        assertEquals(this.pc2.getPosY(),500);
    }

    @Test
    void getId() {
        assertEquals(this.pc1.getId(),"id1");
        assertEquals(this.pc2.getId(),"id2");
    }

    @Test
    void getNomEtape() {
        assertEquals(this.pc1.getNomEtape(),"Toboggan");
        assertEquals(this.pc2.getNomEtape(),"Zoo");
    }
}