package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Controller {

    public TextField popuniIme;
    public TextField popuniPrezime;
    public TextField popuniIndex;
    public TextField popuniJMBG;
    public TextField popuniMail;
    public DatePicker popuniDat;
    boolean tacnoime=false, tacnoprezime=false, tacanindeks=false, tacanmaticni=false,tacanmail=false;

    public SimpleStringProperty ime;
    public SimpleStringProperty prezime;
    public SimpleStringProperty indeks;
    public SimpleStringProperty maticni;
    public SimpleStringProperty email;

    public ComboBox popuniOdsjek;
    ObservableList<String> odsjeci= FXCollections.observableArrayList("RI","AM","EE","SI", "TK");

    public ComboBox popuniGod;
    ObservableList<String> god= FXCollections.observableArrayList("1.","2.","3.","4.", "5.");

    public ComboBox popuniCiklus;
    ObservableList<String> ciklusi= FXCollections.observableArrayList("Bachelor","Master");

    public Controller() { ime=new SimpleStringProperty("");
        prezime=new SimpleStringProperty("");
        indeks=new SimpleStringProperty("");
        email=new SimpleStringProperty("");
        maticni=new SimpleStringProperty("");
        popuniIme= new TextField();
        popuniPrezime=new TextField();
        popuniIndex=new TextField();
        popuniJMBG=new TextField();
        popuniMail= new TextField();
    }

    public void initialize() {
        popuniOdsjek.setItems(odsjeci);
        popuniGod.setItems(god);
        popuniCiklus.setItems(ciklusi);
        popuniIme.textProperty().bindBidirectional(ime);
        popuniPrezime.textProperty().bindBidirectional(prezime);
        popuniIndex.textProperty().bindBidirectional(indeks);
        popuniJMBG.textProperty().bindBidirectional(maticni);
        popuniMail.textProperty().bindBidirectional(email);

        popuniIme.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validnoIme(n)) {
                    popuniIme.getStyleClass().removeAll("poljeneispravno");
                    popuniIme.getStyleClass().add("poljeispravno");
                    tacnoime=true;
                } else {
                    popuniIme.getStyleClass().removeAll("poljeispravno");
                    popuniIme.getStyleClass().add("poljeneispravno");
                }
            }
        });

        popuniPrezime.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validnoIme(n)) {
                    popuniPrezime.getStyleClass().removeAll("poljeneispravno");
                    popuniPrezime.getStyleClass().add("poljeispravno");
                    tacnoprezime=true;
                } else {
                    popuniPrezime.getStyleClass().removeAll("poljeispravno");
                    popuniPrezime.getStyleClass().add("poljeneispravno");
                }
            }
        });

        popuniIndex.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanIndeks(n)) {
                    popuniIndex.getStyleClass().removeAll("poljeneispravno");
                    popuniIndex.getStyleClass().add("poljeispravno");
                    tacanindeks=true;
                } else {
                    popuniIndex.getStyleClass().removeAll("poljeispravno");
                    popuniIndex.getStyleClass().add("poljeneispravno");
                }
            }
        });

        popuniJMBG.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanMaticni(n)) {
                    popuniJMBG.getStyleClass().removeAll("poljeneispravno");
                    popuniJMBG.getStyleClass().add("poljeispravno");
                    tacanmaticni=true;
                } else {
                    popuniJMBG.getStyleClass().removeAll("poljeispravno");
                    popuniJMBG.getStyleClass().add("poljeneispravno");
                }
            }
        });

        popuniMail.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanMail(n)) {
                    popuniMail.getStyleClass().removeAll("poljeneispravno");
                    popuniMail.getStyleClass().add("poljeispravno");
                    tacanmail=true;
                } else {
                    popuniMail.getStyleClass().removeAll("poljeispravno");
                    popuniMail.getStyleClass().add("poljeneispravno");
                }
            }
        });

        popuniIme.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                if(!n){
                    if (validnoIme(ime.get())) {
                        popuniIme.getStyleClass().removeAll("poljeneispravno");
                        popuniIme.getStyleClass().add("poljeispravno");
                        tacnoime=true;
                    } else {
                        popuniIme.getStyleClass().removeAll("poljeispravno");
                        popuniIme.getStyleClass().add("poljeneispravno");
                    }
                }
            }
        });

        popuniPrezime.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                if(!n){
                    if (validnoIme(prezime.get())) {
                        popuniPrezime.getStyleClass().removeAll("poljeneispravno");
                        popuniPrezime.getStyleClass().add("poljeispravno");
                        tacnoprezime=true;
                    } else {
                        popuniPrezime.getStyleClass().removeAll("poljeispravno");
                        popuniPrezime.getStyleClass().add("poljeneispravno");
                    }
                }
            }
        });

        popuniIndex.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                if(!n){
                    if (validanIndeks(indeks.get())) {
                        popuniIndex.getStyleClass().removeAll("poljeneispravno");
                        popuniIndex.getStyleClass().add("poljeispravno");
                        tacanindeks=true;
                    } else {
                        popuniIndex.getStyleClass().removeAll("poljeispravno");
                        popuniIndex.getStyleClass().add("poljeneispravno");
                    }
                }
            }
        });

        popuniJMBG.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                if(!n){
                    if (validanMaticni(maticni.get())) {
                        popuniJMBG.getStyleClass().removeAll("poljeneispravno");
                        popuniJMBG.getStyleClass().add("poljeispravno");
                        tacanmaticni=true;
                    } else {
                        popuniJMBG.getStyleClass().removeAll("poljeispravno");
                        popuniJMBG.getStyleClass().add("poljeneispravno");
                    }
                }
            }
        });

        popuniMail.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                if(!n){
                    if (validanMail(email.get())) {
                        popuniMail.getStyleClass().removeAll("poljeneispravno");
                        popuniMail.getStyleClass().add("poljeispravno");
                        tacanmail=true;
                    } else {
                        popuniMail.getStyleClass().removeAll("poljeispravno");
                        popuniMail.getStyleClass().add("poljeneispravno");
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
        /*if(s.length()==13){
            int A=s.charAt(0), B=s.charAt(2), V=s.charAt(2), G=s.charAt(3), D=s.charAt(4), Đ=s.charAt(5), E=s.charAt(6), Ž=s.charAt(7), Z=s.charAt(8) ;
            int I=s.charAt(9), J=s.charAt(10),K=s.charAt(11), L=s.charAt(12);
            L = 11 - (( 7*(A+E) + 6*(B+Ž) + 5*(V+Z) + 4*(G+I) + 3*(D+J) + 2*(Đ+K) ) % 11)
            if(L<=9 && L>=1) {
                if (L == s.charAt(12)-48)
                    return true;
                else return false;
            }
            else {
                if(s.charAt(12)-48==0) return true;
                return false;
            }
        }*/
        //return false;
        if(s.length()==13)
            return true;
        return false;
    }

    public boolean validanMail(String s) {
        if(!s.contains("@") || s.length()<3 || s.length()>63)
            return false;
        return true;
    }

    public void potvrda(ActionEvent actionEvent) {
        if(tacnoime && tacnoprezime && tacanmaticni&& tacanindeks) {
            System.out.println(ime.get() + "\n" + prezime.get() + "\n" + indeks.get()+ "\n");
            System.out.println(maticni.get() + "\n");
        }
    }

}
