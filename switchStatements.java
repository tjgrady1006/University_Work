package youtube;
import java.util.Scanner;
/**
 * @author Thomas Grady
 *
 */
public class switchStatements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("What is your name? ");
		
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		
		switch(name)
		{
			case "Tom":
				System.out.println("Hello Tom!");
				break;
			case "Sarah":
				System.out.println("Hello Sarah!");
				break;
			default:
				System.out.println("Hello User!");
				break;
		}

	}

}
