package com.vagnerbarbosa.termometro.vendas.web.managedbeans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.vagnerbarbosa.termometro.vendas.web.model.Product;
import com.vagnerbarbosa.termometro.vendas.web.model.SalesOrder;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
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
public class ControlePedidosResourceManagedBean implements Serializable {
    
    private final ObjectMapper mapper = new ObjectMapper();
    private List<SalesOrder> listSalesOrder = null;
    private List<Product> listSalesProducts = null;
    private List<Product> prdAux = null;
    private String teste = null;     
    
    public List<SalesOrder> getPedidos(String filial) throws IOException {
        Client c = Client.create();
        listSalesOrder = new ArrayList<>();
        listSalesProducts = new ArrayList<>();

        WebResource wr1 = c.resource("http://192.168.18.250:8080/sales-weather/webservice/sales-order/" + Integer.valueOf(filial.substring(1)));
        String jsonSales = wr1.get(String.class);

        WebResource wr2 = c.resource("http://192.168.18.250:8080/sales-weather/webservice/sales-order/products/" + Integer.valueOf(filial.substring(1)));
        String jsonProducts = wr2.get(String.class);

        listSalesOrder = mapper.readValue(jsonSales, mapper.getTypeFactory().constructCollectionType(List.class, SalesOrder.class));
        listSalesProducts = mapper.readValue(jsonProducts, mapper.getTypeFactory().constructCollectionType(List.class, Product.class));

        for (int i = 0; i < listSalesOrder.size(); i++) {
            prdAux = new ArrayList<>();
            for (int j = 0; j < listSalesProducts.size(); j++) {
                if ( listSalesOrder.get(i).getIdSalesOrder().equals(listSalesProducts.get(j).getIdSaleOrder())  ) {
                    Product produto = listSalesProducts.get(j);
                    prdAux.add(produto);
                } else {

                }
            }
            listSalesOrder.get(i).setProducts(prdAux);
        }
        
        return (List<SalesOrder>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("salesOrder", listSalesOrder); 
    } 

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }    
    
}
