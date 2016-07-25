package tenthHomework_GeorgiAndreev;

public class SimpleNotepad implements INotepad {

	private static final int DEFAULT_NUMBER_OF_PAGES_IN_NOTEPAD = 100;
	private Page[] pages;

	public SimpleNotepad() {
		this.pages = new Page[DEFAULT_NUMBER_OF_PAGES_IN_NOTEPAD];
		for (int index = 0; index < this.pages.length; index++) {
			Page page = new Page(index + 1);
			this.pages[index] = page;
		}
	}
	
	public SimpleNotepad(int numberOfPages) {
		if (numberOfPages < 1) {
			System.out.println("Invalid number of pages. New notepad will be with default number of pages which is: " + DEFAULT_NUMBER_OF_PAGES_IN_NOTEPAD);
			this.pages = new Page[DEFAULT_NUMBER_OF_PAGES_IN_NOTEPAD];
			for (int index = 0; index < this.pages.length; index++) {
				Page page = new Page(index + 1);
				this.pages[index] = page;
			}
		} else {
			this.pages = new Page[numberOfPages];
			for (int index = 0; index < this.pages.length; index++) {
				Page page = new Page(index + 1);
				this.pages[index] = page;
			}
		}	
	}

	@Override
	public void addTextToPage(int pageNumber, String textToAdd) {
		if ((pageNumber <= 0) || (pageNumber > this.pages.length)) {
			System.out.println("Invalid page number.");
			return;
		}
		if ((textToAdd == null) || (textToAdd.equals(""))) {
			System.out.println("Invalid text for adding.");
			return;
		}
		this.pages[pageNumber - 1].addText(textToAdd);
	}

	@Override
	public void replaceAllTextOnPage(int pageNumber, String textToAdd) {
		if ((pageNumber <= 0) || (pageNumber > this.pages.length)) {
			System.out.println("Invalid page number.");
			return;
		}
		if ((textToAdd == null) || (textToAdd.equals(""))) {
			System.out.println("Invalid text for adding.");
			return;
		}
		this.pages[pageNumber - 1].deleteText();
		this.pages[pageNumber - 1].addText(textToAdd);
	}

	@Override
	public void deleteTextOnPage(int pageNumber) {
		if ((pageNumber <= 0) || (pageNumber > this.pages.length)) {
			System.out.println("Invalid page number.");
			return;
		}
		this.pages[pageNumber - 1].deleteText();
	}

	@Override
	public void viewAllPages() {
		System.out.println("\nShowing notebook pages:");
		for (int index = 1; index <= pages.length; index++) {
			this.pages[index - 1].viewPage();
		}
	}

	@Override
	public boolean searchWord(String word) {
		for (int index = 1; index <= pages.length; index++) {
			if (this.pages[index - 1].searchWord(word)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void printAllPagesWithDigits() {
		boolean hasPagesWithDigits = false;
		System.out.println("\nPrinting all pages that contain digits:");
		for (int index = 1; index <= pages.length; index++) {
			if (this.pages[index - 1].containsDigits()) {
				hasPagesWithDigits = true;
				this.pages[index - 1].viewPage();
			}
		}
		if (!hasPagesWithDigits) {
			System.out.print(" there are no pages that contain digits in this notebook");
		}
	}

}
