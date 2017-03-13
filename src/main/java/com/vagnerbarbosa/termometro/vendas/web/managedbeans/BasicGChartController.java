package com.vagnerbarbosa.termometro.vendas.web.managedbeans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.vagnerbarbosa.termometro.vendas.web.model.Sales;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.extensions.component.gchart.model.GChartModel;
import org.primefaces.extensions.component.gchart.model.GChartModelBuilder;
import org.primefaces.extensions.component.gchart.model.GChartType;

@ManagedBean
@RequestScoped
public class BasicGChartController implements Serializable {

    private static final long serialVersionUID = 253762400419864192L;
    List<Sales> vendas = null;
    private GChartModel chartModel = null;
    private GChartType chartType = GChartType.COLUMN; 
    ObjectMapper mapper = new ObjectMapper();
    private Date date1 = new Date(System.currentTimeMillis());
    private Date date2 = new Date(System.currentTimeMillis());

    public GChartModel getChart() {
        return chartModel;
    }

    @PostConstruct
    public void generateModel()  {
        try {
            chartModel = new GChartModelBuilder().setChartType(getChartType())
                    .addColumns("Filial", "Vendas","Devoluções"  
                            
                    ).addRow("F" + getVendas().get(0).getBranchNumber(),
                            getVendas().get(0).getBalanceTotal(),
                            getVendas().get(0).getServDevolutionTotal() + getVendas().get(0).getProdDevolutionTotal()
                    ).addRow("F" + getVendas().get(1).getBranchNumber(),
                            getVendas().get(1).getBalanceTotal(),
                            getVendas().get(1).getServDevolutionTotal() + getVendas().get(1).getProdDevolutionTotal()
                    ).addRow("F" + getVendas().get(2).getBranchNumber(),
                            getVendas().get(2).getBalanceTotal(),
                            getVendas().get(2).getServDevolutionTotal() + getVendas().get(2).getProdDevolutionTotal()
                    ).addRow("F" + getVendas().get(3).getBranchNumber(),
                            getVendas().get(3).getBalanceTotal(),
                            getVendas().get(3).getServDevolutionTotal() + getVendas().get(3).getProdDevolutionTotal()
                    ).addRow("F" + getVendas().get(4).getBranchNumber(),
                            getVendas().get(4).getBalanceTotal(),
                            getVendas().get(4).getServDevolutionTotal() + getVendas().get(4).getProdDevolutionTotal()
                    ).addRow("F" + getVendas().get(5).getBranchNumber(),
                            getVendas().get(5).getBalanceTotal(),
                            getVendas().get(5).getServDevolutionTotal() + getVendas().get(5).getProdDevolutionTotal()
                    ).addRow("F" + getVendas().get(6).getBranchNumber(),
                            getVendas().get(6).getBalanceTotal(),
                            getVendas().get(6).getServDevolutionTotal() + getVendas().get(6).getProdDevolutionTotal()
                    ).addRow("F" + getVendas().get(7).getBranchNumber(),
                            getVendas().get(7).getBalanceTotal(),
                            getVendas().get(7).getServDevolutionTotal() + getVendas().get(7).getProdDevolutionTotal()
                    ).addRow("F" + getVendas().get(8).getBranchNumber(),
                            getVendas().get(8).getBalanceTotal(),
                            getVendas().get(8).getServDevolutionTotal() + getVendas().get(8).getProdDevolutionTotal()
                    ).addRow("F" + getVendas().get(9).getBranchNumber(),
                            getVendas().get(9).getBalanceTotal(),
                            getVendas().get(9).getServDevolutionTotal() + getVendas().get(9).getProdDevolutionTotal()
                    ).addRow("F" + getVendas().get(10).getBranchNumber(),
                            getVendas().get(10).getBalanceTotal(),
                            getVendas().get(10).getServDevolutionTotal() + getVendas().get(10).getProdDevolutionTotal()
                    ).addRow("F" + getVendas().get(11).getBranchNumber(),
                            getVendas().get(11).getBalanceTotal(),
                            getVendas().get(11).getServDevolutionTotal() + getVendas().get(11).getProdDevolutionTotal()
                    ).addRow("F" + getVendas().get(12).getBranchNumber(),
                            getVendas().get(12).getBalanceTotal(),
                            getVendas().get(12).getServDevolutionTotal() + getVendas().get(12).getProdDevolutionTotal()
                    ).addRow("F" + getVendas().get(13).getBranchNumber(),
                            getVendas().get(13).getBalanceTotal(),
                            getVendas().get(13).getServDevolutionTotal() + getVendas().get(13).getProdDevolutionTotal()
                    ).addRow("F" + getVendas().get(14).getBranchNumber(),
                            getVendas().get(14).getBalanceTotal(),
                            getVendas().get(14).getServDevolutionTotal() + getVendas().get(14).getProdDevolutionTotal()
                    ).addRow("F" + getVendas().get(15).getBranchNumber(),
                            getVendas().get(15).getBalanceTotal(),
                            getVendas().get(15).getServDevolutionTotal() + getVendas().get(15).getProdDevolutionTotal()
                    ).addRow("F" + getVendas().get(16).getBranchNumber(),
                            getVendas().get(16).getBalanceTotal(),
                            getVendas().get(16).getServDevolutionTotal() + getVendas().get(16).getProdDevolutionTotal()
                    ).addRow("F" + getVendas().get(17).getBranchNumber(),
                            getVendas().get(17).getBalanceTotal(),
                            getVendas().get(17).getServDevolutionTotal() + getVendas().get(17).getProdDevolutionTotal()
                    ).addRow("F" + getVendas().get(18).getBranchNumber(),
                            getVendas().get(18).getBalanceTotal(),
                            getVendas().get(18).getServDevolutionTotal() + getVendas().get(18).getProdDevolutionTotal()
                    ).addRow("F" + getVendas().get(19).getBranchNumber(),
                            getVendas().get(19).getBalanceTotal(),
                            getVendas().get(19).getServDevolutionTotal() + getVendas().get(19).getProdDevolutionTotal()
                    ).build();
        } catch (IOException ex) {
            Logger.getLogger(BasicGChartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refreshModel(Date data1, Date data2)  {
        try {
        List<Sales> vendasAtual = null;
        vendasAtual = this.getVendasByDate(data1, data2);
            chartModel = new GChartModelBuilder().setChartType(getChartType())
                    .addColumns("Filial", "Vendas","Devoluções"  
                            
                    ).addRow("F" + vendasAtual.get(0).getBranchNumber(),
                            vendasAtual.get(0).getBalanceTotal(),
                            vendasAtual.get(0).getServDevolutionTotal() + vendasAtual.get(0).getProdDevolutionTotal()
                    ).addRow("F" + vendasAtual.get(1).getBranchNumber(),
                            vendasAtual.get(1).getBalanceTotal(),
                            vendasAtual.get(1).getServDevolutionTotal() + vendasAtual.get(1).getProdDevolutionTotal()
                    ).addRow("F" + vendasAtual.get(2).getBranchNumber(),
                            vendasAtual.get(2).getBalanceTotal(),
                            vendasAtual.get(2).getServDevolutionTotal() + vendasAtual.get(2).getProdDevolutionTotal()
                    ).addRow("F" + vendasAtual.get(3).getBranchNumber(),
                            vendasAtual.get(3).getBalanceTotal(),
                            vendasAtual.get(3).getServDevolutionTotal() + vendasAtual.get(3).getProdDevolutionTotal()
                    ).addRow("F" + vendasAtual.get(4).getBranchNumber(),
                            vendasAtual.get(4).getBalanceTotal(),
                            vendasAtual.get(4).getServDevolutionTotal() + vendasAtual.get(4).getProdDevolutionTotal()
                    ).addRow("F" + vendasAtual.get(5).getBranchNumber(),
                            vendasAtual.get(5).getBalanceTotal(),
                            vendasAtual.get(5).getServDevolutionTotal() + vendasAtual.get(5).getProdDevolutionTotal()
                    ).addRow("F" + vendasAtual.get(6).getBranchNumber(),
                            vendasAtual.get(6).getBalanceTotal(),
                            vendasAtual.get(6).getServDevolutionTotal() + vendasAtual.get(6).getProdDevolutionTotal()
                    ).addRow("F" + vendasAtual.get(7).getBranchNumber(),
                            vendasAtual.get(7).getBalanceTotal(),
                            vendasAtual.get(7).getServDevolutionTotal() + vendasAtual.get(7).getProdDevolutionTotal()
                    ).addRow("F" + vendasAtual.get(8).getBranchNumber(),
                            vendasAtual.get(8).getBalanceTotal(),
                            vendasAtual.get(8).getServDevolutionTotal() + vendasAtual.get(8).getProdDevolutionTotal()
                    ).addRow("F" + vendasAtual.get(9).getBranchNumber(),
                            vendasAtual.get(9).getBalanceTotal(),
                            vendasAtual.get(9).getServDevolutionTotal() + vendasAtual.get(9).getProdDevolutionTotal()
                    ).addRow("F" + vendasAtual.get(10).getBranchNumber(),
                            vendasAtual.get(10).getBalanceTotal(),
                            vendasAtual.get(10).getServDevolutionTotal() + vendasAtual.get(10).getProdDevolutionTotal()
                    ).addRow("F" + vendasAtual.get(11).getBranchNumber(),
                            vendasAtual.get(11).getBalanceTotal(),
                            vendasAtual.get(11).getServDevolutionTotal() + vendasAtual.get(11).getProdDevolutionTotal()
                    ).addRow("F" + vendasAtual.get(12).getBranchNumber(),
                            vendasAtual.get(12).getBalanceTotal(),
                            vendasAtual.get(12).getServDevolutionTotal() + vendasAtual.get(12).getProdDevolutionTotal()
                    ).addRow("F" + vendasAtual.get(13).getBranchNumber(),
                            vendasAtual.get(13).getBalanceTotal(),
                            vendasAtual.get(13).getServDevolutionTotal() + vendasAtual.get(13).getProdDevolutionTotal()
                    ).addRow("F" + vendasAtual.get(14).getBranchNumber(),
                            vendasAtual.get(14).getBalanceTotal(),
                            vendasAtual.get(14).getServDevolutionTotal() + vendasAtual.get(14).getProdDevolutionTotal()
                    ).addRow("F" + vendasAtual.get(15).getBranchNumber(),
                            vendasAtual.get(15).getBalanceTotal(),
                            vendasAtual.get(15).getServDevolutionTotal() + vendasAtual.get(15).getProdDevolutionTotal()
                    ).addRow("F" + vendasAtual.get(16).getBranchNumber(),
                            vendasAtual.get(16).getBalanceTotal(),
                            vendasAtual.get(16).getServDevolutionTotal() + vendasAtual.get(16).getProdDevolutionTotal()
                    ).addRow("F" + vendasAtual.get(17).getBranchNumber(),
                            vendasAtual.get(17).getBalanceTotal(),
                            vendasAtual.get(17).getServDevolutionTotal() + vendasAtual.get(17).getProdDevolutionTotal()
                    ).addRow("F" + vendasAtual.get(18).getBranchNumber(),
                            vendasAtual.get(18).getBalanceTotal(),
                            vendasAtual.get(18).getServDevolutionTotal() + vendasAtual.get(18).getProdDevolutionTotal()
                    ).addRow("F" + vendasAtual.get(19).getBranchNumber(),
                            vendasAtual.get(19).getBalanceTotal(),
                            vendasAtual.get(19).getServDevolutionTotal() + vendasAtual.get(19).getProdDevolutionTotal()
                    ).build();
        } catch (IOException ex) {
            Logger.getLogger(BasicGChartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public GChartType getChartType() {
        return chartType;
    }

    public void setChartType(GChartType chartType) {
        this.chartType = chartType;
    }
                 
    public List<Sales> getVendas() throws IOException {
        this.vendas = null;
        this.vendas = (List<Sales>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("salesList");
        return vendas;
    }
        
    public List<Sales> getVendasByDate(Date date1, Date date2) throws IOException {
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            String dat1 = df.format(date1);
            String dat2 = df.format(date2);
        Client c = Client.create();
        WebResource wr = c.resource("http://192.168.19.250:8080/riodopeixe-rest/webservice/sales/" + dat1 + "/" + dat2);
        String json = wr.get(String.class);
        this.vendas = null;
        this.vendas = (List<Sales>) mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, Sales.class));
        return vendas;
    }
    
    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }    
             
}
