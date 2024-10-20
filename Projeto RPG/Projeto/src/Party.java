package Projeto.src;
import java.util.ArrayList;
import java.util.Scanner;


public class Party {
        private ArrayList<Character> party;

        public Party() {
            party = new ArrayList<>();
        }

    public void addCHaracter(Character c){
        party.add(c);
    }

    public void Fight(Party opponent) {
        Scanner s = new Scanner(System.in);  // Scanner fora do loop
        for (int i = 0; i < party.size(); i++) {  
            System.out.println("---------");
            Character currentCharacter = party.get(i);  
            System.out.println("É a vez de " + currentCharacter.getName() + ":");
            
            // Exibir opções
            System.err.println("\u001B[34m" + "Qual método de ataque você deseja usar:" + "\u001B[0m");
            System.err.println("1) Ataque o oponente");
            System.err.println("2) Use seus poderes");
            System.err.println("3) Recupere status (Poções)");
            System.err.println("\u001B[34m" + "--------------------" + "\u001B[0m");
            
            // Mostrar status atuais do personagem
            System.out.println("Os status atuais de " + currentCharacter.getName() + " são:");
            currentCharacter.ShowStatus();
    
            // Captura da escolha do jogador
            int escolha = s.nextInt();
            switch (escolha) {
                case 1:
                    Character target = opponent.party.get(0);  
                    currentCharacter.attack(target);
                    break;
                case 2:
                    currentCharacter.usePower();
                    break;
                case 3:
                    currentCharacter.TakePotion(currentCharacter);
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }
}