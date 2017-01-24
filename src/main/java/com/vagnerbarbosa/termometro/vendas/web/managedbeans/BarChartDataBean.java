package com.vagnerbarbosa.termometro.vendas.web.managedbeans;

/**
 *
 * @author vagner
 */
import com.vagnerbarbosa.termometro.vendas.web.model.Sales;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.chartistjsf.model.chart.AspectRatio;
import org.chartistjsf.model.chart.Axis;
import org.chartistjsf.model.chart.AxisType;
import org.chartistjsf.model.chart.BarChartModel;
import org.chartistjsf.model.chart.BarChartSeries;

@ManagedBean
@ViewScoped
public class BarChartDataBean implements Serializable {

    private BarChartModel barChartModel;
    
    List<Sales> vendas = new ArrayList<>();

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

    public List<Sales> getVendas() throws IOException {
        this.vendas = (List<Sales>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("salesList");
        return vendas;
    }

}
