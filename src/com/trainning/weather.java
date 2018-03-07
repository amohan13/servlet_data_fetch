package com.trainning;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 * Servlet implementation class weather
 */
@WebServlet("/weather")
public class weather extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int count=0;
	JSONArray  cities = new JSONArray();
	JSONObject  list = new JSONObject();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hellooooobhai");
		cities.add(count++,request.getParameter("city"));
		list.put("city",cities);
	
	try {
		
		FileWriter jsonFileWriter = new FileWriter("/home/sapient/Documents/Jee_Servlet/weather_project/src/com/trainning/result.json");
		jsonFileWriter.write(list.toString());
		jsonFileWriter.flush();
		jsonFileWriter.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		
		response.setContentType("application/json");
		response.getWriter().write(cities.toString());
	}		
	
}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
