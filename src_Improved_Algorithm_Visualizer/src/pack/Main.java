package pack;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Dies ist die Hauptklasse, die ueber alle weiteren Klassen Zugriff hat und sie zu einem
 * vollstaendingen Programm, bei einem Start des Programms, vereint.
 * 
 * @author Eduard Hermann
 * @version 1.0
 */
public class Main {

  private JFrame frame;
  private Algorithm algorithm;

  private MyLabel Visualization;

  private JComboBox<String> Selection;

  private JButton btnRun;
  private JButton btnNew;

  public static JTextField MySystem;
  public static JTextField MySwaps;

  private JButton btnInfo;

  private JSeparator Seperator;

  /**
   * Diese Methode fuehrt das Programm aus.
   * 
   * @param args: Dieser Parameter beschreibt die moegliche Uebergabe von Argumenten beim Start des
   *        Programms.
   * @exception e: Diese Fehlermeldung wurde benutzt, um dem Nutzer den Standort und die Art des
   *            Fehlers anzugeben, falls das Programm nicht korrekt gestartet werden konnte.
   */
  public static void main(String[] args) {
    try {
      Algorithm algorithm = new Algorithm();
      Main main = new Main(algorithm);
      main.frame.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("An error occurred while trying to start the program!");
    }
  }

  /**
   * Dies ist der Konstruktor der Hauptklasse, der bei der Instanziierung der Hauptklasse, alle
   * Klassen zu einem Programm verknuepft.
   * 
   * @param algorithm: Ein "Algorithm" Objekt wird bei der Instanziierung der Klasse "Main"
   *        benoetigt, sodass auf die Methoden dieses Objekts, die einen Teil der
   *        Hintergrundoperationen ausfuehren, zugegriffen werden kann.
   */
  public Main(Algorithm algorithm) {
    this.algorithm = algorithm;
    initialize();
  }

  /**
   * Diese Methode verknuepft alle Teile des Programms.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setResizable(false);
    frame.setTitle("AlgorithmVisualizer by Eduard Hermann");
    frame.setIconImage(
        Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/icon/icon.png")));
    frame.setBounds(100, 100, 600, 625);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setLocationRelativeTo(null);
    frame.getContentPane().setLayout(null);

    Visualization = new MyLabel(algorithm);
    Visualization.setBounds(12, 10, 560, 440);
    frame.getContentPane().add(Visualization);

    Selection = new JComboBox<>();
    Selection.setBounds(10, 521, 234, 29);
    frame.getContentPane().add(Selection);
    Selection.addItem("Bubble Sort");
    Selection.addItem("Selection Sort");
    Selection.addItem("Insertion Sort");

    btnRun = new JButton("RUN");
    btnRun.addActionListener(new ActionListener() {
      /**
       * Diese Methode wird beim Klick auf den Menueknopf "RUN" ausgefuehrt. Wenn der Menueknopf
       * "RUN" angeklickt wird, wird der ausgewaehlte Algorithmus ausgefuehrt.
       * 
       * @param e: Damit die Methode ausgefuehrt werden kann, muss der Menueknopf "RUN" gedrueckt
       *        werden. Demnach repraesentiert der Parameter den Klick auf den Menueknopf "RUN".
       */
      public void actionPerformed(ActionEvent e) {
        if (Selection.getSelectedItem() == "Bubble Sort") {
          algorithm.bubbleSort();
        } else if (Selection.getSelectedItem() == "Selection Sort") {
          algorithm.selectionSort();
        } else if (Selection.getSelectedItem() == "Insertion Sort") {
          algorithm.insertionSort();
        }
      }
    });
    btnRun.setFont(new Font("Tahoma", Font.BOLD, 22));
    btnRun.setBounds(474, 470, 100, 80);
    frame.getContentPane().add(btnRun);

    btnNew = new JButton("NEW");
    btnNew.addActionListener(new ActionListener() {
      /**
       * Diese Methode wird beim Klick auf den Menueknopf "NEW" ausgefuehrt. Wenn der Menueknopf
       * "NEW" angeklickt wird, werden alle Rechtecke an eine zufaellige valide Position gestellt.
       * 
       * @param e: Damit die Methode ausgefuehrt werden kann, muss der Menueknopf "NEW" gedrueckt
       *        werden. Demnach repraesentiert der Parameter den Klick auf den Menueknopf "NEW".
       */
      public void actionPerformed(ActionEvent e) {
        algorithm.resortTheBars();
      }
    });
    btnNew.setFont(new Font("Tahoma", Font.BOLD, 22));
    btnNew.setBounds(364, 470, 100, 80);
    frame.getContentPane().add(btnNew);

    MySystem = new JTextField();
    MySystem.setColumns(10);
    MySystem.setBounds(10, 470, 234, 20);
    MySystem.setEditable(false);
    MySystem.setText("System: " + algorithm.MySystemOutput);
    frame.getContentPane().add(MySystem);

    MySwaps = new JTextField();
    MySwaps.setBounds(10, 490, 234, 20);
    frame.getContentPane().add(MySwaps);
    MySwaps.setColumns(10);
    MySwaps.setEditable(false);
    MySwaps.setText("Swaps: " + algorithm.MyNumber);

    btnInfo = new JButton("Info!");
    btnInfo.addActionListener(new ActionListener() {
      /**
       * Diese Methode wird beim Klick auf den Menueknopf "Info!" ausgefuehrt. Wenn der Menueknopf
       * "Info!" angeklickt wird, erscheint eine Informationsmeldung ueber das Programm.
       * 
       * @param e: Damit die Methode ausgefuehrt werden kann, muss der Menueknopf "Info!" gedrueckt
       *        werden. Demnach repraesentiert der Parameter den Klick auf den Menueknopf "Info!".
       */
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,
            "1) The button NEW shouldn't be used whenever an algorithm is currently running! \n"
                + "2) Don't run more than one algorithm at once! \n"
                + "3) Don't run the same algorithm more than once at a time!\n"
                + "4) If you accidentally did one of these mistakes, restart the program in order to make it run correctly.",
            "Info", JOptionPane.INFORMATION_MESSAGE);
      }
    });
    btnInfo.setFont(new Font("Tahoma", Font.BOLD, 22));
    btnInfo.setBounds(254, 470, 100, 80);
    frame.getContentPane().add(btnInfo);

    Seperator = new JSeparator();
    Seperator.setBounds(10, 460, 564, 1);
    frame.getContentPane().add(Seperator);

    MyOptionBar toolbar = new MyOptionBar();
    frame.setJMenuBar(toolbar);
  }
}
