package Projeto.src.CharcterClasses;

import Projeto.src.Character;
import java.util.Scanner;

public class Human extends Character {
    public Human(String name) {
        super(name, 100, 50, 50, 50);  
    }

    public void usePower() {
        Scanner s = new Scanner(System.in); 
        System.out.println("\u001B[32m" + "Qual poder você deseja utilizar?" + "\u001B[0m");
        System.out.println("1. Oração (duplica sua mana)");
        System.out.println("2. Pacto (duplica seu ataque)");
        
        int escolha = s.nextInt(); // Captura a escolha do usuário
        
        switch (escolha) {
            case 1:
                System.out.println(this.getName() + " usou a oração!");
                this.setMG(this.getMG() * 2);  // Duplica a mana
                if (this.getMG() > 30) {
                    this.setMG(this.getMG() - 30); // Consome 30 de mana
                } else {
                    System.out.println("Você não possui mana suficiente.");
                }
                break;
                
            case 2:
                System.out.println(this.getName() + " fez o pacto!");
                this.setAD(this.getAD() * 2); // Aumenta o ataque 
                if (this.getMG() > 30) {
                    this.setMG(this.getMG() - 30); // Consome 30 de mana
                } else {
                    System.out.println("Você não possui mana suficiente.");
                }
                break;
                
            default:
                System.out.println("Escolha inválida.");
                break;
        }
        
        s.close();
    }
}