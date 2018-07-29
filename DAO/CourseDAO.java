package CoreJava.DAO;

import CoreJava.Models.Course;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseDAO {
    public List<Course> getAllCourses() throws FileNotFoundException{
		/*INITIALIZING FILE*/
    	String directory = ("C:\\Users\\akim4\\Google Drive\\CODE\\JAVAPROGRAMS\\PERSCHOLAS PLATFORM JD WORKSPACE\\src\\CoreJava\\Models");
    	String specific = ("\\FILE_BANK\\courses.csv");
    	File cFile = new File(directory + specific);
    		
    	/*INITIALIZING SCANNER*/	
    	Scanner cReader = new Scanner(cFile);
    	ArrayList<Course> clist = new ArrayList<Course>(); /*CREATES ARRAYLIST TO STORE INFORMATION FROM COURSE CSV (cFile)*/
    		
    	
    	while (cReader.hasNextLine()) {	/*READER KEEPS ITERATING WHILE THERE IS DATA ON THE NEXT LINE*/
    		String data[] = cReader.nextLine().split(",");  /* PUTS THE INFORMATION INTO A VARIABLE SPLIT BY ","*/
    		for (int i = 0; i < data.length; i++) {
    			clist.add(new Course(data[i], data[i+1], data[i+2]));  /*CREATES COURSE OBJECT WITH DATA FROM COURSE CSV*/
    		}
    	}
    	cReader.close();  /*CLOSES READER*/
    	return clist;	/*RETURNS OBJECTS (COURSES) FROM LISTARRAY*/
    }
}
