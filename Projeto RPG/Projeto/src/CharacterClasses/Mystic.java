package Projeto.src.CharacterClasses;

import Projeto.src.Character;
import Projeto.src.Party;

import java.util.Scanner;

public class Mystic extends Character {
    public Mystic(String Name){
        super(Name,650,50,35,2000,0);
    }
    public void usePower(Party opponent, Party Allies) {
        Scanner s = new Scanner(System.in); 
        System.out.println("\u001B[32m" + "Qual poder você deseja utilizar?" + "\u001B[0m");
        System.out.println("1. Bola de fogo");
        System.out.println("2. Absorção sinistra");
        System.err.println("3. Ódio ardente");
        System.err.println("4. Relâmpago demoniaco");
        
        System.out.println("\u001B[32m" + "Poderes LVL 2:" + "\u001B[0m");
        System.out.println("5. Implosão sanguínea");
        System.out.println("6. Manipulação Infernal");
        System.err.println("7. Armagedon punk");
        System.err.println("8. Ultimate");
        

        
        int choose = s.nextInt(); 
        
        switch (choose) {
            case 1: // Ataque básico com dano e verificação de mana
                if (this.getMG() >= 30) {  
                    this.setMG(this.getMG() - 30); 
                    Character target = opponent.chooseTarget(opponent);  // Escolher alvo da outra party
                    target.setLife(target.getLife() - 50); 
                    System.out.println(target.getName() + " recebeu 50 de dano!");
                    
                    if (target.getLife() <= 0) {
                        System.out.println(target.getName() + " foi derrotado!");
                    }
                } else {
                    System.out.println("Você não possui mana suficiente.");
                }
                break;
        
            case 2: // Absorção Sinistra: Escolher alvo e absorver poder
                System.out.println(this.getName() + " usou a absorção sinistra!");
                if (this.getMG() >= 45) {
                    this.setMG(this.getMG() - 45); 
                    this.setAD(this.getAD() + 16);  // Aumenta o AD do Mystic
                    
                    // Escolher o alvo da outra party
                    Character target = opponent.chooseTarget(opponent);
                    target.setAD(target.getAD() - 8);  // Reduz o AD do alvo
                    
                    System.out.println(target.getName() + " sofreu a absorção e perdeu força!");
                } else {
                    System.out.println("Você não possui mana suficiente.");
                }
                break;
        
            case 3: // Ódio Infernal: Aumenta o AD de todos os aliados
                System.out.println(this.getName() + " usou o ódio infernal!");
                if (this.getMG() >= 45) {
                    this.setMG(this.getMG() - 45); 
                    this.setLife(this.getLife() - 30);  // Custo de vida
                    
                    // Aumenta o AD de todos os aliados
                    for (Character ally : Allies.party) {
                        ally.setAD(ally.getAD() * 2);
                        System.out.println(ally.getName() + " teve o AD dobrado!");
                    }
                } else {
                    System.out.println("Você não possui mana suficiente.");
                }
                break;
        
            case 4: // Relâmpago Demoníaco: Ataque de alto dano em um alvo escolhido
                System.out.println(this.getName() + " usou o relâmpago demoníaco!");
                if (this.getMG() >= 50) {
                    this.setMG(this.getMG() - 55); 
                    
                    // Escolher o alvo da outra party
                    Character target = opponent.chooseTarget(opponent);
                    target.setLife(target.getLife() - 62);  // Dano ao alvo
                    
                    System.out.println("Invocação máxima utilizada. " + target.getName() + " recebeu 62 de dano!");
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