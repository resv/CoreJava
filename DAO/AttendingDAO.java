package CoreJava.DAO;

import CoreJava.Models.Attending;
import CoreJava.Models.Course;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AttendingDAO {

	
	/*INITIALIZING FILE*/
	String directory = ("C:\\Users\\akim4\\Google Drive\\CODE\\JAVAPROGRAMS\\PERSCHOLAS PLATFORM JD WORKSPACE\\src\\CoreJava\\Models");
	String specific = ("\\FILE_BANK\\attending.csv");
	File aFile = new File(directory + specific);
	
    public List<Attending> getAttending() throws FileNotFoundException{    	
    	Scanner aReader = new Scanner(aFile);
    	ArrayList<Attending> alist = new ArrayList<Attending>(); /*CREATES ARRAYLIST TO STORE INFORMATION FROM ATTENDING CSV (aFile)*/
    	
    	while (aReader.hasNextLine()) {
    		String data[] = aReader.nextLine().split(",");
    		for (int i = 0; i < data.length; i++) {
    			alist.add(new Attending(Integer.parseInt(data[i]),data[i+1]));
    		}
    	}
    	aReader.close();
		return alist;
    }
    
    public void registerStudentToCourse(List<Attending> attending, String studentEmail, int courseID){
//    	Boolean counter = false;
    	for (Attending alist : attending) {
    		if(studentEmail == alist.getStudentEmail() && courseID == alist.getCourseID()) {
//    			counter = true;
    		} else {
//    		if(counter == false) {
    			attending.add(new Attending(courseID,studentEmail));
    			saveAttending(attending);
//    		}
    		}
    	}
    }

    public List<Course> getStudentCourses(List<Course> courseList, List<Attending> attending, String studentEmail){
    	ArrayList<Course> courseList = new Array<Course>();
    	for(Attending alist : attending) {
    		if (studentEmail == attending.get())
    	}
    	
    	
    }

    public void saveAttending(List<Attending> attending){

    }

}
