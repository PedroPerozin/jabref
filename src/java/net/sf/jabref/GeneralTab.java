
package net.sf.jabref;

import javax.swing.*;
import java.awt.*;

public class GeneralTab extends JPanel implements PrefsTab {

    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints con = new GridBagConstraints();
    private JCheckBox autoOpenForm, backup, openLast, 
	defSource, editSource;
    JabRefPreferences _prefs;

    public GeneralTab(JabRefPreferences prefs) {
	_prefs = prefs;

	setLayout(gbl);
	con.weightx = 0;
	con.insets = new Insets(10, 10, 10, 10);
	con.fill = GridBagConstraints.HORIZONTAL;
	con.gridwidth = GridBagConstraints.REMAINDER;
	autoOpenForm = new JCheckBox(Globals.lang("Open editor when a new entry is created"),
				     _prefs.getBoolean("autoOpenForm"));
	openLast = new JCheckBox(Globals.lang
				 ("Open last edited databases at startup"),_prefs.getBoolean("openLastEdited"));
	backup = new JCheckBox(Globals.lang("Backup old file when saving"),
			       _prefs.getBoolean("backup"));
	defSource = new JCheckBox(Globals.lang("Show source by default"),
				  _prefs.getBoolean("defaultShowSource"));
	editSource = new JCheckBox(Globals.lang("Enable source editing"),
				   _prefs.getBoolean("enableSourceEditing"));
	JPanel general = new JPanel();
	    
	general.setBorder(BorderFactory.createTitledBorder
			  (BorderFactory.createEtchedBorder(), 
			   Globals.lang("Miscellaneous")));
	general.setLayout(gbl);

	gbl.setConstraints(openLast, con);
	general.add(openLast);

	gbl.setConstraints(backup, con);
	general.add(backup);

	gbl.setConstraints(autoOpenForm, con);
	general.add(autoOpenForm);

	gbl.setConstraints(defSource, con);
	general.add(defSource);

	//gbl.setConstraints(editSource, con);
	//general.add(editSource);

	gbl.setConstraints(general, con);
	add(general);

    }

    public void storeSettings() {
	_prefs.putBoolean("autoOpenForm", autoOpenForm.isSelected());
	_prefs.putBoolean("backup", backup.isSelected());
	_prefs.putBoolean("openLastEdited", openLast.isSelected());
	_prefs.putBoolean("defaultShowSource", defSource.isSelected());
	_prefs.putBoolean("enableSourceEditing", editSource.isSelected());

    }
   
}
