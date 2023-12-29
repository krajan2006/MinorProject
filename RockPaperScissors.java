
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors 
{
    public static boolean isValidChoice(String choice) 
    {
        return "rock".equals(choice) || "paper".equals(choice) || "scissors".equals(choice);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        
        String[] options = {"rock", "paper", "scissors"};
        
        for(int i=1;i<=100;i++) 
        {
            System.out.println("----------------------------------------------------");
            System.out.println("Round - "+i);
            System.out.println("----------------------------------------------------");
            System.out.println("Enter your choice (rock, paper, scissors or exit):");
            String choice = sc.nextLine().toLowerCase();
            if ("exit".equals(choice)) 
            {
                System.out.println("Goodbye!");
                break;
            }

            if (!isValidChoice(choice)) 
            {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            String computerChoice = options[rnd.nextInt(3)];

            System.out.println("Computer choice: " + computerChoice);

            if (choice.equals(computerChoice)) 
            {
                System.out.println("It's a tie!");
            } 
            else if (choice.equals("rock") && computerChoice.equals("scissors") ||
                       choice.equals("paper") && computerChoice.equals("rock") ||
                       choice.equals("scissors") && computerChoice.equals("paper")) 
            {
                System.out.println("You win!");
            }
            else 
            {
                System.out.println("You lose!");
            }
        }
        sc.close();
    }

}
