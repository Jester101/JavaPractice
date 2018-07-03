package Meny.controller;

import Meny.MainFrame.Panels.EditPanel;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChangeListener implements ItemListener {

    private  EditPanel panel;
    public ChangeListener(EditPanel panel){
        this.panel = panel;
    }
    @Override
    public void itemStateChanged(ItemEvent event) {
        JComboBox cb = (JComboBox) event.getSource();

        Object item = event.getItem();
        if(event.getStateChange() == ItemEvent.SELECTED)
            panel.updateBox();
    }
}
