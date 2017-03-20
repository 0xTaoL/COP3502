import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Grader {

	private boolean available;
	private Student student;
	private Dictionary dict;
	
	public Grader(Dictionary dict) {
		this.dict = dict;
		this.available = true;
	}
	
	public boolean gradeStudent(String fileName){
		try {
			String name;
			String id;
			String major;
			String school;
			String advisor;
			ArrayList<String> errorList = new ArrayList<>();
			File aFile = new File (fileName + ".txt");
			Scanner input = new Scanner(aFile);
			String level = input.nextLine();
			if(level.equals("Graduate Student")){
				name = input.nextLine();
				id = input.nextLine();
				major = input.nextLine();
				advisor = input.nextLine();
				while(input.hasNext()){
					String temp = input.next().replaceAll("[^\\w\\'\\-]", "");
					if(!dict.isWord(temp)){
					errorList.add(temp);
					}
				}
				student = new GraduateStudent(name, id, fileName, errorList, major, advisor);
				available = false;
				return true;
			}
			if(level.equals("Undergraduate Student")){
				name = input.nextLine();
				id = input.nextLine();
				major = input.nextLine();
				while(input.hasNext()){
					String temp = input.next().replaceAll("[^\\w\\'\\-]", "");
					if(!dict.isWord(temp)){
					errorList.add(temp);
					}
				}
				student = new UndergraduateStudent(name, id, fileName, errorList, major);
				available = false;
				return true;
			}
			if(level.equals("HighSchool Student")){
				name = input.nextLine();
				id = input.nextLine();
				school = input.nextLine();
				while(input.hasNext()){
					String temp = input.next().replaceAll("[^\\w\\'\\-]", "");
					if(!dict.isWord(temp)){
					errorList.add(temp);
					}
				}
				student = new HighSchoolStudent(name, id, fileName, errorList, school);
				available = false;
				return true;
			}
			
		}
		catch(IOException x){
			reset();
			return false;
		}
		reset();
		return false;
		
	}
	
	public boolean isAvailable(){
		if((this.student == null) && (available == true)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public Student getStudent(){
		return student;
		
	}
	
	public void reset(){
		this.student = null;
		this.available = true;
	}

}
