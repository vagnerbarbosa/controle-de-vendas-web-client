package com.vagnerbarbosa.termometro.vendas.web.managedbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class LineChartBean {
 
    public List<Births> boys;
    public List<Births> girls;
    public String selectedPoint;
    public String selectedSeries;
     
    // getters and setters omitted   
     
    public LineChartBean() {
        reload();
    }
 
    private void reload() {
        boys = new ArrayList<>();
        girls = new ArrayList<>();
        Random r = new Random();
        for (int i = 2000; i < 2010; i++) {
            boys.add(new Births(Integer.toString(i), r.nextInt(500) + 800));   
            girls.add(new Births(Integer.toString(i), r.nextInt(500) + 800));   
        }  
    }

    public List<Births> getBoys() {
        return boys;
    }

    public void setBoys(List<Births> boys) {
        this.boys = boys;
    }

    public List<Births> getGirls() {
        return girls;
    }

    public void setGirls(List<Births> girls) {
        this.girls = girls;
    }

    public String getSelectedPoint() {
        return selectedPoint;
    }

    public void setSelectedPoint(String selectedPoint) {
        this.selectedPoint = selectedPoint;
    }

    public String getSelectedSeries() {
        return selectedSeries;
    }

    public void setSelectedSeries(String selectedSeries) {
        this.selectedSeries = selectedSeries;
    }    
     
    public void clicked() {
        FacesMessage m = new FacesMessage("You clicked " + selectedPoint + " on series " + selectedSeries);
        FacesContext.getCurrentInstance().addMessage("", m);        
    }
}