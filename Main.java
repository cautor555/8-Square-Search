public class Main
{
  public static void main(String[] args)
  {
    Square A = new Square();
    //Square A = new Square("1 2 8 5 7 6 3 4 0");

    BFS BFSearch = new BFS();
    BFSearch.search(A);

    System.out.println("\n\n");

    AStarH1 AStarH1Search = new AStarH1();
    AStarH1Search.search(A);

    AStarH2 AStarH2Search = new AStarH2();
    AStarH2Search.search(A);
  }
}
