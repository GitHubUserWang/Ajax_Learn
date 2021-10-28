package com.ajax.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BmiServlet", value = "/")   //又一次踩坑
public class BmiServlet extends HttpServlet {
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

        System.out.println("msg="+msg);

        msg="您好："+name+"先生/女士,您的bmi指数为："+bmi+","+msg;

        //把数据存入request
        request.setAttribute("msg",msg);

        //转发到新页面
        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
