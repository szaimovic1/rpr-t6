package ba.unsa.etf.rpr.tutorijal06;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import java.awt.*;
import java.time.LocalDate;
import java.util.Date;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {

    public TextField imeField;
    public TextField prezimeField;
    public TextField indeksField;
    public TextField maticniField;
    public TextField emailField;
    public DatePicker datumPicker;
    boolean tacnoime=false, tacnoprezime=false, tacanindeks=false, tacanmaticni=false,tacanemail=false;


    public SimpleStringProperty ime;
    public SimpleStringProperty prezime;
    public SimpleStringProperty indeks;
    public SimpleStringProperty maticni;
    public SimpleStringProperty email;


    public ComboBox mjestorodjenja;
    ObservableList<String> mjesta= FXCollections.observableArrayList("Sarajevo","Zenica","Tuzla","Mostar","Banja Luka");

    public Controller() { ime=new SimpleStringProperty("");
        prezime=new SimpleStringProperty("");
        indeks=new SimpleStringProperty("");
        email=new SimpleStringProperty("");
        maticni=new SimpleStringProperty("");
        imeField= new TextField();
        prezimeField=new TextField();
        indeksField=new TextField();
        maticniField=new TextField();
        emailField= new TextField();
    }


    public void initialize() {
        mjestorodjenja.setItems(mjesta);
        imeField.textProperty().bindBidirectional(ime);
        prezimeField.textProperty().bindBidirectional(prezime);
        indeksField.textProperty().bindBidirectional(indeks);
        maticniField.textProperty().bindBidirectional(maticni);
        emailField.textProperty().bindBidirectional(email);

        imeField.textProperty().addListener(new ChangeListener<String>() {

            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validnoIme(n)) {
                    imeField.getStyleClass().removeAll("poljeneispravno");
                    imeField.getStyleClass().add("poljeispravno");
                    tacnoime=true;
                } else {
                    imeField.getStyleClass().removeAll("poljeispravno");
                    imeField.getStyleClass().add("poljeneispravno");
                }
            }
        });

        prezimeField.textProperty().addListener(new ChangeListener<String>() {

            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validnoIme(n)) {
                    prezimeField.getStyleClass().removeAll("poljeneispravno");
                    prezimeField.getStyleClass().add("poljeispravno");
                    tacnoprezime=true;
                } else {
                    prezimeField.getStyleClass().removeAll("poljeispravno");
                    prezimeField.getStyleClass().add("poljeneispravno");
                }
            }
        });

        indeksField.textProperty().addListener(new ChangeListener<String>() {

            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanIndeks(n)) {
                    indeksField.getStyleClass().removeAll("poljeneispravno");
                    indeksField.getStyleClass().add("poljeispravno");
                    tacanindeks=true;
                } else {
                    indeksField.getStyleClass().removeAll("poljeispravno");
                    indeksField.getStyleClass().add("poljeneispravno");
                }
            }
        });


        maticniField.textProperty().addListener(new ChangeListener<String>() {

            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanMaticni(n)) {
                    maticniField.getStyleClass().removeAll("poljeneispravno");
                    maticniField.getStyleClass().add("poljeispravno");
                    tacanmaticni=true;
                } else {
                    maticniField.getStyleClass().removeAll("poljeispravno");
                    maticniField.getStyleClass().add("poljeneispravno");
                }
            }
        });

        imeField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                if(!n){
                    if (validnoIme(ime.get())) {
                        imeField.getStyleClass().removeAll("poljeneispravno");
                        imeField.getStyleClass().add("poljeispravno");
                        tacnoime=true;
                    } else {
                        imeField.getStyleClass().removeAll("poljeispravno");
                        imeField.getStyleClass().add("poljeneispravno");
                    }

                }

            }
        });

        prezimeField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                if(!n){
                    if (validnoIme(prezime.get())) {
                        prezimeField.getStyleClass().removeAll("poljeneispravno");
                        prezimeField.getStyleClass().add("poljeispravno");
                        tacnoprezime=true;
                    } else {
                        prezimeField.getStyleClass().removeAll("poljeispravno");
                        prezimeField.getStyleClass().add("poljeneispravno");
                    }

                }

            }
        });

        indeksField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                if(!n){
                    if (validanIndeks(indeks.get())) {
                        indeksField.getStyleClass().removeAll("poljeneispravno");
                        indeksField.getStyleClass().add("poljeispravno");
                        tacanindeks=true;
                    } else {
                        indeksField.getStyleClass().removeAll("poljeispravno");
                        indeksField.getStyleClass().add("poljeneispravno");
                    }

                }

            }
        });

        maticniField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                if(!n){
                    if (validanMaticni(maticni.get())) {
                        maticniField.getStyleClass().removeAll("poljeneispravno");
                        maticniField.getStyleClass().add("poljeispravno");
                        tacanmaticni=true;
                    } else {
                        maticniField.getStyleClass().removeAll("poljeispravno");
                        maticniField.getStyleClass().add("poljeneispravno");
                    }

                }

            }
        });








    }



    public boolean validnoIme(String s) {
        if(s.length()>0 && s.length()<20) return true;
        return false;
    }

    public boolean validanIndeks(String s){
        if(s.length()==5) {
            try{
                Integer.parseInt(s);
            }catch(Exception e) {
                return false;
            }

            return true;
        }
        return false;
    }
    public boolean validanMaticni(String s) {
        if(s.length()==13){
            int A=s.charAt(0), B=s.charAt(2), C=s.charAt(2), D=s.charAt(3), E=s.charAt(4), F=s.charAt(5), G=s.charAt(6), H=s.charAt(7), I=s.charAt(8) ;
            int J=s.charAt(9), K=s.charAt(10),L=s.charAt(11);

            int zadnja = 11 - (( 7*(A+G) + 6*(C+H) + 5*(D+I) + 4*(D+J) + 3*(E+K) + 2*(F+L) ) % 11);

            if(zadnja<=9 && zadnja>=1) {
                if (zadnja == s.charAt(12)-48)
                    return true;
                else return false;
            }
            else {
                if(s.charAt(12)-48==0) return true;
                return false;
            }


        }
        return false;
    }


    public void potvrda(ActionEvent actionEvent) {
        if(tacnoime && tacnoprezime && tacanmaticni&& tacanindeks) {
            System.out.println(ime.get() + "\n" + prezime.get() + "\n" + indeks.get()+ "\n");
            System.out.println(maticni.get() + "\n");
        }

    }

}
