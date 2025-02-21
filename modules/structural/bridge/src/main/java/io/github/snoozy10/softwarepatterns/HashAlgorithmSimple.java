package io.github.snoozy10.softwarepatterns;

public class HashAlgorithmSimple implements HashAlgorithm {

	private static final int SIMPLE_HASH_MAXIMUM = 255;
	private static final int HEXADECIMAL = 16;

	private int maxLength;

	public HashAlgorithmSimple() {
		maxLength = SIMPLE_HASH_MAXIMUM;
	}

	@Override
	public String calculateHashCode(String docPath) {
		int hash = 0;
		char[] charArray = docPath.toCharArray();
		for (char c : charArray) {
			hash += c;
		}
		return Integer.toString(hash % maxLength, HEXADECIMAL);
	}

}
