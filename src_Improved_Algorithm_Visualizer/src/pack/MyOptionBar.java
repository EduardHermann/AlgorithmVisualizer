package pack;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Diese Klasse repraesentiert das oben dargestellte Optionsmenue.
 */
public class MyOptionBar extends JMenuBar {

  private static final long serialVersionUID = 1L;

  private JMenu options;
  private JMenuItem exit;

  private JMenu help;
  private JMenu about;
  private JMenuItem bubbleSort;
  private JMenuItem selectionSort;
  private JMenuItem insertionSort;

  private JMenu contact;
  private JMenu developer;
  private JMenuItem viaGitHub;

  private URI theUrl = null;
  private String url = "https://github.com/EduardHermann";

  /**
   * Diese Methode erstellt bzw. initialisiert das Optionsmenue.
   */
  public MyOptionBar() {
    options = new JMenu("Options");
    exit = new JMenuItem("Exit");

    help = new JMenu("Help");
    about = new JMenu("About");
    bubbleSort = new JMenuItem("Bubble Sort");
    selectionSort = new JMenuItem("Selection Sort");
    insertionSort = new JMenuItem("Insertion Sort");

    contact = new JMenu("Contact");
    developer = new JMenu("Contact the developer");
    viaGitHub = new JMenuItem("via GitHub");

    try {
      theUrl = new URI(url);
    } catch (URISyntaxException e) {
      e.printStackTrace();
      System.out.println("An error occurred while trying to pass in the url!");
    }

    readInIcons();
    addActionListeners();
    createToolBar();
  }

  /**
   * Diese Methode liest alle Bilder des Optionsmenues ein.
   * 
   * @exception e: Diese Fehlermeldung wird benutzt, um auszugeben, dass die Bilder nicht eingelesen
   *            werden konnten und wo diese Bilder falsch eingelesenen wurden.
   */
  public void readInIcons() {
    try {
      exit.setIcon(new ImageIcon(
          ImageIO.read(getClass().getClassLoader().getResource("iconMenu/options/exit.png"))));

      about.setIcon(new ImageIcon(
          ImageIO.read(getClass().getClassLoader().getResource("iconMenu/help/about.png"))));

      developer.setIcon(new ImageIcon(
          ImageIO.read(getClass().getClassLoader().getResource("iconMenu/contact/developer.png"))));
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("The icons of the menuitems couldn't get read in!");
    }
  }

  /**
   * Diese Methode erstellt bzw. gibt die Aktionen an, die getaetigt werden, wenn die einzelnen
   * Knoepfe des Optionsmenues gedrueckt werden.
   * 
   * @exception e1: Diese Fehlermeldung wird benutzt, um auszugeben, dass die Website nicht erreicht
   *            werden konnte.
   */
  public void addActionListeners() {
    exit.addActionListener(new ActionListener() {
      /**
       * Diese Methode wird beim Klick auf den Menueknopf "Exit" ausgefuehrt. Wenn der Menueknopf
       * "Exit" angeklickt wird, schliesst sich das Programm.
       * 
       * @param e: Damit die Methode ausgefuehrt werden kann, muss der Menueknopf "Exit" gedrueckt
       *        werden. Demnach repraesentiert der Parameter den Klick auf den Menueknopf "Exit".
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    bubbleSort.addActionListener(new ActionListener() {
      /**
       * Diese Methode wird beim Klick auf den Menueknopf "Bubble Sort" ausgefuehrt. Wenn der
       * Menueknopf "Bubble Sort" angeklickt wird, erscheint eine Informationsmeldung ueber den
       * Algorithmus.
       * 
       * @param e: Damit die Methode ausgefuehrt werden kann, muss der Menueknopf "Bubble Sort"
       *        gedrueckt werden. Demnach repraesentiert der Parameter den Klick auf den Menueknopf
       *        "Bubble Sort".
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,
            "The bubble sort starts at index = 0 to iterate over the entire length of the array - 2 and checks whether the current index + 1 is smaller\n"
                + "than the current index. If this is the case, the two positions are swapped with each other. As a result of that, the first iteration over\n"
                + "the length of the entire array - 2 puts the largest value is in the last position of the array, so that from then on the algorithm only has to\n"
                + "iterate up to the length of the array - 3, since the largest value is in the last position and from then on only the second largest is\n"
                + "searched for. So by knowing that the algorithm starts iterating from the index = 0 to the length of the array - 3, with the same scheme. This\n"
                + "procedure is used until the smallest value is at the beginning of the array.",
            "Bubble Sort Info", JOptionPane.INFORMATION_MESSAGE);
      }
    });

    selectionSort.addActionListener(new ActionListener() {
      /**
       * Diese Methode wird beim Klick auf den Menueknopf "Selection Sort" ausgefuehrt. Wenn der
       * Menueknopf "Selection Sort" angeklickt wird, erscheint eine Informationsmeldung ueber den
       * Algorithmus.
       * 
       * @param e: Damit die Methode ausgefuehrt werden kann, muss der Menueknopf "Selection Sort"
       *        gedrueckt werden. Demnach repraesentiert der Parameter den Klick auf den Menueknopf
       *        "Selection Sort".
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,
            "The selection sort searches the entire array for the largest value and swaps it with the value at the\n"
                + "end of the array so that the largest value of the array is at the end. This means that the algorithm\n"
                + "knows that the largest value is already at the end of the array and that it now only has to search\n"
                + "for the second largest value in the array, and it does that, according to the same scheme as in\n"
                + "the first iteration. This process is repeated until the algorithm has reached the smallest value in\n"
                + "the array.",
            "Selection Sort Info", JOptionPane.INFORMATION_MESSAGE);
      }
    });

    insertionSort.addActionListener(new ActionListener() {
      /**
       * Diese Methode wird beim Klick auf den Menueknopf "Insertion Sort" ausgefuehrt. Wenn der
       * Menueknopf "Insertion Sort" angeklickt wird, erscheint eine Informationsmeldung ueber den
       * Algorithmus.
       * 
       * @param e: Damit die Methode ausgefuehrt werden kann, muss der Menueknopf "Insertion Sort"
       *        gedrueckt werden. Demnach repraesentiert der Parameter den Klick auf den Menueknopf
       *        "Insertion Sort".
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,
            "The insertion sort starts at index = 1 and iterates over all indexes before this index and checks whether the values at these indexes\n"
                + "are greater than the value of the current start index of the iteration. If this is the case, the larger values are exchanged with the smaller\n"
                + "ones. So that in the end of that iteration the smallest value of the interval from 0 to 1 is searched and is placed at the beginning of\n"
                + "the array. After that iteration the start index is getting incremented by 1. This process is repeated until the start index of each\n"
                + "iteration is bigger than the length of the array. As a result of that, the smaller values of the array are getting swapped to the start of\n"
                + "the array and the greater values are getting pushed to the end of the array. Therefore, the array is getting sorted from minimum to maximum.",
            "Insertion Sort Info", JOptionPane.INFORMATION_MESSAGE);
      }
    });


    viaGitHub.addActionListener(new ActionListener() {
      /**
       * Diese Methode wird beim Klick auf den Menueknopf "via GitHub" ausgefuehrt. Wird der
       * Menueknopf "via GitHub" angeklickt, oeffnet sich die Internet Website
       * "https://github.com/EduardHermann".
       * 
       * @param e: Damit die Methode ausgefuehrt werden kann, muss der Menueknopf "via GitHub"
       *        gedrueckt werden. Demnach repraesentiert der Parameter den Klick auf den Menueknopf
       *        "via GitHub".
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          Desktop.getDesktop().browse(theUrl);
        } catch (IOException e1) {
          e1.printStackTrace();
          System.out.println("The website couldn't be reached!");
        }
      }
    });
  }

  /**
   * Diese Methode kombiniert alle Teile des Optionsmenues.
   */
  public void createToolBar() {
    options.add(exit);

    help.add(about);
    about.add(bubbleSort);
    about.add(selectionSort);
    about.add(insertionSort);

    contact.add(developer);
    developer.add(viaGitHub);

    add(options);
    add(help);
    add(contact);
  }
}
