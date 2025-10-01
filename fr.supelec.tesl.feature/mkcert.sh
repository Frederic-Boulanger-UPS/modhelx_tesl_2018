#!/bin/sh
echo "Keystore and tesl_dev key password: "
read -s KPASS
if [ -z "$KPASS" ]
then
  echo "No password, aborting"
  exit 1
fi

keytool -genkey -alias tesl_dev -keypass "$KPASS" -keystore keystore.jks -storetype pkcs12 -storepass "$KPASS" -validity 365 << ENDOFINPUT
TESL dev team LRI/ModHel
Computer Science Department
CentraleSupélec
Gif-sur-Yvette
Essonne
FR
oui
ENDOFINPUT

keytool -exportcert -rfc -keystore keystore.jks -storepass "$KPASS" -alias tesl_dev > tesl_dev.rfc
