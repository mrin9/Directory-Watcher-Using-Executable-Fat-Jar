# Directory-Watcher-Using-Executable-Fat-Jar

This project uses ```maven-assembly-plugin``` to create a self executable fat jar which will include all the dependencies

## What it does
The app monitors a given folder and can inform about
* File Creations, deletions and changes
* Sub-Folder Creations, deletions and changes

The app uses polling mechanism to do so. The functionality is provided by Appache Commons-IO jar
It fails to Monitor certain folders such as Users home folder as they may need special permissions


## Pre-requisites
Must have ```Java 8 ``` and ```maven 3.5.0``` installed

## To Compile the App.
``` mvn clean install ```

this will generate following 2 jars under the target folder
* ```app-1.0.jar```
* ```app-1.0-jar-with-dependencies.jar```

## To Execute the project
``` java -jar ./target/app-1.0-jar-with-dependencies.jar```

