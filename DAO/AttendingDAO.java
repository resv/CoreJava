package CoreJava.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import CoreJava.Models.Attending;
import CoreJava.Models.Course;

public class AttendingDAO {

	
	/*INITIALIZING FILE*/
	String directory = ("C:\\Users\\akim4\\Google Drive\\CODE\\JAVAPROGRAMS\\PERSCHOLAS PLATFORM JD WORKSPACE\\src\\CoreJava\\Models");
	String specific = ("\\FILE_BANK\\attending.csv");
	File aFile = new File(directory + specific);
	
	//READS FROM ATTENDING LIST AND RETURNS IT TO USER
    public List<Attending> getAttending() throws FileNotFoundException{    	
    	Scanner aReader = new Scanner(aFile);	//INITIALIZE SCANNER
    	ArrayList<Attending> alist = new ArrayList<Attending>(); /*CREATES ARRAYLIST TO STORE INFORMATION FROM ATTENDING CSV (aFile)*/
    	
    	while (aReader.hasNextLine()) {	// WHILE LOOP TO CONTINUE IF THERE IS STILL A NEXT LINE PRESENT
    		String data[] = aReader.nextLine().split(",");	//WE SPLIT "," AND ADD IT TO A TEMP ARRAY
    			alist.add(new Attending(Integer.parseInt(data[0]),data[1]));	//ADD A NEW ATTENDING OBJECT INTO THE ATTENDING LIST
    	}
    	aReader.close();	//CLOSES READER
		return alist;	//RETURNS ATTENDING LIST TO USER
    }
    
    
    //METHOD THAT CHECKS IF STUDENT IS ALREADY ATTENDING A COURSE, IF NOT ,CALL saveAttending()
    public void registerStudentToCourse(List<Attending> attending, String studentEmail, int courseID) throws IOException{
    	Boolean isRegistered = false;
    	for (Attending alist : attending) {	//ITERATE THROUGH ATTENDING LIST
    		if(alist.getStudentEmail().equals(studentEmail) && courseID == alist.getCourseID()) {	//CHECKS TO SEE IF GIVEN EMAIL AND COURSEID PARAMETERS MATCH ATTENDING LIST
    			isRegistered = true;
    			break;
    		}
    	}
    	if(isRegistered == false) {
			attending.add(new Attending(courseID,studentEmail));	//IF NO MATCH THEN WE ADD THOSE VALUES INTO THE PARAMETER HERE
			saveAttending(attending);	//CALL saveAttending() METHOD
    	}
    }
    
    
    //METHOD THAT CHECKS FOR STUDENT EMAIL, IN ATTENDING LIST AND IF IT MATCHES IT CREATES A NEW LIST WITH ALL OF THE ATTENDING COURSES OF THAT STUDENT 
    public List<Course> getStudentCourses(List<Course> courseList, List<Attending> attending, String studentEmail){  
    	ArrayList<Course> newclist = new ArrayList<Course>();	//WE INITALIZE A NEW TEMP ARRAY THAT WILL PRINT THE ATTENDING COURSES
    	
    	for(Attending attendingList : attending) {	//ITERATE THROUGH ATTENDING LIST FROM ABOVE METHODS
    		if (studentEmail.equals(attendingList.getStudentEmail())) {	// CHECK TO SEE IF EMAIL INPUT MATCHES AN EMAIL EXISTING IN ATTENTING LIST
    			
    			for (Course courses : courseList) {	//ITERATE THROUGH COURSE LIST GIVEN IN PARAMETERS
    				if (courses.getID().equals(String.valueOf(attendingList.getCourseID()))) {	//CHECK TO SEE IF COURSEID MATCHES THE STUDENT'S EMAIL
    					newclist.add(new Course(courses.getID(),courses.getName(),courses.getInstructor())); 	//IF TRURE WE ADD COURSE ID AND COURSE NAME TO NEW TEMP ARRAY
    				}
    			}
    		}
    	}
    	return newclist;	//RETURN THE NEW TEMP ARRAY OF COURSE ID AND COURSE NAME, STUDENT IS ATTENDING
    }

  //METHOD THAT GETS CALLED WHEN THERE IS A MISMATCH ON registerStudentCourses();
    public void saveAttending(List<Attending> attending) throws IOException{
    	
    	FileWriter attendingWriter = new FileWriter(aFile,false);	//INITIALIZES THE FILE WRITER
    	
    	for (Attending newalist : attending) {	//ITERATES THROUGH THE ATTENDING ARRAYLIST
    		attendingWriter.write(newalist.getCourseID() + "," + newalist.getStudentEmail() + "\r\n");	//OVERWRITES COURSE ID AND STUDENTEMAIL INTO ATTENDING CSV (aFile)
    	}
    	attendingWriter.close();	//CLOSES WRITER	
    }

}
