package com.callor.todo.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.todo.config.DBConnection;
import com.callor.todo.config.DBInfo;
import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;

public class TodoServiceImplV1 implements TodoService {
	
	protected Connection dbConn;
	
	public TodoServiceImplV1() {
		
		dbConn = DBConnection.getDBConection();
	}

	protected List<TodoVO> select(PreparedStatement pStr) throws SQLException{
		
		List<TodoVO> tdList = new ArrayList<TodoVO>();
		
		ResultSet rSet = pStr.executeQuery();
		
		while(rSet.next()) {
			
			TodoVO tdVO= new TodoVO();
			tdVO.setTd_seq(rSet.getLong(DBInfo.td_seq));
			tdVO.setTd_todo(rSet.getString(DBInfo.td_todo));
			tdVO.setTd_date(rSet.getString(DBInfo.td_todo));
			tdVO.setTd_time(rSet.getString(DBInfo.td_time));
			tdVO.setTd_place(rSet.getString(DBInfo.td_place));
			
//			System.out.println(tdList.toString());
			
			tdList.add(tdVO);
			
			
		}
		
		return tdList;
		
	}
	
	@Override
	public List<TodoVO> selectAll() {
		// TODO 전체 데이터 조회
		
		String sql = " SLECT * FROM tbl_todo ";
		sql += " ORDER BY tb_date DESC, tb_time DESC ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			List<TodoVO> tdList = this.select(pStr);
			pStr.close();
			
//			System.out.println(tdList.toString());
			return tdList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public TodoVO findById(Long seq) {
		// TODO 일련번호로 조회
		
		String sql = " SELECT * FROM tbl_todo ";
		sql += " WHERE td_seq = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, seq);
			
			List<TodoVO> tdList = this.select(pStr);
			pStr.close();
			
			if( tdList != null && tdList.size() > 0) {
				
//				System.out.println(tdList.toString());
				
				return tdList.get(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Integer insert(TodoVO tdVO) {
		// TODO 새로운 데이터 작성
		
		String sql = " INSERT INTO tbl_todo ";
		sql += " (td_seq, td_todo, td_date, td_time, td_place) ";
		sql += " VALUES (seq_todo.NEXTVAL, ?, ?, ?, ?) ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, tdVO.getTd_todo());
			pStr.setString(2, tdVO.getTd_date());
			pStr.setString(3, tdVO.getTd_time());
			pStr.setString(4, tdVO.getTd_place());
			
			Integer result = pStr.executeUpdate(sql);
			
			pStr.close();
			
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer update(TodoVO tdVO) {
		// TODO 데이터 수정하기
		
		String sql = " UPDATE tbl_todo SET ";
		sql += " td_todo = ? , td_date = ? , td_time = ? , td_place = ? ";
		sql += " WEHERE td_seq = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, tdVO.getTd_todo());
			pStr.setString(2, tdVO.getTd_date());
			pStr.setString(3, tdVO.getTd_time());
			pStr.setString(4, tdVO.getTd_place());
			pStr.setLong(5, tdVO.getTd_seq());
			
			Integer result = pStr.executeUpdate(sql);
			
			pStr.close();
			
			return result;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Integer delete(Long seq) {
		// TODO 데이터 삭제
		
		String sql = " DELETE FROM tbl_todo ";
		sql += " WHERE td_seq = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, seq);
			
			Integer result = pStr.executeUpdate(sql);
			pStr.close();
			
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
