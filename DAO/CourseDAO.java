package CoreJava.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import CoreJava.Models.Course;

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
    			clist.add(new Course(data[0], data[1], data[2]));  /*CREATES COURSE OBJECT WITH DATA FROM COURSE CSV*/
    	}
    	cReader.close();  /*CLOSES READER*/
    	return clist;	/*RETURNS OBJECTS (COURSES) FROM LISTARRAY*/
    }
}
