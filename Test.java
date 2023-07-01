// the ridiculous testing library i made in 5 minutes as a joke
public class Test {

  private static int depth = 1;

  public static void describe(String msg) {
    System.out.println(msg + ":");
  }

  public static void it(String should, ItFunction itf) {
    try {
      ++depth;
      System.out.println("  ".repeat(depth) + should);
      long time = System.currentTimeMillis();
      itf.run();
      System.out.println("  ".repeat(depth--)  // decrease depth by 1 aswell
                         + should 
                         + " PASSED in "
                         + (System.currentTimeMillis() - time) + "ms.\n"); // look i even have time checking and depth because i'm cooler than junit
    } catch(AssertionError e) {
      
      System.out.println("  " + should + " FAILED with message:\n  " + e.getMessage());
    }catch (Exception e) {
      e.printStackTrace();
    }
  }
  


  @FunctionalInterface
  public static interface ItFunction {
    void run() throws Exception;
  }


  public static void assertNot(boolean b) {
    assertEquals(b, false);
  }
  public static void assertTrue(boolean b) {
    assertEquals(b, true);
  }
  public static void assertEquals(int a, int b) {
  if (a != b) throw new AssertionError("Expected " + a + " to equal " + b);
  }
  public static void assertEquals(Object o, Object p) {
    if (o == null && p == null) return;
    if (o != p) throw new AssertionError("Expected " + o + " to equal " + p);
  }
  
  
}
