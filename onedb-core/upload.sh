#!/bin/bash

mvn clean package -DskipTests
scp ./target/onedb-core-0.0.1-SNAPSHOT.jar ict@10.17.18.46:/home/ict/programs/
