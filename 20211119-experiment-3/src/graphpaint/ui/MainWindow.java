package graphpaint.ui;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.UIManager;

import graphpaint.ui.elements.AmplitudeSettingsElement;
import graphpaint.ui.elements.PeriodsSettingsElement;
import graphpaint.ui.elements.PhaseSettingsElement;

import java.awt.*;

public class MainWindow extends JFrame {
	private SineGraphPanel sineGraphPanel;
	AmplitudeSettingsElement amplitudeSettingsElement;
	PeriodsSettingsElement periodsSettingsElement;
	PhaseSettingsElement phaseSettingsElement;
	
	private int amplitude = 100;
	
	/*
	 * Домашнее задание :)
	 * 
	 * Создать элемент, позволяющий выбрать цвет графика.
	 * Цвет должен быть типа Color
	 * На основе чего делать выбор цвета - можно выбрать, например,
	 * на https://web.mit.edu/6.005/www/sp14/psets/ps4/java-6-tutorial/components.html
	 * 
	 */
	
	public MainWindow() {
		setTitle("Рисовалка графика y=sin(x) :)");
		setSize(3000, 1800);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		sineGraphPanel = new SineGraphPanel();
		add(sineGraphPanel);
		
		Box settingsPanel = Box.createVerticalBox();
		amplitudeSettingsElement = new AmplitudeSettingsElement();
		periodsSettingsElement = new PeriodsSettingsElement();
		phaseSettingsElement = new PhaseSettingsElement();

		settingsPanel.add(Box.createVerticalGlue());
		settingsPanel.add(new JSeparator());
		settingsPanel.add(amplitudeSettingsElement);
		settingsPanel.add(new JSeparator());
		settingsPanel.add(periodsSettingsElement);
		settingsPanel.add(new JSeparator());
		settingsPanel.add(phaseSettingsElement);
		settingsPanel.add(new JSeparator());
		settingsPanel.add(Box.createVerticalGlue());
		
		add(settingsPanel, BorderLayout.WEST);
	}

}
