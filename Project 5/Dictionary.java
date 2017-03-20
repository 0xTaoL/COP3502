import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {

	private ArrayList<String> dictionary = new ArrayList<>();
	
	
	public int getVocabularySize() {
		return dictionary.size();
	}

	public boolean loadDictionaryFromFile(String string){
		try {
			File aFile = new File (string);
			Scanner input = new Scanner(aFile);
			while(input.hasNextLine()){
				dictionary.add(input.nextLine().toLowerCase());
			}
			return true;
		} 
		catch (Exception e) {
			return false;
		}
	}

	public boolean isWord(String word){
		String temp = word.replaceAll("[^\\w\\'\\-]", "");
		for(int i=0; i <getVocabularySize(); i++){
			if(dictionary.get(i).equalsIgnoreCase(temp)){
				return true;
			}
		}
		return false;
	}
}
