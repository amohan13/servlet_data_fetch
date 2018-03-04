package com.trainning;

import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class ShowFavourite
 */
@WebServlet("/ShowFavourite")
public class ShowFavourite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JSONParser parser = new JSONParser();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFavourite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject cityname=new JSONObject();
		try {
			cityname = (JSONObject) parser.parse(new FileReader("//home//anand//Documents//workspace-sts-3.9.2.RELEASE//jee//weather24//src//com//trainning//result.json"));
			System.out.println(cityname);
			response.setContentType("application/json");
			response.getWriter().write(cityname.toString());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
