package tenthHomework_GeorgiAndreev;

public interface INotepad {
	
	static final int DEFAULT_NUMBER_OF_PAGES_IN_NOTEPAD = 100;
	
	void addTextToPage(int pageNumber, String textToAdd);
	void replaceAllTextOnPage(int pageNumber, String textToAdd);
	void deleteTextOnPage(int pageNumber);
	void viewAllPages();
	boolean searchWord(String word);
	void printAllPagesWithDigits();
	
}
