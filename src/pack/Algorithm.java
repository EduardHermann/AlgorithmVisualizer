package pack;

import javax.swing.SwingWorker;

/**
 * Uses the bars in order to visualize the algorithms. Therefore the algorithms are located in here.
 */
public class Algorithm {

  public String MySystemOutput = "-";
  public int MyNumber = 0;

  public final int BARWIDTH = 70;
  public final int ARROWHIGHT = 50;

  private int[] imageDrawOrderByValue;
  public int[] theArray;
  public int[] theXArray;

  public int arrowX = 0;
  public int arrowXS = 0;// only for the insertion sort!
  public int arrowY2 = 0;
  public int arrowY1 = 0;

  public boolean theBubbleSort = false;
  public boolean theSelectionSort = false;
  public boolean theInsertionSort = false;

  public boolean comparing = false;
  public boolean right = false;
  public boolean wrong = false;

  /**
   * The hight of the bars is getting initialized as the values of an array. The X-coordinates of
   * the bars is getting initialized too.
   */
  public Algorithm() {
    imageDrawOrderByValue = new int[] {250, 100, 175, 300, 275, 50, 350, 200};
    theArray = new int[] {250, 100, 175, 300, 275, 50, 350, 200};
    theXArray = new int[] {0, 70, 140, 210, 280, 350, 420, 490};
  }

  /**
   * Resorts the bars randomly.
   */
  public void resortTheBars() {
    for (int i = 0; i < theXArray.length; i++) {
      int temp = (int) ((Math.random() * theXArray.length - 1) + 0);
      swapValuesByIndex(theArray, temp, temp + 1);
      swapXCoordinatesByIndex(temp, temp + 1);
    }
    newBarsCondition();
  }

  /**
   * The bubble sort is getting created here.
   */
  public void bubbleSort() {
    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

      @Override
      protected Void doInBackground() {
        try {
          theBubbleSort = true;
          algorithmStartCondition();
          for (int i = theArray.length - 1; i >= 1; i--) {
            for (int n = 0; n < i; n++) {
              setArrowsX(n);
              setArrowsY(n);
              comparing = true;
              Thread.sleep(1000);
              if (theArray[n] > theArray[n + 1]) {
                comparing = false;
                wrong = true;
                Thread.sleep(1000);
                swapValuesByIndex(theArray, n, n + 1);
                swapXCoordinatesByIndex(n, n + 1);
                MyNumber++;
                Main.MySwaps.setText("Swaps: " + MyNumber);
                wrong = false;
              } else {
                comparing = false;
                right = true;
                Thread.sleep(1000);
                right = false;
              }
            }
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
          System.out.println("The visualization of the bubble sort went wrong!");
        }
        return null;
      }

      @Override
      protected void done() {
        theBubbleSort = false;
        comparing = false;
        algorithmEndCondition();
      }
    };
    worker.execute();
  }

  /**
   * The selection sort is getting created here.
   */
  public void selectionSort() {
    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

      @Override
      protected Void doInBackground() {
        try {
          theSelectionSort = true;
          algorithmStartCondition();
          for (int i = theArray.length - 1; i >= 1; i--) {
            int maxValue = 0;
            int maxIndex = 0;
            for (int n = 0; n <= i; n++) {
              arrowX = n * BARWIDTH;
              arrowXS = maxIndex * BARWIDTH;
              arrowY1 = 440 - theArray[n] - ARROWHIGHT;
              arrowY2 = 440 - theArray[maxIndex] - ARROWHIGHT;
              comparing = true;
              Thread.sleep(1000);
              if (theArray[n] > maxValue) {
                comparing = false;
                wrong = true;
                Thread.sleep(1000);
                maxValue = theArray[n];
                maxIndex = n;
                wrong = false;
              } else {
                comparing = false;
                right = true;
                Thread.sleep(1000);
                right = false;
              }
            }
            swapValuesByIndex(theArray, maxIndex, i);
            swapXCoordinatesByIndex(maxIndex, i);
            MyNumber++;
            Main.MySwaps.setText("Swaps: " + MyNumber);
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
          System.out.println("The visualization of the selection sort went wrong!");
        }
        return null;
      }

      @Override
      protected void done() {
        theSelectionSort = false;
        comparing = false;
        algorithmEndCondition();
      }
    };
    worker.execute();
  }

  /**
   * The insertion sort is getting created here.
   */
  public void insertionSort() {
    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

      @Override
      protected Void doInBackground() {
        theInsertionSort = true;
        algorithmStartCondition();
        try {
          for (int i = 1; i < theArray.length; i++) {
            int n = i;
            while (n > 0) {
              setArrowsX(n);
              setArrowsY(n);
              comparing = true;
              Thread.sleep(1000);
              if (theArray[n - 1] > theArray[n]) {
                comparing = false;
                wrong = true;
                Thread.sleep(1000);
                swapValuesByIndex(theArray, n - 1, n);
                swapXCoordinatesByIndex(n - 1, n);
                MyNumber++;
                Main.MySwaps.setText("Swaps: " + MyNumber);
                wrong = false;
              } else {
                comparing = false;
                right = true;
                Thread.sleep(1000);
                right = false;
              }
              n--;
            }
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
          System.out.println("The visualization of the insertion sort went wrong!");
        }
        return null;
      }

      @Override
      protected void done() {
        theInsertionSort = false;
        comparing = false;
        algorithmEndCondition();
      }
    };
    worker.execute();
  }

  /**
   * The Textboxes are getting set to the starting point of the algorithm.
   */
  private void algorithmStartCondition() {
    MySystemOutput = "Running...";
    Main.MySystem.setText("System: " + MySystemOutput);
    MyNumber = 0;
    Main.MySwaps.setText("Swaps: " + MyNumber);
  }

  /**
   * The Textboxes are getting reseted when the user presses the button NEW.
   */
  private void newBarsCondition() {
    MySystemOutput = "-";
    Main.MySystem.setText("System: " + MySystemOutput);
    MyNumber = 0;
    Main.MySwaps.setText("Swaps: " + MyNumber);
  }

  /**
   * The Textboxes are getting set to the ending point of the algorithm.
   */
  private void algorithmEndCondition() {
    MySystemOutput = "finished!";
    Main.MySystem.setText("System: " + MySystemOutput);
  }

  /**
   * Sets the X-Coordinate of the first arrow.
   */
  private void setArrowsX(int index) {
    arrowX = BARWIDTH * index;
  }

  /**
   * Sets the Y-Coordinate of the arrows.
   */
  private void setArrowsY(int index) {
    arrowY1 = 440 - theArray[index] - ARROWHIGHT;
    if (theBubbleSort == true) {
      arrowY2 = 440 - theArray[index + 1] - ARROWHIGHT;
    } else if (theInsertionSort == true) {
      arrowY2 = 440 - theArray[index - 1] - ARROWHIGHT;
    }
  }

  /**
   * Swaps two values of two indexes from an Array which contains ints.
   */
  private void swapValuesByIndex(int[] MyArray, int index1, int index2) {
    int temp = MyArray[index1];
    MyArray[index1] = MyArray[index2];
    MyArray[index2] = temp;
  }

  /**
   * Swaps the X-Coordinates from pictures by the indexes and values from theArray
   */
  private void swapXCoordinatesByIndex(int index1, int index2) {
    int temp1 = getIndexByValue(imageDrawOrderByValue, theArray[index1]);
    int temp2 = getIndexByValue(imageDrawOrderByValue, theArray[index2]);
    theXArray[temp1] = getIndexByValue(theArray, theArray[index1]) * BARWIDTH;
    theXArray[temp2] = getIndexByValue(theArray, theArray[index2]) * BARWIDTH;
  }

  /**
   * Gets one index from an Array by searching the given value.
   */
  private int getIndexByValue(int[] MyArray, int value) {
    for (int i = 0; i < MyArray.length; i++) {
      if (MyArray[i] == value) {
        return i;
      }
    }
    return 0;
  }
}
