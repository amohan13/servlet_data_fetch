package com.trainning;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;


/**
 * Servlet implementation class weather
 */
@WebServlet("/weather")
public class weather extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		JSONObject word = new JSONObject();
		try
		{
			word.put("city",request.getParameter("city"));
			System.out.println(word);
		}
		catch (Exception e)
		{ 
		}
try {
			
			FileWriter jsonFileWriter = new FileWriter("/home/sapient/Documents/Jee_Servlet/Weather/src/com/trainning/result.json",true);
			jsonFileWriter.write(word.toString());
			jsonFileWriter.flush();
			jsonFileWriter.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			response.setContentType("application/json");
			response.getWriter().write(word.toString());
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
