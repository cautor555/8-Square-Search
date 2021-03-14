/**
* Class name: Search
* Abstract class for search algorithms to extend
*
* @author  Christian Autor
* @version 1.0
* @since   3/14/2021
*/

import java.util.*;

public abstract class Search
{
  protected Square target, root;
  protected List<Square> path = new ArrayList<Square>();
  protected HashMap<String, String> visited = new HashMap<String, String>();

/**
    * search method
    *
    * @param  Square start
    * @return none
    */
  protected void search(Square start)
  {
    root = start;
    if(root.calculateParity() == 0)
      target = new Square("1 2 3 4 5 6 7 8 0");
    else
      target = new Square("1 2 3 8 0 4 7 6 5");
  }

/**
    * printOutput method
    *
    * @param  Square sq
    * @return none
    */
  protected void printOutput(Square sq)
  {
    path.add(sq);

    while(sq.getParent() != null)
    {
      sq = sq.getParent();
      path.add(sq);
    }

    System.out.println("\nInitial state:");
    System.out.println(root.toString().substring(0,3));
    System.out.println(root.toString().substring(3,6));
    System.out.println(root.toString().substring(6,9) + "\n");

    System.out.println("First 5 moves: ");
    int i = path.size()-2;
    while(i >= path.size()-6 && i>=0)
    {
      System.out.println(path.get(i).toString().substring(0,3));
      System.out.println(path.get(i).toString().substring(3,6));
      System.out.println(path.get(i).toString().substring(6,9) + "\n");
      i--;
    }

    System.out.println("Number of explored nodes: " + visited.size());
    System.out.println("Number of moves: " + (path.size()-1));
  }

/**
    * exploreChildren abstract method
    *
    * @param  Square sq
    * @return none
    */
  protected abstract void exploreChildren(Square sq);

}
