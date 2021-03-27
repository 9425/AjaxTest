package Dao;

import Entity.Province;
import Util.JavaUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Province_Dao {
    private JavaUtil javaUtil=new JavaUtil();
    //根据省份id进行省份名称查询
    public String queryProvinceNameById(Integer provinceId, HttpServletRequest request){
        //使用传递request的方法不用再次创建通道了，因为已经提前创建好了
        String name="";
        String sql="select  name from province where id=?";
        PreparedStatement ps=javaUtil.getStatement(sql,request);
        //设置参数值
        try {
            ps.setInt(1,provinceId);
            ResultSet rs=ps.executeQuery();
            //因此仅查询一个id,此时数组里面只有一个值，此时可以不用循环进行遍历，使用
            //if进行判断即可
            if (rs.next()){
                name=rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            javaUtil.close(request);
        }
        return name;
    }
    //获取一个完整的province进行返回
    public Province queryProvinceById(Integer provinceId,HttpServletRequest request){
        Province province=new Province();
        String sql="select * from province where id=?";
        PreparedStatement ps=javaUtil.getStatement(sql,request);
        //设置参数的值
        try {
            ps.setInt(1,provinceId);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){//当rs中有不止一条记录时就不能用if进行判断，像前面所写的
                //查询所有的内容时，因为内容条数过多，要全部取出，只能用循环判断
                province.setId(rs.getInt("id"));
                province.setName(rs.getString("name"));
                province.setJianCheng(rs.getString("jiancheng"));
                province.setShengHui(rs.getString("shenghui"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            javaUtil.close(request);
        }
        return province;
    }
}
  /* public List findAll(HttpServletRequest request){
       String sql="select * from question";
       PreparedStatement ps=javaUtil.getStatement(sql,request);
       ResultSet rs;
       List list=new ArrayList();
       try {
           rs= ps.executeQuery();
           while (rs.next()){
               Integer questionId=rs.getInt("questionId");
               String title=rs.getString("title");
               String optionA=rs.getString("optionA");
               String optionB=rs.getString("optionB");
               String optionC=rs.getString("optionC");
               String optionD=rs.getString("optionD");
               String answer=rs.getString("answer");
               Question question=new Question(questionId,title,optionA,optionB,optionC,optionD,answer);
               list.add(question);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           javaUtil.close(request);
       }
       return list;
   }*/