package com.mycompany.app.model;

import com.mysql.cj.exceptions.WrongArgumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void addition() {
        int nb1=2, nb2=2;

        int result = calculator.addition(nb1, nb2);
        Assertions.assertEquals(result, nb1 + nb2, "Addition of " + nb1 +" + "+ nb2);
    }

    //Junit 4
    @Test
    @DisplayName("Addition throwing exception because of a wrong parameter")
    void additionWithWrongParameter() {
        int nb1=5, nb2=5;
        Assertions.assertThrows(WrongArgumentException.class,() -> calculator.addition(nb1, nb2));
    }

    @Test
    void soustraction() {
        int nb1=5, nb2=5;

        int result = calculator.soustraction(nb1, nb2);
        Assertions.assertEquals(result, nb1 - nb2, "Substraction of " + nb1 +" - "+ nb2);
    }
}
// TDD
// Créer la class dans model et ne rien mettre dans les méthode si ce n'est la valeur de retour si nécéssaire.
// Créer le test et faire en sorte qu'une fois terminé, il y ait des erreurs au lancement
// Coder les méthodes de la classes, a chaque méthode codée, on relance le test en question afin de voir que le test passe
