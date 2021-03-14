
import java.util.*;

public class Main
{
  public static void main(String[] args)
  {
    Square A;
    String input = null;
    Scanner sc = new Scanner(System.in);

    System.out.println("Type squares separated by spaces to make a custom 8 square or press enter to make a random 8 square");

    if((input = sc.nextLine()).isEmpty())
      A = new Square();
    else
      A = new Square(input);

    System.out.println("BFS Search: ");
    BFS BFSearch = new BFS();
    BFSearch.search(A);

    System.out.println("\nA Star H1: ");
    AStarH1 AStarH1Search = new AStarH1();
    AStarH1Search.search(A);

    System.out.println("\nA Star H2: ");
    AStarH2 AStarH2Search = new AStarH2();
    AStarH2Search.search(A);
  }
}
