package Projeto.src.CharacterClasses;

import Projeto.src.Character;
import Projeto.src.Party;
import java.util.Scanner;

public class Priest extends Character {
    public Priest(String name) {
        super(name, 800, 50, 30, 300, 0); 
    }

    public void usePower(Party opponent, Party allies, Scanner scanner) {
        System.out.println("\u001B[32m" + "Qual poder você deseja utilizar?" + "\u001B[0m");
        System.out.println("1. Cura (recupera vida de todos os aliados)");
        System.out.println("2. Debuff (reduz ataque de um inimigo)");

        int choose = scanner.nextInt();

        switch (choose) {
            case 1:
                System.out.println(this.getName() + " usou Cura!");
                if (this.getMG() >= 50) {
                    this.setMG(this.getMG() - 50);
                    for (Character ally : allies.party) {
                        ally.setLife(ally.getLife() + 40); // Heal 40 life points
                        System.out.println(ally.getName() + " recuperou 40 de vida!");
                    }
                } else {
                    System.out.println("Você não possui mana suficiente.");
                }
                break;

            case 2:
                System.out.println(this.getName() + " usou Debuff!");
                if (this.getMG() >= 30) {
                    this.setMG(this.getMG() - 30);
                    Character target = opponent.chooseTarget(opponent);
                    target.setAD(target.getAD() - 20); // Reduce target's attack
                    System.out.println(target.getName() + " teve seu ataque reduzido em 20!");
                } else {
                    System.out.println("Você não possui mana suficiente.");
                }
                break;

            default:
                System.out.println("Escolha inválida.");
                break;
        }
    }
}