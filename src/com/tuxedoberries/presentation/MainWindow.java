/*
 * Copyright (C) 2016 Juan Silva <juanssl@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.tuxedoberries.presentation;

import com.tuxedoberries.androidhelper.DeviceInformationProcessController;
import com.tuxedoberries.androidhelper.LogcatProcessController;
import com.tuxedoberries.androidhelper.ScreenRecordProcessController;
import com.tuxedoberries.configuration.ADBCommands;
import com.tuxedoberries.configuration.ADBConfiguration;
import com.tuxedoberries.mainloop.IUpdate;
import com.tuxedoberries.mainloop.MainLoop;
import com.tuxedoberries.process.interfaces.IProcessStartListener;
import com.tuxedoberries.process.interfaces.IProcessStopListener;
import com.tuxedoberries.utils.TextToNumberHelper;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Juan Silva
 */
public class MainWindow extends javax.swing.JFrame implements IProcessStartListener, IProcessStopListener, IUpdate {
    
    private final LogcatProcessController logcatProcess;
    private final ScreenRecordProcessController screenRecord;
    private final DeviceInformationProcessController infoProcess;
    private long startedMilis;
    private boolean screenRunning = false;
    
    /**
     * Creates new form MainWindows
     */
    public MainWindow() {
        logcatProcess = new LogcatProcessController();
        screenRecord = new ScreenRecordProcessController();
        infoProcess = new DeviceInformationProcessController();
        
        initComponents();
        ADBConfiguration.loadConfiguration();
        updateADBView();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        adbPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        adbTextField = new javax.swing.JTextField();
        adbChoosePath = new javax.swing.JButton();
        adbSaveConfig = new javax.swing.JButton();
        screenRecordPanel = new javax.swing.JPanel();
        recordTimeSlider = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        recordTimeTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logPanel = new javax.swing.JPanel();
        deviceLogCheckBox = new javax.swing.JCheckBox();
        screenRecordCheckBox = new javax.swing.JCheckBox();
        showWindowCheckBox = new javax.swing.JCheckBox();
        startLogButton = new javax.swing.JButton();
        deviceInfoCheckBox = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        processStateLabel = new javax.swing.JLabel();
        screenRecordProgress = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        adbPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Android Debug Bridge"));

        jLabel1.setText("ADB Path:");

        adbTextField.setText("adb");
        adbTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adbTextFieldActionPerformed(evt);
            }
        });

        adbChoosePath.setText("Choose");
        adbChoosePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adbChoosePathActionPerformed(evt);
            }
        });

        adbSaveConfig.setText("Save");
        adbSaveConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adbSaveConfigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adbPanelLayout = new javax.swing.GroupLayout(adbPanel);
        adbPanel.setLayout(adbPanelLayout);
        adbPanelLayout.setHorizontalGroup(
            adbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adbPanelLayout.createSequentialGroup()
                .addGroup(adbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adbPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1))
                    .addComponent(adbChoosePath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adbPanelLayout.createSequentialGroup()
                        .addComponent(adbSaveConfig)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(adbTextField))
                .addContainerGap())
        );
        adbPanelLayout.setVerticalGroup(
            adbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adbPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(adbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(adbTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adbChoosePath)
                    .addComponent(adbSaveConfig)))
        );

        screenRecordPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Screen Record"));

        recordTimeSlider.setMaximum(180);
        recordTimeSlider.setValue(180);
        recordTimeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                recordTimeSliderStateChanged(evt);
            }
        });

        jLabel3.setText("Time per video [0 - 180 Seconds]");

        recordTimeTextField.setText("180");
        recordTimeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordTimeTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Value:");

        jLabel2.setText("<html>If the session last for more than the time<br>set here, another video will be recorder</html>");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout screenRecordPanelLayout = new javax.swing.GroupLayout(screenRecordPanel);
        screenRecordPanel.setLayout(screenRecordPanelLayout);
        screenRecordPanelLayout.setHorizontalGroup(
            screenRecordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(screenRecordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(screenRecordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(recordTimeSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(screenRecordPanelLayout.createSequentialGroup()
                        .addGroup(screenRecordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(screenRecordPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(recordTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        screenRecordPanelLayout.setVerticalGroup(
            screenRecordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, screenRecordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(screenRecordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(recordTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recordTimeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        logPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("General"));

        deviceLogCheckBox.setSelected(true);
        deviceLogCheckBox.setText("Enable Device Log");
        deviceLogCheckBox.setToolTipText("Record the log from the device.");

        screenRecordCheckBox.setSelected(true);
        screenRecordCheckBox.setText("Enable Screen Record");
        screenRecordCheckBox.setToolTipText("Record the display of the device while testing. Set the time limit of the record from 0 to 180 seconds.");

        showWindowCheckBox.setSelected(true);
        showWindowCheckBox.setText("Show Window");
        showWindowCheckBox.setToolTipText("Show the windows of each process.");
        showWindowCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showWindowCheckBoxActionPerformed(evt);
            }
        });

        startLogButton.setText("Start");
        startLogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startLogButtonActionPerformed(evt);
            }
        });

        deviceInfoCheckBox.setSelected(true);
        deviceInfoCheckBox.setText("Enable Device Info");
        deviceInfoCheckBox.setToolTipText("Gather the general information of the device.");

        javax.swing.GroupLayout logPanelLayout = new javax.swing.GroupLayout(logPanel);
        logPanel.setLayout(logPanelLayout);
        logPanelLayout.setHorizontalGroup(
            logPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(startLogButton))
            .addGroup(logPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(logPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(screenRecordCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showWindowCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deviceInfoCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deviceLogCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logPanelLayout.setVerticalGroup(
            logPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logPanelLayout.createSequentialGroup()
                .addComponent(deviceLogCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(screenRecordCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deviceInfoCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showWindowCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(startLogButton))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Running State"));

        processStateLabel.setText("Stopped");

        screenRecordProgress.setMaximum(180);

        jLabel5.setText("Screen Recording");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(processStateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(screenRecordProgress, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(processStateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(screenRecordProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adbPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(screenRecordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adbPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(screenRecordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startLogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startLogButtonActionPerformed
        if(!areProcessRunning()) {
            startProcesses ();
        }else{
            stopProcesses ();
        }
    }//GEN-LAST:event_startLogButtonActionPerformed

    private void startProcesses () {
        // Update Text
        processStateLabel.setText("Running...");
        // Update Button
        startLogButton.setText("Stop");
        // Start Logcat if selected
        if(deviceLogCheckBox.isSelected()){
            logcatProcess.startProcess();
            logcatProcess.getProcess().getObserver().subscribeOnStart(this);
            logcatProcess.getProcess().getObserver().subscribeOnStop(this);
        }
        // Start Record if selected
        if(screenRecordCheckBox.isSelected()){
            screenRecord.startProcess();
            screenRecord.getProcess().getObserver().subscribeOnStart(this);
            screenRecord.getProcess().getObserver().subscribeOnStop(this);
        }
        // Start Device Information if selected
        if(deviceInfoCheckBox.isSelected()) {
            infoProcess.startProcess();
            infoProcess.getProcess().getObserver().subscribeOnStart(this);
            infoProcess.getProcess().getObserver().subscribeOnStop(this);
        }
        
        // Disable Components
        setEnableGroup(false);
    }
    
    private void stopProcesses () {
        // Update Text
        processStateLabel.setText("Waiting to finish...");
        // Update Button
        startLogButton.setText("Start");
        startLogButton.setEnabled(false);
        // Stop Logcat if selected
        if(deviceLogCheckBox.isSelected()){
            logcatProcess.stopProcess();
        }
        // Stop Record if selected
        if(screenRecordCheckBox.isSelected()){
            screenRecord.stopProcess();
        }
        // Stop Record if selected
        if(deviceInfoCheckBox.isSelected()){
            infoProcess.stopProcess();
        }
    }
    
    private void setEnableGroup (boolean enable) {
        // Processes
        deviceLogCheckBox.setEnabled(enable);
        screenRecordCheckBox.setEnabled(enable);
        deviceInfoCheckBox.setEnabled(enable);
        // Time
        recordTimeSlider.setEnabled(enable);
        recordTimeTextField.setEnabled(enable);
        // ADB
        adbChoosePath.setEnabled(enable);
        adbSaveConfig.setEnabled(enable);
        adbTextField.setEnabled(enable);
    }
    
    private void adbChoosePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adbChoosePathActionPerformed
        // TODO add your handling code here:
        int ret = jFileChooser1.showOpenDialog(adbChoosePath);
        if(ret == JFileChooser.APPROVE_OPTION){
            File file = jFileChooser1.getSelectedFile();
            ADBConfiguration.adbPath = file.getPath();
            updateADBView();
            saveADBPath();
        }
    }//GEN-LAST:event_adbChoosePathActionPerformed

    private void adbSaveConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adbSaveConfigActionPerformed
        saveADBPath ();
    }//GEN-LAST:event_adbSaveConfigActionPerformed

    private void showWindowCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showWindowCheckBoxActionPerformed
        // TODO add your handling code here:
        if(showWindowCheckBox.isSelected()) {
            logcatProcess.showLogWindow(true);
            screenRecord.showLogWindow(true);
            infoProcess.showLogWindow(true);
        } else {
            logcatProcess.showLogWindow(false);
            screenRecord.showLogWindow(false);
            infoProcess.showLogWindow(false);
        }
    }//GEN-LAST:event_showWindowCheckBoxActionPerformed

    private void recordTimeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_recordTimeSliderStateChanged
        updateRecordTime (recordTimeSlider.getValue());
    }//GEN-LAST:event_recordTimeSliderStateChanged

    private void recordTimeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordTimeTextFieldActionPerformed
        String text = recordTimeTextField.getText();
        if(!TextToNumberHelper.canParseToInt(text)) {
            updateRecordTime ();
            return;
        }
        int textValue = Integer.parseInt(text);
        if(!(0 <= textValue && textValue <= ADBConfiguration.MAX_RECORD_TIME)){
            updateRecordTime ();
            return;
        }
        
        updateRecordTime(textValue);
    }//GEN-LAST:event_recordTimeTextFieldActionPerformed

    private void adbTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adbTextFieldActionPerformed
        saveADBPath ();
    }//GEN-LAST:event_adbTextFieldActionPerformed
    
    private void updateRecordTime() {
        updateRecordTime (ADBConfiguration.currentRecordTime);
    }
    
    private void updateRecordTime(int time) {
        ADBConfiguration.currentRecordTime = time;
        screenRecordProgress.setMaximum(time);
        recordTimeTextField.setText(String.format("%d", time));
        recordTimeSlider.setValue(time);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adbChoosePath;
    private javax.swing.JPanel adbPanel;
    private javax.swing.JButton adbSaveConfig;
    private javax.swing.JTextField adbTextField;
    private javax.swing.JCheckBox deviceInfoCheckBox;
    private javax.swing.JCheckBox deviceLogCheckBox;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel logPanel;
    private javax.swing.JLabel processStateLabel;
    private javax.swing.JSlider recordTimeSlider;
    private javax.swing.JTextField recordTimeTextField;
    private javax.swing.JCheckBox screenRecordCheckBox;
    private javax.swing.JPanel screenRecordPanel;
    private javax.swing.JProgressBar screenRecordProgress;
    private javax.swing.JCheckBox showWindowCheckBox;
    private javax.swing.JButton startLogButton;
    // End of variables declaration//GEN-END:variables
    
    private void updateADBView () {
        adbTextField.setText(ADBConfiguration.adbPath);
    }
    
    private void saveADBPath () {
        ADBConfiguration.adbPath = adbTextField.getText();
        ADBConfiguration.saveConfiguration();
    }
    
    private boolean areProcessRunning () {
        return logcatProcess.isRunning() || screenRecord.isRunning() || infoProcess.isRunning();
    }

    @Override
    public void onProcessStarted(String command) {
        if(command.contains(ADBCommands.SCREEN_RECORD_SOLO_COMMAND)){
            screenRunning = true;
            startedMilis = System.currentTimeMillis();
            MainLoop.getLooper().subscribe(this);
            MainLoop.start();
        }
    }
    
    @Override
    public void onProcessStopped(String process) {
        if(process.contains(ADBCommands.SCREEN_RECORD_SOLO_COMMAND)){
            screenRunning = false;
            startedMilis = System.currentTimeMillis();
        }
        
        boolean screenReady = !screenRecord.isRunning() && screenRecord.queueCount() <= 0;
        boolean logReady = !logcatProcess.isRunning() && logcatProcess.queueCount() <= 0;
        boolean infoReady = !infoProcess.isRunning() && infoProcess.queueCount() <= 0;
        
        if(screenReady && logReady && infoReady){
            // Enable all buttons
            setEnableGroup(true);
            startLogButton.setEnabled(true);
            processStateLabel.setText("Stopped");
            startLogButton.setText("Start");
            screenRecordProgress.setValue(0);
            MainLoop.getLooper().unsubscribe(this);
        }
    }

    @Override
    public void Update(long delta) {
        if(!screenRunning)
            return;
        
        int seconds = (int)(System.currentTimeMillis() - startedMilis)/1000;
        screenRecordProgress.setValue(seconds);
    }

}
