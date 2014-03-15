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

	public static ComponentUI createUI(JComponent component) {
		return new BasicToggleSwitchUI();
	}

	private BufferedImage closedImage;

	private BufferedImage openImage;

	public BasicToggleSwitchUI() {
		super();
		closedImage = loadImage("images/switchUp.jpg");
		openImage = loadImage("images/switchDown.jpg");
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
				return new BufferedImage(34, 56, BufferedImage.TYPE_4BYTE_ABGR);
			return ImageIO.read(url);
		} catch (IOException ioException) {
			return new BufferedImage(34, 56, BufferedImage.TYPE_4BYTE_ABGR);
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
		BufferedImage image = toggleSwitch.isClosed() ? closedImage : openImage;

		graphics.drawImage(image, 0, 0, width, height, 0, 0, image.getWidth(),
				image.getHeight(), null);
	}

	@Override
	public void uninstallUI(JComponent component) {
		ToggleSwitch toggleSwitch = (ToggleSwitch) component;
		toggleSwitch.removeMouseListener(this);
	}
}
