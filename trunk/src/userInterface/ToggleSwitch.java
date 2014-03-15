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

import userInterface.Interfaces.ISwitchModel;

public class ToggleSwitch extends JComponent implements PropertyChangeListener {
	private static final long serialVersionUID = 1L;

	private ISwitchModel model;

	private static final Dimension size = new Dimension(34, 56);

	public ToggleSwitch() {
		super();
		setSize(size.width, size.height);
		init(new SwitchModel());
	}

	public void close() {
		if (!isClosed()) {
			model.setClosed(true);
			firePropertyChange("closed", false, true);
		}
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
		if (isClosed()) {
			model.setClosed(false);
			firePropertyChange("closed", true, false);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		repaint();
	}

	public void setModel(ISwitchModel value) {
		ISwitchModel oldModel = model;

		if (oldModel != null)
			oldModel.removePropertyChangeListener(this);

		if (value == null)
			model = new SwitchModel();
		else
			model = value;
		model.addPropertyChangeListener(this);
		firePropertyChange("model", oldModel, model);
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