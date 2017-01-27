package com.vagnerbarbosa.termometro.vendas.web.managedbeans;

import com.vagnerbarbosa.termometro.vendas.web.model.Sales;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import java.io.IOException;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@RequestScoped
public class VendasResourceManagedBean implements Serializable {
    
    ObjectMapper mapper = new ObjectMapper();

    public VendasResourceManagedBean() {
    }
    
    public List<Sales> getVendas() throws IOException {
        Client c = Client.create();
        WebResource wr = c.resource("http://192.168.19.250:8080/sales-weather/webservice/sales/");
        String json = wr.get(String.class);
        return (List<Sales>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("salesList", mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, Sales.class)));
    }

    public ObjectMapper getMapper() {
        return mapper;
    }

    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }
    
    
}
