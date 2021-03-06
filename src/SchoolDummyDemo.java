public class SchoolDummyDemo
{
  public static void main(String[] args)
  {
    School SCD = new School("SCD");

    System.out.println("===== Read Data 1 =====");
    for (int i = 1; i < 13; i++) {
      SCD.readData("src/test" + i + ".txt");
    }
////
//    SCD.readData("src/test1.txt");
    System.out.println("\n===== School Info 1 =====");
    SCD.schoolInfo();
//
    System.out.println("\n===== Read Data 2 =====");
    SCD.readData("src/test2.txt");

    System.out.println("\n===== School Info 2 =====");
    SCD.schoolInfo();
//
    System.out.println("\n===== Search by email =====");
    SCD.searchByEmail("ybyun@csumb.edu");

    System.out.println("\n===== Search by email (fail) =====");
    SCD.searchByEmail("byun@csumb.edu");

    System.out.println("\n===== End of SchoolDemo1 =====");
  }
}
