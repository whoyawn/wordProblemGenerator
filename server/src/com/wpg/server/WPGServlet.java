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
 
/**
 * Servlet implementation class WPGServlet
 * Luke and Arameh
 */
@WebServlet(description = "WPGServlet", urlPatterns = { "/WPGServlet" , "/WPGServlet.do"}, initParams = {@WebInitParam(name="id",value="1"),@WebInitParam(name="name",value="pankaj")})
public class WPGServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final String HTML_START="<html><body>";
    public static final String HTML_END="</body></html>";
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WPGServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
        Date date = new Date();
        QuizDriver drive = new QuizDriver();
        String text = drive.run();
        out.println(HTML_START + "<h2>Hi There!</h2>" + text + "<br/><h3>Date="+date +"</h3>"+HTML_END);
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
//        Date date = new Date();
//        QuizDriver drive = new QuizDriver();
//        String text = drive.run();
//        out.println(HTML_START + "<h2>Hi There!</h2>" + text + "<br/><h3>Date="+date +"</h3>"+HTML_END);
    	
    	
    	String names = request.getParameter("names");
		String items = request.getParameter("itmes");
		String numberOfQuestions = request.getParameter("numberOfQuestions");
		String[] operation = request.getParameterValues("operation");
		String range_min = request.getParameter("range_min");
		String range_max = request.getParameter("range_max");
		
		out.println(HTML_START + "<h2>Hi There!</h2>Names=" + names + "<br/><h3>items= "+items +
				"numberOfQuestions=" + numberOfQuestions  + "<br/>" + 
				"operation=" + operation[0] + operation[1] + operation[2] + operation[3] + "<br/>" + 
				"range_min=" + range_min  + "<br/>" + 
				"range_max=" + range_max  + "<br/>" + 
				
				
				
				"</h3>"+HTML_END);
    }
 
}