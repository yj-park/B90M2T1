package kr.co.easybook.chart;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.easybook.book.service.BookService;

@Controller
@RequestMapping("/chart")
public class ChartController {
	@Autowired
	BookService bookService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	@RequestMapping("/totalChart.do")
	public void totalPieChart(HttpServletResponse response) {
		response.setContentType("image/png; charset=utf-8");
		PieDataset pdSet = createTotalDataSet();
		JFreeChart chart = createChart(pdSet, "Booking rate for daily");
		
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
		JFreeChart chart = createChart(pdSet, "Booking rate for Room");
		
		try {
			ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 600, 400);
			response.getOutputStream().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private PieDataset createTotalDataSet() {
		String toDay = sdf.format(new Date());
		System.out.println("total" + toDay);
		Map<String, Object> map = bookService.retriveBookData(toDay);
		DefaultPieDataset dpd = new DefaultPieDataset();
		dpd.setValue("Booking", (int)map.get("total"));
		dpd.setValue("free", 98 - (int)map.get("total"));
		return dpd;
	}
	private PieDataset createRoomDataSet() {
		String toDay = sdf.format(new Date());
		System.out.println("room" + toDay);
		Map<String, Object> map = bookService.retriveBookData(toDay);
		DefaultPieDataset dpd = new DefaultPieDataset();
		dpd.setValue("a", (int)map.get("a"));
		dpd.setValue("b", (int)map.get("b"));
		dpd.setValue("c", (int)map.get("c"));
		dpd.setValue("d", (int)map.get("d"));
		dpd.setValue("e", (int)map.get("e"));
		dpd.setValue("f", (int)map.get("f"));
		dpd.setValue("g", (int)map.get("g"));
		return dpd;
	}
	private JFreeChart createChart(PieDataset pdSet, String chartTitle) {
		JFreeChart chart = ChartFactory.createPieChart(chartTitle, pdSet, true, true, false);
		return chart;
	}
}
