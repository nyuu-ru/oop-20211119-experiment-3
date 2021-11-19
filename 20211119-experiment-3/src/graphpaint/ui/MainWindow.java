package graphpaint.ui;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
	private SineGraphPanel sineGraphPanel;
	
	public MainWindow() {
		setTitle("Рисовалка графика y=sin(x) :)");
		setSize(3000, 1800);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		sineGraphPanel = new SineGraphPanel();
		add(sineGraphPanel);
	}

}
