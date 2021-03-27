package Test;

import Dao.Province_Dao;
import Entity.Province;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class queryProvince_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strProId=request.getParameter("proId");
        System.out.println("strProId:"+strProId);
        String name="默认是无数据";
        //通过访问dao,将id参数进行传递，此时可以获得name
        if (strProId!=null&&!"".equals(strProId.trim())){
            //创建Dao对象，调用它的方法
            Province_Dao dao=new Province_Dao();
            Integer ProId=Integer.valueOf(strProId);
            name=dao.queryProvinceNameById(ProId,request);
        }
        //使用HttpServletResponse输出数据
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw=response.getWriter();
        //pw.println("测试成功...");
        pw.println(name);
        pw.flush();
        pw.close();
    }
}
