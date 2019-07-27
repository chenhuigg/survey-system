package cn.edu.pdsu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.pdsu.mapper.AdminMapper;
import cn.edu.pdsu.pojo.Admin;
@Service
public class AdminService {
	@Autowired
	private AdminMapper adminMapper;

	public Admin userLogin(Admin admin) {
		return adminMapper.getAdminByNoAndPassword(admin);
	}

}
