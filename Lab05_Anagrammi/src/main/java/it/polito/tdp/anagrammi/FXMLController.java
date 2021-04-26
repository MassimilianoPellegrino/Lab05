package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblTime;
    
    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcola(ActionEvent event) {
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    	this.lblTime.setText("");
    	try{
    		String parola = this.txtParola.getText();
    		long in = System.currentTimeMillis();
    		Set<String> soluzione = model.getSoluzione(parola);
        	for(String s: soluzione) {
        		if(model.isCorrect(s))
        			this.txtCorretti.appendText(s+"\n");
        		else
        			this.txtErrati.appendText(s+"\n");
        	}
        	long fin = System.currentTimeMillis();
    		this.lblTime.setText(fin-in+"ms");
    	}catch(NullPointerException e) {
    		this.txtCorretti.appendText("Inserire una parola valida da anagrammare");
    	}
    	
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtParola.clear();
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    	this.lblTime.setText("");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		// TODO Auto-generated method stub
		this.model=model;
	}
}
