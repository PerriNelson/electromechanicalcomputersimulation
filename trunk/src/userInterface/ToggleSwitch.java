/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package userInterface;

import java.awt.Cursor;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.UIManager;

import userInterface.Interfaces.ISwitchModel;
import userInterface.Interfaces.PowerState;

public class ToggleSwitch extends JComponent implements PropertyChangeListener {
	private static final long serialVersionUID = 1L;
	private static final String closedPropertyName = "closed";
	private static final String modelPropertyName = "model";
	private static final String powerOutPropertyName = "powerOut";
	private static final Dimension size = new Dimension(54, 93);

	private ISwitchModel model;

	public ToggleSwitch() {
		super();
		setSize(size.width, size.height);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		init(new SwitchModel());
	}

	public void close() {
		model.setClosed(true);
	}

	@Override
	public Dimension getMaximumSize() {
		return getPreferredSize();
	}

	@Override
	public Dimension getMinimumSize() {
		return getPreferredSize();
	}

	public ISwitchModel getModel() {
		return model;
	}

	public PowerState getPowerOut() {
		return model.getPowerOut();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(getWidth(), getHeight());
	}

	@Override
	public String getUIClassID() {
		return ToggleSwitchUI.UI_CLASS_ID;
	}

	private void init(ISwitchModel newModel) {
		setModel(newModel);
		updateUI();
	}

	public boolean isClosed() {
		return model.isClosed();
	}

	public void open() {
		model.setClosed(false);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource() == model) {
			if (closedPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				firePropertyChange(closedPropertyName, evt.getOldValue(),
						evt.getNewValue());
				repaint();
			} else if (powerOutPropertyName.equalsIgnoreCase(evt
					.getPropertyName())) {
				firePropertyChange(powerOutPropertyName, evt.getOldValue(),
						evt.getNewValue());
			}
		}
	}

	public void setModel(ISwitchModel newModel) {
		ISwitchModel oldModel = model;
		if (oldModel != newModel) {

			if (oldModel != null) {
				oldModel.removePropertyChangeListener(this);
			}

			if (newModel == null) {
				model = new SwitchModel();
			} else {
				model = newModel;
			}

			model.addPropertyChangeListener(this);
			firePropertyChange(modelPropertyName, oldModel, model);
		}
	}

	public void setPowerIn(PowerState value) {
		model.setPowerIn(value);
	}

	public void setUI(ToggleSwitchUI ui) {
		super.setUI(ui);
	}

	@Override
	public void updateUI() {
		if (UIManager.get(getUIClassID()) != null) {
			setUI((ToggleSwitchUI) UIManager.getUI(this));
		} else {
			setUI(new BasicToggleSwitchUI());
		}
		invalidate();
	}
}
