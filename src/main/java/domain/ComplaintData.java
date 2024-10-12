package domain;

import java.util.Date;

public class ComplaintData {
    private String nor;
    private String nori;
    private Date gaur;
    private String textua;
    private boolean aurk;

    // Constructor
    public ComplaintData(String nor, String nori, Date gaur, String textua, boolean aurk) {
        this.nor = nor;
        this.nori = nori;
        this.gaur = gaur;
        this.textua = textua;
        this.aurk = aurk;
    }

    // Getters
    public String getNor() {
        return nor;
    }

    public String getNori() {
        return nori;
    }

    public Date getGaur() {
        return gaur;
    }

    public String getTextua() {
        return textua;
    }

    public boolean isAurk() {
        return aurk;
    }

    // Setters (si los necesitas)
    public void setNor(String nor) {
        this.nor = nor;
    }

    public void setNori(String nori) {
        this.nori = nori;
    }

    public void setGaur(Date gaur) {
        this.gaur = gaur;
    }

    public void setTextua(String textua) {
        this.textua = textua;
    }

    public void setAurk(boolean aurk) {
        this.aurk = aurk;
    }
}
