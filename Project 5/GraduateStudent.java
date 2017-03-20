import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GraduateStudent extends Student{

	private String major;
	private String advisor;
	
	GraduateStudent(String name, String id, String essay, ArrayList<String> errorList, String major, String advisor){
		super(name, id, essay, errorList);
		this.major = major;
		this.advisor = advisor;
	}
	
	public String getMajor(){
		return major;
		
	}
	public void setMajor(String major){
		this.major = major;
	}
	public String getAdvisor(){
		return advisor;
		
	}
	public void setAdvisor(String advisor){
		this.advisor = advisor;
	}
	public void writeToFile(){
		File f = new File(getId() + "_graded.txt");
		try {
			PrintWriter pwrite = new PrintWriter(f);
			pwrite.write("Graduate Student " + getName() + System.lineSeparator()
					+ "Student ID: " + getId() + System.lineSeparator()
					+ "Major: " + getMajor() + System.lineSeparator()
					+ "Advisor: " + getAdvisor() + System.lineSeparator()
					+ getPrintableErrorList());
			pwrite.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
