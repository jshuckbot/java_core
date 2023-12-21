package ru.gb;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class BackupBuilder {
    public static void main(String[] args){
        createBackup();
    }
    
    public static void createBackup(){
        File backupDirectory = createDirectory();
        File[] listOfFiles = getListOfFiles();

        try {
            copyFiles(listOfFiles, backupDirectory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static File createDirectory() {
        String backupPath = "./backup";
        return createDirectory(backupPath);
        
    }
    
    public static File createDirectory(String backupPath) {
        File backupDirectory = new File(backupPath);
        if (!backupDirectory.exists()) {
            backupDirectory.mkdir();
        }
        return backupDirectory;
    }
    public static File[] getListOfFiles() {
        String entryPoint = ".";
        return getListOfFiles(entryPoint);
    }
    
    public static File[] getListOfFiles(String entryPoint) {
        File listOfFiles = new File(entryPoint);
        return listOfFiles.listFiles();
    }
    
    public static void copyFiles(File[] listOfFiles, File backupDirectory) throws IOException {
        for (File file : listOfFiles) {
            if (file.isFile()) {
                Files.copy(file.toPath(), new File(backupDirectory.getPath() + "/" + file.getName()).toPath(), REPLACE_EXISTING);
            }
        }
    }
}
