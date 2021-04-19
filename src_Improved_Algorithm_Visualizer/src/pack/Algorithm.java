package pack;

import javax.swing.SwingWorker;

/**
 * Diese Klasse ist fuer die Ausfuehrung der Sortieralgorithmen und der zufaelligen Sortierung der
 * Rechtecke zustaendig.
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
  public int arrowXS = 0;
  public int arrowY2 = 0;
  public int arrowY1 = 0;

  public boolean theBubbleSort = false;
  public boolean theSelectionSort = false;
  public boolean theInsertionSort = false;

  public boolean comparing = false;
  public boolean right = false;
  public boolean wrong = false;

  /**
   * Die benoetigten Arrays zur Ausfuehrung der Rechen- und Darstellungsoperationen werden
   * initialisiert.
   */
  public Algorithm() {
    imageDrawOrderByValue = new int[] {250, 100, 175, 300, 275, 50, 350, 200};
    theArray = new int[] {250, 100, 175, 300, 275, 50, 350, 200};
    theXArray = new int[] {0, 70, 140, 210, 280, 350, 420, 490};
  }

  /**
   * Diese Methode stellt alle Rechtecke an eine zufaellige valide Position.
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
   * Diese Methode fuehrt den bubble sort aus.
   * 
   * @exception e: Diese Fehlermeldung wird benutzt, um den Standort und die Art eines Fehlers
   *            herauszufinden, bei der Ausfuehrung von dem Algorithmus.
   */
  public void bubbleSort() {
    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

      /**
       * Diese Methode wird beim Start des "Threads" ausgefuehrt.
       */
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

      /**
       * Diese Methode wird beim Ende des "Threads" ausgefuehrt.
       */
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
   * Diese Methode fuehrt den selection sort aus.
   * 
   * @exception e: Diese Fehlermeldung wird benutzt, um den Standort und die Art eines Fehlers
   *            herauszufinden, bei der Ausfuehrung von dem Algorithmus.
   */
  public void selectionSort() {
    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

      /**
       * Diese Methode wird beim Start des "Threads" ausgefuehrt.
       */
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

      /**
       * Diese Methode wird beim Ende des "Threads" ausgefuehrt.
       */
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
   * Diese Methode fuehrt den insertion sort aus.
   * 
   * @exception e: Diese Fehlermeldung wird benutzt, um den Standort und die Art eines Fehlers
   *            herauszufinden, bei der Ausfuehrung von dem Algorithmus.
   */
  public void insertionSort() {
    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

      /**
       * Diese Methode wird beim Start des "Threads" ausgefuehrt.
       */
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

      /**
       * Diese Methode wird beim Ende des "Threads" ausgefuehrt.
       */
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
   * Diese Methode gleicht die Texte der Textfelder, beim Start eines Algorithmus, an.
   */
  private void algorithmStartCondition() {
    MySystemOutput = "Running...";
    Main.MySystem.setText("System: " + MySystemOutput);
    MyNumber = 0;
    Main.MySwaps.setText("Swaps: " + MyNumber);
  }

  /**
   * Diese Methode gleicht die Texte der Textfelder, bei einer Ausfuehrung einer zufaelligen
   * Sortierung der Positionen der Rechtecke, an.
   */
  private void newBarsCondition() {
    MySystemOutput = "-";
    Main.MySystem.setText("System: " + MySystemOutput);
    MyNumber = 0;
    Main.MySwaps.setText("Swaps: " + MyNumber);
  }

  /**
   * Diese Methode gleicht die Texte der Textfelder, beim Ende eines Algorithmus, an.
   */
  private void algorithmEndCondition() {
    MySystemOutput = "finished!";
    Main.MySystem.setText("System: " + MySystemOutput);
  }

  /**
   * Diese Methode setzt die X-Koordinate eines Pfeils, an die aktuell von dem Algorithmus
   * verglichene Stelle.
   * 
   * @param index: Dieser Parameter stellt den Pfeil dar, von dem die X-Koordinate abegaendert wird.
   */
  private void setArrowsX(int index) {
    arrowX = BARWIDTH * index;
  }

  /**
   * Diese Methode setzt die Y-Koordinaten der Pfeile, an die aktuell von dem Algorithmus
   * verglichene Stelle. Die zweite Y-Koordinate des selection sort wird separat behandelt, da sich
   * der Algorithmus grundlegend von den anderen zwei unterscheidet.
   * 
   * @param index: Dieser Parameter stellt den Pfeil dar, von dem die Y-Koordinate abegaendert wird.
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
   * Diese Methode tauscht zwei Werte eines beliebigen Arrays, basierend auf ihren Indexen, aus.
   * 
   * @param MyArray: Dieser Parameter stellt ein beliebiges Array dar, bei dem der Tausch stattfindet.
   * @param index1: Dieser Parameter stellt die erste Position in dem Array dar.
   * @param index2: Dieser Parameter stellt die zweite Position in dem Array dar.
   */
  private void swapValuesByIndex(int[] MyArray, int index1, int index2) {
    int temp = MyArray[index1];
    MyArray[index1] = MyArray[index2];
    MyArray[index2] = temp;
  }

  /**
   * Diese Methode tauscht die X-Koordinaten von zwei Bildern, basierend auf ihren Indexen, aus.
   * Alle X-Koordinaten der Bilder sind in einem Array vordefiniert.
   * 
   * @param index1: Dieser Parameter stellt die erste Position in dem vorgeschriebenen Array dar.
   * @param index2: Dieser Parameter stellt die zweite Position in dem vorgeschriebenen Array dar.
   */
  private void swapXCoordinatesByIndex(int index1, int index2) {
    int temp1 = getIndexByValue(imageDrawOrderByValue, theArray[index1]);
    int temp2 = getIndexByValue(imageDrawOrderByValue, theArray[index2]);
    theXArray[temp1] = getIndexByValue(theArray, theArray[index1]) * BARWIDTH;
    theXArray[temp2] = getIndexByValue(theArray, theArray[index2]) * BARWIDTH;
  }

  /**
   * Diese Methode sucht nach einem gegebenen Wert innerhalb eines gegebenen Arrays und wirft den
   * Index zurueck, an dem der Wert gefunden wurde. Wurde der Wert nicht gefunden, wird der Wert 0
   * zurueckgegeben.
   * 
   * @return int: Dieser Rueckgabewert stellt die Position bzw. den Index, an dem der Wert in dem gegebenen Array gefunden wurde, dar.
   * @param MyArray: Dieser Parameter stellt das Array, in dem nach dem gegebenen Wert gesucht werden soll, dar.
   * @param value: Dieser Parameter stellt den Wert dar, nach dem in dem gegebenen Array gesucht werden soll.
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
