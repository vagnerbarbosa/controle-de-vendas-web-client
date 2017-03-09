package com.vagnerbarbosa.termometro.vendas.web.managedbeans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.vagnerbarbosa.termometro.vendas.web.model.Sales;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.extensions.component.gchart.model.GChartModel;
import org.primefaces.extensions.component.gchart.model.GChartModelBuilder;
import org.primefaces.extensions.component.gchart.model.GChartType;

@ManagedBean
@RequestScoped
public class BasicGChartController implements Serializable {

    private static final long serialVersionUID = 253762400419864192L;
    List<Sales> vendas = null;
    private GChartModel chartModel = null;
    ObjectMapper mapper = new ObjectMapper();

    public GChartModel getChart() {
        return chartModel;
    }

    @PostConstruct
    public void generateModel()  {
        try {
            chartModel = new GChartModelBuilder().setChartType(GChartType.COLUMN)
                    .addColumns("coluna1", "Vendas"  
                            
                    ).addRow("F" + getVendas().get(0).getBranchNumber(),
                            getVendas().get(0).getBalanceTotal()
                    ).addRow("F" + getVendas().get(1).getBranchNumber(),
                            getVendas().get(1).getBalanceTotal()
                    ).addRow("F" + getVendas().get(2).getBranchNumber(),
                            getVendas().get(2).getBalanceTotal()
                    ).addRow("F" + getVendas().get(3).getBranchNumber(),
                            getVendas().get(3).getBalanceTotal()
                    ).addRow("F" + getVendas().get(4).getBranchNumber(),
                            getVendas().get(4).getBalanceTotal()
                    ).addRow("F" + getVendas().get(5).getBranchNumber(),
                            getVendas().get(5).getBalanceTotal()
                    ).addRow("F" + getVendas().get(6).getBranchNumber(),
                            getVendas().get(6).getBalanceTotal()
                    ).addRow("F" + getVendas().get(7).getBranchNumber(),
                            getVendas().get(7).getBalanceTotal()
                    ).addRow("F" + getVendas().get(8).getBranchNumber(),
                            getVendas().get(8).getBalanceTotal()
                    ).addRow("F" + getVendas().get(9).getBranchNumber(),
                            getVendas().get(9).getBalanceTotal()
                    ).addRow("F" + getVendas().get(10).getBranchNumber(),
                            getVendas().get(10).getBalanceTotal()
                    ).addRow("F" + getVendas().get(11).getBranchNumber(),
                            getVendas().get(11).getBalanceTotal()
                    ).addRow("F" + getVendas().get(12).getBranchNumber(),
                            getVendas().get(12).getBalanceTotal()
                    ).addRow("F" + getVendas().get(13).getBranchNumber(),
                            getVendas().get(13).getBalanceTotal()
                    ).addRow("F" + getVendas().get(14).getBranchNumber(),
                            getVendas().get(14).getBalanceTotal()
                    ).addRow("F" + getVendas().get(15).getBranchNumber(),
                            getVendas().get(15).getBalanceTotal()
                    ).addRow("F" + getVendas().get(16).getBranchNumber(),
                            getVendas().get(16).getBalanceTotal()
                    ).addRow("F" + getVendas().get(17).getBranchNumber(),
                            getVendas().get(17).getBalanceTotal()
                    ).addRow("F" + getVendas().get(18).getBranchNumber(),
                            getVendas().get(18).getBalanceTotal()
                    ).addRow("F" + getVendas().get(19).getBranchNumber(),
                            getVendas().get(19).getBalanceTotal()
                    ).build();
        } catch (IOException ex) {
            Logger.getLogger(BasicGChartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
        public List<Sales> getVendas() throws IOException {
        if (vendas == null) {
        Client c = Client.create();
        WebResource wr = c.resource("http://192.168.19.250:8080/riodopeixe-rest/webservice/sales/");
        String json = wr.get(String.class);
        this.vendas = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, Sales.class));
        }
        return vendas;
    }
}
