#!/bin/bash

PROFILE="${PROFILE:-prod}"

mvn clean test -P=$PROFILE