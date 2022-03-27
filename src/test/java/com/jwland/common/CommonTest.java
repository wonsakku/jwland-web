package com.jwland.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Test;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.SHA256Digest;

public class CommonTest {

	@Test
	void password_test() throws NoSuchAlgorithmException {
		String key = "sample";
	
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update("1111".getBytes());
	
		String hex = String.format("%64x", new BigInteger(1, md.digest()));
	
	}

	
	@Test
	void long_check() {
		Long a = 1l;
		Long b = 1l;
		
		System.out.println(a == b);
	}
	
}
