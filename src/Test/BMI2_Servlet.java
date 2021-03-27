package Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BMI2_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收参数
        String strName=request.getParameter("name");
        String strWeight=request.getParameter("weight");
        String strHeight=request.getParameter("height");

        //计算bmi
        float height=Float.valueOf(strHeight);
        float weight=Float.valueOf(strWeight);
        float bmi=weight/(height*height);

        //判断范围进行输出
        String msg="";
        if (bmi<=18.5){
            msg="偏瘦";
        }else if (bmi>18.5&&bmi<23.9){
            msg="正常";
        }else if (bmi>24&&bmi<=27){
            msg="肥胖";
        }
        msg="bmi值为："+bmi+","+"体型属于："+msg;
        //使用HttpServletResponse响应对象进行输出
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw=response.getWriter();
        //输出数据
        pw.print(msg);
        pw.print("好的");
        //清空缓存
        pw.flush();
        //关闭输出流
        pw.close();
    }
}
