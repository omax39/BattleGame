package com.marlboro;

import java.util.Random;

public class Archer extends Hero {


    public Archer(String name) {
        super(name, 100, 150, 50, 1);
    }


    Random random = new Random();

    @Override
    public int attackEnemy(Enemy enemy) {
        int d = random.nextInt(200) + (int) getDamage() - 100;
        enemy.takeDamage(d);
        return d;
    }

    public void setAbilities() {
        setDamage('a');
        upArmor();
        upEvasion();
        recHealth();
    }

}
