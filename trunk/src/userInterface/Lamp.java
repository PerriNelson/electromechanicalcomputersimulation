/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package userInterface;

import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.UIManager;

import userInterface.Interfaces.ILampModel;

public class Lamp extends JComponent implements PropertyChangeListener {
	private static final long serialVersionUID = 1L;

	private ILampModel model;

	private static final Dimension size = new Dimension(45, 45);

	public Lamp() {
		super();
		setSize(size.width, size.height);
		init(new LampModel());
	}

	@Override
	public Dimension getMaximumSize() {
		return getPreferredSize();
	}

	@Override
	public Dimension getMinimumSize() {
		return getPreferredSize();
	}

	public ILampModel getModel() {
		return model;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(getWidth(), getHeight());
	}

	@Override
	public String getUIClassID() {
		return LampUI.UI_CLASS_ID;
	}

	private void init(ILampModel newModel) {
		setModel(newModel);
		updateUI();
	}

	public boolean isOn() {
		return model.isOn();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		repaint();
	}

	public void setModel(ILampModel value) {
		ILampModel oldModel = model;

		if (oldModel != null)
			oldModel.removePropertyChangeListener(this);

		if (value == null)
			model = new LampModel();
		else
			model = value;
		model.addPropertyChangeListener(this);
		firePropertyChange("model", oldModel, model);
	}

	public void setOn(boolean value) {
		if (isOn() != value) {
			model.setOn(value);
			firePropertyChange("on", !value, value);
		}
	}

	public void setUI(LampUI ui) {
		super.setUI(ui);
	}

	@Override
	public void updateUI() {
		if (UIManager.get(getUIClassID()) != null) {
			setUI((LampUI) UIManager.getUI(this));
		} else {
			setUI(new BasicLampUI());
		}
		invalidate();
	}
}
