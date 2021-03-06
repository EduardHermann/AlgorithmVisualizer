package pack;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 * Diese Klasse ist fuer die visuelle Darstellung der Algorithmen zustaendig.
 */
public class MyLabel extends JLabel {

  private static final long serialVersionUID = 1L;

  private BufferedImage[] theBars;
  private Algorithm algorithm;

  private BufferedImage arrow_blue;
  private BufferedImage arrow_green;
  private BufferedImage arrow_red;

  /**
   * Alle Bilder, fuer die visuelle Darstellung der Algorithmen, werden hier eingelesen.
   * 
   * @param algorithm: Ein "Algorithm" Objekt wird bei der Instanziierung der Klasse "Label"
   *        benoetigt, da einige Groessen dieses Objekts verwendet werden, um die Bilder auf das
   *        Fenster malen zu koennen.
   * @exception e: Diese Fehlermeldung wird benutzt, um auszugeben, dass einige Bilder nicht richtig
   *            eingelesen werden konnten und wo diese Bilder falsch eingelesenen wurden.
   */
  public MyLabel(Algorithm algorithm) {
    this.algorithm = algorithm;
    theBars = new BufferedImage[8];
    try {
      for (int i = 0; i < theBars.length; i++) {
        theBars[i] =
            ImageIO.read(getClass().getClassLoader().getResource("Bars/bar_" + i + ".png"));
      }
      arrow_blue = ImageIO.read(getClass().getClassLoader().getResource("Arrows/arrow_blue.png"));
      arrow_green = ImageIO.read(getClass().getClassLoader().getResource("Arrows/arrow_green.png"));
      arrow_red = ImageIO.read(getClass().getClassLoader().getResource("Arrows/arrow_red.png"));
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("The images couldn't be read in!");
    }
  }

  /**
   * Diese Methode malt kontinuierlich alle noetigen Bilder auf das Fenster, sobald ein Algorithmus
   * gestartet wird.
   * 
   * @param g: Dies ist die Komponente, mit der die Bilder, sobald ein Algorithmus gestartet wird,
   *        auf die vorgesehene Flaeche des Fensters gemalt werden.
   */
  protected void paintComponent(Graphics g) {

    g.drawImage(theBars[0], algorithm.theXArray[0], 440 - 250, algorithm.BARWIDTH, 250, null);
    g.drawImage(theBars[1], algorithm.theXArray[1], 440 - 100, algorithm.BARWIDTH, 100, null);
    g.drawImage(theBars[2], algorithm.theXArray[2], 440 - 175, algorithm.BARWIDTH, 175, null);
    g.drawImage(theBars[3], algorithm.theXArray[3], 440 - 300, algorithm.BARWIDTH, 300, null);
    g.drawImage(theBars[4], algorithm.theXArray[4], 440 - 275, algorithm.BARWIDTH, 275, null);
    g.drawImage(theBars[5], algorithm.theXArray[5], 440 - 50, algorithm.BARWIDTH, 50, null);
    g.drawImage(theBars[6], algorithm.theXArray[6], 440 - 350, algorithm.BARWIDTH, 350, null);
    g.drawImage(theBars[7], algorithm.theXArray[7], 440 - 200, algorithm.BARWIDTH, 200, null);

    if (algorithm.theBubbleSort == true) {
      if (algorithm.comparing == true) {
        g.drawImage(arrow_blue, algorithm.arrowX, algorithm.arrowY1, 70, 50, null);
        g.drawImage(arrow_blue, algorithm.arrowX + algorithm.BARWIDTH, algorithm.arrowY2, 70, 50,
            null);
      } else if (algorithm.wrong == true) {
        g.drawImage(arrow_red, algorithm.arrowX, algorithm.arrowY1, 70, 50, null);
        g.drawImage(arrow_red, algorithm.arrowX + algorithm.BARWIDTH, algorithm.arrowY2, 70, 50,
            null);
      } else if (algorithm.right == true) {
        g.drawImage(arrow_green, algorithm.arrowX, algorithm.arrowY1, 70, 50, null);
        g.drawImage(arrow_green, algorithm.arrowX + algorithm.BARWIDTH, algorithm.arrowY2, 70, 50,
            null);
      }
    } else if (algorithm.theSelectionSort) {
      if (algorithm.comparing == true) {
        g.drawImage(arrow_blue, algorithm.arrowX, algorithm.arrowY1, 70, 50, null);
        g.drawImage(arrow_blue, algorithm.arrowXS, algorithm.arrowY2, 70, 50, null);
      } else if (algorithm.wrong == true) {
        g.drawImage(arrow_red, algorithm.arrowX, algorithm.arrowY1, 70, 50, null);
        g.drawImage(arrow_red, algorithm.arrowXS, algorithm.arrowY2, 70, 50, null);
      } else if (algorithm.right == true) {
        g.drawImage(arrow_green, algorithm.arrowX, algorithm.arrowY1, 70, 50, null);
        g.drawImage(arrow_green, algorithm.arrowXS, algorithm.arrowY2, 70, 50, null);
      }
    } else if (algorithm.theInsertionSort == true) {
      if (algorithm.comparing == true) {
        g.drawImage(arrow_blue, algorithm.arrowX, algorithm.arrowY1, 70, 50, null);
        g.drawImage(arrow_blue, algorithm.arrowX - algorithm.BARWIDTH, algorithm.arrowY2, 70, 50,
            null);
      } else if (algorithm.wrong == true) {
        g.drawImage(arrow_red, algorithm.arrowX, algorithm.arrowY1, 70, 50, null);
        g.drawImage(arrow_red, algorithm.arrowX - algorithm.BARWIDTH, algorithm.arrowY2, 70, 50,
            null);
      } else if (algorithm.right == true) {
        g.drawImage(arrow_green, algorithm.arrowX, algorithm.arrowY1, 70, 50, null);
        g.drawImage(arrow_green, algorithm.arrowX - algorithm.BARWIDTH, algorithm.arrowY2, 70, 50,
            null);
      }
    }
    repaint();
  }
}
