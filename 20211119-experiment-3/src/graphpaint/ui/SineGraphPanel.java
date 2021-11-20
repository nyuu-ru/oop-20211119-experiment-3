package graphpaint.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;

import javax.swing.JPanel;

public class SineGraphPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int MARGIN_WIDTH = 20;
	private static final int GRAPH_SEGMENTS = 100;
	
	private static Color graphColor = Color.red;
	private static double phaseShift = 0.0;
	private static int amplitude  = 100;
	private static int periods = 1;

	public SineGraphPanel() {

	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;

		int areaStartX  = MARGIN_WIDTH + 1;
		int areaEndX    = getWidth() - MARGIN_WIDTH - 1;
		int areaStartY  = MARGIN_WIDTH + 1;
		int areaEndY    = getHeight() - MARGIN_WIDTH - 1;
		int areaMiddleY = (areaStartY + areaEndY) / 2;
		
		drawGraphArea(g2d);
		
		double startX = 0.0;
		double endX = 2*Math.PI;
		double stepX = (endX - startX) / GRAPH_SEGMENTS;
		int lastX = areaStartX;
		int lastY = areaMiddleY;
		
		g2d.setColor(graphColor);
		for (double x = startX; x <= endX; x += stepX) {
			double amp = amplitude / 100.0;
			double y = Math.sin((x * periods) +
					phaseShift * 2.0 * Math.PI) * amp;
			int nextX = (int)(((x - startX) / stepX / GRAPH_SEGMENTS) * (areaEndX - areaStartX) + areaStartX);
			int nextY = (int)((-y * (areaMiddleY - areaStartY)) + areaMiddleY);
			g2d.drawLine(lastX, lastY, nextX, nextY);
			lastX = nextX;
			lastY = nextY;
		}
	}

	private void drawGraphArea(Graphics2D g2d) {
		g2d.setColor(Color.white);
		g2d.fillRect(MARGIN_WIDTH, MARGIN_WIDTH,
				getWidth() - MARGIN_WIDTH * 2,
				getHeight() - MARGIN_WIDTH * 2);
		g2d.setStroke(new BasicStroke(6));
		g2d.setColor(Color.black);
		g2d.drawRect(MARGIN_WIDTH, MARGIN_WIDTH,
				getWidth() - MARGIN_WIDTH * 2,
				getHeight() - MARGIN_WIDTH * 2);
	}

}
