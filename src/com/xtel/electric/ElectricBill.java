/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtel.electric;

/**
 *
 * @author Administrator
 */
public class ElectricBill {
int[] electricNumber = {100, 150, 200, 250};
    int[] price = {1000, 1500, 2000, 2500};
    int[] arrayOfMaxPrice;
    int numberInput;
    

    public ElectricBill(int numberInput) {
        this.numberInput = numberInput;
        arrayOfMaxPrice = getArrayOfMaxPrice();
    }

    public int getLevel() {
        int level=0;
        for (int i = 0; i < electricNumber.length; i++) {
            if (numberInput > electricNumber[i]) {
                level++;
            }
        }
        if(level>=arrayOfMaxPrice.length){
            level--;
        }
        return level;
    }

    private int[] getArrayOfMaxPrice() {
        int lengOfArr = electricNumber.length;
        int[] arrOfMaxPrice = new int[lengOfArr];
        int lastPrice = 0;
        for (int i = 0; i < lengOfArr; i++) {
            if (i == 0) {
                lastPrice = electricNumber[i] * price[i];
            } else {
                int range = electricNumber[i]-electricNumber[i-1];
                lastPrice = lastPrice + range*price[i];
            }
            arrOfMaxPrice[i] = lastPrice;
        }
        return arrOfMaxPrice;
    }
    public int getMoney(){
        int level = getLevel();
        if(level ==0){
            return numberInput * price[0];
        } 
        return arrayOfMaxPrice[level] +(numberInput-electricNumber[level])*price[level]; 
    }}
