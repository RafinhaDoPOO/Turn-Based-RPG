package Projeto.src.CharacterClasses;

import Projeto.src.Character;
import Projeto.src.Party;
import java.util.Scanner;

public class Martial extends Character {
    public Martial(String name) {
        super(name, 1000, 120, 50, 200, 0); 
    }

    public void usePower(Party opponent, Party allies, Scanner scanner) {
        System.out.println("\u001B[32m" + "Qual poder você deseja utilizar?" + "\u001B[0m");
 System.out.println("1. Ataque Duplo (ataca dois inimigos)");
        System.out.println("2. Ataque Critico (aumenta o ataque e ataca um inimigo)");

        int choose = scanner.nextInt();

        switch (choose) {
            case 1:
                System.out.println(this.getName() + " usou Ataque Duplo!");
                if (this.getMG() >= 40) {
                    this.setMG(this.getMG() - 40);
                    Character target1 = opponent.chooseTarget(opponent);
                    Character target2 = opponent.chooseTarget(opponent);
                    int damage = this.getAD(); // Normal attack damage
                    target1.setLife(target1.getLife() - damage);
                    target2.setLife(target2.getLife() - damage);
                    System.out.println(target1.getName() + " e " + target2.getName() + " receberam " + damage + " de dano!");
                } else {
                    System.out.println("Você não possui mana suficiente.");
                }
                break;

            case 2:
                System.out.println(this.getName() + " usou Ataque Critico!");
                if (this.getMG() >= 60) {
                    this.setMG(this.getMG() - 60);
                    Character target = opponent.chooseTarget(opponent);
                    int critDamage = this.getAD() + 50; // Critical attack damage
                    target.setLife(target.getLife() - critDamage);
                    System.out.println(target.getName() + " recebeu " + critDamage + " de dano critico!");
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