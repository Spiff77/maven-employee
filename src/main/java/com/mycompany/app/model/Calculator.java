package com.mycompany.app.model;

import com.mysql.cj.exceptions.WrongArgumentException;

public class Calculator {

    public int addition(int a, int b){

        if(b > 3){
            throw new WrongArgumentException("B doit êtere supperieur à 3");
        }
        return a + b;
    }

    public int soustraction(int a, int b){
        return a - b;
    }
}
