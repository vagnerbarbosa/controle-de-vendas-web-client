/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vagnerbarbosa.termometro.vendas.web.managedbeans;

public class Births {
 
    protected String year;
    protected Integer amount;
 
    public String getYear() {
        return year;
    }
 
    public void setYear(String year) {
        this.year = year;
    }
 
    public Integer getAmount() {
        return amount;
    }
 
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
 
    public Births() {
    }
 
    public Births(String year, Integer amount) {
        this.year = year;
        this.amount = amount;
    }
}
