package cn.prince.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.prince.pojo.Car;
import jxl.Sheet;
import jxl.Workbook;

public class Excle {
	public static List<Car> getAllByExcel(String file){
        List<Car> list=new ArrayList<Car>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet("Test Shee 1");//或者rwb.getSheet(0)
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行
            
            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    String id=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String name=rs.getCell(j++, i).getContents();
                    String sex=rs.getCell(j++, i).getContents();
                    String num=rs.getCell(j++, i).getContents();
                    
                    System.out.println("id:"+id+" name:"+name+" sex:"+sex+" num:"+num);
                    list.add(new Car());
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return list;
        
    }
}
