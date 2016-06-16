/**
 * @file SessionIdentifier
 * @author http://stackoverflow.com/a/41156/5931255
 * 
 */

package com.sergiorb.loginapp.utils;

import java.security.SecureRandom;
import java.math.BigInteger;

// Generates a random session string
public final class SessionIdentifierGenerator {

	public static String newSessionId() {
		return new BigInteger(130, new SecureRandom()).toString(32);
	}
}
