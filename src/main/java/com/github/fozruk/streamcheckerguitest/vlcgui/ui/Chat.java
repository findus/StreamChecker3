package com.github.fozruk.streamcheckerguitest.vlcgui.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Philipp on 18.08.2015.
 */
public class Chat extends JList implements Scrollable {

    public Chat(DefaultListModel model)
    {
        super(model);

    }

    public Dimension getPreferredScrollableViewportSize() {
        return getPreferredSize();
    }

    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 10;
    }

    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return ((orientation == SwingConstants.VERTICAL) ? visibleRect.height : visibleRect.width) - 10;
    }

    public boolean getScrollableTracksViewportWidth() {
        return true;
    }

    public boolean getScrollableTracksViewportHeight() {
        return false;
    }

    @Override
    public void updateUI() {
        super.updateUI();
    }


}
