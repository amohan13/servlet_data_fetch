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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public weather() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hellooooobhai");
		cities.add(count++,request.getParameter("city"));
		list.put("city",cities);
	
	try {
		
		FileWriter jsonFileWriter = new FileWriter("/home/anand/Documents/workspace-sts-3.9.2.RELEASE/jee/weather24/src/com/trainning/result.json");
		jsonFileWriter.write(list.toString());
		jsonFileWriter.flush();
		jsonFileWriter.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	} 		
	response.setContentType("application/json");
	response.getWriter().write(cities.toString());
}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
