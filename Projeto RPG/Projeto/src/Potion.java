package Projeto.src;

public class Potion {
    private String name;
    private String desc;
    private int Pmg;
    private int Plife;

    public Potion(String name, String desc, int pmg, int plife) {
        this.name = name;
        this.desc = desc;
        Pmg = pmg;
        Plife = plife;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPmg() {
        return Pmg;
    }

    public void setPmg(int pmg) {
        Pmg = pmg;
    }

    public int getPlife() {
        return Plife;
    }

    public void setPlife(int plife) {
        Plife = plife;
    }

}
