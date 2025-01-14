#!/bin/sh

javadoc -d docs -sourcepath src org.uob.a3 org.uob.a3.gameobjects org.uob.a3.commands org.uob.a3.utils org.uob.a3.parser
zip -r docs.zip docs