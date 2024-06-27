package com.marlboro;

import java.util.Scanner;

public class BattleGround {
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        Hero hero;
        int numHero = 0;
        int stage = 0;
        System.out.println("""
                Добро пожаловать в Игру!
                Правила игры:
                1) Для выбора варианта вводите цифру соответствующую вашему выбору.
                2) После каждой стадии битвы вам будет предложено улучшить одну из характеристик.
                3) В игре 3 типа героя: 
                    1. Воин (Отличается высокими показателями здоровья и брони, Основная характеристика - Сила)
                    2. Маг (Отличается высоким показателем урона, Основная характеристика - Интеллект)
                    3. Лучние (Отличается средними показателями урона и уклонения, Основная характеристика - Ловкость)
                4) Показатели:
                    1. Сила - Влияет на урон (больший показатель у Воина), здоровье, броня (в большей степени)
                    2. Ловкость - Влияет на урон (больший показатель у Лучника), уклонение, броня
                    3. Интеллекст - Влияет на урон (больший показатель у Мага), броня
                 
                Для начала игры выберите героя:
                1. Воин
                2. Маг
                3. Лучник
                """);

        
        
        while (!(1 <= numHero && numHero <= 3)) {
            System.out.println("Введите корректный номер : ");
            numHero = in.nextInt();
        }
        switch (numHero) {
            case 1: {
                System.out.println("Введите имя вашего героя: ");
                hero = new Warrior(in.next());
                break;
            }
            case 2: {
                System.out.println("Введите имя вашего героя: ");
                hero = new Mage(in.next());
                break;
            }
            case 3: {
                System.out.println("Введите имя вашего героя: ");
                hero = new Archer(in.next());
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + numHero);
        }
        hero.setAbilities();
        while (hero.isAlive()){
            stage ++;
            Battle battle = new Battle(stage, hero);
            hero.setAbilities();
            System.out.println(hero.getAbilities());
            System.out.println();
            System.out.println("Уровень: " + battle.getStage());
            System.out.println();
            System.out.println("Бой начнется через секунду");
            Thread.sleep(1000);
            battle.startBattle();
        }
    }
}
