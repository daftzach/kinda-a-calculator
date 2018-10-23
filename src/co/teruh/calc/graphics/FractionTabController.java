package co.teruh.calc.graphics;

import co.teruh.calc.math.Fraction;
import co.teruh.calc.math.MixedNumber;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FractionTabController {
	
	private MixedNumber mixedNumber;
	private Fraction fraction;
	
	int wholeNum;
	int numerator;
	int denominator;
	
	@FXML private TextField fieldFractionWholeNum;
	@FXML private TextField fieldFractionNumerator;
	@FXML private TextField fieldFractionDenominator;
	@FXML private Button buttonTest;
	@FXML private Label labelFraction;

	public void setFractionalValues() {
		
		fieldFractionWholeNum.setOnAction((ActionEvent e) -> {
			if(fieldFractionWholeNum.getText() != null && !fieldFractionWholeNum.getText().isEmpty()) {
				wholeNum = Integer.parseInt(fieldFractionWholeNum.getText());
			} else {
				wholeNum = Integer.parseInt(fieldFractionWholeNum.getText());
			}
		});
		
		fieldFractionNumerator.setOnAction((ActionEvent e) -> {
			if(fieldFractionNumerator.getText() != null && !fieldFractionNumerator.getText().isEmpty()) {
				numerator = Integer.parseInt(fieldFractionNumerator.getText());
			} else {
				numerator = Integer.parseInt(fieldFractionNumerator.getText());
			}
		});
		
		fieldFractionDenominator.setOnAction((ActionEvent e) -> {
			if(fieldFractionDenominator.getText() != null && !fieldFractionDenominator.getText().isEmpty()) {
				denominator = Integer.parseInt(fieldFractionDenominator.getText());
			} else {
				denominator = Integer.parseInt(fieldFractionDenominator.getText());
			}
		});
		
		buttonTest.setOnAction((ActionEvent e) -> {
			if(wholeNum != 0) {
				mixedNumber = new MixedNumber(wholeNum, numerator, denominator);
				labelFraction.setText(mixedNumber.toString());
			} else {
				fraction = new Fraction(numerator, denominator);
				labelFraction.setText(fraction.toString());
			}
		});
	}
}
