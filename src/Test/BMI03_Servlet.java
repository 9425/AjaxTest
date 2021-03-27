package Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BMI03_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("接受了AJAX的请求");
        String strName=request.getParameter("name");
        String strWeight=request.getParameter("weight");
        String strHeight=request.getParameter("height");
        float height=Float.valueOf(strHeight);
        float weight=Float.valueOf(strWeight);
        float bmi=weight/(height*height);
        //判断bmi的范围
        String msg="";
        if (bmi<=18.5){
            msg="偏瘦";
        }else if (bmi>18.5&&bmi<=23.9){
            msg="正常";
        }else if (bmi>24&&bmi<=27){
            msg="比较肥胖";
        }else{
            msg="肥胖";
        }
        msg=strName+"，"+"bmi值为："+bmi+"，属于："+msg;
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw=response.getWriter();
        pw.println(msg);
        pw.flush();
        pw.close();
    }
}
