package tenthHomework_GeorgiAndreev;

import java.util.Scanner;

public abstract class SecuredNotepad implements INotepad {

	private static final int MAX_TRIES_TO_GUESS_PASSWORD = 3;
	private static final int DEFAULT_NUMBER_OF_PAGES_IN_NOTEPAD = 100;
	protected String password;
	protected Page[] pages;

	SecuredNotepad(String password) {
		this.pages = new Page[DEFAULT_NUMBER_OF_PAGES_IN_NOTEPAD];
		for (int index = 0; index < pages.length; index++) {
			pages[index] = new Page(index + 1);
		}
		if ((password != null) && (!password.equals(""))) {
			this.password = password;
		} else {
			System.out.println("Invalid password.");
		}
	}

	SecuredNotepad(String password, int numberOfPages) {
		if (numberOfPages < 0) {
			System.out.println("Invalid number of pages. New notepad will be with default number of pages which is: "
					+ DEFAULT_NUMBER_OF_PAGES_IN_NOTEPAD);
			this.pages = new Page[DEFAULT_NUMBER_OF_PAGES_IN_NOTEPAD];
			for (int index = 0; index < pages.length; index++) {
				pages[index] = new Page(index + 1);
			}
			if ((password != null) && (!password.equals(""))) {
				this.password = password;
			} else {
				System.out.println("Invalid password.");
			}
		} else {
			this.pages = new Page[numberOfPages];
			for (int index = 0; index < pages.length; index++) {
				pages[index] = new Page(index + 1);
			}
			if ((password != null) && (!password.equals(""))) {
				this.password = password;
			} else {
				System.out.println("Invalid password.");
			}
		}

	}

	protected static boolean checkIfPasswordIsStrong(String passwordToCheck) {
		boolean hasSmallLetter = false;
		boolean hasBigLetter = false;
		boolean hasNumber = false;
		if (passwordToCheck.length() < 5) {
			System.out.println("\nPasswort too short. Password must be at least 5 characters long.");
			return false;
		}
		for (int index = 0; index < passwordToCheck.length(); index++) {
			if ((passwordToCheck.charAt(index) >= '0') && (passwordToCheck.charAt(index) <= '9')) {
				hasNumber = true;
			}
			if ((passwordToCheck.charAt(index) >= 'a') && (passwordToCheck.charAt(index) <= 'z')) {
				hasSmallLetter = true;
			}
			if ((passwordToCheck.charAt(index) >= 'A') && (passwordToCheck.charAt(index) <= 'Z')) {
				hasBigLetter = true;
			}
		}
		if ((!hasNumber) || (!hasSmallLetter) || (!hasBigLetter)) {
			System.out.println(
					"\nWeak password. Password must contain at least one number, one small letter and one big letter.");
			return false;
		}
		return true;
	}

	boolean verifyPassword() {
		byte tries = 0;
		boolean guessedPassword = false;
	
		while ((tries < MAX_TRIES_TO_GUESS_PASSWORD) && (guessedPassword == false)) {
			System.out.printf("\nOperation requires password. Insert password(you have %d tries):",
					MAX_TRIES_TO_GUESS_PASSWORD);	
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String password = sc.next().trim();
			if (!this.password.equals(password)) {
				tries++;
				System.out.printf("\nInvalid password. You have %d more tries left.",
						MAX_TRIES_TO_GUESS_PASSWORD - tries);
			} else {
				System.out.println("Password accepted.");
				guessedPassword = true;
			}
		}
		if (!guessedPassword) {
			System.out.println(" You didn't insert correct passwort and cannot perform action.");
			return false;
		} else {
			return true;
		}

	}

	@Override
	public void addTextToPage(int pageNumber, String textToAdd) {
		if (this.verifyPassword()) {
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
	}

	@Override
	public void replaceAllTextOnPage(int pageNumber, String textToAdd) {
		if (this.verifyPassword()) {
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
	}

	@Override
	public void deleteTextOnPage(int pageNumber) {
		if (this.verifyPassword()) {
			if ((pageNumber <= 0) || (pageNumber > this.pages.length)) {
				System.out.println("Invalid page number.");
				return;
			}
			this.pages[pageNumber - 1].deleteText();
		}
	}

	@Override
	public void viewAllPages() {
		if (this.verifyPassword()) {
			System.out.println("Showing notebook pages:");
			for (int index = 1; index <= pages.length; index++) {
				this.pages[index - 1].viewPage();
			}
		}
	}

	@Override
	public boolean searchWord(String word) {
		if (this.verifyPassword()) {
			for (int index = 1; index <= pages.length; index++) {
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

}
