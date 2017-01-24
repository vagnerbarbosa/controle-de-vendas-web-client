/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vagnerbarbosa.termometro.vendas.web.managedbeans;

import com.vagnerbarbosa.termometro.vendas.web.model.Sales;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.chartistjsf.model.chart.PieChartModel;
import org.primefaces.event.ItemSelectEvent;

@ManagedBean
@ViewScoped
public class PieChartDataBean implements Serializable {

	private PieChartModel pieChartModel;
        private List<Sales> vendas;
        private final VendasResourceManagedBean vendasWS = new VendasResourceManagedBean();

	public PieChartDataBean() throws IOException {
		createPieChart();
	}

	public void createPieChart() throws IOException {
		pieChartModel = new PieChartModel();

            pieChartModel.addLabel("1º " + this.getVendas().get(0).getTrade());
            pieChartModel.addLabel("2º " + this.getVendas().get(1).getTrade());
            pieChartModel.addLabel("3º " + this.getVendas().get(2).getTrade());
            
            pieChartModel.set(this.getVendas().get(0).getProdSaleTotal());                    
            pieChartModel.set(this.getVendas().get(1).getProdSaleTotal());                    
            pieChartModel.set(this.getVendas().get(2).getProdSaleTotal());                    

		pieChartModel.setShowTooltip(true);
	}

	public void pieItemSelect(ItemSelectEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected", "Item Value: "
				+ pieChartModel.getData().get(event.getItemIndex()));

		FacesContext.getCurrentInstance().addMessage(event.getComponent().getClientId(), msg);
	}
	
		/**
	 * @return the pieChartModel
	 */
	public PieChartModel getPieChartModel() {
		return pieChartModel;
	}

	/**
	 * @param pieChartModel
	 *            the pieChartModel to set
	 */
	public void setPieChartModel(PieChartModel pieChartModel) {
		this.pieChartModel = pieChartModel;
	}
        
    public List<Sales> getVendas() throws IOException {
        vendas = new ArrayList<>();
        vendas = (List<Sales>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("salesList");
        Collections.sort(vendas);
        return vendas;
    }        

}