import java.lang.reflect.*;
import java.util.*;
public class Test {


  private static int depth = 1;

  public static void describe(final String msg) {

    StackTraceElement[] ah  = new Exception().getStackTrace();
    String callingClass = ah[1].getClassName();
    int lineNum = ah[1].getLineNumber(); 
    System.out.println(String.format("[%s:%d] %s:", callingClass, lineNum, msg));
  }

  public static void it(final String should, final ItFunction itf) {
    StackTraceElement[] ah  = new Exception().getStackTrace();
    String callingClass = ah[1].getClassName() + ".java";
    int lineNum = ah[1].getLineNumber();  
    try {

      System.out.println();

      ++depth;

      itf.run();
      System.out.print("  ".repeat(depth) + should + String.format(" [%s:%d] ", callingClass, lineNum));
      System.out.println("\u2713"); // part 1 of hack
      depth--;
    } catch(final AssertionError e) {
      
      System.out.println("\u274C"); // part 2 of hack
      
      System.out.println("  ".repeat(depth) + should + " FAILED AT " + callingClass + ":" +  lineNum + ":\n" + "  ".repeat(depth+1) + e.getMessage());
      depth--;
    }catch (final Exception e) {
      e.printStackTrace();
    }
  }



    @FunctionalInterface
    public static interface ItFunction {
      void run() throws Exception;
    }



  /**
    <p> Fails if <code> b </code> is true. </p>
  */
  public static void assertNot(final boolean b) {
    assertEquals(b, false);
  }
  /**
    <p> Fails if <code> b </code> is false. </p>
  */
  public static void assertTrue(final boolean b) {
    assertEquals(b, true);
  }


/**
  <p> Fails if <code> a </code> differs from <code> b </code> </p>
*/
  public static void assertEquals(final Object[] a, final Object[] b)
  {
    if (a == null && b == null) return;
    if (a.length == 0 && b.length==0) return;
    if (a.length != b.length) fail(String.format("Array lengths differ (expected %d but was %d", a.length, b.length));
    for (int i = 0 ; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        fail(String.format("Arrays differ at index %d, expected %s but was %s", i, a[i], b[i]));
      }
    }
  }
  // here we go again

/**
  <p> Fails if <code> a </code> differs from <code> b </code> </p>
  */
  public static void assertEquals(final int[] a, final int[] b)
  {
    if (a == null && b == null) return;
    if (a.length == 0 && b.length==0) return;
    if (a.length != b.length) fail(String.format("Array lengths differ (expected %d but was %d", a.length, b.length));
    for (int i = 0 ; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        fail(String.format("Arrays differ at index %d, expected %s but was %s", i, a[i], b[i]));
      }
    }
  }
  /**
    Array equality check.
  */
  public static void assertEquals(final double[] a, final double[] b)
  {
    if (a == null && b == null) return;
    if (a.length == 0 && b.length==0) return;
    if (a.length != b.length) fail(String.format("Array lengths differ (expected %d but was %d", a.length, b.length));
    for (int i = 0 ; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        fail(String.format("Arrays differ at index %d, expected %s but was %s", i, a[i], b[i]));
      }
    }
  }
  /**
    Array equality check.
  */
  public static void assertEquals(final float[] a, final float[] b)
  {
    if (a == null && b == null) return;
    if (a.length == 0 && b.length==0) return;
    if (a.length != b.length) fail(String.format("Array lengths differ (expected %d but was %d", a.length, b.length));
    for (int i = 0 ; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        fail(String.format("Arrays differ at index %d, expected %s but was %s", i, a[i], b[i]));
      }
    }
  }

    /**
  <p> Fails if <code> a </code> differs from <code> b </code> </p>
  */
  public static void assertEquals(final long[] a, final long[] b)
  {
    if (a == null && b == null) return;
    if (a.length == 0 && b.length==0) return;
    if (a.length != b.length) fail(String.format("Array lengths differ (expected %d but was %d", a.length, b.length));
    for (int i = 0 ; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        fail(String.format("Arrays differ at index %d, expected %s but was %s", i, a[i], b[i]));
      }
    }
  }

    /**
  <p> Fails if <code> a </code> differs from <code> b </code> </p>
  */
  public static void assertEquals(final short[] a, final short[] b) {
    if (a == null && b == null) return;
    if (a.length == 0 && b.length==0) return;
    if (a.length != b.length) fail(String.format("Array lengths differ (expected %d but was %d", a.length, b.length));
    for (int i = 0 ; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        fail(String.format("Arrays differ at index %d, expected %s but was %s", i, a[i], b[i]));
      }
    }
  }

    /**
  <p> Fails if <code> a </code> differs from <code> b </code> </p>
  */
  public static void assertEquals(final boolean[] a, final boolean[] b) {
    if (a == null && b == null) return;
    if (a.length == 0 && b.length==0) return;
    if (a.length != b.length) fail(String.format("Array lengths differ (expected %d but was %d", a.length, b.length));
    for (int i = 0 ; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        fail(String.format("Arrays differ at index %d, expected %s but was %s", i, a[i], b[i]));
      }
    }
  }
  

  

    /**
  <p> Fails if <code> a </code> differs from <code> b </code> </p>
  */
  public static void assertEquals(final int a, final int b) {
    if (a != b) fail("Expected " + a + " but was " + b);
  }
  /**
  <p> Fails if <code> a </code> differs from <code> b </code> </p>
  */
  public static void assertEquals(final float a, final float b) {
    if (a != b) fail("Expected " + a + " but was " + b);
  }
  /**
  <p> Fails if <code> a </code> differs from <code> b </code> </p>
  */
  public static void assertEquals(final long a, final long b) {
    if (a != b) fail("Expected " + a + " but was " + b);
  }
  /**
  <p> Fails if <code> a </code> differs from <code> b </code> </p>
  */
  public static void assertEquals(final byte a, final byte b) {
    if (a != b) fail("Expected " + a + " but was " + b);
  }
  /**
  <p> Fails if <code> a </code> differs from <code> b </code> </p>
  */
  public static void assertEquals(final short a, final short b) {
    if (a != b) fail("Expected " + a + " but was " + b);
  }

  /**
  <p> Fails if <code> a </code> differs from <code> b </code> </p>
  */
  public static void assertEquals(final boolean a, final boolean b) {
    if (a != b) fail("Expected " + a + " but was " + b);
  }
  // it's finally over


  

  /**
  <p>  Will ALWAYS fail unless o and p implement their own #equals methods. </p>
  <p> Fails if <code> o </code> differs from <code> p </code> </p>
  */
  public static void assertEquals(final Object o, final Object p) {
    if (!isEqual(o, p)) fail("Expected " + o + " but was " + p);
  } 


  /**
  //   wouldn't it be nice if this was as easy as i wish it would be
  // 
  public static void assertEquals(final Object o, final Object p) {
    try {
    final Class<?> pClass = p.getClass(),
                   oClass = o.getClass();
    if (!(isEqual(pClass.getName(), oClass.getName()))) // classtype check first.
      fail("Expected " + p + " to be of type " + o.getClass().getName() + " but was " + p.getClass().getName());

    Optional<Field> diff;
    for (Field f: pClass.getDeclaredFields()) { // ahh
      f.setAccessible(true);
      System.out.println(f.getName());
      if ((diff = deepEqualityCheck(f.get(o), 
f.get(p))).isPresent()) {  // if only...
        StringBuilder sb = new StringBuilder();
        sb.append("Expected ");
        sb.append(pClass.getName());
        sb.append(".");
        sb.append(f.getName());
        sb.append(" to equal ");
        sb.append(f.get(o));
        sb.append(" but was ");
        sb.append(f.get(p));
        fail(sb.toString());
      }
        
  //   }

    }catch(Exception e) {
      e.printStackTrace();
    }

    
  } 
  */

  /**
    Method will always return false unless the objects implement their own #equals method because a recursive equality check is too annoying to make so suck it (and might be impossible lol)
  */
  private static boolean isEqual(Object o, Object p) {
    if (o == null && p == null) return true; 
    return o == p || o.equals(p);
  }
  // update: i am not doing this 
  // /**
  //   If the optional has an item, that is the field that was different.
  // */
  // private static Optional<Field> deepEqualityCheck(Object o, Object p) {
  //   Optional<Field> f = Optional.empty();
  //   if (o instanceof String && 
  //       p instanceof String && 
  //       isEqual((String) o, (String) p)) return f;
  //   if (o == null && p == null) return f;
  //   if (o == p || o.equals(p)) return f;
  //   for (Field fi: pClass.getDeclaredFields()) { // ahh
  //     fi.setAccessible(true);
  //     System.out.println(fi.getName());
  //     if (!deepEqualityCheck(o, p))
  //     return f;

  //   }
  // }

  //==========NOT EQUALS============

  /**
  <p> Fails if <code> o </code> equals <code> p</code></p>
  */
  public static <T> void assertNotEquals(final T[] a, final T[] b)
  {
    if (a == null && b == null) fail("Expected arrays to differ (both are null)");
    if (a.length == 0 && b.length==0) fail("Expected arrays to differ(both are empty");
    if (a.length != b.length) return;
    for (int i = 0 ; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        return;
      }
    }
    fail("Expected arrays to differ (they didn't).");
  }

  /**
  <p> Fails if <code> o </code> equals <code> p</code></p>
  */
  public static void assertNotEquals(final int[] a, final int[] b)
  {
    if (a == null && b == null) fail("Expected arrays to differ (both are null)");
    if (a.length == 0 && b.length==0) fail("Expected arrays to differ(both are empty");
    if (a.length != b.length) return;
    for (int i = 0 ; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        return;
      }
    }
    fail("Expected arrays to differ (they didn't).");
  }
  /**
    Array equality check.
  */
  public static void assertNotEquals(final double[] a, final double[] b)
  {
      if (a == null && b == null) fail("Expected arrays to differ (both are null)");
    if (a.length == 0 && b.length==0) fail("Expected arrays to differ(both are empty");
    if (a.length != b.length) return;
    for (int i = 0 ; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        return;
      }
    }
    fail("Expected arrays to differ (they didn't).");

  /**
  <p> Fails if <code> o </code> equals <code> p</code></p>
  */
  }
  public static void assertNotEquals(final float[] a, final float[] b)
  {
    if (a == null && b == null) fail("Expected arrays to differ (both are null)");
    if (a.length == 0 && b.length==0) fail("Expected arrays to differ(both are empty");
    if (a.length != b.length) return;
    for (int i = 0 ; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        return;
      }
    }
    fail("Expected arrays to differ (they didn't).");
  }

  /**
  <p> Fails if <code> o </code> equals <code> p</code></p>
  */
  public static void assertNotEquals(final long[] a, final long[] b)
  {
    if (a == null && b == null) fail("Expected arrays to differ (both are null)");
    if (a.length == 0 && b.length==0) fail("Expected arrays to differ(both are empty");
    if (a.length != b.length) return;
    for (int i = 0 ; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        return;
      }
    }
    fail("Expected arrays to differ (they didn't).");
  }

  /**
  <p> Fails if <code> o </code> equals <code> p</code></p>
  */
  public static void assertNotEquals(final short[] a, final short[] b)
  {
    if (a == null && b == null) fail("Expected arrays to differ (both are null)");
    if (a.length == 0 && b.length==0) fail("Expected arrays to differ(both are empty");
    if (a.length != b.length) return;
    for (int i = 0 ; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        return;
      }
    }
    fail("Expected arrays to differ (they didn't).");
  }

  /**
  <p> Fails if <code> o </code> equals <code> p</code></p>
  */
  public static void assertNotEquals(final boolean[] a, final boolean[] b)
  {
    if (a == null && b == null) fail("Expected arrays to differ (both are null)");
    if (a.length == 0 && b.length==0) fail("Expected arrays to differ(both are empty");
    if (a.length != b.length) return;
    for (int i = 0 ; i < a.length; i++) {
      if (!isEqual(a[i], b[i])) {
        return;
      }
    }
    fail("Expected arrays to differ (they didn't).");
  }
  

  /**
  <p> Fails if <code> o </code> equals <code> p</code></p>
  */
  public static void assertNotEquals(final int a, final int b) {
    if (a == b) fail("Arguments did not differ");
  }
  /**
  <p> Fails if <code> o </code> equals <code> p</code></p>
  */
  public static void assertNotEquals(final float a, final float b) {
    if (a == b) fail("Arguments did not differ");
  }
  /**
  <p> Fails if <code> o </code> equals <code> p</code></p>
  */
  public static void assertNotEquals(final long a, final long b) {
    if (a == b) fail("Arguments did not differ");
  }
  /**
  <p> Fails if <code> o </code> equals <code> p</code></p>
  */
  public static void assertNotEquals(final byte a, final byte b) {
    if (a == b) fail("Arguments did not differ");
  }
  /**
  <p> Fails if <code> o </code> equals <code> p</code></p>
  */
  public static void assertNotEquals(final short a, final short b) {
    if (a == b) fail("Arguments did not differ");
  }
  /**
  <p> Fails if <code> o </code> equals <code> p</code></p>
  */
  public static void assertNotEquals(final boolean a, final boolean b) {
    if (a == b) fail("Arguments did not differ");
  }
  /**
  This method will ALWAYS pass unless the objects implement their own #equals since hashcodes are a pain in your mom.

  <p> Fails if <code> o </code> equals <code> p</code></p>
  
  */
  public static void assertNotEquals(final Object o, final Object p) {
    if (isEqual(o, p)) fail("Arguments did not differ");
  } 
  private static void fail(String message) {
    throw new AssertionError(message);
  }






}
