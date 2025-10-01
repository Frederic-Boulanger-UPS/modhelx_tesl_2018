#!/bin/sh
echo "Keystore password: "
read -s KSPASS
echo "tesl_team key password [empty if same as key store]: "
read -s KPASS
if [ -z "$KPASS" ]
then
  KPASS="$KSPASS"
fi
for jar in ../fr.supelec.teslfeature.update-site/{*.jar,*/*.jar}
do
  echo "Signing $jar with key tesl_dev"
  jarsigner -keystore keystore.jks -storepass "$KSPASS" -keypass "$KPASS" $jar tesl_dev
done