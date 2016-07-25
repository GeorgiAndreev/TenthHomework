package tenthHomework_GeorgiAndreev;

public class NotepadDemo {

	public static void main(String[] args) {

		System.out.println("\nPAGE TEST:");
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
		
		System.out.println("\nSIMPLE NOTEPAD TEST:");
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
		
		System.out.println("\nNOT ELECTRONIC SEQURED NOTEPAD TEST:");
		NotElectronicSecuredNotepad nesn1 = NotElectronicSecuredNotepad.createNotElectronicSecuredNotepad("k");
		NotElectronicSecuredNotepad nesn2 = NotElectronicSecuredNotepad.createNotElectronicSecuredNotepad("kofa1");
		NotElectronicSecuredNotepad nesn3 = NotElectronicSecuredNotepad.createNotElectronicSecuredNotepad("Kofaa");
		NotElectronicSecuredNotepad nesn4 = NotElectronicSecuredNotepad.createNotElectronicSecuredNotepad("Kofa1");
		NotElectronicSecuredNotepad nesn5 = NotElectronicSecuredNotepad.createNotElectronicSecuredNotepad("Kofa1", 4);
		nesn5.addTextToPage(1, "tekst");
		nesn5.addTextToPage(2, "tekst 2");
		nesn5.addTextToPage(3, "tekst na str. 3");
		nesn5.addTextToPage(4, "tekst posleden");
		nesn5.viewAllPages();
		nesn5.deleteTextOnPage(1);
		nesn5.viewAllPages();
		nesn5.replaceAllTextOnPage(2, "nov tekst");
		nesn5.viewAllPages();
		nesn5.printAllPagesWithDigits();
		System.out.println("\ncontains 'nov': " + nesn5.searchWord("nov"));
		System.out.println("\ncontains 'banica': " + nesn5.searchWord("banica"));
		
		System.out.println("\nELECTRONIC SEQURED NOTEPAD TEST:");
		ElectronicSecuredNotepad esn1 = ElectronicSecuredNotepad.createElectronicSecuredNotepad("k");
		ElectronicSecuredNotepad esn2 = ElectronicSecuredNotepad.createElectronicSecuredNotepad("kofa1");
		ElectronicSecuredNotepad esn3 = ElectronicSecuredNotepad.createElectronicSecuredNotepad("Kofaa");
		ElectronicSecuredNotepad esn4 = ElectronicSecuredNotepad.createElectronicSecuredNotepad("Kofa1");
		ElectronicSecuredNotepad esn5 = ElectronicSecuredNotepad.createElectronicSecuredNotepad("Kofa1", 4);
		esn5.addTextToPage(1, "tekst na str. 1");
		esn5.start();
		esn5.addTextToPage(1, "tekst na str. 1");
		esn5.stop();
		esn5.addTextToPage(2, "tekst na str. 2");
		esn5.start();
		esn5.addTextToPage(2, "tekst na str. 2");
		esn5.addTextToPage(3, "tekst na str. 3");
		esn5.addTextToPage(4, "tekst na str. 4");
		esn5.viewAllPages();
		esn5.deleteTextOnPage(1);
		esn5.viewAllPages();
		esn5.replaceAllTextOnPage(3, "nov tekst na taq str.");
		esn5.viewAllPages();
		esn5.printAllPagesWithDigits();
		System.out.println("\ncontains 'na': " + esn5.searchWord("na"));
		System.out.println("\ncontains 'luk': " + esn5.searchWord("luk"));
		
	}

}
