package Projeto.src;

import Projeto.src.CharcterClasses.Human;

public class App {
            public static void main(String[] args) {
                Character hero = new Character("Rafael", 100, 20, 10,50);
                Character villain = new Character("Lopes", 100, 15, 8,30);
                Human human = new Human("Rafa");

                System.out.println("Nome do herói: " + hero.getName());
                System.out.println("Vida do herói: " + hero.getLife());

                Potion smallPotion = new Potion("Pequena Poção de Cura","Essa cura bem pouquinho", 20,30);
                Potion largePotion = new Potion("Grande Poção de Cura","Essa poção cura demais", 50, 30);


                human.attack(hero);
                human.usePower();
                human.ShowStatus();

                hero.addPotion(largePotion);
                villain.addPotion(smallPotion);
               /*  while(hero.getLife() > 0 || villain.getLife() >= 0){
                    villain.attack(hero);
                    hero.attack(villain);
                        System.err.println("Você deseja tomar qual Potion?");
                        hero.showPotions();
                        hero.TakePotion(hero);
                        villain.TakePotion(villain);
                }*/
            }
    }
