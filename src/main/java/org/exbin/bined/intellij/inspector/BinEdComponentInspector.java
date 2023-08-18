/*
 * Copyright (C) ExBin Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.exbin.bined.intellij.inspector;

import com.intellij.ui.components.JBScrollPane;
import org.exbin.bined.intellij.gui.BinEdComponentPanel;
import org.exbin.bined.swing.extended.ExtCodeArea;
import org.exbin.framework.bined.inspector.BasicValuesPositionColorModifier;
import org.exbin.framework.bined.inspector.gui.BasicValuesPanel;

import javax.annotation.ParametersAreNonnullByDefault;
import java.awt.BorderLayout;

/**
 * BinEd component data inspector.
 *
 * @author ExBin Project (https://exbin.org)
 */
@ParametersAreNonnullByDefault
public class BinEdComponentInspector implements BinEdComponentPanel.BinEdComponentExtension {

    private BinEdComponentPanel componentPanel;
    private BasicValuesPanel valuesPanel;
    private boolean parsingPanelVisible = false;

    private JBScrollPane valuesPanelScrollPane;
    private BasicValuesPositionColorModifier basicValuesColorModifier;

    @Override
    public void onCreate(BinEdComponentPanel componentPanel) {
        this.componentPanel = componentPanel;
        ExtCodeArea codeArea = componentPanel.getCodeArea();

        valuesPanel = new BasicValuesPanel();
        valuesPanel.setCodeArea(codeArea, null);
        if (basicValuesColorModifier != null) {
            valuesPanel.registerFocusPainter(basicValuesColorModifier);
        }

        valuesPanelScrollPane = new JBScrollPane(valuesPanel);
        valuesPanelScrollPane.setBorder(null);
        setShowParsingPanel(true);
    }

    @Override
    public void onDataChange() {
    }

    @Override
    public void onUndoHandlerChange() {
        if (valuesPanel != null) {
            valuesPanel.setCodeArea(componentPanel.getCodeArea(), componentPanel.getUndoHandler());
        }
    }

    @Override
    public void onClose() {
    }

    public void setShowParsingPanel(boolean show) {
        if (parsingPanelVisible != show) {
            if (show) {
                componentPanel.add(valuesPanelScrollPane, BorderLayout.EAST);
                componentPanel.revalidate();
                parsingPanelVisible = true;
                valuesPanel.enableUpdate();
            } else {
                valuesPanel.disableUpdate();
                componentPanel.remove(valuesPanelScrollPane);
                componentPanel.revalidate();
                parsingPanelVisible = false;
            }
        }
    }

    public boolean isShowParsingPanel() {
        return parsingPanelVisible;
    }

    public void setBasicValuesColorModifier(BasicValuesPositionColorModifier basicValuesColorModifier) {
        this.basicValuesColorModifier = basicValuesColorModifier;
    }
}
