package edu.bit.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.board.mapper.LoginMapper;
import edu.bit.board.vo.UserVO;

@Service
public class LoginService {
	@Autowired
	private LoginMapper loginMapper;

	public UserVO loginUser(String username, String password) {
		return loginMapper.loginUser(username, password);
	}

}
