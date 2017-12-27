package com.hms.util;

import java.util.Random;

public class TookeanGenerator {
	

	public static int generateToken(int no) {
		int tookeanNo = 0;
		Random r = new Random();
		tookeanNo = r.nextInt(no);
		return tookeanNo;

	}

}
