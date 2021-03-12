import java.util.*;

public class AStarH1 extends Search
{
  Queue<Square> pQueue =  new PriorityQueue<>(new SquareComparator());
  HashMap<String, String> notVisited = new HashMap<String, String>();

  Square sq;

  public void search(Square start)
  {
    super.search(start);

    boolean solved = false;

    exploredNodes = 0;



    pQueue.add(start);

    while(!solved)
    {
      sq = pQueue.poll();

      if(sq.compareSquares(target))
      {
        System.out.println(sq.toString());
        solved = true;
        break;
      }

      visited.put(sq.toString(), "");

      exploreChildren(sq);
    }

    printOutput(sq);

  }



  public void exploreChildren(Square sq)
  {
    int zeroIndex = sq.getIndex(0);

    if(zeroIndex-3 >= 0)
    {
      Square shiftUp = sq.shift(-3);

      if(!(visited.containsKey(shiftUp.toString())) && !(notVisited.containsKey(shiftUp.toString())))
      {
        shiftUp.setPathCost(sq.getPathCost() + 1);
        shiftUp.setHeuristic(target);
        shiftUp.setParent(sq);
        sq.setChild(shiftUp);
        pQueue.add(shiftUp);
      }
    }

    if(zeroIndex+3 <9)
    {
      Square shiftDown = sq.shift(3);

      if(!(visited.containsKey(shiftDown.toString())) && !(notVisited.containsKey(shiftDown.toString())))
      {
        shiftDown.setPathCost(sq.getPathCost() + 1);
        shiftDown.setHeuristic(target);
        shiftDown.setParent(sq);
        sq.setChild(shiftDown);
        pQueue.add(shiftDown);
      }
    }

    if((zeroIndex-1)%3 == 0 || (zeroIndex+1)%3 == 0)
    {
      Square shiftLeft = sq.shift(-1);

      if(!(visited.containsKey(shiftLeft.toString())) && !(notVisited.containsKey(shiftLeft.toString())))
      {
        shiftLeft.setPathCost(sq.getPathCost() + 1);
        shiftLeft.setHeuristic(target);
        shiftLeft.setParent(sq);
        sq.setChild(shiftLeft);
        pQueue.add(shiftLeft);
      }
    }

    if(zeroIndex%3 == 0 || (zeroIndex-1)%3 == 0)
    {
      Square shiftRight = sq.shift(1);

      if(!(visited.containsKey(shiftRight.toString())) && !(notVisited.containsKey(shiftRight.toString())))
      {
        shiftRight.setPathCost(sq.getPathCost() + 1);
        shiftRight.setHeuristic(target);
        shiftRight.setParent(sq);
        sq.setChild(shiftRight);
        pQueue.add(shiftRight);
      }
    }

  }

}
