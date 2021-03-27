package Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BMI_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收浏览器传递的参数
        String strName=request.getParameter("name");
        String strWeight=request.getParameter("weight");
        String strHeight=request.getParameter("height");

        //计算BMI:BMI=体重/身高的平方
        float height=Float.valueOf(strHeight);
        float weight=Float.valueOf(strWeight);
        float bmi=weight/(height*height);

        //判断BMI的值并进行输出
        //表示要输出的内容为一个字符串，当下面出现异常时，仍然可以进行输出
        String msg="";
        if (bmi<=18.5){
            msg="偏瘦";
        }else if (bmi>18.5&&bmi<=23.9){
            msg="正常";
        }else if (bmi>24&&bmi<=27){
            msg="肥胖";
        }
        msg="bmi值为："+bmi+","+"属于"+msg;

        //将数据存储到请求作用域
        request.setAttribute("msg",msg);

        //请求转发进行输出
        request.getRequestDispatcher("/AJAX01_Reslut.jsp").forward(request,response);
    }
}
