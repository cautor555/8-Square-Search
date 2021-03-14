/**
* Class name: Square
* Object to represent an eight square state
*
* @author  Christian Autor
* @version 1.0
* @since   3/14/2021
*/

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Square
{
  private int[] eightSquare;
  private Square parent;
  private Square[] children = new Square[4];
  private int pathCost;
  private int heuristic;

  /**
    * Square constructor
    *
    * @param  none
    * @return none
    */
  public Square()
  {
    int randomNum1, randomNum2, swap;
    eightSquare = new int[9];

    for(int i = 0; i<eightSquare.length; i++)
      eightSquare[i] = i;

    for(int i = 0; i<100; i++)
    {
      randomNum1 = ThreadLocalRandom.current().nextInt(0, 9);
      randomNum2 = ThreadLocalRandom.current().nextInt(0, 9);

      swap = eightSquare[randomNum1];
      eightSquare[randomNum1] = eightSquare[randomNum2];
      eightSquare[randomNum2] = swap;
    }
  }

/**
  * Square constructor
  *
  * @param  Strint input
  * @return none
  */
  public Square(String input)
  {
    eightSquare = new int[9];

    StringTokenizer st1 = new StringTokenizer(input, " ");

    for(int i = 0; i<eightSquare.length; i++)
      eightSquare[i] = Integer.parseInt(st1.nextToken());
  }

  /**
    * Square constructor
    *
    * @param  int[] squareArray
    * @return none
    */
  public Square(int[] squareArray)
  {
    eightSquare = new int[9];

    for(int i = 0; i<squareArray.length; i++)
      eightSquare[i] = squareArray[i];
  }

/**
    * getSquare method
    *
    * @param  int position
    * @return int
    */
  public int getSquare(int position)
  {
    return eightSquare[position];
  }

/**
    * getIndex method
    *
    * @param  int target
    * @return int
    */
  public int getIndex(int target)
  {
    for(int index = 0; index<9; index++)
    {
      if(getSquare(index) == target)
        return index;
    }
    return -1;
  }

/**
    * compareSquares method
    *
    * @param  Square square2
    * @return boolean
    */
  public boolean compareSquares(Square square2)
  {
    for(int i = 0; i<eightSquare.length; i++)
    {
      if(eightSquare[i] != square2.getSquare(i))
        return false;
    }
    return true;
  }

/**
    * calculateParity method
    *
    * @param  none
    * @return int
    */
  public int calculateParity()
  {
    int pCount = 0;

    for(int i = 0; i<eightSquare.length; i++)
    {
      for(int j = i+1; j<eightSquare.length; j++)
      {
        if(eightSquare[i] > eightSquare[j] && !(eightSquare[i] == 0 || eightSquare[j] == 0))
          pCount++;
      }
    }
    return pCount%2;
  }

/**
    * shift method
    *
    * @param  int position
    * @return Square
    */
  public Square shift(int position)
  {
    int[] eightSquareShift = eightSquare.clone();
    int zeroIndex = getIndex(0);

    int swap = eightSquareShift[zeroIndex+position];
    eightSquareShift[zeroIndex+position] = 0;
    eightSquareShift[zeroIndex] = swap;
    return new Square(eightSquareShift);
  }

/**
    * toString method
    *
    * @param  none
    * @return String
    */
  public String toString()
  {
    String S = "";
    for(int index = 0; index<9; index++)
      S += getSquare(index);
    return S;
  }

/**
    * setParent method
    *
    * @param  Square parent
    * @return none
    */
  public void setParent(Square parent)
  {
    this.parent = parent;
  }

/**
    * getParent method
    *
    * @param  none
    * @return Square
    */
  public Square getParent()
  {
    return parent;
  }

/**
    * setChild method
    *
    * @param  Square child
    * @return none
    */
  public void setChild(Square child)
  {
    for(int i = 0; i<children.length; i++)
    {
      if(children[i] == null)
      {
        children[i] = child;
        return;
      }
    }
  }

/**
    * getChild method
    *
    * @param  int index
    * @return Square
    */
  public Square getChild(int index)
  {
    return children[index];
  }

/**
    * setHeuristic1 method
    *
    * @param  Square square2
    * @return none
    */
  public void setHeuristic1(Square square2)
  {
    int count = 0;
    for(int i = 0; i<eightSquare.length; i++)
    {
      if(eightSquare[i] != square2.getSquare(i))
        count++;
    }
    heuristic = count;
  }

/**
    * setHeuristic2 method
    *
    * @param  Square square2
    * @return none
    */
  public void setHeuristic2(Square square2)
  {
    int count = 0;
    int distance;
    for(int i = 0; i<eightSquare.length; i++)
    {
      distance = Math.abs(square2.getIndex(i)-getIndex(i));
      count += distance/3;
      count += distance%3;
    }
    heuristic = count;
  }

/**
    * getHeuristic method
    *
    * @param none
    * @return int
    */
  public int getHeuristic()
  {
    return heuristic;
  }

/**
    * setPathCost method
    *
    * @param int cost
    * @return none
    */
  public void setPathCost(int cost)
  {
    pathCost = cost;
  }

/**
    * getPathCost method
    *
    * @param none
    * @return int
    */
  public int getPathCost()
  {
    return pathCost;
  }

}

/**
* Class name: SquareComparator
* Overrides Comparator class to be used in a priority queue
*
* @author  Christian Autor
* @version 1.0
* @since   3/14/2021
*/
class SquareComparator implements Comparator<Square> {

       @Override
       public int compare(Square sq1, Square sq2) {
           return (sq1.getHeuristic() + sq1.getPathCost()) > (sq2.getHeuristic() + sq2.getPathCost()) ? 1 : -1;
       }
   }
