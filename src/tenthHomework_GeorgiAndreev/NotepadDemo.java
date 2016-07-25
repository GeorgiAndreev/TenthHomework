package tenthHomework_GeorgiAndreev;

public class NotepadDemo {

	public static void main(String[] args) {

		Page page1 = new Page("page 1");
		page1.addText("Az sum nov text.");
		page1.addText("Az sum oshte nov text.");
		page1.viewPage();
		System.out.println("\nhas digits? " + page1.containsDigits());
		page1.addText(" 1 e cifra.");
		System.out.println("\nhas digits? " + page1.containsDigits());		
		System.out.println("\ncontains 'Az': " + page1.searchWord("Az"));
		System.out.println("\ncontains 'ne': " + page1.searchWord("ne"));
		page1.deleteText();
		page1.viewPage();
		Page page2 = new Page(2);
		page2.viewPage();

		SimpleNotepad simpleNotepad1 = new SimpleNotepad(4);
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
		System.out.println("\ncontains 'stranica': " + simpleNotepad1.searchWord("stranica"));
		System.out.println("\ncontains 'kifla': " + simpleNotepad1.searchWord("kifla"));
		
		NotElectronicSecuredNotepad nesn1 = NotElectronicSecuredNotepad.createNotElectronicSecuredNotepad("e");
		NotElectronicSecuredNotepad nesn2 = NotElectronicSecuredNotepad.createNotElectronicSecuredNotepad("erwa1");
		NotElectronicSecuredNotepad nesn3 = NotElectronicSecuredNotepad.createNotElectronicSecuredNotepad("Erwaw");
		NotElectronicSecuredNotepad nesn4 = NotElectronicSecuredNotepad.createNotElectronicSecuredNotepad("Erwa1");
		NotElectronicSecuredNotepad nesn5 = NotElectronicSecuredNotepad.createNotElectronicSecuredNotepad("Erwa1", 4);
		nesn5.addTextToPage(1, "tekst");
		
		
	}

}
