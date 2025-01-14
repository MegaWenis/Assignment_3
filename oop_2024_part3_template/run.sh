#!/bin/sh

javac -d out src/org/uob/a3/*.java src/org/uob/a3/commands/*.java src/org/uob/a3/gameobjects/*.java src/org/uob/a3/parser/*.java src/org/uob/a3/utils/*.java 
java -cp out org.uob.a3.Game 