public class TimothyDriver110818 {

  public static void main(String[] args) {

    WordSearch WSe = new WordSearch(6,10);

    System.out.println("WordSearch WSe = new WordSearch(6,10)");
    System.out.println(WSe);
    /*
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
    */

    System.out.println();

    System.out.println("WSe.addWordHorizontal(\"CLOUD\",0,7)");
    if(WSe.addWordHorizontal("CLOUD",0,7)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - FAIL");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - PASS");
    }
    // > addition failure.
    // should fail, CLOUD is outside of bounds

    System.out.println(WSe);
    /*
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
    */

    System.out.println();

    System.out.println("WSe.addWordHorizontal(\"TIFA\",0,5)");
    if(WSe.addWordHorizontal("TIFA",0,5)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - PASS");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - FAIL");
    }
    // > addition success.
    // should succeed, TIFA is within bounds, no destructive interference

    System.out.println(WSe);
    /*
      _ _ _ _ _ T I F A _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
    */

    System.out.println("WSe.addWordHorizontal(\"REDXIII\",0,2)");
    if(WSe.addWordHorizontal("REDXIII",0,2)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - FAIL");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - PASS");
    }
    // > addition failure.
    // should fail, REDXIII is within bounds, yes destructive interference

    System.out.println(WSe);
    /*
      _ _ _ _ _ T I F A _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
    */

    System.out.println("WSe.addWordHorizontal(\"REDXIII\",1,0)");
    if(WSe.addWordHorizontal("REDXIII",1,0)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - PASS");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - FAIL");
    }
    // > addition success.
    // should succeed, REDXIII is within bounds, no destructive interference

    System.out.println(WSe);
    /*
      _ _ _ _ _ T I F A _
      R E D X I I I _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
    */

    System.out.println("WSe.addWordHorizontal(\"BARRET\",0,0)");
    if(WSe.addWordHorizontal("BARRET",0,0)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - PASS");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - FAIL");
    }
    // > addition success.
    // should succeed, BARRET is within bounds, only constructive interference

    System.out.println(WSe);
    /*
      B A R R E T I F A _
      R E D X I I I _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
    */

    System.out.println("WSe.addWordVertical(\"YUFFIE\",2,9)");
    if(WSe.addWordVertical("YUFFIE",2,9)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - FAIL");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - PASS");
    }
    // > addition failure.
    // should fail, YUFFIE is out of bounds

    System.out.println(WSe);
    /*
    B A R R E T I F A _
    R E D X I I I _ _ _
    _ _ _ _ _ _ _ _ _ _
    _ _ _ _ _ _ _ _ _ _
    _ _ _ _ _ _ _ _ _ _
    _ _ _ _ _ _ _ _ _ _
    */

    System.out.println("WSe.addWordVertical(\"CLOUD\",1,9)");
    if(WSe.addWordVertical("CLOUD",1,9)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - PASS");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - FAIL");
    }
    // > addition success.
    // should succeed, CLOUD is within bounds, no destructive interference

    System.out.println(WSe);
    /*
      B A R R E T I F A _
      R E D X I I I _ _ C
      _ _ _ _ _ _ _ _ _ L
      _ _ _ _ _ _ _ _ _ O
      _ _ _ _ _ _ _ _ _ U
      _ _ _ _ _ _ _ _ _ D
    */

    System.out.println("WSe.addWordVertical(\"YUFFIE\",0,9)");
    if(WSe.addWordVertical("YUFFIE",0,9)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - FAIL");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - PASS");
    }
    // > addition failure.
    // should fail, YUFFIE is within bounds, yes destructive interference

    System.out.println(WSe);
    /*
      B A R R E T I F A _
      R E D X I I I _ _ C
      _ _ _ _ _ _ _ _ _ L
      _ _ _ _ _ _ _ _ _ O
      _ _ _ _ _ _ _ _ _ U
      _ _ _ _ _ _ _ _ _ D
    */

    System.out.println("WSe.addWordVertical(\"AERITH\",0,1)");
    if(WSe.addWordVertical("AERITH",0,1)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - PASS");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - FAIL");
    }
    // > addition success.
    // should succeed, AERITH is within bounds, only constructive interference

    System.out.println(WSe);
    /*
      B A R R E T I F A _
      R E D X I I I _ _ C
      _ R _ _ _ _ _ _ _ L
      _ I _ _ _ _ _ _ _ O
      _ T _ _ _ _ _ _ _ U
      _ H _ _ _ _ _ _ _ D
    */

    System.out.println("WSe.addWordDiagonal(\"CAIT\",3,2)");
    if(WSe.addWordDiagonal("CAIT",3,2)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - FAIL");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - PASS");
    }
    // > addition failure.
    // should fail, CAIT is out of bounds

    System.out.println(WSe);
    /*
      B A R R E T I F A _
      R E D X I I I _ _ C
      _ R _ _ _ _ _ _ _ L
      _ I _ _ _ _ _ _ _ O
      _ T _ _ _ _ _ _ _ U
      _ H _ _ _ _ _ _ _ D
    */

    System.out.println("WSe.addWordDiagonal(\"CAIT\",2,2)");
    if(WSe.addWordDiagonal("CAIT",2,2)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - PASS");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - FAIL");
    }
    // > addition success
    // should succeed, CAIT is within bounds, no destructive interference

    System.out.println(WSe);
    /*
      B A R R E T I F A _
      R E D X I I I _ _ C
      _ R C _ _ _ _ _ _ L
      _ I _ A _ _ _ _ _ O
      _ T _ _ I _ _ _ _ U
      _ H _ _ _ T _ _ _ D
    */

    System.out.println("WSe.addWordDiagonal(\"SITH\",2,3)");
    if(WSe.addWordDiagonal("SITH",2,3)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - PASS");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - FAIL");
    }
    // > addition success
    // should succeed, SITH is within bounds, no destructive interference

    System.out.println(WSe);
    /*
      B A R R E T I F A _
      R E D X I I I _ _ C
      _ R C S _ _ _ _ _ L
      _ I _ A I _ _ _ _ O
      _ T _ _ I T _ _ _ U
      _ H _ _ _ T H _ _ D
    */

    System.out.println("WSe.addWordDiagonal(\"CAIT\",2,0)");
    if(WSe.addWordDiagonal("CAIT",2,0)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - FAIL");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - PASS");
    }
    // > addition failure
    // should fail, CAIT is within bounds, yes destructive interference

    System.out.println(WSe);
    /*
      B A R R E T I F A _
      R E D X I I I _ _ C
      _ R C S _ _ _ _ _ L
      _ I _ A I _ _ _ _ O
      _ T _ _ I T _ _ _ U
      _ H _ _ _ T H _ _ D
    */

    System.out.println("WSe.addWordDiagonal(\"TIFA\",0,5)");
    if(WSe.addWordDiagonal("TIFA",0,5)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - PASS");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - FAIL");
    }
    // > addition success
    // should succeed, TIFA is within bounds, only constructive interference

    System.out.println(WSe);
    /*
      B A R R E T I F A _
      R E D X I I I _ _ C
      _ R C S _ _ _ F _ L
      _ I _ A I _ _ _ A O
      _ T _ _ I T _ _ _ U
      _ H _ _ _ T H _ _ D
    */

    // System.out.println("WSe.clear()");
    // WSe.clear();
    //
    // System.out.println(WSe);
    // /*
    //   _ _ _ _ _ _ _ _ _ _
    //   _ _ _ _ _ _ _ _ _ _
    //   _ _ _ _ _ _ _ _ _ _
    //   _ _ _ _ _ _ _ _ _ _
    //   _ _ _ _ _ _ _ _ _ _
    //   _ _ _ _ _ _ _ _ _ _
    // */

  }

}
