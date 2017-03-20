import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class HighSchoolStudent extends Student{
	
	private String nameOfSchool;
	
	HighSchoolStudent(String name, String id, String essay, ArrayList<String> errorList, String nameOfSchool){
		super(name, id, essay, errorList);
		this.nameOfSchool = nameOfSchool;
	}
	
	public String getSchoolName(){
		return nameOfSchool;
		
	}
	
	public void setSchoolName(String schoolName){
		this.nameOfSchool = schoolName;
	}
	
	public void writeToFile(){
		File f = new File(getId() + "_graded.txt");
		try {
			PrintWriter pwrite = new PrintWriter(f);
			pwrite.write("High School Student " + getName() + System.lineSeparator()
					+ "Student ID: " + getId() + System.lineSeparator()
					+ "School Name:  " + getSchoolName() + System.lineSeparator()
					+ getPrintableErrorList());
			pwrite.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
