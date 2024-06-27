package com.marlboro;


public abstract class Hero implements Mortal{
    private String name;
    private int health;
    private double damage;
    private int strength;
    private int agility;
    private int intelligence;
    private int armor;
    private double evasion;
    private int level;

    public Hero(String name, int strength, int agility, int intelligence, int level) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.level = level;
    }

    public abstract int attackEnemy(Enemy enemy);

    @Override
    public boolean isAlive() {
        if (health <= 0) {
            return false;
        }
        return true;
    }

    public int getHealth() {
        return health;
    }

    public void recHealth() {
        this.health = this.strength*10 + (this.level-1)*20;
    }

    public int getStrength() {
        return strength;
    }

    public void upStrength() {
        this.strength += 10;
    }

    public int getAgility() {
        return agility;
    }

    public void upAgility() {
        this.agility += 10;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void upIntelligence() {
        this.intelligence += 10;
    }

    public int getArmor() {
        return armor;
    }

    public void upArmor() {
        this.armor = (this.strength*2 + this.agility + this.intelligence)/2;
    }

    public double getEvasion() {
        return evasion;
    }

    public void upEvasion() {
        this.evasion = (double) this.agility / 8;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void upLevel() {
        this.level ++;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(char typeHero){
        switch (typeHero){
            case 'a': this.damage = this.strength*0.5 + this.agility + this.intelligence*0.5; break;
            case 'm': this.damage = this.strength*0.5 + this.agility*0.5 + this.intelligence; break;
            case 'w': this.damage = this.strength + this.agility*0.5 + this.intelligence*0.5; break;
        }
    }

    public abstract void setAbilities();

    public void takeDamage(int damage) {
        if (this.armor < damage) {
            this.health = this.health - damage + this.armor;
        } else {
            this.health = this.health - this.armor;
        }
    }

    public String getAbilities() {
        return String.format("Ваши характеристики на бой:\nЗдоровье: %d, Урон: %d, Сила: %d, Ловкость: %d, Интеллект: %d"
                , getHealth(), (int) getDamage(), getStrength(), getAgility(), getIntelligence());
    }

}