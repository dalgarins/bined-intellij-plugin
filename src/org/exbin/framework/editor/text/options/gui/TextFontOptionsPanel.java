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
package org.exbin.framework.editor.text.options.gui;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.font.TextAttribute;
import java.util.Map;
import java.util.ResourceBundle;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.exbin.framework.editor.text.options.impl.TextFontOptionsImpl;
import org.exbin.framework.utils.LanguageUtils;
import org.exbin.framework.utils.WindowUtils;
import org.exbin.framework.options.api.OptionsCapable;
import org.exbin.framework.options.api.OptionsModifiedListener;
import org.exbin.framework.editor.text.service.TextFontService;

/**
 * Text font options panel.
 *
 * @author ExBin Project (https://exbin.org)
 */
@ParametersAreNonnullByDefault
public class TextFontOptionsPanel extends javax.swing.JPanel implements OptionsCapable<TextFontOptionsImpl> {

    private OptionsModifiedListener optionsModifiedListener;
    private FontChangeAction fontChangeAction;
    private final ResourceBundle resourceBundle = LanguageUtils.getResourceBundleByClass(TextFontOptionsPanel.class);
    private TextFontService textFontService;
    private Font codeFont;

    public TextFontOptionsPanel() {
        initComponents();
    }

    @Nonnull
    @Override
    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public void setTextFontService(TextFontService textFontService) {
        this.textFontService = textFontService;
    }

    @Override
    public void saveToOptions(TextFontOptionsImpl options) {
        options.setUseDefaultFont(defaultFontCheckBox.isSelected());
        options.setFontAttributes(codeFont != null ? (Map<TextAttribute, Object>) codeFont.getAttributes() : null);
    }

    @Override
    public void loadFromOptions(TextFontOptionsImpl options) {
        boolean useDefaultFont = options.isUseDefaultFont();
        defaultFontCheckBox.setSelected(useDefaultFont);
        setEnabled(!useDefaultFont);

        codeFont = textFontService == null ? options.getFont(new Font(Font.MONOSPACED, Font.PLAIN, 12)) : textFontService.getDefaultFont().deriveFont(options.getFontAttributes());
        updateFontFields();
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        fontPreviewLabel.setEnabled(enabled);
        fillDefaultFontButton.setEnabled(enabled && textFontService != null);
        fillCurrentFontButton.setEnabled(enabled && textFontService != null);
        changeFontButton.setEnabled(enabled);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        colorChooser = new javax.swing.JColorChooser();
        defaultFontCheckBox = new javax.swing.JCheckBox();
        fillDefaultFontButton = new javax.swing.JButton();
        changeFontButton = new javax.swing.JButton();
        fontPreviewLabel = new javax.swing.JLabel();
        fillCurrentFontButton = new javax.swing.JButton();
        fontTextField = new javax.swing.JTextField();

        colorChooser.setName("colorChooser"); // NOI18N

        setName("Form"); // NOI18N

        defaultFontCheckBox.setSelected(true);
        defaultFontCheckBox.setText(resourceBundle.getString("defaultFontCheckBox.text")); // NOI18N
        defaultFontCheckBox.setName("defaultFontCheckBox"); // NOI18N
        defaultFontCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                defaultFontCheckBoxItemStateChanged(evt);
            }
        });

        fillDefaultFontButton.setText(resourceBundle.getString("fillDefaultFontButton.text")); // NOI18N
        fillDefaultFontButton.setEnabled(false);
        fillDefaultFontButton.setName("fillDefaultFontButton"); // NOI18N
        fillDefaultFontButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillDefaultFontButtonActionPerformed(evt);
            }
        });

        changeFontButton.setText(resourceBundle.getString("changeFontButton.text")); // NOI18N
        changeFontButton.setEnabled(false);
        changeFontButton.setName("changeFontButton"); // NOI18N
        changeFontButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFontButtonActionPerformed(evt);
            }
        });

        fontPreviewLabel.setBackground(java.awt.Color.white);
        fontPreviewLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fontPreviewLabel.setText(resourceBundle.getString("fontPreviewLabel.text")); // NOI18N
        fontPreviewLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fontPreviewLabel.setEnabled(false);
        fontPreviewLabel.setName("fontPreviewLabel"); // NOI18N
        fontPreviewLabel.setOpaque(true);

        fillCurrentFontButton.setText(resourceBundle.getString("fillCurrentFontButton.text")); // NOI18N
        fillCurrentFontButton.setEnabled(false);
        fillCurrentFontButton.setName("fillCurrentFontButton"); // NOI18N
        fillCurrentFontButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillCurrentFontButtonActionPerformed(evt);
            }
        });

        fontTextField.setEditable(false);
        fontTextField.setName("fontTextField"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fontPreviewLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fontTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(defaultFontCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(changeFontButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fillDefaultFontButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fillCurrentFontButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(defaultFontCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fontTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fontPreviewLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeFontButton)
                    .addComponent(fillDefaultFontButton)
                    .addComponent(fillCurrentFontButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void defaultFontCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_defaultFontCheckBoxItemStateChanged
        boolean selected = evt.getStateChange() != ItemEvent.SELECTED;
        fontPreviewLabel.setEnabled(selected);
        fillDefaultFontButton.setEnabled(selected);
        fillCurrentFontButton.setEnabled(selected);
        changeFontButton.setEnabled(selected);
        setModified(true);
    }//GEN-LAST:event_defaultFontCheckBoxItemStateChanged

    private void fillDefaultFontButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillDefaultFontButtonActionPerformed
        codeFont = textFontService.getDefaultFont();
        updateFontFields();
        setModified(true);
    }//GEN-LAST:event_fillDefaultFontButtonActionPerformed

    private void changeFontButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFontButtonActionPerformed
        if (fontChangeAction != null) {
            Font resultFont = fontChangeAction.changeFont(fontPreviewLabel.getFont());
            if (resultFont != null) {
                codeFont = resultFont;
                updateFontFields();
                setModified(true);
            }
        }
    }//GEN-LAST:event_changeFontButtonActionPerformed

    private void fillCurrentFontButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillCurrentFontButtonActionPerformed
        codeFont = textFontService.getCurrentFont();
        updateFontFields();
        setModified(true);
    }//GEN-LAST:event_fillCurrentFontButtonActionPerformed

    /**
     * Test method for this panel.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WindowUtils.invokeDialog(new TextFontOptionsPanel());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeFontButton;
    private javax.swing.JColorChooser colorChooser;
    private javax.swing.JCheckBox defaultFontCheckBox;
    private javax.swing.JButton fillCurrentFontButton;
    private javax.swing.JButton fillDefaultFontButton;
    private javax.swing.JLabel fontPreviewLabel;
    private javax.swing.JTextField fontTextField;
    // End of variables declaration//GEN-END:variables

    private void updateFontFields() {
        int fontStyle = codeFont.getStyle();
        String fontStyleName;
        if ((fontStyle & (Font.BOLD + Font.ITALIC)) == Font.BOLD + Font.ITALIC) {
            fontStyleName = "Bold Italic";
        } else if ((fontStyle & Font.BOLD) > 0) {
            fontStyleName = "Bold";
        } else if ((fontStyle & Font.ITALIC) > 0) {
            fontStyleName = "Italic";
        } else {
            fontStyleName = "Plain";
        }
        fontTextField.setText(codeFont.getFamily() + " " + String.valueOf(codeFont.getSize()) + " " + fontStyleName);
        fontPreviewLabel.setFont(codeFont);
    }

    private void setModified(boolean b) {
        if (optionsModifiedListener != null) {
            optionsModifiedListener.wasModified();
        }
    }

    @Override
    public void setOptionsModifiedListener(OptionsModifiedListener listener) {
        optionsModifiedListener = listener;
    }

    public void setFontChangeAction(FontChangeAction fontChangeAction) {
        this.fontChangeAction = fontChangeAction;
    }

    @ParametersAreNonnullByDefault
    public static interface FontChangeAction {

        @Nullable
        Font changeFont(Font currentFont);
    }
}
