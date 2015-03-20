package com.example.snmc.controller.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.snmc.controller.dao.StaffDAO;
import com.example.snmc.controller.nodel.Staff;
import com.example.snmc.controller.nodel.Timer;

public class JdbcStaffDAO implements StaffDAO {

	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Staff staffLoginVerification(String username, String password) {
		String sql = "SELECT * FROM hc_staff WHERE username = ? and password = ?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			Staff staff = new Staff();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				staff.setStaffId(rs.getString("staff_id"));
				staff.setUserTypeId(rs.getInt("user_type_id"));
				staff.setFirstName(rs.getString("first_name"));
				staff.setLastName(rs.getString("last_name"));
			}
			rs.close();
			ps.close();
			return staff;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public Staff getStaffInfo(String staffId) {
		String sql = "SELECT * FROM hc_staff WHERE staff_id = ?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, staffId);
			Staff staff = new Staff();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				staff.setStaffId(staffId);
				staff.setUserTypeId(rs.getInt("user_type_id"));
				staff.setFirstName(rs.getString("first_name"));
				staff.setLastName(rs.getString("last_name"));
			}
			rs.close();
			ps.close();
			return staff;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public List<Staff> listStaff() {
		String SQL = "select * from hc_staff";
		List<Staff> students = jdbcTemplate.query(SQL, new BeanPropertyRowMapper(Staff.class));
		return students;
	}

	public List<Timer> getTimerList() {
		String SQL = "select * from hc_timer";
		List<Timer> timer = jdbcTemplate.query(SQL, new BeanPropertyRowMapper(Timer.class));
		return timer;
	}
}
