package edu.kis.powp.jobs2d.features;

import edu.kis.powp.jobs2d.enums.RecordingOption;
import edu.kis.powp.jobs2d.events.SelectRecordingOptionListener;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.command.recorder.RecordCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;

import java.util.List;

public class RecordFeature {
    private static Application application;
    private static RecordCommand recordCommand;

    private static boolean isRecording = false;

    public static void setupRecorderPlugin(Application app) {
        recordCommand = new RecordCommand();
        application = app;

        SelectRecordingOptionListener startOption = new SelectRecordingOptionListener(RecordingOption.START);
        SelectRecordingOptionListener stopOption = new SelectRecordingOptionListener(RecordingOption.STOP);
        SelectRecordingOptionListener clearOption = new SelectRecordingOptionListener(RecordingOption.CLEAR);

        application.addComponentMenu(edu.kis.powp.jobs2d.features.RecordFeature.class, "Recorder");
        application.addComponentMenuElement(edu.kis.powp.jobs2d.features.RecordFeature.class, "Start", startOption);
        application.addComponentMenuElement(edu.kis.powp.jobs2d.features.RecordFeature.class, "Stop", stopOption);
        application.addComponentMenuElement(edu.kis.powp.jobs2d.features.RecordFeature.class, "Clear", clearOption);

    }
    public static void setCommand(DriverCommand command){
        if(isRecording){
            recordCommand.addCommand(command);
        }
    }

    public static void start(){
        isRecording = true;
    }

    public static void stop(){
        isRecording = false;
    }

    public static void clear(){
        recordCommand.clearCommand();
    }

    public static List<DriverCommand> getCommands(){
        return recordCommand.getCommands();
    }
}
