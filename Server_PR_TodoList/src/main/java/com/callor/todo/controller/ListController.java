package com.callor.todo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todo.config.DBInfo;
import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;
import com.callor.todo.service.impl.TodoServiceImplV1;

@WebServlet("/list/*")
public class ListController extends HttpServlet{

	protected TodoService tdService;
	
	public ListController() {
		
		tdService = new TodoServiceImplV1();
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String subPath = req.getPathInfo();
		
		if(subPath.equals("/insert")) {
			
			TodoVO tdVO = new TodoVO();
			
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			
			SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss");
			
			Date date = new Date(System.currentTimeMillis());
			
			tdVO.setTd_seq(0L);
			tdVO.setTd_date(sd.format(date));
			tdVO.setTd_time(st.format(date));
			
			req.setAttribute("TD", tdVO);
			
			RequestForwardController.forward(req, resp, "write");
			
		} else if(subPath.equals("/view")) {
			
			String strSeq = req.getParameter("td_seq");
			Long td_seq = Long.valueOf(strSeq);
			TodoVO tdVO = tdService.findById(td_seq);
			
			req.setAttribute("TD", tdVO);
			RequestForwardController.forward(req, resp, "view");
			
		}else if (subPath.equals("/delete")) {
			
			String strSeq = req.getParameter("td_seq");
			Long td_seq = Long.valueOf(strSeq);
			
//			System.out.println("delete seq + "td_seq);
			
			tdService.delete(td_seq);
			resp.sendRedirect("/todo/");
			
		} else if (subPath.equals("/update")) {
			
			String strSeq = req.getParameter("td_seq");
			
			Long td_seq = Long.valueOf(strSeq);
			
			TodoVO tdVO = tdService.findById(td_seq);
			
			req.setAttribute("TD", tdVO);
			
			System.out.println(tdVO.toString());
			
			RequestForwardController.forward(req, resp, "write");
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String subPath = req.getPathInfo();
		req.setCharacterEncoding("UTF-8");
		
		String strSeq = req.getParameter(DBInfo.td_seq);
		String td_todo = req.getParameter(DBInfo.td_todo);
		String td_date= req.getParameter(DBInfo.td_date);
		String td_time = req.getParameter(DBInfo.td_time);
	    String td_place= req.getParameter(DBInfo.td_place);
	    
	    Long td_seq = Long.valueOf(strSeq); 
	    TodoVO tdVO = new TodoVO();
	    tdVO.setTd_seq(td_seq);
	    tdVO.setTd_todo(td_todo);
	    tdVO.setTd_date(td_date);
	    tdVO.setTd_time(td_time);
	    tdVO.setTd_place(td_place);
	    
	    System.out.println(tdVO.toString());
	    
	    if(subPath.equals("/insert")) {
	    	
	    	tdService.insert(tdVO);
	    	
	    	resp.sendRedirect("/todo/");
	    	
	    } else if(subPath.equals("/update")) {
	    	
	    	tdService.update(tdVO);
	    	
	    	resp.sendRedirect("/todo/");
	    }
	    
	}
	
	
}
