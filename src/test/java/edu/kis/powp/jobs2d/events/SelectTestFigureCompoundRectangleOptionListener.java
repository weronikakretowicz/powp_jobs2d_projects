package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.command.factory.CompoundCommandRectangleFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestFigureCompoundRectangleOptionListener implements ActionListener {

    private final DriverManager driverManager;

    public SelectTestFigureCompoundRectangleOptionListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CompoundCommandRectangleFactory.getRectangleAction().execute(driverManager.getCurrentDriver());
    }
}