package com.msys.cbt1.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ls")
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao ld;

	@Override
	public Integer validateCredintials(Object obj) {

		return ld.validateCredintials(obj);
	}

}
