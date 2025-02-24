package io.github.snoozy10.softwarepatterns;

public final class ExamSystem {
	// private constructor, i.e. no instantiation of class with "main"
	private ExamSystem() {
	}

	public static String hashFile(String documentPath, Hashing hashing) {
		return hashing.hashDocument(documentPath);
	}

	public static void main(String[] args) {
		String file1_path = "exam_texts/short_exam.txt";
		String file2_path = "exam_texts/long_exam.txt";

		// try preview hashing with file1 (should work) and file2 (shouldn't work)
		HashingPreview hashingPreview = new HashingPreview();
		// file1
		System.out.println("Preview Hashing: file1");
		System.out.println(hashFile(file1_path, hashingPreview));
		// file2
//		try {
//			System.out.println("Preview Hashing: file2_path [THIS SHOULD NOT WORK!] " + hashFile(file2, hashingPreview));
//			throw new IllegalStateException("Hashing this file with preview hashing should not work!");
//		} catch (IllegalArgumentException e) {
//			System.out.println("IllegalArgumentException. Printing stacktrace...");
//			e.printStackTrace();
//		}

		// try preview hashing with file1 (should work) and file2 (should work)
		HashingEnterprise hashingEnterprise = new HashingEnterprise();

		System.out.println("Enterprise Hashing: file1");
		System.out.println(hashFile(file1_path, hashingEnterprise));

		System.out.println("Enterprise Hashing: file2");
		System.out.println(hashFile(file2_path, hashingEnterprise));
	}
}
