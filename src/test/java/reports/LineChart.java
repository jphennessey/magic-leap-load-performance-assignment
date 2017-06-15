package reports;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;

/**
 * Created by josephhennessey on 6/14/17.
 */
public class LineChart {
    public static void createLineChart(DefaultCategoryDataset lineChart) {
        JFreeChart chartObject = ChartFactory.createLineChart(
                "www.magicleap.com Load Time Latency", "Load Number",
                "Load Time (ms)",
                lineChart, PlotOrientation.HORIZONTAL,
                true, true, false);
        int width = 900;
        int height = 1300;
        File lineChart1 = new File("output/LoadTimePlot.jpeg");
        try {
            ChartUtilities.saveChartAsJPEG(lineChart1, chartObject, width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
