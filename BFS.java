import java.util.*;

public class BFS extends Search
{
  Square sq;

  Queue<Square> queue =  new LinkedList<>();

  public void search(Square start)
  {
    super.search(start);

    queue.add(root);


    while(queue.peek() != null)
    {
      sq = queue.poll();

      if(sq.compareSquares(target))
        break;

      if(!visited.containsKey(sq.toString()))
      {
        visited.put(sq.toString(), "");
        exploreChildren(sq);
      }
    }

    printOutput(sq);

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
