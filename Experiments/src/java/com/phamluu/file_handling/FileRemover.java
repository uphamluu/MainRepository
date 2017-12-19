package com.phamluu.file_handling;

import java.io.File;
import java.util.HashSet;

public class FileRemover {
	private static final HashSet<String> FILE_LIST = new HashSet<String>() {{
	    add("C:\\DATA\\Data from  scandisk\\tobemoved\\S-VNX2__-021003WF-EUREN-64BIT_.exe");
	    add("C:\\DATA\\Data from  scandisk\\tobemoved\\private\\JAX-WS-Integrate-WebApplication-Example.zip");
	    add("C:\\DATA\\Data from  scandisk\\tobemoved\\private\\DEVELOPEMENT\\DEVELOPEMENT\\sqldeveloper-4.1.1.19.59-no-jre.zip");
	    add("C:\\DATA\\Data from  scandisk\\tobemoved\\private\\jaxwsdocumentclient.zip");
	    
	    
	}};

	public static void main(String[] args) {
		for (String fileName: FILE_LIST){
			deleteFile(fileName);
		}
	}
	
	private static void deleteFile(String fileName){
		try {

			File file = new File(fileName);
			if (file.exists()) {
				if (file.delete()) {
					System.out.println(file.getName() + " is deleted!");
				} else {
					System.out.println("Delete operation is failed.");
				}
			}else {
				System.out.println(fileName +" doesn't exist");
				
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		
	}
}
