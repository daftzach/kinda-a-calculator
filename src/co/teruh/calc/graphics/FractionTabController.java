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

	@FXML private TextField fieldWholeNumber;
	@FXML private TextField fieldNumerator;
	@FXML private TextField fieldDenominator;
	@FXML private TextArea  textOutput;

	@FXML private Button buttonConvert;
	@FXML private Button buttonSimplify;

	@FXML private CheckBox boxImproperFraction;
	@FXML private CheckBox boxMixedNumber;
	@FXML private CheckBox boxDecimal;
	@FXML private CheckBox boxPercentage;
	@FXML private CheckBox boxGCF;

	public FractionTabController() {
		wholeNum = 0;
		numerator = -1;
		denominator = -1;

		mixedNumber = new MixedNumber(wholeNum, numerator, denominator);
		fraction = new Fraction(numerator, denominator);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fieldWholeNumber.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue && !(fieldWholeNumber.getText().isEmpty())) {
					wholeNum = Integer.parseInt(fieldWholeNumber.getText());
					setMixedNumberValues();
					validate();
				} else if (fieldWholeNumber.getText().isEmpty()) {
					mixedNumber.setWholeNumber(0);
					validate();
				}
			}
		});

		fieldWholeNumber.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					fieldWholeNumber.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		fieldNumerator.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue && !(fieldNumerator.getText().isEmpty())) {
					numerator = Integer.parseInt(fieldNumerator.getText());
					setFractionValues();
					validate();
				} else if (fieldWholeNumber.getText().isEmpty()) {
					fraction.setNumerator(0);
					validate();
				}
			}
		});

		fieldNumerator.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					fieldNumerator.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		fieldDenominator.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue && !(fieldDenominator.getText().isEmpty())) {
					denominator = Integer.parseInt(fieldDenominator.getText());
					setFractionValues();
					validate();
				} else if (fieldWholeNumber.getText().isEmpty()) {
					fraction.setDenominator(0);
					validate();
				}
			}
		});

		fieldDenominator.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					fieldDenominator.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		buttonConvert.setOnAction((ActionEvent e) -> {
			if (!mixedNumber.isMixed()) {
				setFractionValues();
				runConversions();
			} else {
				setMixedNumberValues();
				runConversions();
			}
		});

		buttonSimplify.setOnAction((ActionEvent e) -> {
			simplify();
		});
	}

	public void validate() {
		validateImproper();
		validateMixed();
		validateDenominator();
	}

	public void validateImproper() {
		if (fraction.isImproper() && mixedNumber.isMixed()) {
			boxMixedNumber.setDisable(true);
		} else if (!fraction.isImproper()) {
			boxMixedNumber.setDisable(true);
		} else {
			boxMixedNumber.setDisable(false);
		}
	}

	public void validateMixed() {
		if (!mixedNumber.isMixed()) {
			boxImproperFraction.setDisable(true);
		} else {
			boxImproperFraction.setDisable(false);
		}
	}

	public void validateDenominator() {
		if (denominator == 0) {
			textOutput.appendText("ERROR: Denominator cannot be ZERO!\n");
		}
	}

	public void setFractionValues() {
		fraction.setNumerator(numerator);
		fraction.setDenominator(denominator);
	}

	public void setMixedNumberValues() {
		mixedNumber.setWholeNumber(wholeNum);
		mixedNumber.setNumerator(numerator);
		mixedNumber.setDenominator(denominator);
	}

	public void runConversions() {
		textOutput.clear();

		if (boxImproperFraction.isSelected() && !(boxImproperFraction.isDisabled())) {
			textOutput.appendText("Improper Fraction: " + mixedNumber.convertToFraction() + "\n");
		}

		if (boxMixedNumber.isSelected() && !(boxMixedNumber.isDisabled())) {
			textOutput.appendText("Mixed Number: " + fraction.convertToMixedNumber() + "\n");
		}

		if (boxDecimal.isSelected() && mixedNumber.isMixed()) {
			textOutput.appendText("Decimal: " + Float.toString(mixedNumber.toDecimal()) + "\n");
		} else if (!mixedNumber.isMixed()) {
			textOutput.appendText("Decimal: " + Float.toString(fraction.toDecimal()) + "\n");
		}

		if (boxPercentage.isSelected() && mixedNumber.isMixed()) {
			textOutput.appendText("Percentage: " + Double.toString(mixedNumber.toPercent()) + "%\n");
		} else if (!mixedNumber.isMixed()) {
			textOutput.appendText("Percentage: " + Double.toString(fraction.toPercent()) + "%\n");
		}
	}

	public void simplify() {
		fraction.simplify();

		if (textOutput.getText().contains("Simplified: ") && !boxGCF.isSelected()) {
			textOutput.clear();
			textOutput.appendText("Simplified: " + fraction.toString() + "\n");
		} else if (!boxGCF.isSelected()) {
			textOutput.appendText("Simplified: " + fraction.toString() + "\n");
		} else if (!textOutput.getText().contains("Simplified: ") && boxGCF.isSelected()) {
			textOutput.appendText("Simplified: " + fraction.toString() + "\n");
			textOutput.appendText("GCF: " + fraction.getGCF(numerator, denominator) + "\n");
		} else {
			textOutput.clear();
			textOutput.appendText("Simplified: " + fraction.toString() + "\n");
			textOutput.appendText("GCF: " + fraction.getGCF(numerator, denominator) + "\n");
		}
	}
}
