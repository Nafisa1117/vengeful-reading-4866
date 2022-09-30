package com.masai.utility;

import java.sql.Connection;

public class Demo {
	
	public static void main(String[] args) {
		
		//checking if connection is build or not
		Connection conn = DBconnUtil.provideConnection();
		
		System.out.println(conn);
		
	}

}
