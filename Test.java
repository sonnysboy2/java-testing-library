
import java.lang.reflect.*;
import java.util.*;
import java.util.function.BiFunction;
import java.nio.file.*;
import java.util.stream.*;
import java.io.*;

public class Test {

  private static int depth = 1;

  private static int passed = 0;

  private static int testsRan = 0;
  

  public static void describe(final String msg) {

    StackTraceElement[] ah = new Exception().getStackTrace();
    String callingClass = ah[1].getClassName();
    int lineNum = ah[1].getLineNumber();
    System.out.println(String.format("[%s:%d] %s:", callingClass, lineNum, msg));
  }

  public static void it(final String should, final ItFunction itf) {
    StackTraceElement[] ah = new Exception().getStackTrace();
    String callingClass = ah[1].getClassName() + ".java";
    int lineNum = ah[1].getLineNumber();
    testsRan++;
    try {

      System.out.println();

      ++depth;

      itf.run();
      System.out.print("  ".repeat(depth) + should + String.format(" [%s:%d] ", callingClass, lineNum));
      System.out.println("\u2713"); // part 1 of hack
      depth--;

      passed++;
      
    } catch (final AssertionError e) {

      System.out.println("\u274C"); // part 2 of hack

      System.out.println("  ".repeat(depth) + should + " FAILED AT " + callingClass + ":" + lineNum + ":\n"
          + "  ".repeat(depth + 1) + e.getMessage());
      depth--;

      passed--;
    } catch (final Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * <p>
   * Fails if <code> b </code> is true.
   * </p>
   */
  public static void assertNot(final boolean b) {
    assertEquals(b, false);
  }

  /**
   * <p>
   * Fails if <code> b </code> is false.
   * </p>
   */
  public static void assertTrue(final boolean b) {
    assertEquals(b, true);
  }

  /**
   * <p>
   * Fails if <code> a </code> differs from <code> b </code>
   * </p>
   */
  public static void assertEquals(final Object[] a, final Object[] b) {
    if (a == null && b == null)
      return;
    if (a.length == 0 && b.length == 0)
      return;
    if (a.length != b.length)
      fail(String.format("Array lengths differ (expected %d but was %d", a.length, b.length));
    for (int i = 0; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        fail(String.format("Arrays differ at index %d, expected %s but was %s", i, a[i], b[i]));
      }
    }
  }
  // here we go again

  /**
   * <p>
   * Fails if <code> a </code> differs from <code> b </code>
   * </p>
   */
  public static void assertEquals(final int[] a, final int[] b) {
    if (a == null && b == null)
      return;
    if (a.length == 0 && b.length == 0)
      return;
    if (a.length != b.length)
      fail(String.format("Array lengths differ (expected %d but was %d", a.length, b.length));
    for (int i = 0; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        fail(String.format("Arrays differ at index %d, expected %s but was %s", i, a[i], b[i]));
      }
    }
  }

  /**
   * Array equality check.
   */
  public static void assertEquals(final double[] a, final double[] b) {
    if (a == null && b == null)
      return;
    if (a.length == 0 && b.length == 0)
      return;
    if (a.length != b.length)
      fail(String.format("Array lengths differ (expected %d but was %d", a.length, b.length));
    for (int i = 0; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        fail(String.format("Arrays differ at index %d, expected %s but was %s", i, a[i], b[i]));
      }
    }
  }

  /**
   * Array equality check.
   */
  public static void assertEquals(final float[] a, final float[] b) {
    if (a == null && b == null)
      return;
    if (a.length == 0 && b.length == 0)
      return;
    if (a.length != b.length)
      fail(String.format("Array lengths differ (expected %d but was %d", a.length, b.length));
    for (int i = 0; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        fail(String.format("Arrays differ at index %d, expected %s but was %s", i, a[i], b[i]));
      }
    }
  }

  /**
   * <p>
   * Fails if <code> a </code> differs from <code> b </code>
   * </p>
   */
  public static void assertEquals(final long[] a, final long[] b) {
    if (a == null && b == null)
      return;
    if (a.length == 0 && b.length == 0)
      return;
    if (a.length != b.length)
      fail(String.format("Array lengths differ (expected %d but was %d", a.length, b.length));
    for (int i = 0; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        fail(String.format("Arrays differ at index %d, expected %s but was %s", i, a[i], b[i]));
      }
    }
  }

  /**
   * <p>
   * Fails if <code> a </code> differs from <code> b </code>
   * </p>
   */
  public static void assertEquals(final short[] a, final short[] b) {
    if (a == null && b == null)
      return;
    if (a.length == 0 && b.length == 0)
      return;
    if (a.length != b.length)
      fail(String.format("Array lengths differ (expected %d but was %d", a.length, b.length));
    for (int i = 0; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        fail(String.format("Arrays differ at index %d, expected %s but was %s", i, a[i], b[i]));
      }
    }
  }

  /**
   * <p>
   * Fails if <code> a </code> differs from <code> b </code>
   * </p>
   */
  public static void assertEquals(final boolean[] a, final boolean[] b) {
    if (a == null && b == null)
      return;
    if (a.length == 0 && b.length == 0)
      return;
    if (a.length != b.length)
      fail(String.format("Array lengths differ (expected %d but was %d", a.length, b.length));
    for (int i = 0; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        fail(String.format("Arrays differ at index %d, expected %s but was %s", i, a[i], b[i]));
      }
    }
  }

  /**
   * <p>
   * Fails if <code> a </code> differs from <code> b </code>
   * </p>
   */
  public static void assertEquals(final int a, final int b) {
    if (a != b)
      fail("Expected " + a + " but was " + b);
  }

  /**
   * <p>
   * Fails if <code> a </code> differs from <code> b </code>
   * </p>
   */
  public static void assertEquals(final float a, final float b) {
    if (a != b)
      fail("Expected " + a + " but was " + b);
  }

  /**
   * <p>
   * Fails if <code> a </code> differs from <code> b </code>
   * </p>
   */
  public static void assertEquals(final long a, final long b) {
    if (a != b)
      fail("Expected " + a + " but was " + b);
  }

  /**
   * <p>
   * Fails if <code> a </code> differs from <code> b </code>
   * </p>
   */
  public static void assertEquals(final byte a, final byte b) {
    if (a != b)
      fail("Expected " + a + " but was " + b);
  }

  /**
   * <p>
   * Fails if <code> a </code> differs from <code> b </code>
   * </p>
   */
  public static void assertEquals(final short a, final short b) {
    if (a != b)
      fail("Expected " + a + " but was " + b);
  }

  /**
   * <p>
   * Fails if <code> a </code> differs from <code> b </code>
   * </p>
   */
  public static void assertEquals(final boolean a, final boolean b) {
    if (a != b)
      fail("Expected " + a + " but was " + b);
  }
  // it's finally over

  /**
   * <p>
   * Will ALWAYS fail unless o and p implement their own #equals methods.
   * </p>
   * <p>
   * Fails if <code> o </code> differs from <code> p </code>
   * </p>
   */
  public static void assertEquals(final Object o, final Object p) {
    if (!isEqual(o, p))
      fail("Expected " + o + " but was " + p);
  }

  /**
   * Allows one to compare objects however the hell they want to i dont care do
   * what you want
   * <p>
   * Fails if <code> comparison(o, p) </code> returns false.
   * </p>
   * 
   * @param o          the first object
   * @param p          the second object
   * @param comparison the comparison function to use.
   */
  public static <T> void assertEqualsWith(final T o, final T p, final BiFunction<T, T, Boolean> comparison,
      final String message) {
    if (!(comparison.apply(o, p)))
      fail(message);
  }

  public static <T> void assertEqualsWith(final T o, final T p, final BiFunction<T, T, Boolean> comparison) {
    if (!(comparison.apply(o, p)))
      fail("");
  }

  /**
   * // wouldn't it be nice if this was as easy as i wish it would be
   * //
   * public static void assertEquals(final Object o, final Object p) {
   * try {
   * final Class<?> pClass = p.getClass(),
   * oClass = o.getClass();
   * if (!(isEqual(pClass.getName(), oClass.getName()))) // classtype check first.
   * fail("Expected " + p + " to be of type " + o.getClass().getName() + " but was
   * " + p.getClass().getName());
   * 
   * Optional<Field> diff;
   * for (Field f: pClass.getDeclaredFields()) { // ahh
   * f.setAccessible(true);
   * System.out.println(f.getName());
   * if ((diff = deepEqualityCheck(f.get(o),
   * f.get(p))).isPresent()) { // if only...
   * StringBuilder sb = new StringBuilder();
   * sb.append("Expected ");
   * sb.append(pClass.getName());
   * sb.append(".");
   * sb.append(f.getName());
   * sb.append(" to equal ");
   * sb.append(f.get(o));
   * sb.append(" but was ");
   * sb.append(f.get(p));
   * fail(sb.toString());
   * }
   * 
   * // }
   * 
   * }catch(Exception e) {
   * e.printStackTrace();
   * }
   * 
   * 
   * }
   */

  /**
   * Method will always return false unless the objects implement their own
   * #equals method because a recursive equality check is too annoying to make so
   * suck it (and might be impossible lol)
   */
  private static boolean isEqual(Object o, Object p) {
    if (o == null && p == null)
      return true;
    return o == p || o.equals(p);
  }
  // update: i am not doing this
  // /**
  // If the optional has an item, that is the field that was different.
  // */
  // private static Optional<Field> deepEqualityCheck(Object o, Object p) {
  // Optional<Field> f = Optional.empty();
  // if (o instanceof String &&
  // p instanceof String &&
  // isEqual((String) o, (String) p)) return f;
  // if (o == null && p == null) return f;
  // if (o == p || o.equals(p)) return f;
  // for (Field fi: pClass.getDeclaredFields()) { // ahh
  // fi.setAccessible(true);
  // System.out.println(fi.getName());
  // if (!deepEqualityCheck(o, p))
  // return f;

  // }
  // }

  // ==========NOT EQUALS============

  /**
   * <p>
   * Fails if <code> o </code> equals <code> p</code>
   * </p>
   */
  public static <T> void assertNotEquals(final T[] a, final T[] b) {
    if (a == null && b == null)
      fail("Expected arrays to differ (both are null)");
    if (a.length == 0 && b.length == 0)
      fail("Expected arrays to differ(both are empty");
    if (a.length != b.length)
      return;
    for (int i = 0; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        return;
      }
    }
    fail("Expected arrays to differ (they didn't).");
  }

  /**
   * <p>
   * Fails if <code> o </code> equals <code> p</code>
   * </p>
   */
  public static void assertNotEquals(final int[] a, final int[] b) {
    if (a == null && b == null)
      fail("Expected arrays to differ (both are null)");
    if (a.length == 0 && b.length == 0)
      fail("Expected arrays to differ(both are empty");
    if (a.length != b.length)
      return;
    for (int i = 0; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        return;
      }
    }
    fail("Expected arrays to differ (they didn't).");
  }

  /**
   * Array equality check.
   */
  public static void assertNotEquals(final double[] a, final double[] b) {
    if (a == null && b == null)
      fail("Expected arrays to differ (both are null)");
    if (a.length == 0 && b.length == 0)
      fail("Expected arrays to differ(both are empty");
    if (a.length != b.length)
      return;
    for (int i = 0; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        return;
      }
    }
    fail("Expected arrays to differ (they didn't).");

    /**
     * <p>
     * Fails if <code> o </code> equals <code> p</code>
     * </p>
     */
  }

  public static void assertNotEquals(final float[] a, final float[] b) {
    if (a == null && b == null)
      fail("Expected arrays to differ (both are null)");
    if (a.length == 0 && b.length == 0)
      fail("Expected arrays to differ(both are empty");
    if (a.length != b.length)
      return;
    for (int i = 0; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        return;
      }
    }
    fail("Expected arrays to differ (they didn't).");
  }

  /**
   * <p>
   * Fails if <code> o </code> equals <code> p</code>
   * </p>
   */
  public static void assertNotEquals(final long[] a, final long[] b) {
    if (a == null && b == null)
      fail("Expected arrays to differ (both are null)");
    if (a.length == 0 && b.length == 0)
      fail("Expected arrays to differ(both are empty");
    if (a.length != b.length)
      return;
    for (int i = 0; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        return;
      }
    }
    fail("Expected arrays to differ (they didn't).");
  }

  /**
   * <p>
   * Fails if <code> o </code> equals <code> p</code>
   * </p>
   */
  public static void assertNotEquals(final short[] a, final short[] b) {
    if (a == null && b == null)
      fail("Expected arrays to differ (both are null)");
    if (a.length == 0 && b.length == 0)
      fail("Expected arrays to differ(both are empty");
    if (a.length != b.length)
      return;
    for (int i = 0; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        return;
      }
    }
    fail("Expected arrays to differ (they didn't).");
  }

  /**
   * <p>
   * Fails if <code> o </code> equals <code> p</code>
   * </p>
   */
  public static void assertNotEquals(final boolean[] a, final boolean[] b) {
    if (a == null && b == null)
      fail("Expected arrays to differ (both are null)");
    if (a.length == 0 && b.length == 0)
      fail("Expected arrays to differ(both are empty");
    if (a.length != b.length)
      return;
    for (int i = 0; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        return;
      }
    }
    fail("Expected arrays to differ (they didn't).");
  }

  /**
   * <p>
   * Fails if <code> o </code> equals <code> p</code>
   * </p>
   */
  public static void assertNotEquals(final int a, final int b) {
    if (a == b)
      fail("Arguments did not differ");
  }

  /**
   * <p>
   * Fails if <code> o </code> equals <code> p</code>
   * </p>
   */
  public static void assertNotEquals(final float a, final float b) {
    if (a == b)
      fail("Arguments did not differ");
  }

  /**
   * <p>
   * Fails if <code> o </code> equals <code> p</code>
   * </p>
   */
  public static void assertNotEquals(final long a, final long b) {
    if (a == b)
      fail("Arguments did not differ");
  }

  /**
   * <p>
   * Fails if <code> o </code> equals <code> p</code>
   * </p>
   */
  public static void assertNotEquals(final byte a, final byte b) {
    if (a == b)
      fail("Arguments did not differ");
  }

  /**
   * <p>
   * Fails if <code> o </code> equals <code> p</code>
   * </p>
   */
  public static void assertNotEquals(final short a, final short b) {
    if (a == b)
      fail("Arguments did not differ");
  }

  /**
   * <p>
   * Fails if <code> o </code> equals <code> p</code>
   * </p>
   */
  public static void assertNotEquals(final boolean a, final boolean b) {
    if (a == b)
      fail("Arguments did not differ");
  }

  /**
   * This method will ALWAYS pass unless the objects implement their own #equals
   * since hashcodes are a pain in your mom.
   * 
   * <p>
   * Fails if <code> o </code> equals <code> p</code>
   * </p>
   * 
   */
  public static void assertNotEquals(final Object o, final Object p) {
    if (isEqual(o, p))
      fail("Arguments did not differ");
  }

  /**
   * Allows one to compare objects however the hell they want to i dont care do
   * what you want
   * <p>
   * Fails if <code> comparison(o, p) </code> returns true.
   * </p>
   * 
   * @param o          the first object
   * @param p          the second object
   * @param comparison the comparison function to use.
   * @param message    failure message.
   */
  public static <T> void assertNotEqualsWith(final T o, final T p, BiFunction<T, T, Boolean> comparison,
      String message) {
    if (comparison.apply(o, p))
      fail(message);
  }

  /**
   * <p>
   * Equivalent to {@link Test.assertNotEqualsWith}(o, p, comparison, "")
   * </p>
   */
  public static <T> void assertNotEqualsWith(final T o, final T p, BiFunction<T, T, Boolean> comparison) {
    assertNotEqualsWith(o, p, comparison, "");
  }

  private static void fail(String message) {
    throw new AssertionError(message);
  }

  @FunctionalInterface
  public static interface ItFunction {
    void run() throws Exception;
  }

  public static void main(String[] args) throws IOException {

    // methods that begin with "test" inside classes with the TestTarget annotation will be called.
    

    if (args.length > 0 && "-h".equals(args[0])) {
      System.out.println("Usage: <idk what im gonna call it or how im gonna have it execute> [folder path]\n-- If [folder path] is left blank, \"./\" will be used.");
      System.exit(0);
    }


    String arg = "./";
    if (args.length > 0) arg = args[0]; // yep
    
    File folder = new File(arg);

    if (!(folder.exists()))
    {
      System.out.println(folder.getPath() + " doesn't exist");
      System.exit(1);
    }
    if (!(folder.isDirectory())) {
      System.out.println(folder.getPath() + " is not a folder");
      System.exit(1);
    }

    final long[] endingValues = new long[2]; // endingValues[0] = whether or not we even found a class. if it's 0 we didn't, 1 we did. 1 is the start time
    try (
      Stream<Path> stream = Files.walk(Paths.get(arg))
      .filter(Files::isRegularFile)
        
      .filter(x -> x.toString().endsWith(".class")
            //only take classes
              && !x.toString().contains("$") // filter out subclasses and stuff
              )) {
      endingValues[1] = System.currentTimeMillis(); // don't take finding the files into consideration
      stream.forEach(file -> {
        

        String classPath = file.toString()
          .replace(".class", "")
          .replaceAll("/", ".").substring(2);
        try {
          Class<?> clazz = Class.forName(classPath);
          

          if (!clazz.isAnnotationPresent(TestTarget.class)) return;


          for (Method m: clazz.getDeclaredMethods()) {
            // this part is just making sure we're likely hitting a testing method lol
            if ((m.getModifiers() & 9) == 0) continue; // 9 == (static | public)
            if (!(m.getName().startsWith("test"))) continue; // should start with test
            if (m.getParameterCount() != 0) continue; // shouldn't have parameters.
            if (m.getReturnType() != void.class) continue; // shouldn't return anything
            m.setAccessible(true); // your mom
            
            endingValues[0] = 1;
            m.invoke(null, (Object[]) null /* believe me cuh it's a vararg!*/); // run the test
          }
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException e) {
          e.printStackTrace();
        }
      });
    }
    if (0 == testsRan) { 
      // then we never actually tested anything
      System.out.println("Found no tests :/");
      System.exit(0);
    }
    System.out.printf("%d/%d tests passed (%dms)\n", passed, testsRan, (System.currentTimeMillis() - endingValues[1]));
    System.exit(0);
  }
}
