package Projeto.src.CharacterClasses;

import Projeto.src.Character;
import Projeto.src.Party;
import java.util.Scanner;

public class Hunter extends Character {
    public Hunter(String name) {
        super(name, 1200, 80, 100, 100, 0); 
    }

    public void usePower(Party opponent, Party allies, Scanner scanner) {
        System.out.println("\u001B[32m" + "Qual poder você deseja utilizar?" + "\u001B[0m");
        System.out.println("1. Defender (recebe dano e aumenta defesa)");
        System.out.println("2. Ataque Potente (aumenta o ataque e ataca)");
        
        int choose = scanner.nextInt();

        switch (choose) {
            case 1:
                System.out.println(this.getName() + " usou Defender!");
                this.setDF(this.getDF() + 20); 
                System.out.println(this.getName() + " agora tem " + this.getDF() + " de defesa!");
                break;
                
            case 2:
                System.out.println(this.getName() + " usou Ataque Potente!");
                if (this.getMG() >= 30) {
                    this.setMG(this.getMG() - 30);
                    Character target = opponent.chooseTarget(opponent);
                    int damage = this.getAD() + 50; // Extra damage
                    target.setLife(target.getLife() - damage);
                    System.out.println(target.getName() + " recebeu " + damage + " de dano!");
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