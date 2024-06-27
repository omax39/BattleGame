package com.marlboro;

import java.util.Random;

public class Warrior extends Hero {

    Random rand = new Random();

    public Warrior(String name) {
        super(name, 200, 50, 50, 1);
    }



    @Override
    public int attackEnemy(Enemy enemy) {
        int d = rand.nextInt(200) + (int) getDamage() - 100;
        enemy.takeDamage(d);
        return d;
    }

    public void setAbilities() {
        setDamage('w');
        upArmor();
        upEvasion();
        recHealth();
    }
}
