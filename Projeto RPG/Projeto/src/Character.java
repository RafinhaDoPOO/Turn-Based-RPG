package Projeto.src;  
import java.util.ArrayList;
import java.util.Scanner;

public class Character {
    private String name;
    private int life;
    private int ad;
    private int df;
    private int mg;
    private int lvl;
    private ArrayList<Potion> potions;

    public Character(String name, int life, int ad, int df, int mg, int lvl) {
        this.name = name;
        this.life = life;
        this.ad = ad;
        this.df = df;
        this.mg = mg;
        this.potions = new ArrayList<>();
        this.lvl = lvl;
    }

    // Métodos get e set
    public String getName() { return name; }
    public int getLife() { return life; }
    public int getAD() { return ad; }
    public int getDF() { return df; }
    public int getMG() {return mg;}
    public int getLvl() {return lvl;}

    public void setName(String name) { this.name = name; }
    public void setLife(int life) { this.life = life; }
    public void setAD(int ad) { this.ad = ad; }
    public void setDF(int df) { this.df = df; }
    public void setMG(int mg)  {this.mg = mg;}
    public void setLvl(int lvl) {this.lvl = lvl;}

    public void modifyStats(double lifePercentage, double attackPercentage, double defensePercentage, double magicPecentage, double LevelPercentage) {
        this.life = (int)(this.life * lifePercentage);
        this.ad = (int)(this.ad * attackPercentage);
        this.df = (int)(this.df * defensePercentage);
        this.mg = (int)(this.mg * magicPecentage);
        this.lvl = (int)(this.lvl * LevelPercentage);
    }

    public void addPotion(Potion potion) {
        potions.add(potion);
    }
    // Método de ataque
    public void attack(Character target) {
        int damage = this.ad - target.getDF();
        if (damage < 0) {
            damage = 0;
        }
        System.out.println(this.name + " atacou " + target.getName() + " causando " + damage + " de dano!");
        target.setLife(target.getLife() - damage);

        if (target.getLife() <= 0) {
            System.out.println(target.getName() + " deixou este mundo!");
        } else {
            System.out.println(target.getName() + " ainda tem " + target.getLife() + " de vida.");
        }
    }

    public void TakePotion(Character target){
        if (potions.size() > 0) {
            Scanner s = new Scanner(System.in);  
            System.out.println("choose a poção para usar:");
            for (int i = 0; i < potions.size(); i++) {
                System.out.println(i + ": " + potions.get(i).getName());
            }
            int choose = s.nextInt();
            if (choose >= 0 && choose < potions.size()) {
                Potion potion = potions.get(choose);
                System.out.println(target.getName() + " usou a poção: " + potion.getName());
                target.setLife(target.getLife() + potion.getPlife());
                target.setMG(target.getMG() + potion.getPmg());
    
                // Remove potion from inventory
                potions.remove(choose);
                // Display updated target stats
                System.out.println("Vida atual de " + target.getName() + ": " + target.getLife());
                System.out.println("Mana atual de " + target.getName() + ": " + target.getMG());
                s.close();
            } else {
                System.out.println("escolha inválida.");
            }
        } else {
            System.out.println("Sem poções disponíveis.");
        }
        
    }

    public void showPotions() {
        if (potions.isEmpty()) {
            System.out.println("Nenhuma poção disponível.");
        } else {
            for (int i = 0; i < potions.size(); i++) {
                System.out.println(i + ": " + potions.get(i).getName() + " (Cura: " + potions.get(i).getPlife() + potions.get(i).getPmg() +")");
            }
        }
    }
    public void LevelUP(){
        this.modifyStats(1.5, 1.12, 1.20 , 1.45, 1.0);
        System.out.println("\u001B[32m" + this.getName() +" Evoluiu de Level" + "\u001B[0m");
        this.setLvl(lvl+1);
    }
    public void ShowStatus(){
        System.err.println(this.getName() +" Vida: "+ this.getLife() + " Ataque: " + this.getAD() + " Mana: " + this.getMG() +" Defesa: " + this.getDF());
    }
    public void usePower(Party opponent, Party Allies) {
       
    }
    }


