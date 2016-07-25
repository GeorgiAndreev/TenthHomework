package tenthHomework_GeorgiAndreev;

public class SimpleNotepad implements INotepad {

	private Page[] pages;

	public SimpleNotepad() {
		this.pages = new Page[4];
		for (int index = 0; index < pages.length; index++) {
			Page page = new Page(index + 1);
			this.pages[index] = page;
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
		if ((pageNumber < 0) || (pageNumber >= this.pages.length)) {
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
		if ((pageNumber < 0) || (pageNumber >= this.pages.length)) {
			System.out.println("Invalid page number.");
			return;
		}
		this.pages[pageNumber - 1].deleteText();
	}

	@Override
	public void viewAllPages() {
		System.out.println("\nShowing notebook pages:\n");
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
		System.out.println("\nPrinting all pages that contain digits:\n");
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
