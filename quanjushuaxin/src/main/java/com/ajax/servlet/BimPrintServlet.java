package com.ajax.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BimPrintServlet", value = "/")
public class BimPrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String weight=request.getParameter("weight");
        String height=request.getParameter("height");

        //计算bmi bmi=体重/身高平方
        float h=Float.valueOf(height);
        float w=Float.valueOf(weight);

        float bmi=w/(h*h);

        //判断bmi范围
        String msg="";
        if(bmi<18.5){
            msg="体重过轻";
        }else if(bmi>=18.5&&bmi<=23.9){
            msg="体重正常！";
        }else if(bmi>23.9&&bmi<=27){
            msg="体重偏重";
        }else{
            msg="超重";
        }


        msg="您好："+name+"先生/女士,您的bmi指数为："+bmi+","+msg;

        System.out.println("msg---->"+msg);

        //使用HttpServletResponses输出数据(应答对象)
        response.setContentType("text/html;charset=utf-8");

        //获取PrintWriter对象
        PrintWriter pw=response.getWriter();

        pw.println(msg);

        //清空缓存,目的是为了让输出的数据立即输出给浏览器
        pw.flush();
        //
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
