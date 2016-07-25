package tenthHomework_GeorgiAndreev;

public class NotElectronicSecuredNotepad extends SecuredNotepad implements INotepad{

	private NotElectronicSecuredNotepad(String password) {
		super(password);
	}
	
	private NotElectronicSecuredNotepad(String password, int numberOfPages) {
		super(password, numberOfPages);
	}
	
	public static NotElectronicSecuredNotepad createNotElectronicSecuredNotepad(String password) {
		if (SecuredNotepad.checkIfPasswordIsStrong(password)) {
			return new NotElectronicSecuredNotepad(password);
		}
		System.out.println("Cannot create new not electronic sequred notepad.");
		return null;
	}
	
	public static NotElectronicSecuredNotepad createNotElectronicSecuredNotepad(String password, int numberOfPages) {
		if (SecuredNotepad.checkIfPasswordIsStrong(password)) {
			if (numberOfPages > 0) {
				return new NotElectronicSecuredNotepad(password, numberOfPages);
			} else {
				System.out.println("Invalid number of pages.");
				return null;
			}	
		}
		System.out.println("Cannot create new not electronic sequred notepad.");
		return null;
	}

	@Override
	public void addTextToPage(int pageNumber, String textToAdd) {
		if (this.verifyPassword()) {
			if ((pageNumber < 0) || (pageNumber >= this.pages.length)) {
				System.out.println("Invalid page number.");
				return;
			}
			if ((textToAdd == null) || (textToAdd.equals(""))) {
				System.out.println("Invalid text for adding.");
				return;
			}
			this.pages[pageNumber - 1].addText(textToAdd);
		}	
	}

	@Override
	public void replaceAllTextOnPage(int pageNumber, String textToAdd) {
		if (this.verifyPassword()) {
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
	}

	@Override
	public void deleteTextOnPage(int pageNumber) {
		if (this.verifyPassword()) {
			if ((pageNumber < 0) || (pageNumber >= this.pages.length)) {
				System.out.println("Invalid page number.");
				return;
			}
			this.pages[pageNumber - 1].deleteText();
		}
	}

	@Override
	public void viewAllPages() {
		if (this.verifyPassword()) {
			System.out.println("Showing notebook pages:\n");
			for (int index = 0; index < pages.length; index++) {
				this.pages[index - 1].viewPage();
			}
		}
	}

	@Override
	public boolean searchWord(String word) {
		if (this.verifyPassword()) {
			for (int index = 0; index < pages.length; index++) {
				if (this.pages[index - 1].searchWord(word)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void printAllPagesWithDigits() {
		if (this.verifyPassword()) {
			boolean hasPagesWithDigits = false;
			System.out.println("Printing all pages that contain digits:");
			for (int index = 0; index < pages.length; index++) {
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

}
