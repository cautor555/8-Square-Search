import java.util.*;

public class BFS extends Search
{
  Square sq;

  Queue<Square> queue =  new LinkedList<>();
  HashMap<String, String> squareStates = new HashMap<String, String>();
  //List<Square> path = new ArrayList<Square>();

  public void search(Square start)
  {
    super.search(start);

    exploredNodes = 0;

    queue.add(root);


    while(queue.peek() != null)
    {
      sq = queue.poll();



      if(sq.compareSquares(target))
        break;

      if(!squareStates.containsKey(sq.toString()))
      {
        squareStates.put(sq.toString(), "");
        exploreChildren(sq);
        exploredNodes++;
      }
    }

    printOutput(sq);

/*
    path.add(sq);
    while(sq.getParent() != null)
    {
      sq = sq.getParent();
      path.add(sq);
    }

    System.out.println("First 5 moves: ");

    for(int i = path.size()-1; i>=path.size()-5; i--)
    {
      System.out.println(path.get(i).toString().substring(0,3));
      System.out.println(path.get(i).toString().substring(3,6));
      System.out.println(path.get(i).toString().substring(6,9) + "\n");
    }

    System.out.println("Number of explored nodes: " + exploredNodes + "\n");
    System.out.println("Number of moves: " + path.size());

*/

  }


  public void exploreChildren(Square sq)
  {
    int zeroIndex = sq.getIndex(0);

    if(zeroIndex-3 >= 0)
    {
      Square shiftUp = sq.shift(-3);
      shiftUp.setParent(sq);
      sq.setChild(shiftUp);
      queue.add(shiftUp);
    }
    if(zeroIndex+3 <9)
    {
      Square shiftDown = sq.shift(3);
      shiftDown.setParent(sq);
      sq.setChild(shiftDown);
      queue.add(shiftDown);
    }
    if((zeroIndex-1)%3 == 0 || (zeroIndex+1)%3 == 0)
    {
      Square shiftLeft = sq.shift(-1);
      shiftLeft.setParent(sq);
      sq.setChild(shiftLeft);
      queue.add(shiftLeft);
    }
    if(zeroIndex%3 == 0 || (zeroIndex-1)%3 == 0)
    {
      Square shiftRight = sq.shift(1);
      shiftRight.setParent(sq);
      sq.setChild(shiftRight);
      queue.add(shiftRight);
    }
  }
}
