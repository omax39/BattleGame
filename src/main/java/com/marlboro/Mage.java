package com.marlboro;

import java.util.Random;

public class Mage extends Hero{

    Random rand = new Random();

    public Mage(String name) {
        super(name, 50, 100, 200, 1);
    }



    @Override
    public int attackEnemy(Enemy enemy) {
        int d = rand.nextInt(200) + (int) getDamage() - 100;
        enemy.takeDamage(d);
        return d;
    }

    public void setAbilities() {
        setDamage('m');
        upArmor();
        upEvasion();
        recHealth();
    }
}
