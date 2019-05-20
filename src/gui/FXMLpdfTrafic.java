/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.scenario.effect.ImageData;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.HBox;
import javafx.stage.Stage;


/**
 *
 * @author Adly
 */
public class FXMLpdfTrafic extends Application{

  public static  void main ( String args []) throws FileNotFoundException, DocumentException {
      
      launch(args);
  }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hbox = new HBox() ;
        Button b = new Button() ;
        b.setText("ok");
        b.setOnAction((event) -> {
               Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
		Font redFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
		Font yellowFont = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 255, 0));
           
            try {
           
          Document document  = new Document() ;
          PdfWriter instance = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/mghozzi/Desktop/plll.pdf"));
         
            document.open();
              Image image1 = Image.getInstance("src/resources/images/azer.png");
             double percent = 0.5;
           image1.scaleAbsolute(150,130);
 
               Paragraph chapterTitle = new Paragraph("Horde Social Pro ADMINISTRATION ", redFont);
                Paragraph paragraphOne = new Paragraph("Objet : Reclamation a propos de votre publication ");
                 Paragraph paragraphtwo = new Paragraph("Madame, Monsieur,\n" +
"Le 8 septembre 1996, j’ai acheté chez vous un téléviseur (marque), (modèle),\n" +
"(n° de série) (facture n°).3\n" +
"Depuis l’achat, ce téléviseur n’a jamais bien fonctionné : (Décrivez le problème). Je\n" +
"l’ai rapporté à trois reprises (les 15 janvier, 12 février et 18 mars 1997) à votre\n" +
"magasin, pour des périodes d’examen d’environ trois semaines chaque fois. Quand\n" +
"je reprenais possession de l’appareil, vos techniciens m’affirmaient que le problème\n" +
"était résolu, mais ce téléviseur ne fonctionnait pas bien et ne fonctionne toujours\n" +
"pas bien.4\n" +
"Puisque ce téléviseur est défectueux et que vos techniciens ne peuvent le réparer,\n" +
"je vous demande de le remplacer.5\n" +
" J’attends votre réponse dans les 10 jours de la\n" +
"réception de la présente, à défaut de quoi j’intenterai des poursuites judiciaires\n" +
"contre vous sans autre avis ni délai.\n" +
"Veuillez donc agir en conséquence.  ", blueFont);
                  Paragraph paragraphsignature = new Paragraph("ADMINISTRATION", yellowFont) ;
		    Chapter chapter1 = new Chapter(chapterTitle, 1);
		    chapter1.setNumberDepth(0);
          
        
         document.add(chapter1);
         document.add(paragraphOne);
         document.add(paragraphtwo);
          document.add(image1);
          document.add(paragraphsignature);
        document.close();
      }catch(Exception e) {
          System.out.println(e);
      }
      System.out.println("generated success"); 
 
        }); 
      
      
      
      
      
      
        hbox.getChildren().addAll(b) ;
        Stage primarystage = new Stage() ;
          Scene scene = new Scene(hbox);
        primarystage.setScene(scene);
        primarystage.show();
    }
    
    
}