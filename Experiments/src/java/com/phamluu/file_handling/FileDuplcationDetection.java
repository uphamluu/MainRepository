package com.phamluu.file_handling;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class FileDuplcationDetection {

	public static void main(String[] args) {
		System.err.println("uyen");

		String[] startFolders = {"C:\\DEVELOPMENT", "C:\\DATA"};
		ArrayList<File> fileList = new ArrayList<>();
		for (String s: startFolders){
			fileList.addAll(retrieveAllFiles(s));
			
		}
		System.out.println(fileList.size() + " Files");
		// printFullName(fileList, false);
		detectDuplications(fileList);

	}

	private static void detectDuplications(ArrayList<File> fileList) {
		TreeMap<String, List<File>> duplicationFile = new TreeMap<>();
		for (File aFile : fileList) {
			String fileName = aFile.getName();
			if (acceptName(fileName)) {
				List<File> sameNameFileList = duplicationFile.getOrDefault(fileName, new ArrayList<File>());
				sameNameFileList.add(aFile);
				duplicationFile.put(fileName, sameNameFileList);
			}

		}

		for (List<File> listOfFileWithTheSameName : duplicationFile.values()) {
			if (listOfFileWithTheSameName.size() > 1) {
				System.out.println("#######################");
				for (File aFile : listOfFileWithTheSameName) {
					System.out.println(aFile.getAbsolutePath() + " :: " + aFile.length());
				}
				System.out.println("#######################");
			}

		}

	}

	private static boolean acceptName(String fileName) {
		String lowerCase = fileName.toLowerCase();
		if (lowerCase.endsWith(".mp4")) {
			return true;
		}

		// if (lowerCase.endsWith(".mp3")){
		// return true;
		// }

		// if (lowerCase.endsWith(".flac")){
		// return true;
		// }

		// if (lowerCase.endsWith(".pdf")){
		// return true;
		// }

		if (lowerCase.endsWith(".xlsm")) {
			return true;
		}

		if (lowerCase.endsWith(".xlsx")) {
			return true;
		}

		if (lowerCase.endsWith(".xls")) {
			return true;
		}
		if (lowerCase.endsWith(".jpg")) {
			return true;
		}
		 if (lowerCase.endsWith(".jpeg")){
		 return true;
		 }
		 if (lowerCase.endsWith(".txt")){
		 return true;
		 }
		// if (lowerCase.endsWith(".docx")){
		// return true;
		// }
		// if (lowerCase.endsWith(".docx")){
		// return true;
		// }
		// if (lowerCase.endsWith(".exe")){
		// return true;
		// }
		// if (lowerCase.endsWith(".java")){
		// return true;
		// }
		if (lowerCase.endsWith(".wav")) {
			return true;
		}

		return false;
	}

	private static ArrayList<File> retrieveAllFiles(String startFolderName) {
		File startFolder = new File(startFolderName);

		ArrayList<File> folderList = new ArrayList<>();
		ArrayList<File> fileList = new ArrayList<>();

		sortIntoFileListOrFolderList(startFolder, folderList, fileList);

		boolean cont = true;
		int i = 0;
		while (cont) {

			File aaaa = folderList.get(i);
			sortIntoFileListOrFolderList(aaaa, folderList, fileList);
			i++;
			cont = shouldContinue(folderList, i);
		}

		return fileList;

	}

	// private static void printFullName(ArrayList<File> fileList, boolean
	// printDetailFile) {
	//
	// if (printDetailFile) {
	// for (File file : fileList) {
	// System.out.println(file.getAbsolutePath());
	// }
	// }
	//
	// }

	private static boolean shouldContinue(ArrayList<File> folderList, int i) {
		return i < folderList.size();
		// return false;
	}

	private static void sortIntoFileListOrFolderList(File fff, ArrayList<File> folderList, ArrayList<File> fileList) {
		for (File file : fff.listFiles()) {
			if (file.isFile()) {
				fileList.add(file);
			} else if (file.isDirectory()) {
				if (shouldBeIncluded(file.getName())) {
					folderList.add(file);
				}

			}
		}

	}

	private static boolean shouldBeIncluded(String folderName) {
		if (folderName.equalsIgnoreCase("node_modules")) {
			return false;
		}
		if (folderName.equalsIgnoreCase("eclipse-java-luna-SR2-win32-x86_64")) {
			return false;
		}
		
		if (folderName.equalsIgnoreCase("eclipse-jee-neon-2-win32-x86_64")) {
			return false;
		}
		
		if (folderName.equalsIgnoreCase("Java")) {
			return false;
		}
		
		if (folderName.equalsIgnoreCase("Servers")) {
			return false;
		}
		if (folderName.equalsIgnoreCase("spark-1.4.1")) {
			return false;
		}
		if (folderName.equalsIgnoreCase("panda_trunk")) {
			return false;
		}
		
		
		
		
		
		return true;

	}

	// private static FilenameFilter createFileFilter(){
	// FilenameFilter textFilter = new FilenameFilter() {
	// // accept folder oder file with extention
	// public boolean accept(File dir, String name) {
	// String lowercaseName = name.toLowerCase();
	// if (dir.isDirectory()) {
	// return true;
	// } else if (dir.isFile()) {
	//
	// if (lowercaseName.endsWith(".jpeg")) {
	// return true;
	// } else if (lowercaseName.endsWith(".jpg")) {
	// return true;
	// } else if (lowercaseName.endsWith(".mp3")) {
	// return true;
	// } else if (lowercaseName.endsWith(".java")) {
	// return true;
	// } else if (lowercaseName.endsWith(".txt")) {
	// return true;
	// } else {
	// return false;
	// }
	// }
	// return false;
	// }
	// };
	// return textFilter;
	// }

}
