package com.vagnerbarbosa.termometro.vendas.web.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Vagner Barbosa
 */
public class SalesOrder implements Serializable {
    
    private Integer idSalesOrder; //idpedidovenda
    private Integer branchNumber; //numerofilial
    private String trade; //fantasia
    private String clientName; //nome    
    private Date movingDate; //datamovimento  
    private String shopRequestSituation; //situacaopedidoloja 
    private String neighborhood; //bairro
    private String city; //cidade
    private Integer days;
    private List<Product> products;

    public Integer getIdSalesOrder() {
        return idSalesOrder;
    }

    public void setIdSalesOrder(Integer idSalesOrder) {
        this.idSalesOrder = idSalesOrder;
    }

    public Integer getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(Integer branchNumber) {
        this.branchNumber = branchNumber;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getMovingDate() {
        return movingDate;
    }

    public void setMovingDate(Date movingDate) {
        this.movingDate = movingDate;
    }

    public String getShopRequestSituation() {
        return shopRequestSituation;
    }

    public void setShopRequestSituation(String shopRequestSituation) {
        this.shopRequestSituation = shopRequestSituation;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.idSalesOrder);
        hash = 19 * hash + Objects.hashCode(this.branchNumber);
        hash = 19 * hash + Objects.hashCode(this.trade);
        hash = 19 * hash + Objects.hashCode(this.clientName);
        hash = 19 * hash + Objects.hashCode(this.movingDate);
        hash = 19 * hash + Objects.hashCode(this.shopRequestSituation);
        hash = 19 * hash + Objects.hashCode(this.neighborhood);
        hash = 19 * hash + Objects.hashCode(this.city);
        hash = 19 * hash + Objects.hashCode(this.days);
        hash = 19 * hash + Objects.hashCode(this.products);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SalesOrder other = (SalesOrder) obj;
        if (!Objects.equals(this.trade, other.trade)) {
            return false;
        }
        if (!Objects.equals(this.clientName, other.clientName)) {
            return false;
        }
        if (!Objects.equals(this.shopRequestSituation, other.shopRequestSituation)) {
            return false;
        }
        if (!Objects.equals(this.neighborhood, other.neighborhood)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.idSalesOrder, other.idSalesOrder)) {
            return false;
        }
        if (!Objects.equals(this.branchNumber, other.branchNumber)) {
            return false;
        }
        if (!Objects.equals(this.movingDate, other.movingDate)) {
            return false;
        }
        if (!Objects.equals(this.days, other.days)) {
            return false;
        }
        if (!Objects.equals(this.products, other.products)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SalesOrder{" + "idSalesOrder=" + idSalesOrder + ", branchNumber=" + branchNumber + ", trade=" + trade + ", clientName=" + clientName + ", movingDate=" + movingDate + ", shopRequestSituation=" + shopRequestSituation + ", neighborhood=" + neighborhood + ", city=" + city + ", days=" + days + ", products=" + products + '}';
    }    
   
}
