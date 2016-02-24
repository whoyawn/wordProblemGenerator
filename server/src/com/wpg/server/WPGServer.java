package com.wpg.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wpg.logic.QuizDriver;
import com.wpg.logic.WebParameters;
 
/**
 * Servlet implementation class WPGServer
 * Luke and Arameh
 */
@WebServlet(description = "WPGServer", urlPatterns = { "/WPGServer" , "/WPGServer.do"}, initParams = {@WebInitParam(name="id",value="1"),@WebInitParam(name="name",value="pankaj")})
public class WPGServer extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final String HTML_START="<html><body>";
    public static final String HTML_END="</body></html>";
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WPGServer() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
        Date date = new Date();
        String text = "test get request";
        out.println(HTML_START + "<h2>Hi There!</h2>" + text + "<br/><h3>Date=" + date +"</h3>"+HTML_END);
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();

    	
    	String names = request.getParameter("names");
		String items = request.getParameter("items");
		String numberOfQuestions = request.getParameter("numberOfQuestions");
		String[] operations = request.getParameterValues("operations[]");
		String range_min = request.getParameter("range_min");
		String range_max = request.getParameter("range_max");
		
		WebParameters webParam = new WebParameters(names, items, numberOfQuestions,
				operations, range_min, range_max);
//		System.out.println(webParam.toString());
		
		QuizDriver quiz = new QuizDriver(webParam);
		String text = quiz.run();
		
		out.println(text);
		
		
		
//		out.println("<h2>Hi There!</h2><br/>"
//				+ "<h4>Names=" + names + "<br/>" 
//				+ "items= " + items +"<br/>" + 
//				" numberOfQuestions=" + numberOfQuestions  + "<br/>" 
//				+ "operations=" + operations + "<br/>" 
//				+ "range_min=" + range_min  + "<br/>" 
//				+ "range_max=" + range_max  + "<br/>" + 
//			
//				"</h4>");
		
    }
 
}