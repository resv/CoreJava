package CoreJava.Models;

public class Attending {

//	INSTANCIATING VARIABLES	
		private int courseID;
		private String studentEmail;
		
//	DEFAULT CONSTRUCTOR ADDED BECAUSE WE ARE USING MORE THAN 1		
	    public Attending() {
	    	
		}
    
//	2ND CONSTRUCTOR WITH PARAMETERS
		public Attending(int courseID, String studentEmail) {
			this.courseID = courseID;
			this.studentEmail = studentEmail;
		}
		
//	GETTERS AND SETTERS
		public int getCourseID() {
			return courseID;
		}
	
		public void setCourseID(int courseID) {
			this.courseID = courseID;
		}
	
		public String getStudentEmail() {
			return studentEmail;
		}
	
		public void setStudentEmail(String studentEmail) {
			this.studentEmail = studentEmail;
		}
}
