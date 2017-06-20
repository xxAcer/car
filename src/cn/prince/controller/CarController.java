package cn.prince.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import cn.prince.pojo.Car;
import cn.prince.service.CarService;
import cn.prince.utils.PageBean;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

@Controller
public class CarController {

	@Resource
	CarService carService;

	// 查询全部的汽车信息 并分页
	@RequestMapping("car")
	@ResponseBody
	public void car(Car car, HttpServletRequest request, HttpServletResponse response) {
		Map map = new HashMap<>();

		int index = 1;
		String sindex = request.getParameter("index");// null
		if (sindex != null && !"".equals(sindex)) {
			index = Integer.parseInt(sindex);
		}

		int size = 5;
		String ssize = request.getParameter("size");// null
		if (ssize != null && !"".equals(ssize)) {
			size = Integer.parseInt(ssize);
		}

		PageBean pageBean = new PageBean<Car>();
		pageBean.setIndex(index);
		pageBean.setSize(size);

		carService.findAll(pageBean);

		request.getSession().setAttribute("pageBean", pageBean);

		System.out.println("pagedaxiao++++++++" + pageBean.getSize());

		// List<Car> c = carService.find();
		// request.getSession().setAttribute("car", c);
		// System.out.println("++++++++++++"+c.size());
		//
		// if(c.size()>0) {
		map.put("flg", "ok");
		// }else {
		// map.put("flg", "ng");
		// }

		// Gson gson = new Gson();
		// String str = gson.toJson(map);
		// System.out.println(str);
		try {
			request.getRequestDispatcher("form-guide.html").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return "form-guide";

	}

	// 查询全部的汽车信息 并分页
	@RequestMapping("allCar")
	@ResponseBody
	public void allcar(Car car, HttpServletRequest request, HttpServletResponse response) {
		Map map = new HashMap<>();

		int index = 1;
		String sindex = request.getParameter("index");// null
		if (sindex != null && !"".equals(sindex)) {
			index = Integer.parseInt(sindex);
		}

		int size = 5;
		String ssize = request.getParameter("size");// null
		if (ssize != null && !"".equals(ssize)) {
			size = Integer.parseInt(ssize);
		}

		PageBean pageBean = new PageBean<Car>();
		pageBean.setIndex(index);
		pageBean.setSize(size);

		carService.findAll(pageBean);

		request.getSession().setAttribute("pageBean", pageBean);

		System.out.println("pagedaxiao++++++++" + pageBean.getSize());

		// List<Car> c = carService.find();
		// request.getSession().setAttribute("car", c);
		// System.out.println("++++++++++++"+c.size());
		//
		// if(c.size()>0) {
		map.put("flg", "ok");
		// }else {
		// map.put("flg", "ng");
		// }

//		 Gson gson = new Gson();
//		 String str = gson.toJson(map);
		// System.out.println(str);
		try {
			request.getRequestDispatcher("form-guide2.html").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		 return "str";
		
		
		
		

	}
	
	@RequestMapping("addCars")
	@ResponseBody
	public String addCar(HttpServletRequest request) {
		Map map = new HashMap<>();
		Integer id = 0;

		String cartype = request.getParameter("cartype");
		String color = request.getParameter("color");
		String price = request.getParameter("price");
		String rentprice = request.getParameter("rentprice");
		String deposit = request.getParameter("deposit");
		String description = request.getParameter("description");

		Car car = new Car(0, cartype, color, price, rentprice, deposit, "0", description);

		int i = carService.addCar(car);

		if (i > 0) {
			map.put("flg", "ok");
		} else {
			map.put("flg", "ng");
		}
		Gson gson = new Gson();
		String str = gson.toJson(map);
		System.out.println(str);
		return str;
	}
	
	@RequestMapping("removeCar")
	@ResponseBody
	public void removeCars(HttpServletRequest request, HttpServletResponse response) {
		Map map = new HashMap<>();
		Integer id = 0;
		String carnumber = request.getParameter("carnumber");
		if(carnumber != null) {
			id = Integer.parseInt(carnumber);
		}
				
		int i = carService.removeCars(id);

		if (i > 0) {
			map.put("flg", "ok");
		} else {
			map.put("flg", "ng");
		}
		try {
			request.getRequestDispatcher("form-guide2.html").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("findCarByC")
	public String updateCars(HttpServletRequest request) {
		Map map = new HashMap<>();
		Integer id = 0;
		String carnumber = request.getParameter("carnumber");
		if(carnumber != null) {
			id = Integer.parseInt(carnumber);
		}
		Car car = carService.findById(id);
		System.out.println(car);
		request.getSession().setAttribute("carById", car);
		
		return "updatecar";
	}
	
	@RequestMapping("updateCar")
	@ResponseBody
	public String updateCar(HttpServletRequest request) {
		Map map = new HashMap<>();
		Integer id = 0;
		String carnumber = request.getParameter("carnumber");
		String cartype = request.getParameter("cartype");
		String color = request.getParameter("color");
		String price = request.getParameter("price");
		String rentprice = request.getParameter("rentprice");
		String deposit = request.getParameter("deposit");
		String description = request.getParameter("description");
		if( carnumber != null) {
			id= Integer.parseInt(carnumber);
		}
		Car car = new Car(id, cartype, color, price, rentprice, deposit, "0", description);
		System.out.println("car"+car);
		int i = carService.updateCar(car);

		if (i > 0) {
			map.put("flg", "ok");
		} else {
			map.put("flg", "ng");
		}
		Gson gson = new Gson();
		String str = gson.toJson(map);
		System.out.println(str);
		return str;
	}
	
	@RequestMapping("excle")
	public String excle() {
		Map map = new HashMap<>();
		map.put("flg", "ok");
		try {
            WritableWorkbook wwb = null;
             
               // 创建可写入的Excel工作簿
               String fileName = "E://book.xls";
               File file=new File(fileName);
               if (!file.exists()) {
                   file.createNewFile();
               }
               //以fileName为文件名来创建一个Workbook
               wwb = Workbook.createWorkbook(file);

               // 创建工作表
               WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
               
               //查询数据库中所有的数据
               List<Car> list= carService.find();
               //要插入到的Excel表格的行号，默认从0开始
               Label labelId= new Label(0, 0, "车号");//表示第
               Label labelName= new Label(1, 0, "类型");
               Label labelSex= new Label(2, 0, "颜色");
               Label labelNum= new Label(3, 0, "价值");
               Label labelNum1= new Label(4, 0, "租金");
               Label labelNum2= new Label(5, 0, "押金");
               Label labelNum3= new Label(6, 0, "是否出租");
               Label labelNum4= new Label(7, 0, "简介");
               
               ws.addCell(labelId);
               ws.addCell(labelName);
               ws.addCell(labelSex);
               ws.addCell(labelNum);
               ws.addCell(labelNum1);
               ws.addCell(labelNum2);
               ws.addCell(labelNum3);
               ws.addCell(labelNum4);
               for (int i = 0; i < list.size(); i++) {
                   
                   Label carnumber= new Label(0, i+1, list.get(i).getCarnumber()+"");
                   Label cartype= new Label(1, i+1, list.get(i).getCartype());
                   Label color= new Label(2, i+1, list.get(i).getColor());
                   Label price= new Label(3, i+1, list.get(i).getPrice());
                   Label rentprice= new Label(4, i+1, list.get(i).getRentprice());
                   Label deposit= new Label(5, i+1, list.get(i).getDeposit());
                   Label isrenting= new Label(6, i+1, list.get(i).getIsrenting());
                   Label description= new Label(7, i+1, list.get(i).getDescription());
                   ws.addCell(carnumber);
                   ws.addCell(cartype);
                   ws.addCell(color);
                   ws.addCell(price);
                   ws.addCell(rentprice);
                   ws.addCell(deposit);
                   ws.addCell(isrenting);
                   ws.addCell(description);
                   
               }
             
              //写进文档
               wwb.write();
              // 关闭Excel工作簿对象
               wwb.close();
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return "form-guide2";
		
	}
	
	@RequestMapping("excle1")
	public void excle1 () {
		List<Car> listExcel=carService.getAllByExcel("E://book.xls");
        /*//得到数据库表中所有的数据
        List<StuEntity> listDb=StuService.getAllByDb();*/
        for (Car car : listExcel) {
                carService.addCar(car);
        }
	}
	@RequestMapping("fileupload")
	public void upload(MultipartFile file,HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
		String name = file.getOriginalFilename();
		file.transferTo(new File("E:/" + name));
		
		try {
			request.getRequestDispatcher("addCar.html").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("download")
	public String download(HttpServletResponse response) {
		
		try {
			InputStream input = new FileInputStream("E:/book.xls");
			
			// 设置响应头.为文件下载
			response.setContentType("application/octet-stream");
			// 设置响应头参数. 附件名称为 xxx
			response.setHeader("content-disposition", "attchment;filename=book.xls");
			
			// 获取响应输出流,向客户端输出文件内容.
			OutputStream output = response.getOutputStream();
			
			byte[] bytes = new byte[1024];
			int length = 0;
			
			while((length = input.read(bytes)) != -1){
				output.write(bytes, 0, length);
			}
			output.close();
			response.getOutputStream().close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		return "form-guide2";
		
		
		
	}
	

}