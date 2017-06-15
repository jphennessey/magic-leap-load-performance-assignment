import browsers.Chrome;
import com.google.common.base.Stopwatch;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import waits.ExplicitWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static reports.BarChart.createBarChart;
import static reports.LineChart.createLineChart;


/**
 * Created by josephhennessey on 6/14/17.
 */
public class HompageTest {

    @Test
    public void testRepeatedLoads() {
        long totalTime = 0;
        long minTime = 99999;
        long maxTime = 0;
        int iterations = 100;

        DefaultCategoryDataset lineChart = new DefaultCategoryDataset();
        Stopwatch stopwatch = Stopwatch.createUnstarted();
        for (int i = 1; i <= iterations; i++) {
            WebDriver driver = Chrome.createDriver();

            stopwatch.start();
            driver.get("https://www.magicleap.com");
            ExplicitWait.waitForAllToLoad(driver);
            stopwatch.stop();

            long loadTime = stopwatch.elapsed(TimeUnit.MILLISECONDS);
            lineChart.addValue(loadTime, "Load Time", String.valueOf(i));
            totalTime += loadTime;
            if (loadTime > maxTime) {
                maxTime = loadTime;
            }
            if (loadTime < minTime) {
                minTime = loadTime;
            }
            stopwatch.reset();
            driver.quit();
        }
        createLineChart(lineChart);

        long avgTime = totalTime / iterations;
        System.out.println("Min time = " + minTime);
        System.out.println("Max time = " + maxTime);
        System.out.println("Average time = " + avgTime);
        DefaultCategoryDataset barChart = new DefaultCategoryDataset();
        barChart.addValue(minTime, "Load Time", "Min Time");
        barChart.addValue(avgTime, "Load Time", "Avg Time");
        barChart.addValue(maxTime, "Load Time", "Max Time");
        createBarChart(barChart);
    }
}
