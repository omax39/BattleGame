package com.marlboro;

import java.util.Scanner;

public class Battle {
    private int stage;
    private Hero hero;
    Scanner in = new Scanner(System.in);
    int numAbil = 0;

    public Battle(int stage, Hero hero) {
        this.stage = stage;
        this.hero = hero;
    }
    public int getStage() {
        return stage;
    }

    public void startBattle() throws InterruptedException {
        Enemy enemy = new Enemy((1000 + stage*50), (stage*20), 200 + (stage*50), 10 + stage*0.2);
        while (enemy.isAlive()) {
            if (hero.isAlive()){
                if (enemy.getEvasion() < Math.random()*100) {
                    System.out.printf("%s наносит монстру %d урона. Монстр заблокировал: %d урона. Здоровье монстра: %d%n"
                            , hero.getName(), hero.attackEnemy(enemy), enemy.getArmor(), Math.max(enemy.getHealth(), 0));
                } else {
                    System.out.println(hero.getName() + " хотел нанести атаку, но Монстр уклонился!");
                }
            } else {
                System.out.println("Вы погибли! Пройдено уровней " + (stage - 1));
                break;
            }
            Thread.sleep(750);
            if (enemy.isAlive()){
                if (hero.getEvasion() < Math.random()*100) {
                    System.out.printf("Моснтр наносит %s %d урона. %s заблокировал %d урона. Здоровье %s : %d%n"
                            , hero.getName(), enemy.attack(hero), hero.getName(), hero.getArmor(), hero.getName()
                            , Math.max(hero.getHealth(), 0));
                } else {
                    System.out.println("Монстр хотел нанести атаку, но " + hero.getName() + " уклонился!");
                }
                Thread.sleep(500);
            } else {
                enemy.setHealth(0);
                System.out.println("Вы победили!");
                hero.upLevel();
                System.out.println("""
                        Какую характеристику хотите улучшить?
                        1. Сила
                        2. Ловкость
                        3. Интеллект
                        """);
                while (!(1 <= numAbil && numAbil <= 3)) {
                    System.out.println("Введите корректный номер : ");
                    numAbil = in.nextInt();
                }
                switch (numAbil) {
                    case 1: {
                        hero.upStrength();
                        break;
                    }
                    case 2: {
                        hero.upAgility();
                        break;
                    }
                    case 3: {
                        hero.upIntelligence();
                        break;
                    }
                    default:
                        throw new IllegalStateException("Unexpected value: " + numAbil);
                }
            }
            System.out.println();
        }
    }
}
