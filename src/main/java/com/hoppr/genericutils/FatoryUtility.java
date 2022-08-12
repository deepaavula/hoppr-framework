package com.hoppr.genericutils;

import java.util.HashMap;
import java.util.Map;


import com.hoppr.login.LoginSource;
import com.hoppr.reimbursement.ReimbursementLoginSourcePage;



public class FatoryUtility {

	private static Map<String, Object> sources = new HashMap<>();
	

	public static Object getObject(String name) {
		Object obj = sources.get(name);
		if (obj == null) {
			if ("loginSource".equals(name)) {
				obj = new LoginSource(Basepage.getDriver());
			}
			else if("reimbursementLoginSourcePage".equals(name)) {
				obj = new ReimbursementLoginSourcePage (Basepage.getDriver());
			}
		
		}
		return obj;
	}
	

}
