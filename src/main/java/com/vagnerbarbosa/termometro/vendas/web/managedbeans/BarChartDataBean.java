package com.vagnerbarbosa.termometro.vendas.web.managedbeans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.vagnerbarbosa.termometro.vendas.web.model.Sales;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.chartistjsf.model.chart.AspectRatio;
import org.chartistjsf.model.chart.Axis;
import org.chartistjsf.model.chart.AxisType;
import org.chartistjsf.model.chart.BarChartModel;
import org.chartistjsf.model.chart.BarChartSeries;

/**
 *
 * @author vagner
 */
@ManagedBean
@ViewScoped
public class BarChartDataBean implements Serializable {

    private BarChartModel barChartModel;
    
    private Date date1 = new Date(System.currentTimeMillis());
    private Date date2 = new Date(System.currentTimeMillis());
    
    List<Sales> vendas = new ArrayList<>();
    ObjectMapper mapper = new ObjectMapper();

    public BarChartDataBean() throws IOException {
        createBarModel();
    }

    public void createBarModel() throws IOException {
        barChartModel = new BarChartModel();
        barChartModel.setAspectRatio(AspectRatio.MAJOR_ELEVENTH);

        BarChartSeries series1 = new BarChartSeries();
        series1.setName("R$");

        for (int i = 0; i < this.getVendas().size(); i++) {
            barChartModel.addLabel("F" + this.getVendas().get(i).getBranchNumber());
            series1.set(this.getVendas().get(i).getBalanceTotal());
        }
        barChartModel.addSeries(series1);

        Axis xAxis = barChartModel.getAxis(AxisType.X);
        xAxis.setShowGrid(false);

        barChartModel.setShowTooltip(true);
        barChartModel.setSeriesBarDistance(15);
        barChartModel.setAnimatePath(true);
    }

    /**
     * @return the barChartModel
     */
    public BarChartModel getBarChartModel() {
        return barChartModel;
    }

    /**
     * @param barChartModel the barChartModel to set
     */
    public void setBarChartModel(BarChartModel barChartModel) {
        this.barChartModel = barChartModel;
    }

    public List<Sales> atualizaVendas(Date date1, Date date2) throws IOException {        
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String dat1 = df.format(date1);
        String dat2 = df.format(date2);
        Client c = Client.create();
        WebResource wr = c.resource("http://192.168.19.250:8080/riodopeixe-rest/webservice/sales/" + dat1 + "/" + dat2);
        String json = wr.get(String.class);
        this.vendas = null;
        this.vendas = (List<Sales>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("salesList", mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, Sales.class)));
        return vendas;
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
        this.vendas = (List<Sales>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("salesList", mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, Sales.class)));
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
