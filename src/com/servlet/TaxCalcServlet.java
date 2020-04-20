package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import taxlogic.*;
/**
 * Servlet implementation class TaxCalcServlet
 */
@WebServlet("/TaxCalcServlet")
public class TaxCalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaxCalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Taxable tax;
		String filingStatus = request.getParameter("filingstatus");
		String incomeStr = request.getParameter("income");
		double income =0;
		try {
			income = Double.parseDouble(incomeStr);
		}
		catch(Exception e) {}		
		System.out.println(filingStatus);
		Taxable taxCalc=null;
		if(filingStatus.equals("single")) {
			taxCalc = new FilingStatusSingle();
		}
		if(filingStatus.equals("married")) {
			taxCalc = new FilingStatusMarried();
		}
		if(filingStatus.equals("headofhousehold")) {
			taxCalc = new FilingStatusHeadOfHousehold();
		}
		double totalTax = taxCalc.calculateTax(income);
		
		
		HttpSession session = request.getSession(true);
		//ArrayList<Course> courses = (ArrayList<Course>)session.getAttribute("courses");
		session.setAttribute("totaltax", "$" + totalTax);
		
		RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
		rs.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
