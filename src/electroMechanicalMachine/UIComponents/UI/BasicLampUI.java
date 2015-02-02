/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.UIComponents.UI;

import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

import electroMechanicalMachine.UIComponents.Lamp;

public class BasicLampUI extends ToggleSwitchUI {

	public static ComponentUI createUI(final JComponent component) {
		return new BasicLampUI();
	}

	private final BufferedImage offImage;

	private final BufferedImage onImage;

	public BasicLampUI() {
		super();
		offImage = loadImage("images/LampOff.jpg");
		onImage = loadImage("images/LampOn.jpg");
	}

	@Override
	public void paint(final Graphics graphics, final JComponent component) {
		final Insets insets = component.getInsets();
		graphics.translate(insets.left, insets.top);
		final int width = component.getWidth() - insets.left - insets.right;
		final int height = component.getHeight() - insets.top - insets.bottom;

		final Lamp lamp = (Lamp) component;
		final BufferedImage image = lamp.isOn() ? onImage : offImage;

		graphics.drawImage(image, 0, 0, width, height, 0, 0, image.getWidth(),
				image.getHeight(), null);
	}

	private BufferedImage loadImage(final String imagePath) {
		try {
			final URL url = getClass().getResource(imagePath);
			if (url == null) {
				return new BufferedImage(34, 56, BufferedImage.TYPE_4BYTE_ABGR);
			}
			return ImageIO.read(url);
		} catch (final IOException ioException) {
			return new BufferedImage(34, 56, BufferedImage.TYPE_4BYTE_ABGR);
		}
	}
}
