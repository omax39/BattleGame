package com.marlboro;

import java.util.Random;

public class Enemy implements Mortal{
    private int health;
    private int damage;
    private int armor;
    private double evasion;
    Random rand = new Random();

    public Enemy(int health, int armor, int damage, double evasion) {
        this.health = health;
        this.armor = armor;
        this.damage = damage;
        this.evasion = evasion;
    }

    public double getEvasion() {
        return evasion;
    }

    public int getArmor() {
        return armor;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void takeDamage(int damage) {
        if (this.armor < damage) {
            this.health = this.health - damage + this.armor;
        } else {
            this.health = this.health - this.armor;
        }
    }

    @Override
    public boolean isAlive() {
        if (health <= 0) {
            return false;
        }
        return true;
    }

    public int attack(Hero hero) {
        int d = rand.nextInt(200) + damage - 100;
        hero.takeDamage(d);
        return d;
    }
}
