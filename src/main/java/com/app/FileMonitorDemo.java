package com.app;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

public class FileMonitorDemo  {


    
    // Get the user home directory to be monitored
    private static final String FOLDER = System.getProperty("user.dir");

    // The monitor will perform polling on the folder every 30 seconds
    private static final long pollingInterval = 10 * 1000;

    public static void main(String[] args)  throws Exception {
        
        String folderToWatch;
        Path currentRelativePath = Paths.get("");
        folderToWatch = currentRelativePath.toAbsolutePath().toString();
        //folderToWatch = FOLDER;
        final File directory = new File(folderToWatch);
        if (directory.exists()==false) {
            // Test to see if monitored folder exists
            throw new RuntimeException("Directory not found: " + folderToWatch);
        }
        else{
            System.out.println("Configuring Observer for Folder: (" + folderToWatch + ")");
        }
        
        // Create a new FileAlterationObserver on the given directory
        FileAlterationObserver observer = new FileAlterationObserver(directory);
        // Create a new FileAlterationMonitor with the given pollingInterval period
        final FileAlterationMonitor monitor = new FileAlterationMonitor(pollingInterval);

        observer.addListener(new FileAlterationListenerImpl());
        monitor.addObserver(observer);
        monitor.start();

        System.out.println("Starting monitor (" + FOLDER + "). \"Press CTRL+C to stop\"");

    }

}
