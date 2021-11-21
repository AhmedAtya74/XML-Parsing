package Parsing;
import java.util.Scanner;

import org.w3c.dom.Node;

public class Demo {

	public static void main(String argv[]) {
		Catalogue catalogue = new Catalogue();
		Printer printer = new Printer();
		CD cdInfo = new CD();
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {

				System.out.println("Web Application - XML \n\n" + "--------------------------------------------\n"
						+ "1. Add More CDs \n" + "--------------------------------------------\n"
						+ "2. Search for a Specific CD in terms of Title or Artist \n"
						+ "--------------------------------------------\n" + "3. Display All Elemenst (XML Document) \n"
						+ "--------------------------------------------\n" + "4. Exit \n"
						+ "--------------------------------------------\n");

				System.out.print("Enter operation number U want do it: ");
				String choice = sc.nextLine();
				
                            switch (choice) {
                                case "1":
                                    System.out.print("Enter the number of CDs U wants to store data about: ");
                                    int nCV = sc.nextInt();
                                    sc.nextLine();
                                    for (int i = 0; i < nCV; i++) {
                                        System.out.println("CDs #"+ (i +1) +" Information U wants to store about it :- \n"
                                                + "--------------------------------------------");
                                        
                                        System.out.print("Enter title: ");
                                        String title = sc.nextLine();
                                        cdInfo.setTitile(title);
                                        
                                        System.out.print("Enter artist: ");
                                        String artist = sc.nextLine();
                                        cdInfo.setArtist(artist);
                                        
                                        System.out.print("Enter country: ");
                                        String country = sc.nextLine();
                                        cdInfo.setCountry(country);
                                        
                                        System.out.print("Enter company: ");
                                        String company = sc.nextLine();
                                        cdInfo.setCompany(company);
                                        
                                        System.out.print("Enter Price: ");
                                        String price = sc.nextLine();
                                        cdInfo.setPrice(price);
                                        
                                        System.out.print("Enter Year: ");
                                        String year = sc.nextLine();
                                        cdInfo.setYear(year);
                                        
                                        catalogue.addCD(cdInfo);
                                        
                                        System.out.println("**********************************************************\n");
                                    }
                                    break;
                                case "2":
                                    System.out.println("Enter Search Key **(Title or artist)");
                                    String key = sc.nextLine();
                                    Node node = catalogue.searchByKey(key);
                                    if(node == null)
                                        System.out.println("Not Found.");
                                    else
                                        printer.printNode(node);
                                    break;
                                case "3":
                                    printer.printAll(catalogue);
                                    break;
                                case "4":
                                    System.out.println("-------- Thank U ------------");
                                    return;
                                default:
                                    System.out.println("Invalid Choice");
                                    break;
                            }
				
				System.out.println("\n\n\n");
			}
		}

	}
}
