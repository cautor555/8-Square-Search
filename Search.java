import java.util.*;

public abstract class Search
{
  Square target;
  Square root;
  int exploredNodes;

  List<Square> path = new ArrayList<Square>();


  protected void search(Square start)
  {
    root = start;
    if(root.calculateParity() == 0)
      target = new Square("1 2 3 4 5 6 7 8 0");
    else
      target = new Square("1 2 3 8 0 4 7 6 5");
  }


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

    for(int i = path.size()-2; i>=path.size()-6; i--)
    {
      System.out.println(path.get(i).toString().substring(0,3));
      System.out.println(path.get(i).toString().substring(3,6));
      System.out.println(path.get(i).toString().substring(6,9) + "\n");
    }

    System.out.println("Number of explored nodes: " + exploredNodes);
    System.out.println("Number of moves: " + path.size());
  }



}
