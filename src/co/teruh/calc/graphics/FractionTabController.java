package co.teruh.calc.graphics;

import java.net.URL;
import java.util.ResourceBundle;
import co.teruh.calc.math.Fraction;
import co.teruh.calc.math.MixedNumber;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FractionTabController implements Initializable {

	private int wholeNum;
	private int numerator;
	private int denominator;

	private MixedNumber mixedNumber;
	private Fraction fraction;

	@FXML private TextField fieldFractionWholeNum;
	@FXML private TextField fieldFractionNumerator;
	@FXML private TextField fieldFractionDenominator;
	@FXML private TextArea areaOutput;

	@FXML private Button buttonConvert;

	@FXML private CheckBox checkImproper;
	@FXML private CheckBox checkMixedNumber;
	@FXML private CheckBox checkDecimal;
	@FXML private CheckBox checkPercentage;

	public FractionTabController() {
		wholeNum = 0;
		numerator = -1;
		denominator = -1;

		mixedNumber = new MixedNumber(wholeNum, numerator, denominator);
		fraction = new Fraction(numerator, denominator);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fieldFractionWholeNum.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue && !(fieldFractionWholeNum.getText().isEmpty())) {
					wholeNum = Integer.parseInt(fieldFractionWholeNum.getText());
					setMixedNumberValues();
					validiate();
				} else if (fieldFractionWholeNum.getText().isEmpty()) {
					mixedNumber.setInteger(0);
					validiate();
				}
			}
		});

		fieldFractionWholeNum.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					fieldFractionWholeNum.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		fieldFractionNumerator.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue && !(fieldFractionNumerator.getText().isEmpty())) {
					numerator = Integer.parseInt(fieldFractionNumerator.getText());
					setFractionValues();
					validiate();
				} else if (fieldFractionWholeNum.getText().isEmpty()) {
					fraction.setNumerator(0);
					validiate();
				}
			}
		});

		fieldFractionNumerator.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					fieldFractionNumerator.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		fieldFractionDenominator.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue && !(fieldFractionDenominator.getText().isEmpty())) {
					denominator = Integer.parseInt(fieldFractionDenominator.getText());
					setFractionValues();
					validiate();
				} else if (fieldFractionWholeNum.getText().isEmpty()) {
					fraction.setDenominator(0);
					validiate();
				}
			}
		});

		fieldFractionDenominator.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					fieldFractionDenominator.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		buttonConvert.setOnAction((ActionEvent e) -> {
			if (!mixedNumber.isMixed()) {
				setFractionValues();
				System.out.println(fraction.toString());
				runConversions();
			} else {
				setMixedNumberValues();
				System.out.println(mixedNumber.toString());
				runConversions();
			}
		});
	}

	public void validiate() {
		validateImproper();
		validateMixed();
		validateDenominator();
	}

	public void validateImproper() {
		if (!fraction.isImproper() && mixedNumber.isMixed()) {
			checkMixedNumber.setDisable(true);
		} else {
			checkMixedNumber.setDisable(false);
		}
	}

	public void validateMixed() {
		if (!mixedNumber.isMixed()) {
			checkImproper.setDisable(true);
		} else {
			checkImproper.setDisable(false);
		}
	}

	public void validateDenominator() {
		if (denominator == 0) {
			areaOutput.appendText("ERROR: Denominator cannot be ZERO!\n");
		}
	}

	public void setFractionValues() {
		fraction.setNumerator(numerator);
		fraction.setDenominator(denominator);
	}

	public void setMixedNumberValues() {
		mixedNumber.setInteger(wholeNum);
		mixedNumber.setNumerator(numerator);
		mixedNumber.setDenominator(denominator);
	}

	public void runConversions() {
		areaOutput.clear();

		if (checkImproper.isSelected() && !(checkImproper.isDisabled())) {
			areaOutput.appendText("Improper Fraction: " + mixedNumber.convertToFraction() + "\n");
		}

		if (checkMixedNumber.isSelected() && !(checkMixedNumber.isDisabled())) {
			areaOutput.appendText("Mixed Number: " + fraction.convertToMixedNumber() + "\n");
		}

		if (checkDecimal.isSelected() && mixedNumber.isMixed()) {
			areaOutput.appendText("Decimal: " + Float.toString(mixedNumber.toDecimal()) + "\n");
		} else if (!mixedNumber.isMixed()) {
			areaOutput.appendText("Decimal: " + Float.toString(fraction.toDecimal()) + "\n");
		}

		if (checkPercentage.isSelected() && mixedNumber.isMixed()) {
			areaOutput.appendText("Percentage: " + Double.toString(mixedNumber.toPercent()) + "%\n");
		} else if (!mixedNumber.isMixed()) {
			areaOutput.appendText("Percentage: " + Double.toString(fraction.toPercent()) + "%\n");
		}
	}
}
