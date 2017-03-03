package kr.co.easybook.chart;

import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chart")
public class ChartController {
	@RequestMapping("/pieChart.do")
	public void drawPieChart(HttpServletResponse response) {
		response.setContentType("image/png; charset=utf-8");
		PieDataset pdSet = createDataSet();
		JFreeChart chart = createChart(pdSet, "Today's Reservation");
		
		try {
			ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 600, 400);
			response.getOutputStream().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private PieDataset createDataSet() {
		DefaultPieDataset dpd = new DefaultPieDataset();
		dpd.setValue("Reservation", 55);
		dpd.setValue("free", 45);
		return dpd;
	}
	
	private JFreeChart createChart(PieDataset pdSet, String chartTitle) {
		JFreeChart chart = ChartFactory.createPieChart3D(chartTitle, pdSet, true, true, false);
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(90);
		plot.setDirection(Rotation.ANTICLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		return chart;
	}
}
