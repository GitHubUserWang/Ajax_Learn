package com.ajax.controller;

import net.minidev.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
//BmiAjax
@WebServlet(name = "BmiAjaxServlet", value = "/")
public class BmiAjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //使用HttpServletResponses输出数据(应答对象)
        response.setContentType("text/html;charset=utf-8");//输出数据格式

        PrintWriter pw=response.getWriter();

        String name=request.getParameter("name");
        String weight=request.getParameter("weight");
        String height=request.getParameter("height");

        //计算bmi bmi=体重/身高平方
        float h=Float.valueOf(height);
        float w=Float.valueOf(weight);

        float bmi=w/(h*h);

        //判断bmi范围
        String msg="";
        String msg1="";
        if(bmi<18.5){
            msg="体重过轻";
        }else if(bmi>=18.5&&bmi<=23.9){
            msg="体重正常！";
        }else if(bmi>23.9&&bmi<=27){
            msg="体重偏重";
        }else{
            msg="超重";
        }

        JSONObject jsonObj=new JSONObject();
        Map<String, String> data = new HashMap<String, String>();
        data.put("name", name);
        data.put("bmi", String.valueOf(bmi));
        data.put("msg", msg);
        jsonObj.put("data", data);
        System.out.println(jsonObj);


        msg1="{'name':'"+name+"','bmi':'"+bmi+"','msg':'"+msg+"'}";
        System.out.println(msg1);



        msg="您好："+name+"先生/女士,您的bmi指数为："+bmi+","+msg;



        System.out.println("msg---->"+msg);

        pw.println(msg1);

        //清空缓存,目的是为了让输出的数据立即输出给浏览器
        pw.flush();
        //关闭流？
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
