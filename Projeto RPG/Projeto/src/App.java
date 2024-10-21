package Projeto.src;

import Projeto.src.CharacterClasses.Mystic;
import Projeto.src.CharacterClasses.Martial;
import Projeto.src.CharacterClasses.Hunter;
import Projeto.src.CharacterClasses.Priest;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Party playerParty = new Party();
        Party enemyParty = new Party();

        // Create characters
        Mystic mystic = new Mystic("Místico");
        Martial martial = new Martial("Marcial");
        Hunter hunter = new Hunter("Gon");
        Priest priest = new Priest("Padre");

        Martial enemyMartial1 = new Martial("Inimigo Marcial 1");
        Martial enemyMartial2 = new Martial("Inimigo Marcial 2");
        Martial enemyMartial3 = new Martial("Inimigo Marcial 3");
        Martial enemyMartial4 = new Martial("Inimigo Marcial 4");

       
        playerParty.addCHaracter(mystic);
        playerParty.addCHaracter(martial);
        playerParty.addCHaracter(hunter);
        playerParty.addCHaracter(priest);
        
        enemyParty.addCHaracter(enemyMartial1);
        enemyParty.addCHaracter(enemyMartial2);
        enemyParty.addCHaracter(enemyMartial3);
        enemyParty.addCHaracter(enemyMartial4);

        // Fight loop
        while (!playerParty.party.isEmpty() && !enemyParty.party.isEmpty()) {
            // Player's turn
            System.out.println("Turno do jogador:");
            playerParty.Fight(enemyParty);

            // Check if enemy party is still alive
            if (enemyParty.party.isEmpty()) {
                System.out.println("Parabéns! Você derrotou o inimigo!");
                break;
            }

            // Enemy's turn
            System.out.println("Turno do inimigo:");
            for (Character enemy : enemyParty.party) {
                if (enemy.getLife() > 0) {
                    int action = random.nextInt(2); // Randomly choose action (0: attack, 1: use power)
                    if (action == 0) {
                        Character target = playerParty.chooseTarget(playerParty); // Choose a target from player party
                        enemy.attack(target);
                    } else {
                        enemy.usePower(enemyParty, playerParty); // Use power
                    }
                }
            }

            
            if (playerParty.party.isEmpty()) {
                System.out.println("Você foi derrotado! Tente novamente.");
                break;
            }
        }

      
        scanner.close();
    }
}