package com.vagnerbarbosa.termometro.vendas.web.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author vagner
 */
public class Product implements Serializable {

    private BigInteger itemBaseId;
    private Integer prodId; //idproduto   
    private Integer branchNumberToInvoice; //filialreserva  
    private String prodDescription; //desc__prod
    private Integer amount; //quantidade
    private String itemSituation; //situacao_item
    private String deliver; //entregar
    private Integer idChargerMap; //idmapacarga
    private String situationChargerMap; //situacaomapacarga
    private Date invoicePredictionDate; //previsaofaturamento  
    private String deliverSituation; //situacao__entrega
    private String montage; //montagem 
    private Integer idMontageMap; //idmapamontagem  
    private Date predictionMontageDate; //previsoamontagem  
    private String montageSituation; //situacaomontagem
    private String idDeliverySituation; //idsituacaoentrega  
    private String idMontageSituation; //idsituacaomontagem
    private Integer idSaleOrder;

    public BigInteger getItemBaseId() {
        return itemBaseId;
    }

    public void setItemBaseId(BigInteger itemBaseId) {
        this.itemBaseId = itemBaseId;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getBranchNumberToInvoice() {
        return branchNumberToInvoice;
    }

    public void setBranchNumberToInvoice(Integer branchNumberToInvoice) {
        this.branchNumberToInvoice = branchNumberToInvoice;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getItemSituation() {
        return itemSituation;
    }

    public void setItemSituation(String itemSituation) {
        this.itemSituation = itemSituation;
    }    

    public String getDeliver() {
        return deliver;
    }

    public void setDeliver(String deliver) {
        this.deliver = deliver;
    }

    public Integer getIdChargerMap() {
        return idChargerMap;
    }

    public void setIdChargerMap(Integer idChargerMap) {
        this.idChargerMap = idChargerMap;
    }

    public String getSituationChargerMap() {
        return situationChargerMap;
    }

    public void setSituationChargerMap(String situationChargerMap) {
        this.situationChargerMap = situationChargerMap;
    }

    public Date getInvoicePredictionDate() {
        return invoicePredictionDate;
    }

    public void setInvoicePredictionDate(Date invoicePredictionDate) {
        this.invoicePredictionDate = invoicePredictionDate;
    }

    public String getDeliverSituation() {
        return deliverSituation;
    }

    public void setDeliverSituation(String deliverSituation) {
        this.deliverSituation = deliverSituation;
    }

    public String getMontage() {
        return montage;
    }

    public void setMontage(String montage) {
        this.montage = montage;
    }

    public Integer getIdMontageMap() {
        return idMontageMap;
    }

    public void setIdMontageMap(Integer idMontageMap) {
        this.idMontageMap = idMontageMap;
    }

    public Date getPredictionMontageDate() {
        return predictionMontageDate;
    }

    public void setPredictionMontageDate(Date predictionMontageDate) {
        this.predictionMontageDate = predictionMontageDate;
    }

    public String getMontageSituation() {
        return montageSituation;
    }

    public void setMontageSituation(String montageSituation) {
        this.montageSituation = montageSituation;
    }

    public String getIdDeliverySituation() {
        return idDeliverySituation;
    }

    public void setIdDeliverySituation(String idDeliverySituation) {
        this.idDeliverySituation = idDeliverySituation;
    }

    public String getIdMontageSituation() {
        return idMontageSituation;
    }

    public void setIdMontageSituation(String idMontageSituation) {
        this.idMontageSituation = idMontageSituation;
    }

    public Integer getIdSaleOrder() {
        return idSaleOrder;
    }

    public void setIdSaleOrder(Integer idSaleOrder) {
        this.idSaleOrder = idSaleOrder;
    }

    @Override
    public String toString() {
        return "Product{" + "itemBaseId=" + itemBaseId + ", prodId=" + prodId + ", branchNumberToInvoice=" + branchNumberToInvoice + ", prodDescription=" + prodDescription + ", amount=" + amount + ", itemSituation=" + itemSituation + ", deliver=" + deliver + ", idChargerMap=" + idChargerMap + ", situationChargerMap=" + situationChargerMap + ", invoicePredictionDate=" + invoicePredictionDate + ", deliverSituation=" + deliverSituation + ", montage=" + montage + ", idMontageMap=" + idMontageMap + ", predictionMontageDate=" + predictionMontageDate + ", montageSituation=" + montageSituation + ", idDeliverySituation=" + idDeliverySituation + ", idMontageSituation=" + idMontageSituation + ", idSaleOrder=" + idSaleOrder + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.itemBaseId);
        hash = 83 * hash + Objects.hashCode(this.prodId);
        hash = 83 * hash + Objects.hashCode(this.branchNumberToInvoice);
        hash = 83 * hash + Objects.hashCode(this.prodDescription);
        hash = 83 * hash + Objects.hashCode(this.amount);
        hash = 83 * hash + Objects.hashCode(this.itemSituation);
        hash = 83 * hash + Objects.hashCode(this.deliver);
        hash = 83 * hash + Objects.hashCode(this.idChargerMap);
        hash = 83 * hash + Objects.hashCode(this.situationChargerMap);
        hash = 83 * hash + Objects.hashCode(this.invoicePredictionDate);
        hash = 83 * hash + Objects.hashCode(this.deliverSituation);
        hash = 83 * hash + Objects.hashCode(this.montage);
        hash = 83 * hash + Objects.hashCode(this.idMontageMap);
        hash = 83 * hash + Objects.hashCode(this.predictionMontageDate);
        hash = 83 * hash + Objects.hashCode(this.montageSituation);
        hash = 83 * hash + Objects.hashCode(this.idDeliverySituation);
        hash = 83 * hash + Objects.hashCode(this.idMontageSituation);
        hash = 83 * hash + Objects.hashCode(this.idSaleOrder);
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
        final Product other = (Product) obj;
        if (!Objects.equals(this.prodDescription, other.prodDescription)) {
            return false;
        }
        if (!Objects.equals(this.itemSituation, other.itemSituation)) {
            return false;
        }
        if (!Objects.equals(this.deliver, other.deliver)) {
            return false;
        }
        if (!Objects.equals(this.situationChargerMap, other.situationChargerMap)) {
            return false;
        }
        if (!Objects.equals(this.deliverSituation, other.deliverSituation)) {
            return false;
        }
        if (!Objects.equals(this.montage, other.montage)) {
            return false;
        }
        if (!Objects.equals(this.montageSituation, other.montageSituation)) {
            return false;
        }
        if (!Objects.equals(this.idDeliverySituation, other.idDeliverySituation)) {
            return false;
        }
        if (!Objects.equals(this.idMontageSituation, other.idMontageSituation)) {
            return false;
        }
        if (!Objects.equals(this.itemBaseId, other.itemBaseId)) {
            return false;
        }
        if (!Objects.equals(this.prodId, other.prodId)) {
            return false;
        }
        if (!Objects.equals(this.branchNumberToInvoice, other.branchNumberToInvoice)) {
            return false;
        }
        if (!Objects.equals(this.amount, other.amount)) {
            return false;
        }
        if (!Objects.equals(this.idChargerMap, other.idChargerMap)) {
            return false;
        }
        if (!Objects.equals(this.invoicePredictionDate, other.invoicePredictionDate)) {
            return false;
        }
        if (!Objects.equals(this.idMontageMap, other.idMontageMap)) {
            return false;
        }
        if (!Objects.equals(this.predictionMontageDate, other.predictionMontageDate)) {
            return false;
        }
        if (!Objects.equals(this.idSaleOrder, other.idSaleOrder)) {
            return false;
        }
        return true;
    }
   
}
