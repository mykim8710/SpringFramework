package edu.bit.board.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import edu.bit.board.vo.UserVO;

@Repository
public interface LoginMapper {
	@Select("SELECT * FROM USERS WHERE username = #{username} and password = #{password}")
	public UserVO loginUser(@Param("username") String username, @Param("password") String password);
}
