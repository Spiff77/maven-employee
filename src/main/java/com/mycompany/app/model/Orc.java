package com.mycompany.app.model;

import java.util.Objects;

public class Orc {

    private String name = "NameLess";
    private int health;
    private int force;

    public Orc(String name, int health, int force) {
        this(health, force);
        this.name = name;
    }

    public Orc(int health, int force) {
        this.setHealth(health);
        this.force = force;
    }

    public void attack(Orc orc){
        orc.health -= this.force;
    }

    public void receiveDamage(int amount){
        this.health-=amount;
    }


    public Orc compare(Orc orc){
        if(this.getForce() > orc.getForce()) return this;
        else return orc;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health > 100 ? 100 : health;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Orc{");
        sb.append("name='").append(name).append('\'');
        sb.append(", health=").append(health);
        sb.append(", force=").append(force);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orc orc)) return false;
        return Objects.equals(name, orc.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
