package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DriverFeature;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClickConverter implements MouseListener {
    private final int MOUSE_BUTTON_LEFT = 1;
    private final int MOUSE_BUTTON_RIGHT = 3;
    private final int TIMER_DELAY = 10; // Milliseconds

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private final JPanel panel;
    private final Timer followCursorTimer;
    private final Job2dDriver driver;
    private boolean isFollowingCursor = false;
    private boolean leftButtonFirstClick = true;

    public MouseClickConverter(JPanel panel) {
        this.panel = panel;
        this.panel.addMouseListener(this);
        this.followCursorTimer = new Timer(TIMER_DELAY, new FollowCursorActionListener());
        this.driver = DriverFeature.getDriverManager().getCurrentDriver();
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        Point position = getClickPosition(event);

        int buttonPressed = event.getButton();

        if (buttonPressed == MOUSE_BUTTON_LEFT) {
            handleLeftClick(position);
        } else if (buttonPressed == MOUSE_BUTTON_RIGHT) {
            handleRightClick(position);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Not used in this example
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Not used in this example
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (isFollowingCursor && !leftButtonFirstClick) {
            followCursorTimer.start();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Not used in this example
    }

    private Point getClickPosition(MouseEvent event) {
        int x = event.getX();
        int y = event.getY();

        int offsetX = panel.getWidth() / 2;
        int offsetY = panel.getHeight() / 2;

        return new Point(x - offsetX, y - offsetY);
    }

    private void handleLeftClick(Point position) {
        if (leftButtonFirstClick) {
            driver.setPosition(position.x, position.y);
            leftButtonFirstClick = false;
        } else {
            driver.operateTo(position.x, position.y);
            leftButtonFirstClick = true;
        }
    }

    private void handleRightClick(Point position) {
        if (!isFollowingCursor) {
            driver.setPosition(position.x, position.y);
            followCursorTimer.start();
            isFollowingCursor = true;
        } else {
            followCursorTimer.stop();
            isFollowingCursor = false;
        }
    }

    private void updateDriverPosition() {
        Point mousePosition = getMousePositionOnPanel();
        if (mousePosition != null) {
            driver.operateTo(mousePosition.x, mousePosition.y);
        }
    }

    private Point getMousePositionOnPanel() {
        Point mousePosition = null;
        java.awt.Point mousePanelPosition = panel.getMousePosition();
        if (mousePanelPosition != null && panel.contains(mousePanelPosition)) {
            int mouseX = mousePanelPosition.x;
            int mouseY = mousePanelPosition.y;

            int offsetX = panel.getWidth() / 2;
            int offsetY = panel.getHeight() / 2;

            mousePosition = new Point(mouseX - offsetX, mouseY - offsetY);
        }
        return mousePosition;
    }

    private class FollowCursorActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateDriverPosition();
        }
    }
}