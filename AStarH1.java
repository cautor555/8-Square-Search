import java.util.*;

public class AStarH1 extends Search
{
  Queue<Square> pQueue =  new PriorityQueue<>(new SquareComparator());

  Square sq;

  public void search(Square start)
  {
    super.search(start);

    boolean solved = false;

    pQueue.add(start);

    while(!solved)
    {
      sq = pQueue.poll();

      if(sq.compareSquares(target))
      {
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

      if(!(visited.containsKey(shiftUp.toString())))
      {
        shiftUp.setPathCost(sq.getPathCost() + 1);
        shiftUp.setHeuristic1(target);
        shiftUp.setParent(sq);
        sq.setChild(shiftUp);
        pQueue.add(shiftUp);
      }
    }

    if(zeroIndex+3 <9)
    {
      Square shiftDown = sq.shift(3);

      if(!(visited.containsKey(shiftDown.toString())))
      {
        shiftDown.setPathCost(sq.getPathCost() + 1);
        shiftDown.setHeuristic1(target);
        shiftDown.setParent(sq);
        sq.setChild(shiftDown);
        pQueue.add(shiftDown);
      }
    }

    if((zeroIndex-1)%3 == 0 || (zeroIndex+1)%3 == 0)
    {
      Square shiftLeft = sq.shift(-1);

      if(!(visited.containsKey(shiftLeft.toString())))
      {
        shiftLeft.setPathCost(sq.getPathCost() + 1);
        shiftLeft.setHeuristic1(target);
        shiftLeft.setParent(sq);
        sq.setChild(shiftLeft);
        pQueue.add(shiftLeft);
      }
    }

    if(zeroIndex%3 == 0 || (zeroIndex-1)%3 == 0)
    {
      Square shiftRight = sq.shift(1);

      if(!(visited.containsKey(shiftRight.toString())))
      {
        shiftRight.setPathCost(sq.getPathCost() + 1);
        shiftRight.setHeuristic1(target);
        shiftRight.setParent(sq);
        sq.setChild(shiftRight);
        pQueue.add(shiftRight);
      }
    }
  }

}
