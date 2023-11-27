package sio.devoir1sioalt;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.ResourceBundle;

public class DevoirController implements Initializable {

    @FXML
    private Button btnExo1;
    @FXML
    private AnchorPane apExo1;
    @FXML
    private AnchorPane apExo2;
    @FXML
    private AnchorPane apExo3;
    @FXML
    private Button btnExo2;
    @FXML
    private Slider sldNbLignes;
    @FXML
    private TextArea txtTriangle;
    @FXML
    private Button btnExo3;
    @FXML
    private Button btnDessiner;
    @FXML
    private TextField txtNbJours;
    @FXML
    private TextField txtNbEleves;
    @FXML
    private TextField txtCoutGlobal;
    @FXML
    private Button btnCalculer;
    @FXML
    private Button btnJouer;
    @FXML
    private TextArea txtResultatsTirages;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        apExo1.toFront();
    }

    @FXML
    public void btnExosMenuClicked(Event event) {
        if (event.getSource() == btnExo1) {
            apExo1.toFront();
        } else if (event.getSource() == btnExo2) {
            apExo2.toFront();
        } else {
            apExo3.toFront();
            ;
        }
    }

    // Exercice n°1
    @FXML
    public void btnCalculerClicked(Event event) {
        // A vous de jouer
        Alert alert;
        if (this.txtNbJours.getText().matches("")) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setContentText("Veuillez saisir nombre de jour");
            alert.setHeaderText("");
            alert.showAndWait();
        } else if (this.txtNbEleves.getText().matches("")) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setContentText("Veuillez saisir le nombre d'èleve");
            alert.setHeaderText("");
            alert.showAndWait();

        } else {

            int nombreEleves = Integer.parseInt(txtNbEleves.getText());
            int nombreJours = Integer.parseInt(txtNbJours.getText());
            double coutTrajet;

            if (nombreEleves <= 25) {
                coutTrajet = nombreEleves * 67.30;
            } else {
                coutTrajet = 25 * 67.30 + (nombreEleves - 25) * 61.00;
            }

            double coutNourriture = nombreEleves * 3.50 * nombreJours;

            double coutHebergement;
            if (nombreEleves <= 30) {
                coutHebergement = nombreEleves * 4.75 * nombreJours;
            } else if (nombreEleves <= 35) {
                coutHebergement = nombreEleves * 4.00 * nombreJours;
            } else {
                coutHebergement = nombreEleves * 3.50 * nombreJours;
            }

            double coutGlobal = coutTrajet + coutNourriture + coutHebergement;

            txtCoutGlobal.setText(String.valueOf(coutGlobal));
        }

    }

    // Exercice n°2
    @FXML
    public void btnDessinerClicked(Event event) {
        // A vous de jouer

        txtTriangle.setText("");
        for (int i = 1; i <= sldNbLignes.getValue(); i++) {
            for (int j = 1; j <= sldNbLignes.getValue() - i + 1; j++) {
                txtTriangle.setText(txtTriangle.getText() + " " + i + " ");
            }
            txtTriangle.setText(txtTriangle.getText() + "\n");
        }
    }

    // Exercice n°3
    @FXML
    public void btnJouerClicked(Event event) {
        // A vous de jouer

        int scoreJoueur = 0;
        int scoreOrdinateur = 0;

        while (scoreJoueur < 30 && scoreOrdinateur < 30) {

            Random r = new Random();



            int nbOrdi1 = 1 + r.nextInt(6);
            int nbOrdi2 = 1 + r.nextInt(6);
            int nbJoueur1 = 1 + r.nextInt(6);
            int nbJoueur2 = 1 + r.nextInt(6);

            int sommeJoueur = nbJoueur1 + nbJoueur2;
            int sommeOrdi = nbOrdi1 + nbOrdi2;

            txtResultatsTirages.setText("NB1J = " + nbJoueur1 + " NB2J = " + nbJoueur2 + " Total = " + sommeJoueur + "\n");
            txtResultatsTirages.setText(txtResultatsTirages.getText() + "NB1O = " + nbOrdi1 + "NB2O = " + nbOrdi2 + "Total = " + sommeOrdi + "\n");

            if (nbJoueur1 == nbJoueur2) {
                if (nbJoueur1 == 3) {
                    scoreJoueur = 0;
                } else if (nbJoueur1 == 6) {
                    scoreJoueur += 25;
                } else {
                    scoreJoueur += 5;
                }
            }

            if (nbOrdi1 == nbOrdi2) {
                if (nbOrdi1 == 3) {
                    scoreOrdinateur = 0;
                } else if (nbOrdi1 == 6) {
                    scoreOrdinateur += 25;
                } else {
                    scoreOrdinateur += 5;
                }
            }

        }

        if (scoreJoueur >= 30) {
            txtResultatsTirages.setText(txtResultatsTirages.getText() + "Le joueur a gagné la partie !" + "\n");
        } else {
            txtResultatsTirages.setText(txtResultatsTirages.getText() + "L'ordinateur a gagné la partie !" + "\n");
        }

    }
}