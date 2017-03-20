import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class UndergraduateStudent extends Student{

	private String major;
	
	UndergraduateStudent(String name, String id, String essay, ArrayList<String> errorList, String major){
		super(name, id, essay, errorList);
		this.major = major;
	}
	
	public String getMajor(){
		return major;
		
	}
	
	public void setMajor(String major){
		this.major = major;
	}
	
	public void writeToFile(){
		File f = new File(getId() + "_graded.txt");
		try {
			PrintWriter pwrite = new PrintWriter(f);
			pwrite.write("Undergraduate Student " + getName() + System.lineSeparator()
					+ "Student ID: " + getId() + System.lineSeparator()
					+ "Major: " + getMajor() + System.lineSeparator()
					+ getPrintableErrorList());
			pwrite.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
