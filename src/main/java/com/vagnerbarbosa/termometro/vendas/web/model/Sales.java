package com.vagnerbarbosa.termometro.vendas.web.model;

import java.util.Objects;

/**
 *
 * @author vagner
 */
public class Sales implements Comparable<Sales> {

    private Integer branchId; //idFilial

    private Integer branchNumber; // numeroFilial

    private String trade; // fantasi

    //Produtos 
    private Double prodSaleTotal; //PRODUT BRUTO

    private Double prodDevolutionTotal; ////DEV PRODU

    private Double prodBalanceTotal; //PROD LIQU    

    //Serviços 
    private Double servSaleTotal; //sg_totalitem 

    private Double servDevolutionTotal; //sg_devolucao

    private Double servBalanceTotal; ////SERVIÇO LIQ

    private Double rechargeTotal; //REG

    //Total Líquido
    private Double balanceTotal; //LIQUI_TOTAL      

    /**
     *
     */
    public Sales() {
    }

    /**
     *
     * @return
     */
    public Integer getBranchId() {
        return branchId;
    }

    /**
     *
     * @param branchId
     */
    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    /**
     *
     * @return
     */
    public Integer getBranchNumber() {
        return branchNumber;
    }

    /**
     *
     * @param branchNumber
     */
    public void setBranchNumber(Integer branchNumber) {
        this.branchNumber = branchNumber;
    }

    /**
     *
     * @return
     */
    public String getTrade() {
        return trade;
    }

    /**
     *
     * @param trade
     */
    public void setTrade(String trade) {
        this.trade = trade;
    }

    /**
     *
     * @return
     */
    public Double getProdSaleTotal() {
        return prodSaleTotal;
    }

    /**
     *
     * @param prodSaleTotal
     */
    public void setProdSaleTotal(Double prodSaleTotal) {
        this.prodSaleTotal = prodSaleTotal;
    }

    /**
     *
     * @return
     */
    public Double getProdDevolutionTotal() {
        return prodDevolutionTotal;
    }

    /**
     *
     * @param prodDevolutionTotal
     */
    public void setProdDevolutionTotal(Double prodDevolutionTotal) {
        this.prodDevolutionTotal = prodDevolutionTotal;
    }

    /**
     *
     * @return
     */
    public Double getProdBalanceTotal() {
        return prodBalanceTotal;
    }

    /**
     *
     * @param prodBalanceTotal
     */
    public void setProdBalanceTotal(Double prodBalanceTotal) {
        this.prodBalanceTotal = prodBalanceTotal;
    }

    /**
     *
     * @return
     */
    public Double getServSaleTotal() {
        return servSaleTotal;
    }

    /**
     *
     * @param servSaleTotal
     */
    public void setServSaleTotal(Double servSaleTotal) {
        this.servSaleTotal = servSaleTotal;
    }

    /**
     *
     * @return
     */
    public Double getServDevolutionTotal() {
        return servDevolutionTotal;
    }

    /**
     *
     * @param servDevolutionTotal
     */
    public void setServDevolutionTotal(Double servDevolutionTotal) {
        this.servDevolutionTotal = servDevolutionTotal;
    }

    /**
     *
     * @return
     */
    public Double getServBalanceTotal() {
        return servBalanceTotal;
    }

    /**
     *
     * @param servBalanceTotal
     */
    public void setServBalanceTotal(Double servBalanceTotal) {
        this.servBalanceTotal = servBalanceTotal;
    }

    /**
     *
     * @return
     */
    public Double getRechargeTotal() {
        return rechargeTotal;
    }

    /**
     *
     * @param rechargeTotal
     */
    public void setRechargeTotal(Double rechargeTotal) {
        this.rechargeTotal = rechargeTotal;
    }

    public Double getBalanceTotal() {
        return balanceTotal;
    }

    public void setBalanceTotal(Double balanceTotal) {
        this.balanceTotal = balanceTotal;
    }

    @Override
    public String toString() {
        return "Sales{" + "branchId=" + branchId + ", branchNumber=" + branchNumber + ", trade=" + trade + ", prodSaleTotal=" + prodSaleTotal + ", prodDevolutionTotal=" + prodDevolutionTotal + ", prodBalanceTotal=" + prodBalanceTotal + ", balanceTotal=" + balanceTotal + ", servSaleTotal=" + servSaleTotal + ", servDevolutionTotal=" + servDevolutionTotal + ", servBalanceTotal=" + servBalanceTotal + ", servAverageTicket=" + rechargeTotal + '}';
    }

    @Override
    public int compareTo(Sales sales) {
        if (this.balanceTotal < sales.balanceTotal) {
            return 1;
        }
        if (this.balanceTotal > sales.balanceTotal) {
            return -1;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.branchId);
        hash = 31 * hash + Objects.hashCode(this.branchNumber);
        hash = 31 * hash + Objects.hashCode(this.trade);
        hash = 31 * hash + Objects.hashCode(this.prodSaleTotal);
        hash = 31 * hash + Objects.hashCode(this.prodDevolutionTotal);
        hash = 31 * hash + Objects.hashCode(this.prodBalanceTotal);
        hash = 31 * hash + Objects.hashCode(this.servSaleTotal);
        hash = 31 * hash + Objects.hashCode(this.servDevolutionTotal);
        hash = 31 * hash + Objects.hashCode(this.servBalanceTotal);
        hash = 31 * hash + Objects.hashCode(this.rechargeTotal);
        hash = 31 * hash + Objects.hashCode(this.balanceTotal);
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
        final Sales other = (Sales) obj;
        if (!Objects.equals(this.trade, other.trade)) {
            return false;
        }
        if (!Objects.equals(this.branchId, other.branchId)) {
            return false;
        }
        if (!Objects.equals(this.branchNumber, other.branchNumber)) {
            return false;
        }
        if (!Objects.equals(this.prodSaleTotal, other.prodSaleTotal)) {
            return false;
        }
        if (!Objects.equals(this.prodDevolutionTotal, other.prodDevolutionTotal)) {
            return false;
        }
        if (!Objects.equals(this.prodBalanceTotal, other.prodBalanceTotal)) {
            return false;
        }
        if (!Objects.equals(this.servSaleTotal, other.servSaleTotal)) {
            return false;
        }
        if (!Objects.equals(this.servDevolutionTotal, other.servDevolutionTotal)) {
            return false;
        }
        if (!Objects.equals(this.servBalanceTotal, other.servBalanceTotal)) {
            return false;
        }
        if (!Objects.equals(this.rechargeTotal, other.rechargeTotal)) {
            return false;
        }
        if (!Objects.equals(this.balanceTotal, other.balanceTotal)) {
            return false;
        }
        return true;
    }
    
}
