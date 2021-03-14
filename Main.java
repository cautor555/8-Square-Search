/**
* Class name: Main
* Main class for search algorithm project
*
* @author  Christian Autor
* @version 1.0
* @since   3/14/2021
*/

import java.util.*;

public class Main
{
  public static void main(String[] args)
  {
    Square sq;
    String input;
    Scanner sc = new Scanner(System.in);

    System.out.println("Type squares separated by spaces to make a custom 8 square or press enter to make a random 8 square");

    if((input = sc.nextLine()).isEmpty())
      sq = new Square();
    else
      sq = new Square(input);

    System.out.println("BFS Search: ");
    BFS BFSearch = new BFS();
    BFSearch.search(sq);

    System.out.println("\nA Star H1: ");
    AStarH1 AStarH1Search = new AStarH1();
    AStarH1Search.search(sq);

    System.out.println("\nA Star H2: ");
    AStarH2 AStarH2Search = new AStarH2();
    AStarH2Search.search(sq);
  }
}
