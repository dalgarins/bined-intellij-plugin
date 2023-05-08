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
package org.exbin.framework.about.gui;

import org.exbin.framework.utils.DesktopUtils;
import org.exbin.framework.utils.LanguageUtils;
import org.exbin.framework.utils.UiUtils;
import org.exbin.framework.utils.WindowUtils;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * About application panel.
 *
 * @author ExBin Project (https://exbin.org)
 */
@ParametersAreNonnullByDefault
public class AboutPanel extends javax.swing.JPanel implements HyperlinkListener {

    private ResourceBundle appBundle;
    private final ResourceBundle resourceBundle = LanguageUtils.getResourceBundleByClass(AboutPanel.class);
    private JComponent sideComponent = null;
    private boolean darkMode = false;

    public AboutPanel() {
        initComponents();
        init();
    }

    private void init() {
        initComponents();
        darkMode = UiUtils.isDarkUI();
        if (darkMode) {
            aboutHeaderPanel.setBackground(Color.BLACK);
            appTitleLabel.setForeground(Color.WHITE);
            appDescLabel.setForeground(Color.WHITE);
        }

        HashMap<TextAttribute, Object> attribs = new HashMap<>();
        attribs.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_ONE_PIXEL);

        // Fill system properties tab
        environmentTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    resourceBundle.getString("environmentTable.propertyColumn"), resourceBundle.getString("environmentTable.valueColumn")
                }
        ) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });

        Properties systemProperties = System.getProperties();
        DefaultTableModel tableModel = (DefaultTableModel) environmentTable.getModel();
        Set<java.util.Map.Entry<Object, Object>> items = systemProperties.entrySet();
        for (java.util.Map.Entry<Object, Object> entry : items) {
            Object[] line = new Object[2];
            line[0] = entry.getKey();
            line[1] = entry.getValue();
            tableModel.addRow(line);
        }
    }

    /**
     * Opens hyperlink in external browser.
     *
     * @param event hyperlink event
     */
    @Override
    public void hyperlinkUpdate(HyperlinkEvent event) {
        if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            DesktopUtils.openDesktopURL(event.getURL().toExternalForm());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productTabbedPane = new javax.swing.JTabbedPane();
        applicationPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        versionLabel = new javax.swing.JLabel();
        versionTextField = new javax.swing.JTextField();
        vendorLabel = new javax.swing.JLabel();
        vendorTextField = new javax.swing.JTextField();
        appLicenseLabel = new javax.swing.JLabel();
        licenseTextField = new javax.swing.JTextField();
        homepageLabel = new javax.swing.JLabel();
        appHomepageLabel = new javax.swing.JLabel();
        authorsPanel = new javax.swing.JPanel();
        authorsScrollPane = new javax.swing.JScrollPane();
        authorsTextArea = new javax.swing.JTextArea();
        licensePanel = new javax.swing.JPanel();
        licenseScrollPane = new javax.swing.JScrollPane();
        licenseEditorPane = new javax.swing.JEditorPane();
        environmentPanel = new javax.swing.JPanel();
        environmentScrollPane = new javax.swing.JScrollPane();
        environmentTable = new javax.swing.JTable();
        aboutHeaderPanel = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        appTitleLabel = new javax.swing.JLabel();
        appDescLabel = new javax.swing.JLabel();
        headerSeparator = new javax.swing.JSeparator();

        setLayout(new java.awt.BorderLayout());

        productTabbedPane.setMinimumSize(new java.awt.Dimension(38, 15));

        applicationPanel.setAutoscrolls(true);

        nameLabel.setFont(nameLabel.getFont().deriveFont(nameLabel.getFont().getStyle() | java.awt.Font.BOLD));
        nameLabel.setText(resourceBundle.getString("nameLabel.text")); // NOI18N

        nameTextField.setEditable(false);
        nameTextField.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nameTextField.setBorder(null);

        versionLabel.setFont(versionLabel.getFont().deriveFont(versionLabel.getFont().getStyle() | java.awt.Font.BOLD));
        versionLabel.setText(resourceBundle.getString("versionLabel.text")); // NOI18N

        versionTextField.setEditable(false);
        versionTextField.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        versionTextField.setBorder(null);

        vendorLabel.setFont(vendorLabel.getFont().deriveFont(vendorLabel.getFont().getStyle() | java.awt.Font.BOLD));
        vendorLabel.setText(resourceBundle.getString("vendorLabel.text")); // NOI18N

        vendorTextField.setEditable(false);
        vendorTextField.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        vendorTextField.setBorder(null);

        appLicenseLabel.setFont(appLicenseLabel.getFont().deriveFont(appLicenseLabel.getFont().getStyle() | java.awt.Font.BOLD));
        appLicenseLabel.setText(resourceBundle.getString("appLicenseLabel.text")); // NOI18N

        licenseTextField.setEditable(false);
        licenseTextField.setFont(new java.awt.Font("Dialog 12", 1, 12)); // NOI18N
        licenseTextField.setBorder(null);

        homepageLabel.setFont(homepageLabel.getFont().deriveFont(homepageLabel.getFont().getStyle() | java.awt.Font.BOLD));
        homepageLabel.setText(resourceBundle.getString("homepageLabel.text")); // NOI18N

        appHomepageLabel.setForeground(java.awt.Color.blue);
        appHomepageLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HashMap<TextAttribute, Object> attribs = new HashMap<TextAttribute, Object>();
        attribs.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_ONE_PIXEL);
        appHomepageLabel.setFont(appHomepageLabel.getFont().deriveFont(attribs));
        appHomepageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appHomepageLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout applicationPanelLayout = new javax.swing.GroupLayout(applicationPanel);
        applicationPanel.setLayout(applicationPanelLayout);
        applicationPanelLayout.setHorizontalGroup(
            applicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(applicationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(applicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vendorLabel)
                    .addComponent(homepageLabel)
                    .addComponent(appLicenseLabel)
                    .addComponent(versionLabel)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(applicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(vendorTextField)
                    .addComponent(licenseTextField)
                    .addComponent(appHomepageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(versionTextField))
                .addContainerGap())
        );
        applicationPanelLayout.setVerticalGroup(
            applicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(applicationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(applicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(applicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(versionLabel)
                    .addComponent(versionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(applicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vendorLabel)
                    .addComponent(vendorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(applicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appLicenseLabel)
                    .addComponent(licenseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(applicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homepageLabel)
                    .addComponent(appHomepageLabel))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        productTabbedPane.addTab("Application", applicationPanel);

        authorsTextArea.setEditable(false);
        authorsScrollPane.setViewportView(authorsTextArea);

        javax.swing.GroupLayout authorsPanelLayout = new javax.swing.GroupLayout(authorsPanel);
        authorsPanel.setLayout(authorsPanelLayout);
        authorsPanelLayout.setHorizontalGroup(
            authorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(authorsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );
        authorsPanelLayout.setVerticalGroup(
            authorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(authorsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );

        productTabbedPane.addTab("Authors", authorsPanel);

        licenseEditorPane.setEditable(false);
        licenseEditorPane.setContentType("text/html"); // NOI18N
        licenseEditorPane.setText("<html>   <head>    </head>   <body>     <p style=\"margin-top: 0\"></p>   </body> </html> ");
        licenseScrollPane.setViewportView(licenseEditorPane);

        javax.swing.GroupLayout licensePanelLayout = new javax.swing.GroupLayout(licensePanel);
        licensePanel.setLayout(licensePanelLayout);
        licensePanelLayout.setHorizontalGroup(
            licensePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(licenseScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );
        licensePanelLayout.setVerticalGroup(
            licensePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(licenseScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );

        productTabbedPane.addTab("License", licensePanel);

        environmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Property", "Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        environmentScrollPane.setViewportView(environmentTable);

        javax.swing.GroupLayout environmentPanelLayout = new javax.swing.GroupLayout(environmentPanel);
        environmentPanel.setLayout(environmentPanelLayout);
        environmentPanelLayout.setHorizontalGroup(
            environmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(environmentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );
        environmentPanelLayout.setVerticalGroup(
            environmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(environmentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );

        productTabbedPane.addTab("Environment", environmentPanel);

        add(productTabbedPane, java.awt.BorderLayout.CENTER);

        aboutHeaderPanel.setBackground(new java.awt.Color(255, 255, 255));

        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        appTitleLabel.setFont(appTitleLabel.getFont().deriveFont(appTitleLabel.getFont().getStyle() | java.awt.Font.BOLD, appTitleLabel.getFont().getSize()+4));
        appTitleLabel.setForeground(java.awt.Color.black);
        appTitleLabel.setText("Application Title");

        appDescLabel.setForeground(java.awt.Color.black);
        appDescLabel.setText("Description");

        javax.swing.GroupLayout aboutHeaderPanelLayout = new javax.swing.GroupLayout(aboutHeaderPanel);
        aboutHeaderPanel.setLayout(aboutHeaderPanelLayout);
        aboutHeaderPanelLayout.setHorizontalGroup(
            aboutHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutHeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel)
                .addGap(18, 18, 18)
                .addGroup(aboutHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appDescLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(appTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(headerSeparator)
        );
        aboutHeaderPanelLayout.setVerticalGroup(
            aboutHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutHeaderPanelLayout.createSequentialGroup()
                .addGroup(aboutHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aboutHeaderPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(appTitleLabel)
                        .addGap(7, 7, 7)
                        .addComponent(appDescLabel))
                    .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(headerSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(aboutHeaderPanel, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void appHomepageLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appHomepageLabelMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1 && !evt.isPopupTrigger()) {
            String targetURL = ((JLabel) evt.getSource()).getText();
            DesktopUtils.openDesktopURL(targetURL);
        }
    }//GEN-LAST:event_appHomepageLabelMouseClicked

    /**
     * Test method for this panel.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WindowUtils.invokeDialog(new AboutPanel());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aboutHeaderPanel;
    private javax.swing.JLabel appDescLabel;
    private javax.swing.JLabel appHomepageLabel;
    private javax.swing.JLabel appLicenseLabel;
    private javax.swing.JLabel appTitleLabel;
    private javax.swing.JPanel applicationPanel;
    private javax.swing.JPanel authorsPanel;
    private javax.swing.JScrollPane authorsScrollPane;
    private javax.swing.JTextArea authorsTextArea;
    private javax.swing.JPanel environmentPanel;
    private javax.swing.JScrollPane environmentScrollPane;
    private javax.swing.JTable environmentTable;
    private javax.swing.JSeparator headerSeparator;
    private javax.swing.JLabel homepageLabel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JEditorPane licenseEditorPane;
    private javax.swing.JPanel licensePanel;
    private javax.swing.JScrollPane licenseScrollPane;
    private javax.swing.JTextField licenseTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTabbedPane productTabbedPane;
    private javax.swing.JLabel vendorLabel;
    private javax.swing.JTextField vendorTextField;
    private javax.swing.JLabel versionLabel;
    private javax.swing.JTextField versionTextField;
    // End of variables declaration//GEN-END:variables

    public void setSideComponent(JComponent sideComponent) {
        if (this.sideComponent != null) {
            remove(this.sideComponent);
        }

        if (sideComponent != null) {
            add(sideComponent, BorderLayout.WEST);
            this.sideComponent = sideComponent;
        }
    }

    public void setupFields() {
        appBundle = ResourceBundle.getBundle("org.exbin.bined.intellij.resources.Bundle");

        // Load license
        try {
            String licenseFilePath = appBundle.getString("Application.licenseFile");
            if (licenseFilePath != null && !licenseFilePath.isEmpty()) {
                licenseEditorPane.setPage(getClass().getResource(licenseFilePath));
            }
            licenseEditorPane.addHyperlinkListener(this);
        } catch (IOException ex) {
            Logger.getLogger(AboutPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        nameTextField.setText(appBundle.getString("Application.name"));
        versionTextField.setText(appBundle.getString("Application.version"));
        vendorTextField.setText(appBundle.getString("Application.vendor"));
        licenseTextField.setText(appBundle.getString("Application.license"));
        appHomepageLabel.setText(appBundle.getString("Application.homepage"));
        authorsTextArea.setText(appBundle.getString("Application.authors"));
        String aboutImagePath = appBundle.getString("Application.aboutImage");
        if (aboutImagePath != null) {
            imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(appBundle.getString("Application.aboutImage"))));
        }
        appTitleLabel.setText(appBundle.getString("Application.title"));
        appDescLabel.setText(appBundle.getString("Application.description"));
    }
}
