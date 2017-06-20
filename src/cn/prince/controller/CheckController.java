package cn.prince.controller;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import cn.prince.pojo.Checktable;
import cn.prince.pojo.Rent;
import cn.prince.service.CarService;
import cn.prince.service.CheckService;
import cn.prince.service.RentService;


@Controller
public class CheckController {
	@Resource
	CheckService checkService;
	@Resource
	RentService rentService;
	@Resource
	CarService carService;
	
	//检查单 插到数据库里面 同时 也代表着还车完成 需要更新出租单里面 汽车的状态
	@RequestMapping(value = "check",produces = "text/plain;charset=UTF-8")
	public void check(HttpServletRequest request, HttpServletResponse response) {
		Date checkdate = Date.valueOf(request.getParameter("checkdate"));
		String problem = request.getParameter("problem");
		String paying = request.getParameter("paying");
		String username = request.getParameter("username");
		int rentid = Integer.parseInt(request.getParameter("rentid"));
		
		//根据售货单id 查询 出售单信息
		Rent rent = rentService.findById(rentid);
		int carid = rent.getCarid();
		
		Checktable checktable = new Checktable(0, checkdate, problem, paying, username, rentid);
		
		int i = checkService.add(checktable);
		
		if(i>0) {
			carService.notRent(carid);
			rentService.updateById(rentid );
		}
		
		try {
			request.getRequestDispatcher("yanche.html").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("checkAll")
	@ResponseBody
	public String checkAll(HttpServletRequest request)  {
		Map map = new HashMap<>();
		List<Checktable> c = checkService.findAll();
		request.getSession().setAttribute("check", c);
		System.out.println("++++++++++++"+c.size());
		
		if(c.size()>0) {
			map.put("flg", "ok");
		}else {
			map.put("flg", "ng");
		}
		
		Gson gson = new Gson();
		String str = gson.toJson(map);
		System.out.println(str);
		return str;
	}
	
//	@RequestMapping("text")
//	public String text(HttpServletResponse response) {
//		DefaultCategoryDataset dataTime = new DefaultCategoryDataset();  
//        // 这是一组数据  
//        dataTime.addValue(52, "0-6", "2010-1-1");  
//        dataTime.addValue(86, "6-12", "2010-1-1");  
//        dataTime.addValue(126, "12-18", "2010-1-1");  
//        dataTime.addValue(42, "18-24", "2010-1-1");  
//        // 这是一组数据  
//        dataTime.addValue(452, "0-6", "2010-1-2");  
//        dataTime.addValue(96, "6-12", "2010-1-2");  
//        dataTime.addValue(254, "12-18", "2010-1-2");  
//        dataTime.addValue(126, "18-24", "2010-1-2");  
//        // 这是一组数据  
//        dataTime.addValue(256, "0-6", "2010-1-3");  
//        dataTime.addValue(86, "6-12", "2010-1-3");  
//        dataTime.addValue(365, "12-18", "2010-1-3");  
//        dataTime.addValue(24, "18-24", "2010-1-3");  
//        try {  
//            DefaultCategoryDataset data = dataTime;  
//            // 使用ChartFactory创建3D柱状图，不想使用3D，直接使用createBarChart  
//            JFreeChart chart = ChartFactory.createBarChart3D(  
//                    "网站时间段访问量统计",   
//                    "时间",   
//                    "访问量",   
//                    data,  
//                    PlotOrientation.VERTICAL,   
//                    true,   
//                    false,   
//                    false  
//            );  
//            // 设置整个图片的背景色  
//            chart.setBackgroundPaint(Color.PINK);  
//            // 设置图片有边框  
//            chart.setBorderVisible(true);  
//            Font kfont = new Font("宋体", Font.PLAIN, 12);    // 底部  
//            Font titleFont = new Font("宋体", Font.BOLD, 25); // 图片标题  
//            // 图片标题  
//            chart.setTitle(new TextTitle(chart.getTitle().getText(), titleFont));  
//            // 底部  
//            chart.getLegend().setItemFont(kfont);  
//            // 得到坐标设置字体解决乱码  
//            CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();  
//            categoryplot.setDomainGridlinesVisible(true);  
//            categoryplot.setRangeCrosshairVisible(true);  
//            categoryplot.setRangeCrosshairPaint(Color.blue);  
//            NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();  
//            numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());  
//            BarRenderer barrenderer = (BarRenderer) categoryplot.getRenderer();  
//            barrenderer.setBaseItemLabelFont(new Font("宋体", Font.PLAIN, 12));  
//            barrenderer.setSeriesItemLabelFont(1, new Font("宋体", Font.PLAIN, 12));  
//            CategoryAxis domainAxis = categoryplot.getDomainAxis();           
//            /*------设置X轴坐标上的文字-----------*/  
//            domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));  
//            /*------设置X轴的标题文字------------*/  
//            domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));  
//            /*------设置Y轴坐标上的文字-----------*/  
//            numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));  
//            /*------设置Y轴的标题文字------------*/  
//            numberaxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));  
//            /*------这句代码解决了底部汉字乱码的问题-----------*/  
//            chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));    
//            ChartUtilities.writeChartAsJPEG(response.getOutputStream(), 1.0f,  
//                    chart, 500, 300, null);  
//        } catch (Exception es) {  
//            es.printStackTrace();  
//        }
//		return "text";  
//	}
//	
}
