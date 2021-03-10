import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Square
{
  int[] eightSquare;

  Square parent;
  Square[] children = new Square[4];

  public Square()
  {
    int randomNum1, randomNum2, temp;

    eightSquare = new int[9];
    for(int i = 0; i<eightSquare.length; i++)
      eightSquare[i] = i;

    for(int i = 0; i<100; i++)
    {
      randomNum1 = ThreadLocalRandom.current().nextInt(0, 9);
      randomNum2 = ThreadLocalRandom.current().nextInt(0, 9);

      temp = eightSquare[randomNum1];
      eightSquare[randomNum1] = eightSquare[randomNum2];
      eightSquare[randomNum2] = temp;
    }
  }

  public Square(String input)
  {
    eightSquare = new int[9];

    StringTokenizer st1 = new StringTokenizer(input, " ");

    for(int i = 0; i<eightSquare.length; i++)
      eightSquare[i] = Integer.parseInt(st1.nextToken());
  }



  public Square(int[] squareArray)
  {
    eightSquare = new int[9];
    for(int i = 0; i<squareArray.length; i++)
      eightSquare[i] = squareArray[i];

  }




  public int getSquare(int position)
  {
    return eightSquare[position];
  }

  public boolean compareSquares(Square square2)
  {
    for(int i = 0; i<eightSquare.length; i++)
    {
      if(eightSquare[i] != square2.getSquare(i))
        return false;
    }
    return true;
  }

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

  public int getIndex(int target)
  {
    for(int index = 0; index<9; index++)
    {
      if(getSquare(index) == target)
        return index;
    }
    return -1;
  }

  public Square shift(int position)
  {
    int[] eightSquareShift = eightSquare.clone();
    int zeroIndex = getIndex(0);

    int temp = eightSquareShift[zeroIndex+position];
    eightSquareShift[zeroIndex+position] = 0;
    eightSquareShift[zeroIndex] = temp;
    return new Square(eightSquareShift);
  }

  public String toString()
  {
    String S = "";
    for(int index = 0; index<9; index++)
      S += getSquare(index);
    return S;
  }

  public int getOutOfPlace(Square square2)
  {
    int count = 0;
    for(int i = 0; i<eightSquare.length; i++)
    {
      if(eightSquare[i] != square2.getSquare(i))
        count++;
    }
    return count;
  }

  public void setParent(Square parent)
  {
    this.parent = parent;
  }

  public Square getParent()
  {
    return parent;
  }

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

}
