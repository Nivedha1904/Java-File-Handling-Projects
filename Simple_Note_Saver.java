package file_handling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Simple_Note_Saver {

	public static void main(String[] args) throws IOException {
	Scanner sc=new Scanner(System.in);
	
	
File directory=new File("C:\\Users\\Admin\\Desktop\\Notes App");
if(directory.mkdirs()) {
	System.out.println("Note Folder created :"+directory.getAbsolutePath());
	System.out.println("Folder Name: "+directory.getName());
}else {
	System.out.println("Already Exists or not created");
}
	
	
	
	
System.out.println("\nTitle of Note:");
String note=sc.nextLine();

File f=new File(directory,note+".txt");
	if(f.createNewFile()) {
		System.out.println("File Name: "+f.getName());
		System.out.println("Get the Path: "+f.getAbsolutePath());
	}else {
		System.out.println("Already exists or not created");
	}
	
	
System.out.println("Enter your note content(type 'END' to finish):");
StringBuilder content=new StringBuilder();
while(true) {
	String line=sc.nextLine();
	if(line.equalsIgnoreCase("End")) 
		break;
		content.append(line).append("\n");
		
	}

FileWriter fw=new FileWriter(f);
fw.write(content.toString());
fw.close();
System.out.println("Note Saved Successfully");


Scanner sc1=new Scanner(f);
System.out.println("Read the file");
while(sc1.hasNextLine()) {
	String data=sc1.nextLine();
	System.out.println(data);
}

sc1.close();


System.out.println("\nYour saved notes:");
String[] list=directory.list();
if(list!=null && list.length>0) {
	  System.out.println("📄 " + note);
}else {
	System.out.println("No notes found.");
}
sc.close();

}
	


	
	
	
	
	

	}


