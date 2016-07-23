package tenthHomework_GeorgiAndreev;

public interface INotepad {
	
	void addTextToPage(int pageNumber, String textToAdd);
	void replaceAllTextOnPage(int pageNumber, String textToAdd);
	void deleteTextOnPage(int pageNumber);
	void viewAllPages();
	boolean searchWord(String word);
	void printAllPagesWithDigits();
}
