ifndef DEBUG
export COMPRESS_CMD=java -jar ${BIN_DIR}/yuicompressor-2.4.2.jar
else
export COMPRESS_CMD=cat
endif

.PHONY : compile scripts css

all:

scripts:
	mkdir -p ${STATIC_DIR}/scripts
	scripts/createCombined2.sh
	scripts/createIndexCombined.sh
	cp scripts/jquery-1.3.2.min.js ${STATIC_DIR}/scripts/
# cp scripts/jquery.scrollTo-min.js ${STATIC_DIR}/scripts/
	cp scripts/oauth_july2010.js ${STATIC_DIR}/scripts/
# cp scripts/bitly.js ${STATIC_DIR}/scripts/
	cp scripts/sha1.js ${STATIC_DIR}/scripts/
# cp scripts/persist-all-min.js ${STATIC_DIR}/scripts/
# cp scripts/jquery.simplemodal-1.3.3.min.js ${STATIC_DIR}/scripts/
	cp scripts/compound2.js ${STATIC_DIR}/scripts/
	cp scripts/indexComp2.js ${STATIC_DIR}/scripts/
	${COMPRESS_CMD} -v scripts/dash-new4.js > ${STATIC_DIR}/scripts/dash-new4.js
	${COMPRESS_CMD} scripts/jquery.rotate.1-1-a.min.js > ${STATIC_DIR}/scripts/jquery.rotate.1-1-a.min.js
	${COMPRESS_CMD} scripts/pic.js > ${STATIC_DIR}/scripts/pic.js
#${COMPRESS_CMD} scripts/index.js > ${STATIC_DIR}/scripts/index.js
	${COMPRESS_CMD} scripts/raphael-combined.js > ${STATIC_DIR}/scripts/raphael-combined.js
	${COMPRESS_CMD} scripts/jquery.date_input.js > ${STATIC_DIR}/scripts/jquery.date_input.js

css:
ifndef DEBUG
	npm run gulp sass -- --env=prod
else
	npm run gulp sass
endif
	cp -R css/ ${STATIC_DIR}

compile: clean all scripts css
	cp -R images/ ${STATIC_DIR}
	cp *.html ${STATIC_DIR}
	cp *.xml ${STATIC_DIR}
	cp persist.swf ${STATIC_DIR}
#cp robots.txt ${STATIC_DIR}
	cp *.ico ${STATIC_DIR}
	mkdir -p ${SERVLET_DIR}
	cp ErrorPage.html ${SERVLET_DIR}

clean:
	rm -rf ${STATIC_DIR}/scripts
	rm -rf ${STATIC_DIR}/css
	rm -rf ${STATIC_DIR}/images
	rm	-f ${STATIC_DIR}/*.html
	rm  -f ${STATIC_DIR}/*.xml
	rm  -f ${STATIC_DIR}/*.ico
	rm  -f ${STATIC_DIR}/persist.swf
