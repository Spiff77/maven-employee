package com.mycompany.app.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrcTest {

    Orc o1;
    Orc o2;

    @BeforeEach
    public void initOrcs(){
        // Arrange
        o1 = new Orc(100, 10);
        o2 = new Orc(100, 8);
    }

    @Test
    public void attack() {
        //Arrange
        int healthBeforeAttack = o2.getHealth();

        //ACT
        o1.attack(o2);

        //ASSERT
        Assertions.assertEquals(healthBeforeAttack - o1.getForce() , o2.getHealth(), "Orc have lost health according to oponent force:");
    }
}
