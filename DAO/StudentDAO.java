package CoreJava.DAO;

import CoreJava.Models.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDAO {
	
	public List<Student>  getStudents() throws FileNotFoundException{
		/*INITIALIZING FILE*/
    	String directory = ("C:\\Users\\akim4\\Google Drive\\CODE\\JAVAPROGRAMS\\PERSCHOLAS PLATFORM JD WORKSPACE\\src\\CoreJava\\Models");
    	String specific = ("\\FILE_BANK\\students.csv");
    	File sFile = new File(directory + specific);
    		
    	/*INITIALIZING SCANNER*/	
    	Scanner sReader = new Scanner(sFile);
    	ArrayList<Student> slist = new ArrayList<Student>(); /*CREATES ARRAYLIST TO STORE INFORMATION FROM STUDENTS CSV (sFile)*/
    		
    	/*WHILE LOOP TO READ FILE*/
    	while (sReader.hasNextLine()) {
    		String data[] = sReader.nextLine().split(","); /* PUTS THE INFORMATION INTO A VARIABLE SPLIT BY ","*/
    		for (int i = 0; i < data.length; i++) {
    			slist.add(new Student(data[i], data[i+1], data[i+2]));    /*CREATES STUDENT OBJECT WITH DATA FROM CSV*/
    		}
    	}
    	sReader.close(); /*CLOSES READER*/
    	
    	/*RETURNS OBJECTS FROM LISTARRAY*/
    	return slist;
    }
    		
    	
    public Student getStudentByEmail(List<Student> studentList, String studentEmail){

    	
    	
    }

    public boolean validateUser(List<Student> studentList, String studentEmail, String studentPass){

    }
    
    
}
