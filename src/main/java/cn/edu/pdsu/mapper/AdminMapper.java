package cn.edu.pdsu.mapper;

import org.apache.ibatis.annotations.Select;

import cn.edu.pdsu.pojo.Admin;

public interface AdminMapper {

	@Select("SELECT * FROM t_admin WHERE no=#{no} AND password=#{password}")
	public Admin getAdminByNoAndPassword(Admin admin);

}
