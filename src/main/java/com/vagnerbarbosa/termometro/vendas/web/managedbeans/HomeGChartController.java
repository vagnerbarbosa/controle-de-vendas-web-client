package com.vagnerbarbosa.termometro.vendas.web.managedbeans;

import com.vagnerbarbosa.termometro.vendas.web.model.Sales;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.extensions.component.gchart.model.GChartModel;
import org.primefaces.extensions.component.gchart.model.GChartModelBuilder;
import org.primefaces.extensions.component.gchart.model.GChartType;

@ManagedBean
@RequestScoped
public class HomeGChartController implements Serializable {

    private static final long serialVersionUID = 253762400419864192L;
    private List<Sales> sales = null;
    private GChartModel chartModel = null;
    private GChartType chartType = GChartType.COLUMN; 
    private Date initialDate = new Date(System.currentTimeMillis());
    private Date finalDate = new Date(System.currentTimeMillis());
    
    public SalesServiceManagedBean salesServiceManagedBean = new SalesServiceManagedBean();

    public GChartModel getChart() {
        return chartModel;
    }

    @PostConstruct
    public void generateModel()  {
        try {
            chartModel = new GChartModelBuilder().setChartType(getChartType())
                    .addColumns("Filial", "Vendas","Devoluções"  
                            
                    ).addRow("F" + getSales().get(0).getBranchNumber(),
                            getSales().get(0).getBalanceTotal(),
                            getSales().get(0).getServDevolutionTotal() + getSales().get(0).getProdDevolutionTotal()
                    ).addRow("F" + getSales().get(1).getBranchNumber(),
                            getSales().get(1).getBalanceTotal(),
                            getSales().get(1).getServDevolutionTotal() + getSales().get(1).getProdDevolutionTotal()
                    ).addRow("F" + getSales().get(2).getBranchNumber(),
                            getSales().get(2).getBalanceTotal(),
                            getSales().get(2).getServDevolutionTotal() + getSales().get(2).getProdDevolutionTotal()
                    ).addRow("F" + getSales().get(3).getBranchNumber(),
                            getSales().get(3).getBalanceTotal(),
                            getSales().get(3).getServDevolutionTotal() + getSales().get(3).getProdDevolutionTotal()
                    ).addRow("F" + getSales().get(4).getBranchNumber(),
                            getSales().get(4).getBalanceTotal(),
                            getSales().get(4).getServDevolutionTotal() + getSales().get(4).getProdDevolutionTotal()
                    ).addRow("F" + getSales().get(5).getBranchNumber(),
                            getSales().get(5).getBalanceTotal(),
                            getSales().get(5).getServDevolutionTotal() + getSales().get(5).getProdDevolutionTotal()
                    ).addRow("F" + getSales().get(6).getBranchNumber(),
                            getSales().get(6).getBalanceTotal(),
                            getSales().get(6).getServDevolutionTotal() + getSales().get(6).getProdDevolutionTotal()
                    ).addRow("F" + getSales().get(7).getBranchNumber(),
                            getSales().get(7).getBalanceTotal(),
                            getSales().get(7).getServDevolutionTotal() + getSales().get(7).getProdDevolutionTotal()
                    ).addRow("F" + getSales().get(8).getBranchNumber(),
                            getSales().get(8).getBalanceTotal(),
                            getSales().get(8).getServDevolutionTotal() + getSales().get(8).getProdDevolutionTotal()
                    ).addRow("F" + getSales().get(9).getBranchNumber(),
                            getSales().get(9).getBalanceTotal(),
                            getSales().get(9).getServDevolutionTotal() + getSales().get(9).getProdDevolutionTotal()
                    ).addRow("F" + getSales().get(10).getBranchNumber(),
                            getSales().get(10).getBalanceTotal(),
                            getSales().get(10).getServDevolutionTotal() + getSales().get(10).getProdDevolutionTotal()
                    ).addRow("F" + getSales().get(11).getBranchNumber(),
                            getSales().get(11).getBalanceTotal(),
                            getSales().get(11).getServDevolutionTotal() + getSales().get(11).getProdDevolutionTotal()
                    ).addRow("F" + getSales().get(12).getBranchNumber(),
                            getSales().get(12).getBalanceTotal(),
                            getSales().get(12).getServDevolutionTotal() + getSales().get(12).getProdDevolutionTotal()
                    ).addRow("F" + getSales().get(13).getBranchNumber(),
                            getSales().get(13).getBalanceTotal(),
                            getSales().get(13).getServDevolutionTotal() + getSales().get(13).getProdDevolutionTotal()
                    ).addRow("F" + getSales().get(14).getBranchNumber(),
                            getSales().get(14).getBalanceTotal(),
                            getSales().get(14).getServDevolutionTotal() + getSales().get(14).getProdDevolutionTotal()
                    ).addRow("F" + getSales().get(15).getBranchNumber(),
                            getSales().get(15).getBalanceTotal(),
                            getSales().get(15).getServDevolutionTotal() + getSales().get(15).getProdDevolutionTotal()
                    ).addRow("F" + getSales().get(16).getBranchNumber(),
                            getSales().get(16).getBalanceTotal(),
                            getSales().get(16).getServDevolutionTotal() + getSales().get(16).getProdDevolutionTotal()
                    ).addRow("F" + getSales().get(17).getBranchNumber(),
                            getSales().get(17).getBalanceTotal(),
                            getSales().get(17).getServDevolutionTotal() + getSales().get(17).getProdDevolutionTotal()
                    ).addRow("F" + getSales().get(18).getBranchNumber(),
                            getSales().get(18).getBalanceTotal(),
                            getSales().get(18).getServDevolutionTotal() + getSales().get(18).getProdDevolutionTotal()
                    ).addRow("F" + getSales().get(19).getBranchNumber(),
                            getSales().get(19).getBalanceTotal(),
                            getSales().get(19).getServDevolutionTotal() + getSales().get(19).getProdDevolutionTotal()
                    ).build();
        } catch (IOException ex) {
            Logger.getLogger(HomeGChartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refreshModel(Date data1, Date data2)  {
        try {
        List<Sales> vendasAtual = null;
        vendasAtual = this.getSalesByDate(data1, data2);
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
            Logger.getLogger(HomeGChartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public GChartType getChartType() {
        return chartType;
    }

    public void setChartType(GChartType chartType) {
        this.chartType = chartType;
    }
                 
    public List<Sales> getSales() throws IOException {
        List<Sales> salesSession = (List<Sales>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("salesList");
        List<Sales> salesAux = salesServiceManagedBean.getSales();
        if (salesSession == null) {
        this.sales = salesAux;
        } else {this.sales = salesSession; }
        return sales;
    }
        
    public List<Sales> getSalesByDate(Date initialDate, Date finalDate) throws IOException {
        this.sales = salesServiceManagedBean.getSalesByDate(initialDate, finalDate);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("salesList", this.sales);
        return sales;
        
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }
    
        
}
