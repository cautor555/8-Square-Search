public class AStarH1 extends Search
{

  public void search(Square start)
  {
    super.search(start);

    boolean solved = false;

    Square sq = start;

    Square hMinCost = sq;



    for(int i = 0; i<50; i++)
    {
      int zeroIndex = sq.getIndex(0);



      if(zeroIndex-3 >= 0)
      {
        Square shiftUp = sq.shift(-3);
        System.out.println("U" + shiftUp.getOutOfPlace(target));
        if(shiftUp.getOutOfPlace(target) < hMinCost.getOutOfPlace(target))
          hMinCost = shiftUp;
      }
      if(zeroIndex+3 <9)
      {
        Square shiftDown = sq.shift(3);
        System.out.println("D" + shiftDown.getOutOfPlace(target));
        if(shiftDown.getOutOfPlace(target) < hMinCost.getOutOfPlace(target))
          hMinCost = shiftDown;
      }
      if((zeroIndex-1)%3 == 0 || (zeroIndex+1)%3 == 0)
      {
        Square shiftLeft = sq.shift(-1);
        System.out.println("L" + shiftLeft.getOutOfPlace(target));
        if(shiftLeft.getOutOfPlace(target) < hMinCost.getOutOfPlace(target))
          hMinCost = shiftLeft;
      }
      if(zeroIndex%3 == 0 || (zeroIndex-1)%3 == 0)
      {
        Square shiftRight = sq.shift(1);
        System.out.println("R" + shiftRight.getOutOfPlace(target));
        if(shiftRight.getOutOfPlace(target) < hMinCost.getOutOfPlace(target))
          hMinCost = shiftRight;
      }
      System.out.println("Min" + hMinCost.getOutOfPlace(target));
      //hMinCost.setParent(sq);
      //sq.setChild(hMinCost);
      System.out.println(sq.toString());
      sq = hMinCost;
      hMinCost = new Square("0 0 0 0 0 0 0 0 0");
      System.out.println(sq.toString());

      if(sq.compareSquares(target))
        solved = true;
    }
    //printOutput(sq);
  }


/*

     make an openlist containing only the starting node
   make an empty closed list
   while (the destination node has not been reached):
       consider the node with the lowest f score in the open list
       if (this node is our destination node) :
           we are finished
       if not:
           put the current node in the closed list and look at all of its neighbors
           for (each neighbor of the current node):
               if (neighbor has lower g value than current and is in the closed list) :
                   replace the neighbor with the new, lower, g value
                   current node is now the neighbor's parent
               else if (current g value is lower and this neighbor is in the open list ) :
                   replace the neighbor with the new, lower, g value
                   change the neighbor's parent to our current node

               else if this neighbor is not in both lists:
                   add it to the open list and set its g

      */












  }
