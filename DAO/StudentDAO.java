package CoreJava.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import CoreJava.Models.Student;

public class StudentDAO {
	
	public List<Student>  getStudents() throws FileNotFoundException{
		/*INITIALIZING FILE*/
    	String directory = ("C:\\Users\\akim4\\Google Drive\\CODE\\JAVAPROGRAMS\\PERSCHOLAS PLATFORM JD WORKSPACE\\src\\CoreJava\\Models");
    	String specific = ("\\FILE_BANK\\students.csv");
    	File sFile = new File(directory + specific);
    		
    	/*INITIALIZING SCANNER*/	
    	Scanner sReader = new Scanner(sFile);
    	ArrayList<Student> slist = new ArrayList<Student>();	/*CREATES ARRAYLIST TO STORE INFORMATION FROM STUDENTS CSV (sFile)*/
    		
    	/*WHILE LOOP TO READ FILE*/
    	while (sReader.hasNextLine()) {	/*READER KEEPS ITERATING WHILE THERE IS DATA ON THE NEXT LINE*/
    		String data[] = sReader.nextLine().split(","); /* PUTS THE INFORMATION INTO A VARIABLE SPLIT BY ","*/
    			slist.add(new Student(data[0], data[1], data[2]));	/*CREATES STUDENT OBJECT WITH DATA FROM STUDENT CSV*/
    	}
    	sReader.close();	/*CLOSES READER*/
    	return slist; 	/*RETURNS OBJECTS (STUDENT) FROM LISTARRAY*/
    }
    		
	//METHOD TO GET STUDENT BY EMAIL
    public Student getStudentByEmail(List<Student> studentList, String studentEmail){
    	/*ITERATING THROUGH ARRAYLIST*/
    	for (Student student : studentList) {	/*TYPE STUDENT(OBJECT) NAMED STUDENT FOR THIS FOR EACH LOOP, OF STUDENTLIST ARRAY)*/
    		if (student.getEmail().equals(studentEmail.toLowerCase())) {	/*CHECKING IF OBJECT'S EMAIL MATCHES EMAIL GIVEN*/
    			return student;	/*RETURNS A STUDENT WHEN A MATCH IS FOUND*/
    		}
    	}
    	return null;	/*RETURNS NULL WHEN A STUDENT MATCH IS NOT FOUND(METHOD WOULD ERROR AND NOT LET ME PROGRESS WITH OUT NULL RETURN*/
    }
    //METHOD TO CHECK IF EMAIL AND PASSWORD MATCH
    public boolean validateUser(List<Student> studentList, String studentEmail, String studentPass){
    	for (Student student : studentList) {	/*TYPE STUDENT(OBJECT) NAMED STUDENT FOR THIS FOR EACH LOOP, OF STUDENTLIST ARRAY)*/
    		if (student.getEmail().equalsIgnoreCase(studentEmail) && student.getPass().equalsIgnoreCase(studentPass)) {	/*CHECKING IF OBJECT'S EMAIL && PASSWORD MATCHESMATCHES EMAIL GIVEN*/
    			return true;	/*RETURNS TRUE STUDENT EMAIL AND PASSWORD MATCHES IF FOUND*/
    		}
    	}
		return false;	/*RETURNS TRUE STUDENT EMAIL AND PASSWORD MATCHES IF FOUND*/
    }
}

