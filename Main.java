
import java.util.*;

public class Main
{
  public static void main(String[] args)
  {
    Square A;

    System.out.println("Type squares separated by spaces to make a custom 8 square or press enter to make a random 8 square");

    Scanner sc = new Scanner(System.in);
    
    String input = null;

    if((input = sc.nextLine()).isEmpty())
      A = new Square();
    else
      A = new Square(input);


    BFS BFSearch = new BFS();
    BFSearch.search(A);

    System.out.println("\n\n");

    AStarH1 AStarH1Search = new AStarH1();
    AStarH1Search.search(A);

    AStarH2 AStarH2Search = new AStarH2();
    AStarH2Search.search(A);
  }
}
