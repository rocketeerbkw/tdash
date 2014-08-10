if [ -n "$ROOT_DIR" ]; then
  SRC_DIR="scripts/";
fi
if [ -z "$BIN_DIR" ]; then
  BIN_DIR=../../bin;
fi
if [ -z "$COMPRESS_CMD" ]; then
  COMPRESS_CMD="java -jar ${BIN_DIR}/yuicompressor-2.4.2.jar";
fi

echo ${COMPRESS_CMD}

${COMPRESS_CMD} ${SRC_DIR}jquery.scrollTo-min.js > ${SRC_DIR}compound2.js
${COMPRESS_CMD} ${SRC_DIR}jquery.ba-longurl.min.js >> ${SRC_DIR}compound2.js
${COMPRESS_CMD} ${SRC_DIR}bitly.js >> ${SRC_DIR}compound2.js
${COMPRESS_CMD} ${SRC_DIR}oauth_july2010.js >> ${SRC_DIR}compound2.js
${COMPRESS_CMD} ${SRC_DIR}sha1.js >> ${SRC_DIR}compound2.js
${COMPRESS_CMD} ${SRC_DIR}persist-new.js >> ${SRC_DIR}compound2.js
${COMPRESS_CMD} ${SRC_DIR}jquery.simplemodal-1.3.3.min.js >> ${SRC_DIR}compound2.js
${COMPRESS_CMD} ${SRC_DIR}jquery.cookie-1.4.1.min.js >> ${SRC_DIR}compound2.js
