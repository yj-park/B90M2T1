package kr.co.easybook.chart;

import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chart")
public class ChartController {
	@RequestMapping("/totalChart.do")
	public void totalPieChart(HttpServletResponse response) {
		response.setContentType("image/png; charset=utf-8");
		PieDataset pdSet = createTotalDataSet();
		JFreeChart chart = createChart2(pdSet, "Booking rate");
		
		try {
			ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 600, 400);
			response.getOutputStream().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/roomChart.do")
	public void roomPieChart(HttpServletResponse response) {
		response.setContentType("image/png; charset=utf-8");
		PieDataset pdSet = createRoomDataSet();
		JFreeChart chart = createChart2(pdSet, "Booking rate for Room");
		
		try {
			ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 600, 400);
			response.getOutputStream().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private PieDataset createTotalDataSet() {
		DefaultPieDataset dpd = new DefaultPieDataset();
		dpd.setValue("Booking", 55);
		dpd.setValue("free", 45);
		return dpd;
	}
	private PieDataset createRoomDataSet() {
		DefaultPieDataset dpd = new DefaultPieDataset();
		dpd.setValue("A", 15);
		dpd.setValue("B", 5);
		dpd.setValue("C", 9);
		dpd.setValue("D", 10);
		dpd.setValue("E", 12);
		dpd.setValue("F", 20);
		dpd.setValue("G", 19);
		return dpd;
	}
	private JFreeChart createChart2(PieDataset pdSet, String chartTitle) {
		JFreeChart chart = ChartFactory.createPieChart(chartTitle, pdSet, true, true, false);
		Plot plot = chart.getPlot();
		return chart;
	}
}
