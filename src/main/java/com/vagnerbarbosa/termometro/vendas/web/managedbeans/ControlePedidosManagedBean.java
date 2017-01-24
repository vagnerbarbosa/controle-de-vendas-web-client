package com.vagnerbarbosa.termometro.vendas.web.managedbeans;

import com.vagnerbarbosa.termometro.vendas.web.model.SalesOrder;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author vagner
 */
@ManagedBean
@RequestScoped
public class ControlePedidosManagedBean implements Serializable {

    public ControlePedidosManagedBean() {
    }

    public List<SalesOrder> getPedidos() throws IOException {
        return (List<SalesOrder>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("salesOrder");
    }

    public boolean getDaysRowcolor(Integer days) {
        boolean colorFlag;
        colorFlag = days > 6;
        return colorFlag;
    }
    
    public String getBranchRowColor(int branchNumberToInvoice, int branchNumber, String situationChargerMap) {
        String colorFlag = null;
        if ((branchNumberToInvoice != branchNumber) & (!"Faturado".equals(situationChargerMap)) ) {
            colorFlag = "color: red; font-weight: bold;";
        } else if ((branchNumberToInvoice != branchNumber) & ("Faturado".equals(situationChargerMap)) ) {
            colorFlag = "color: black;";
        }
         
        return colorFlag;
    }

    public String getDeliveriRowColor(String deliverSituation) {
        String colorFlag = null;
        if ("Entrega Pendente".equals(deliverSituation)) {
            colorFlag = "background-color: #f4ff81;";
        } else if ("Saiu Para Entrega".equals(deliverSituation)) {
            colorFlag = "background-color: #32FF69;";
        } else if ("Não Entregue".equals(deliverSituation)) {
            colorFlag = "background-color: red;";            
        } else if ("Não Há Entrega".equals(deliverSituation)) {
            colorFlag = "background-color: #DEE8F6;";
        }
         
        return colorFlag;
    } 
    
    public String getMontageRowColor(String montageSituation) {
        String colorFlag;
        if (null == montageSituation) { colorFlag = "background-color: #32FF69;"; } else switch (montageSituation) {
            case "Montagem Pendente":
                colorFlag = "background-color: #f4ff81;";
                break;
            case "Não Há Montagem":
                colorFlag = "background-color: #DEE8F6;";
                break;
            default:
                colorFlag = "background-color: #32FF69;";
                break;
        }
         
        return colorFlag;
    }
    
    public String getSituationChargerMapRowColor(String situationChargerMap) {
        String colorFlag = null;
        if ("A Faturar".equals(situationChargerMap)) {
            colorFlag = "background-color: #f4ff81;";
        } else {colorFlag = "background-color: #DEE8F6"; }
         
        return colorFlag;
    }     

}
