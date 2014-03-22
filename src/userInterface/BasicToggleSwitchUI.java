/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package userInterface;

import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

public class BasicToggleSwitchUI extends ToggleSwitchUI implements
		MouseListener {

	// The toggle switch image was purchased for this project from Martin
	// Velchevski through
	// the GraphicalRiver market place and is used by permission. The image
	// 590preview.jpg
	// is a stock preview that came from the purchased package, which included a
	// PhotoShop
	// image in PSD format. I will probably re-scale this image to more cleanly
	// fit the UI
	// in the future.
	private static final String imagePath = "images/590preview.jpg";

	private static final int imageHeight = 590;
	private static final int imageWidth = 590;
	private static final int switchBottom = 388;
	private static final int switchClosedLeft = 308;
	private static final int switchClosedRight = 416;
	private static final int switchOpenLeft = 175;
	private static final int switchOpenRight = 284;
	private static final int switchTop = 202;

	public static ComponentUI createUI(JComponent component) {
		return new BasicToggleSwitchUI();
	}

	private BufferedImage toggleSwitches;

	public BasicToggleSwitchUI() {
		super();
		toggleSwitches = loadImage(imagePath);
	}

	@Override
	public void installUI(JComponent component) {
		ToggleSwitch toggleSwitch = (ToggleSwitch) component;
		toggleSwitch.addMouseListener(this);
	}

	private BufferedImage loadImage(String imagePath) {
		try {
			URL url = getClass().getResource(imagePath);
			if (url == null)
				return new BufferedImage(imageWidth, imageHeight,
						BufferedImage.TYPE_4BYTE_ABGR);
			return ImageIO.read(url);
		} catch (IOException ioException) {
			return new BufferedImage(imageWidth, imageHeight,
					BufferedImage.TYPE_4BYTE_ABGR);
		}
	}

	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
		ToggleSwitch toggleSwitch = (ToggleSwitch) mouseEvent.getComponent();
		if (toggleSwitch.isClosed())
			toggleSwitch.open();
		else
			toggleSwitch.close();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// DO NOTHING.
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// DO NOTHING.
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// DO NOTHING.
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// DO NOTHING.
	}

	@Override
	public void paint(Graphics graphics, JComponent component) {
		Insets insets = component.getInsets();
		graphics.translate(insets.left, insets.top);
		int width = component.getWidth() - insets.left - insets.right;
		int height = component.getHeight() - insets.top - insets.bottom;

		ToggleSwitch toggleSwitch = (ToggleSwitch) component;
		int left = toggleSwitch.isClosed() ? switchClosedLeft : switchOpenLeft;
		int right = toggleSwitch.isClosed() ? switchClosedRight
				: switchOpenRight;

		graphics.drawImage(toggleSwitches, 0, 0, width, height, left,
				switchTop, right, switchBottom, null);
	}

	@Override
	public void uninstallUI(JComponent component) {
		ToggleSwitch toggleSwitch = (ToggleSwitch) component;
		toggleSwitch.removeMouseListener(this);
	}
}
