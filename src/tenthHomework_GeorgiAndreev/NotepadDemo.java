package tenthHomework_GeorgiAndreev;

public class NotepadDemo {

	public static void main(String[] args) {

		Page page1 = new Page("page 1");
		page1.addText("Az sum nov text.");
		page1.addText("Az sum oshte nov text.");
		page1.viewPage();

		SimpleNotepad simpleNotepad1 = new SimpleNotepad();
		simpleNotepad1.addTextToPage(1, "Az sum na 1-vata stranica");
		simpleNotepad1.addTextToPage(2, "Az sum na 2-rata stranica");
		simpleNotepad1.addTextToPage(3, "Az sum na 3-tata stranica");
		simpleNotepad1.addTextToPage(4, "Az sum na 4-tata stranica");
		simpleNotepad1.viewAllPages();
		simpleNotepad1.deleteTextOnPage(2);
		simpleNotepad1.viewAllPages();
		simpleNotepad1.addTextToPage(2, "Az sum tekst bez nomer");
		simpleNotepad1.printAllPagesWithDigits();
		simpleNotepad1.replaceAllTextOnPage(1, "nov tekst");
		simpleNotepad1.viewAllPages();
		System.out.println("\n" + simpleNotepad1.searchWord("stranica"));
		System.out.println("\n" + simpleNotepad1.searchWord("kifla"));

	}

}
