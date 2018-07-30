package CoreJava.Models;

//THE PURPOSE OF THE STUDENT CLASS IS TO CARRY DATA RELATED TO ONE STUDENT.
	public class Student {
//	INSTANCIATING VARIABLES
		private String email;
		private String name;
		private String pass;
//	DEFAULT CONSTRUCTOR ADDED BECAUSE WE ARE USING MORE THAN 1	
		public Student() {
			
		}
//	2ND CONSTRUCTOR WITH PARAMETERS
	   public Student(String email, String name, String pass) {
		   this.email = email;
		   this.name = name;
		   this.pass = pass;
	   }
		    
//	GETTERS AND SETTERS
		public String getEmail() {
			return email;
		}
	
		public void setEmail(String email) {
			this.email = email;
		}
	
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
		}
	
		public String getPass() {
			return pass;
		}
	
		public void setPass(String pass) {
			this.pass = pass;
		}
	}
