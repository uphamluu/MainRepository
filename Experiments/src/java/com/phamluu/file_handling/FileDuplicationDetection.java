package com.phamluu.file_handling;

import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Tool to detect files duplication 
 * Duplication is:
 * 1.name is the same --> done
 * 2. Size is the same in byte --> done
 * 3. ma
 *   
 * 
 * 
 * 
 * @author UyenPham
 *
 */
public class FileDuplicationDetection {
	//@formatter:off
	private static final HashSet<String> FOLDER_IGNORE_LIST = new HashSet<String>() {{
	    add("node_modules");
	    add("eclipse-java-luna-SR2-win32-x86_64");
	    add("eclipse-jee-neon-2-win32-x86_64");
	    add("Servers");
	    add("Java");
	    add("spark-1.4.1");
	    add("panda_trunk");
	    add("AffableBean");
	    add("angular2-training");
	    
	    
	}};
	private static final HashSet<String> FILE_EXTENSIONS = new HashSet<String>() {{
	    add(".mp4");
	    add(".mp3");
	    add(".jpg");
	    add(".jpeg");
	    add(".mp3");
	    add(".mp3");
	    add(".mp3");
	}};
	
//	String[] FILE_EXTENSION = {	".mp4",
//								".jpg",
//								".mp3"
//								};
	//@formatter:on
	
	/**
	 * @param fileName
	 * @return
	 */
	private static boolean acceptName(String fileName) {
		String lowerCase = fileName.toLowerCase();
	if (lowerCase.endsWith(".pfx")) {
		return true;
	}
	if (lowerCase.endsWith(".zip")) {
		return true;
	}
		if (lowerCase.endsWith(".mp4")) {
			return true;
		}
//
		 if (lowerCase.endsWith(".mp3")){
		 return true;
		 }
//
		 if (lowerCase.endsWith(".flac")){
		 return true;
		 }
//
		 if (lowerCase.endsWith(".pdf")){
		 return true;
		 }

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
		 
		 if (lowerCase.endsWith(".docx")){
		 return true;
		 }
		 if (lowerCase.endsWith(".docx")){
		 return true;
		 }
		 if (lowerCase.endsWith(".exe")){
		 return true;
		 }
		 if (lowerCase.endsWith(".java")){
		 return true;
		 }
		if (lowerCase.endsWith(".wav")) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		System.err.println("Star searching duplication");

		String[] startFolders = {"C:\\DEVELOPMENT", "C:\\DATA"};
		ArrayList<File> fileList = new ArrayList<>();
		for (String s: startFolders){
			fileList.addAll(retrieveAllFiles(s));
			
		}
		System.out.println(fileList.size() + " Files");
		// printFullName(fileList, false);
		Map<String, List<String>> duplicationInfos = detectDuplications(fileList);
		printDuplicationInfo(duplicationInfos);
		System.err.println("FINISHED...");

	}
	
	private static void printDuplicationInfo(Map<String, List<String>> duplicationInfos){
		for (List<String> listOfDuplFile: duplicationInfos.values()) {
			if (listOfDuplFile.size() > 1){
				System.out.println("------------------------------");
				for (String fileInfo:listOfDuplFile ){
					System.out.println(fileInfo);
				}
				System.out.println("------------------------------");
			}
			
		}
		
	}

	private static Map<String, List<String>> detectDuplications(ArrayList<File> fileList) {
		// STEP 1: Match name
		Map<String, List<File>> mapOfFilenameAndFiles = organizeIntoMapOfNameAndFiles(fileList);
		
		// STEP 2 match SIZE
		Map<String, List<String>> duplicationInfos = new HashMap<>();

		for (List<File> listOfFilesWithTheSameName : mapOfFilenameAndFiles.values()) {
			if (listOfFilesWithTheSameName.size() > 1) {
				for (File aFile : listOfFilesWithTheSameName) {
					String key = aFile.getName() + "##" +aFile.length();
					String value= aFile.getAbsolutePath()+ " size:: "+ aFile.length()+" bytes";
					List<String> duplications = duplicationInfos.getOrDefault(key, new ArrayList<String>());
					duplications.add(value);
					duplicationInfos.put(key, duplications);
				}
			}

		}
		
		return duplicationInfos;
	}
	
	
	
	/**
	 * sap xep cac file vao trong map.
	 * Map la map giua filename -- List of Files. Cac File co cung ten se duoc sep vao 1 map entry
	 * 
	 * 
	 * @return
	 */
	private static TreeMap<String, List<File>> organizeIntoMapOfNameAndFiles(ArrayList<File> fileList){
		TreeMap<String, List<File>> duplicationFile = new TreeMap<>();
		for (File aFile : fileList) {
			String fileName = aFile.getName();
			if (acceptName(fileName)) {
				List<File> sameNameFileList = duplicationFile.getOrDefault(fileName, new ArrayList<File>());
				sameNameFileList.add(aFile);
				duplicationFile.put(fileName, sameNameFileList);
			}

		}
		return duplicationFile;
	}
	



	/**
	 * 
	 * @param startFolderName
	 * @return
	 */
	private static ArrayList<File> retrieveAllFiles(String startFolderName) {
		File startFolder = new File(startFolderName);

		ArrayList<File> folderList = new ArrayList<>();
		ArrayList<File> fileList = new ArrayList<>();

		sortIntoFileListOrFolderList(startFolder, folderList, fileList);

		boolean cont = true;
		int i = 0;
		while (cont) {

			File childrensInAFolder = folderList.get(i);
			sortIntoFileListOrFolderList(childrensInAFolder, folderList, fileList);
			i++;
			cont = shouldContinue(folderList, i);
		}

		return fileList;

	}


	private static boolean shouldContinue(ArrayList<File> folderList, int i) {
		return i < folderList.size();
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
		if (FOLDER_IGNORE_LIST.contains(folderName)){
			return false;
		}
		
		return true;

	}


}
