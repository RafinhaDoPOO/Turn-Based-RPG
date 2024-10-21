package Projeto.src;
import java.util.ArrayList;
import java.util.Scanner;


public class Party {
        public ArrayList<Character> party;

        public Party() {
            party = new ArrayList<>();
        }

    public void addCHaracter(Character c){
        party.add(c);
    }
    
    public Character chooseTarget(Party op) {
        Scanner s = new Scanner(System.in);
        System.out.println("Escolha o alvo:");
    
        // Exibe os membros da party para o jogador choose
        for (int i = 0; i < party.size(); i++) {
            System.out.println((i + 1) + ") " + party.get(i).getName() + " (HP: " + party.get(i).getLife() + ")");
        }
    
        // Captura a escolha do usuário
        int escolha = s.nextInt() - 1;
    
        // Verifica se a escolha é válida
        if (escolha >= 0 && escolha < party.size()) {
            return party.get(escolha);  // Retorna o alvo escolhido
        } else {
            System.out.println("Escolha inválida, atacando o primeiro alvo.");
            return party.get(0);  // Default para o primeiro alvo caso a escolha seja inválida
        }
    }
    public void Fight(Party opponent) {
        Scanner s = new Scanner(System.in);  
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
    
            //  Escolha do jogador
            int choose = s.nextInt();
            switch (choose) {
                case 1:
                    Character target = chooseTarget(opponent);  // Novo método para selecionar alvo
                    currentCharacter.attack(target);
                    break;
                case 2:
                    currentCharacter.usePower(opponent, this);  // Corrigir passando `this` para indicar a própria party
                    break;
                case 3:
                    currentCharacter.TakePotion(currentCharacter);
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
        s.close();
    }
}