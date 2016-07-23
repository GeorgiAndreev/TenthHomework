package tenthHomework_GeorgiAndreev;

public class Page {
	
	private String title;
	private String text;
	private int number;
	
	public Page(int number) {
		if (number > 0) {
			this.number = number;
		} else {
			System.out.println("Invalid number.");
		}
		this.title = "Page " + number;
		this.text = "";
	}
	
	public Page(String title) {
		if ((title != null) && (!title.equals(""))) {
			this.title = title;
		} else {
			System.out.println("Invalid title.");
		}
		this.text = "";
	}
	
	void addText(String text) {
		if ((text != null) && (!text.equals(""))) {
			this.text = this.text + " " + text;
		} else {
			System.out.println("Invalid text.");
		}
	}
	
	void deleteText() {
		this.text = null;
	}
	
	void viewPage() {
		System.out.println("Title: " + this.title);
		System.out.println("Text: " + this.text);
	}
	
	boolean searchWord(String word) {
		if ((word == null) || (word.equals(""))) {
			System.out.println("Invalid word.");
			return false;
		}
		if (this.text.contains(word)) {
			return true;
		}
		return false;
	}
	
	boolean containsDigits() {
		if (this.text.contains("0") || this.text.contains("1") || this.text.contains("2") || this.text.contains("3") || this.text.contains("4") || this.text.contains("5") || this.text.contains("6") ||  this.text.contains("7") || this.text.contains("8") || this.text.contains("9")) {
			return true;
		}
		return false;
	}

}
