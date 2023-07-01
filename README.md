# this is some dumb testing library i spent 5 minutes on and then decided to actually expand lol

## Example.java:
```java
public class Example {
  public static void main(String[] args) {

    Test.describe("Testing assertNot");
    Test.it("Should pass the tests", () -> {
      for (int i = 0; i < 1000; i++ ) Test.assertNot(i < 0);
    });
    Test.describe("Testing assertTrue");
    Test.it("Should also pass the tests", () -> {
      for (int i = 0; i < 1000; i++ ) Test.assertTrue(i > -1);
    });
    Test.describe("testing assertEquals");
    Test.it("int equality", () -> {
      int i, j = 0;
      for (i = 0; i < 30; i++) {
        // just generating some numbers that are equal.
        Test.assertEquals(i, j);
        j++;
      }
    });
    Test.it("Object equality", () -> {
      Test.it("String equality", () -> {
        String a = "test";
        String b = "test";
        Test.assertEquals(a, b);
      });

      Test.it("Complex objects (that define their own equals)", () -> {
        DummyObject o1 = new DummyObject(420);
        DummyObject o2 = new DummyObject(420);
        Test.assertEquals(o1, o2);
      });
    });
    Test.describe("Array equality");
    Test.it("Should determine array equality", () -> {

      int[] a1 = {1,2,3,4,5};
      int[] a2 = {1,2,3,4,5};
      Test.assertEquals(a1, a2);

    });
  }
  private static class DummyObject {
    private int yourMomsPhoneNumber;
    public DummyObject(int yep) {
      this.yourMomsPhoneNumber = yep;
    }

    public boolean equals(Object other) {
      if (!(other instanceof DummyObject o)) return false;
      return o.yourMomsPhoneNumber == this.yourMomsPhoneNumber;
    }
  }
}
```
## Example output:
```
[Example:7] Testing assertNot:

    Should pass the tests [Example.java:8] ✓
[Example:11] Testing assertTrue:

    Should also pass the tests [Example.java:12] ✓
[Example:15] testing assertEquals:

    int equality [Example.java:16] ✓


      String equality [Example.java:25] ✓

      Complex objects (that define their own equals) [Example.java:31] ✓
    Object equality [Example.java:24] ✓
[Example:37] Array equality:

    Should determine array equality [Example.java:38] ✓
```
