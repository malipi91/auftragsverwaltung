/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author marti
 */
public class Zahlungskondition {
    
    private String zk_ID;
    private String auftragsart;
    private int skontozeit_1;
    private int skontozeit_2;
    private int lieferzeit_sofort;
    private int lieferzeit_wunsch;
    private int skonto_1;
    private int skonto_2;
    private int mahnzeit_1;
    private int mahnzeit_2;
    private int mahnzeit_3;

    public Zahlungskondition(String zk_ID, String auftragsart, int skontozeit_1, int skontozeit_2, int lieferzeit_sofort, int lieferzeit_wunsch, int skonto_1, int skonto_2, int mahnzeit_1, int mahnzeit_2, int mahnzeit_3) {
        this.zk_ID = zk_ID;
        this.auftragsart = auftragsart;
        this.skontozeit_1 = skontozeit_1;
        this.skontozeit_2 = skontozeit_2;
        this.lieferzeit_sofort = lieferzeit_sofort;
        this.lieferzeit_wunsch = lieferzeit_wunsch;
        this.skonto_1 = skonto_1;
        this.skonto_2 = skonto_2;
        this.mahnzeit_1 = mahnzeit_1;
        this.mahnzeit_2 = mahnzeit_2;
        this.mahnzeit_3 = mahnzeit_3;
    }

    public Zahlungskondition() {
    }

    public String getZk_ID() {
        return zk_ID;
    }

    public void setZk_ID(String zk_ID) {
        this.zk_ID = zk_ID;
    }

    public String getAuftragsart() {
        return auftragsart;
    }

    public void setAuftragsart(String auftragsart) {
        this.auftragsart = auftragsart;
    }

    public int getSkontozeit_1() {
        return skontozeit_1;
    }

    public void setSkontozeit_1(int skontozeit_1) {
        this.skontozeit_1 = skontozeit_1;
    }

    public int getSkontozeit_2() {
        return skontozeit_2;
    }

    public void setSkontozeit_2(int skontozeit_2) {
        this.skontozeit_2 = skontozeit_2;
    }

    public int getLieferzeit_sofort() {
        return lieferzeit_sofort;
    }

    public void setLieferzeit_sofort(int lieferzeit_sofort) {
        this.lieferzeit_sofort = lieferzeit_sofort;
    }

    public int getLieferzeit_wunsch() {
        return lieferzeit_wunsch;
    }

    public void setLieferzeit_wunsch(int lieferzeit_wunsch) {
        this.lieferzeit_wunsch = lieferzeit_wunsch;
    }

    public int getSkonto_1() {
        return skonto_1;
    }

    public void setSkonto_1(int skonto_1) {
        this.skonto_1 = skonto_1;
    }

    public int getSkonto_2() {
        return skonto_2;
    }

    public void setSkonto_2(int skonto_2) {
        this.skonto_2 = skonto_2;
    }

    public int getMahnzeit_1() {
        return mahnzeit_1;
    }

    public void setMahnzeit_1(int mahnzeit_1) {
        this.mahnzeit_1 = mahnzeit_1;
    }

    public int getMahnzeit_2() {
        return mahnzeit_2;
    }

    public void setMahnzeit_2(int mahnzeit_2) {
        this.mahnzeit_2 = mahnzeit_2;
    }

    public int getMahnzeit_3() {
        return mahnzeit_3;
    }

    public void setMahnzeit_3(int mahnzeit_3) {
        this.mahnzeit_3 = mahnzeit_3;
    }
    
    
}
