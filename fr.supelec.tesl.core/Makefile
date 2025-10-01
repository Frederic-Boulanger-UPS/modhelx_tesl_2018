TOPACKAGE=${wildcard META-INF/MANIFEST.MF} ${wildcard bin/fr/supelec/tesl/core/*} ${wildcard bin/fr/supelec/tesl/logging/*}
teslcore.jar: ${TOPACKAGE}
	cd bin; jar cmf ../META-INF/MANIFEST.MF ../teslcore.jar *

