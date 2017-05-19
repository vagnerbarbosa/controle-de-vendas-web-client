package com.vagnerbarbosa.termometro.vendas.web.managedbeans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.vagnerbarbosa.termometro.vendas.web.datasource.UserDao;
import com.vagnerbarbosa.termometro.vendas.web.datasource.UserDaoImpl;
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
    
    public List<SalesOrder> getPedidos(Integer filial) throws IOException {
        List<SalesOrder> resultado = null;
        Integer salesCount = null;
        if (resultado == null) {
        Client c = Client.create();
        listSalesOrder = new ArrayList<>();
        listSalesProducts = new ArrayList<>();
        
        //user = userService.findBySSO("john");

        WebResource wr1 = c.resource("http://192.168.19.250:8080/riodopeixe-rest/webservice/sales-order/" + filial);
        String jsonSales = wr1.get(String.class);

        WebResource wr2 = c.resource("http://192.168.19.250:8080/riodopeixe-rest/webservice/sales-order/products/" + filial);
        String jsonProducts = wr2.get(String.class);

        listSalesOrder = mapper.readValue(jsonSales, mapper.getTypeFactory().constructCollectionType(List.class, SalesOrder.class));
        listSalesProducts = mapper.readValue(jsonProducts, mapper.getTypeFactory().constructCollectionType(List.class, Product.class));
        
        salesCount = listSalesOrder.size();

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
        resultado = (List<SalesOrder>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("salesOrder", listSalesOrder); 
        }
        return resultado;
    }
    
    public Integer getEntregasPendentes(Integer filial) throws IOException {
        List<SalesOrder> eux = (List<SalesOrder>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("salesOrder");
        Integer retorno = 0;
        
        for (int i = 0; i < eux.size(); i++) {
            for (int j = 0; j < eux.get(i).getProducts().size(); j++) {
                        if ("Entrega Pendente".equals(eux.get(i).getProducts().get(j).getDeliverSituation())){
            retorno++;
                        }
            }

        }        
     return retorno;
    }
    
    public Integer getMontagensPendentes(Integer filial) throws IOException {
        List<SalesOrder> eux = (List<SalesOrder>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("salesOrder");
        Integer retorno = 0;
        
        for (int i = 0; i < eux.size(); i++) {
            for (int j = 0; j < eux.get(i).getProducts().size(); j++) {
                        if ("Montagem Pendente".equals(eux.get(i).getProducts().get(j).getMontageSituation())){
            retorno++;
                        }
            }

        }        
     return retorno;
    }  
    
    public Integer getFaturametosPendentes(Integer filial) throws IOException {
        List<SalesOrder> eux = (List<SalesOrder>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("salesOrder");
        Integer retorno = 0;
        
        for (int i = 0; i < eux.size(); i++) {
            for (int j = 0; j < eux.get(i).getProducts().size(); j++) {
                        if ("Fechado".equals(eux.get(i).getProducts().get(j).getItemSituation())){
            retorno++;
                        }
            }

        }        
     return retorno;
    }    
    
}
