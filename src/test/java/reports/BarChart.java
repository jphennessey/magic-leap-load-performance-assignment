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
public class BarChart {
    public static void createBarChart(DefaultCategoryDataset barChart) {
        JFreeChart chartObject = ChartFactory.createBarChart(
                "www.magicleap.com Load Time Latency Statistics", "Statistic",
                "Load Time (ms)",
                barChart, PlotOrientation.VERTICAL,
                false, true, false);
        int width = 640;
        int height = 480;
        File barChartFile = new File("output/LoadTimeStats.jpeg");
        try {
            ChartUtilities.saveChartAsJPEG(barChartFile, chartObject, width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
