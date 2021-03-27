package Test;

import Dao.Province_Dao;
import Entity.Province;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class queryJson_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //默认值，{}：表示json格式数据
        String json="{}";
        //获取请求参数，省份id
        String strProId=request.getParameter("proId");
        System.out.println(strProId);
        //判断proid有值时，调用dao进行查询
        if (strProId!=null&&strProId.trim().length()>0){
            Province_Dao dao=new Province_Dao();
            Integer proId=Integer.valueOf(strProId);
            Province province=dao.queryProvinceById(proId,request);
            //需要使用jackson把Province对象转化为json
            ObjectMapper om=new ObjectMapper();
            json=om.writeValueAsString(province);
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw=response.getWriter();
        pw.println(json);
        //pw.println("测试成功...");
        pw.flush();
        pw.close();
    }
}
