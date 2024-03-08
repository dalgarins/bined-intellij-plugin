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
package org.exbin.framework.bined.operation.component.gui;

import java.util.ResourceBundle;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import org.exbin.auxiliary.binary_data.EditableBinaryData;
import org.exbin.bined.CodeAreaUtils;
import org.exbin.framework.bined.operation.component.SimpleFillDataMethod;
import org.exbin.framework.utils.LanguageUtils;
import org.exbin.framework.utils.WindowUtils;

/**
 * Fill simple data component panel.
 *
 * @author ExBin Project (https://exbin.org)
 */
@ParametersAreNonnullByDefault
public class SimpleFillDataPanel extends javax.swing.JPanel {

    private final java.util.ResourceBundle resourceBundle = LanguageUtils.getResourceBundleByClass(SimpleFillDataPanel.class);

    private Controller controller;
    private EditableBinaryData sampleBinaryData;
    private ModeChangeListener modeChangeListener = null;

    public SimpleFillDataPanel() {
        initComponents();
    }

    @Nonnull
    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fillWithbuttonGroup = new javax.swing.ButtonGroup();
        lengthLabel = new javax.swing.JLabel();
        lengthBaseSwitchableSpinnerPanel = new org.exbin.framework.bined.gui.BaseSwitchableSpinnerPanel();
        fillWithLabel = new javax.swing.JLabel();
        emptyRadioButton = new javax.swing.JRadioButton();
        spaceRadioButton = new javax.swing.JRadioButton();
        sampleRadioButton = new javax.swing.JRadioButton();
        sampleDataButton = new javax.swing.JButton();

        lengthLabel.setText(resourceBundle.getString("lengthLabel.text")); // NOI18N

        lengthBaseSwitchableSpinnerPanel.setValue(10L);
        lengthBaseSwitchableSpinnerPanel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                lengthBaseSwitchableSpinnerPanelStateChanged(evt);
            }
        });

        fillWithLabel.setText(resourceBundle.getString("fillWithLabel.text")); // NOI18N

        fillWithbuttonGroup.add(emptyRadioButton);
        emptyRadioButton.setSelected(true);
        emptyRadioButton.setText(resourceBundle.getString("emptyRadioButton.text")); // NOI18N
        emptyRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                emptyRadioButtonItemStateChanged(evt);
            }
        });

        fillWithbuttonGroup.add(spaceRadioButton);
        spaceRadioButton.setText(resourceBundle.getString("spaceRadioButton.text")); // NOI18N
        spaceRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                spaceRadioButtonItemStateChanged(evt);
            }
        });

        fillWithbuttonGroup.add(sampleRadioButton);
        sampleRadioButton.setText(resourceBundle.getString("sampleRadioButton.text")); // NOI18N
        sampleRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sampleRadioButtonItemStateChanged(evt);
            }
        });

        sampleDataButton.setText(resourceBundle.getString("sampleDataButton.text")); // NOI18N
        sampleDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sampleDataButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(sampleDataButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lengthBaseSwitchableSpinnerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                            .addComponent(emptyRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lengthLabel)
                                    .addComponent(fillWithLabel))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(sampleRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spaceRadioButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lengthLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lengthBaseSwitchableSpinnerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fillWithLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emptyRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spaceRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sampleRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sampleDataButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sampleDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sampleDataButtonActionPerformed
        if (controller != null) {
            controller.sampleDataAction();
            modeChanged();
        }
    }//GEN-LAST:event_sampleDataButtonActionPerformed

    private void emptyRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_emptyRadioButtonItemStateChanged
        modeChanged();
    }//GEN-LAST:event_emptyRadioButtonItemStateChanged

    private void spaceRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_spaceRadioButtonItemStateChanged
        modeChanged();
    }//GEN-LAST:event_spaceRadioButtonItemStateChanged

    private void sampleRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sampleRadioButtonItemStateChanged
        modeChanged();
    }//GEN-LAST:event_sampleRadioButtonItemStateChanged

    private void lengthBaseSwitchableSpinnerPanelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_lengthBaseSwitchableSpinnerPanelStateChanged
        modeChanged();
    }//GEN-LAST:event_lengthBaseSwitchableSpinnerPanelStateChanged

    private void modeChanged() {
        if (modeChangeListener != null) {
            modeChangeListener.modeChanged();
        }
    }

    @Nonnull
    public SimpleFillDataMethod.FillWithType getFillWithType() {
        if (sampleRadioButton.isSelected()) {
            return SimpleFillDataMethod.FillWithType.SAMPLE;
        } else if (spaceRadioButton.isSelected()) {
            return SimpleFillDataMethod.FillWithType.SPACE;
        }

        return SimpleFillDataMethod.FillWithType.EMPTY;
    }

    public void setFillWith(SimpleFillDataMethod.FillWithType fillWithType) {
        switch (fillWithType) {
            case EMPTY: {
                emptyRadioButton.setSelected(true);
                break;
            }
            case SPACE: {
                spaceRadioButton.setSelected(true);
                break;
            }
            case SAMPLE: {
                sampleRadioButton.setSelected(true);
                break;
            }
            default:
                throw CodeAreaUtils.getInvalidTypeException(fillWithType);
        }
    }

    public long getDataLength() {
        return lengthBaseSwitchableSpinnerPanel.getValue();
    }

    public void setDataLength(long dataLength) {
        lengthBaseSwitchableSpinnerPanel.setValue(dataLength);
    }

    public void setModeChangeListener(ModeChangeListener modeChangeListener) {
        this.modeChangeListener = modeChangeListener;
    }

    public void initFocus() {
        lengthBaseSwitchableSpinnerPanel.initFocus();
    }

    public void acceptInput() {
        lengthBaseSwitchableSpinnerPanel.acceptInput();
    }

    @Nonnull
    public EditableBinaryData getSampleBinaryData() {
        return sampleBinaryData;
    }

    public void setSampleBinaryData(EditableBinaryData sampleBinaryData) {
        this.sampleBinaryData = sampleBinaryData;
    }

    /**
     * Test method for this panel.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WindowUtils.invokeDialog(new SimpleFillDataPanel());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton emptyRadioButton;
    private javax.swing.JLabel fillWithLabel;
    private javax.swing.ButtonGroup fillWithbuttonGroup;
    private org.exbin.framework.bined.gui.BaseSwitchableSpinnerPanel lengthBaseSwitchableSpinnerPanel;
    private javax.swing.JLabel lengthLabel;
    private javax.swing.JButton sampleDataButton;
    private javax.swing.JRadioButton sampleRadioButton;
    private javax.swing.JRadioButton spaceRadioButton;
    // End of variables declaration//GEN-END:variables

    public interface Controller {

        void sampleDataAction();
    }

    public interface ModeChangeListener {

        void modeChanged();
    }
}