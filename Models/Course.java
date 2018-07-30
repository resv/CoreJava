package CoreJava.Models;

//	THE PURPOSE OF THE COURSE CLASS IS TO CARRY DATA RELATED TO ONE COURSE.
	public class Course {
			
//	INSTANCIATING VARIABLES
		private String courseID;
		private String courseName;
		private String instructorName;
			
//	DEFAULT CONSTRUCTOR ADDED BECAUSE WE ARE USING MORE THAN 1		
		public Course() {
			
		}
//	2ND CONSTRUCTOR WITH PARAMETERS
		public Course(String data, String courseName, String instructorName) {
			
			this.courseID = data;
			this.courseName = courseName;
			this.instructorName = instructorName;
		}
//	GETTERS AND SETTERS
		public String getID() {
			return courseID;
		}
		
		public void setCourseID(String courseID) {
			this.courseID = courseID;
		}
		
		public String getName() {
			return courseName;
		}
		
		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}
		
		public String getInstructor() {
			return instructorName;
		}
		
		public void setInstructorName(String instructorName) {
			this.instructorName = instructorName;
		}
	}
