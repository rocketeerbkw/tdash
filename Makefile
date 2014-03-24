export ROOT_DIR:=$(shell pwd)

export BIN_DIR=${ROOT_DIR}/bin
export OUT_DIR=${ROOT_DIR}/build/ROOT
export STATIC_DIR=${OUT_DIR}
export SERVLET_DIR=${OUT_DIR}
export DOMAIN="local"

.PHONY : compile ui

all: compile

ui:
	make -C ui compile

compile:
	make -C ui compile
	make -C framework compile

dist: all
	if [[ -n "${DEBUG}" ]] ; then echo "No DEBUG allowed for dist target"; exit 1 ; fi
	if [[ "${DOMAIN}" != "live" ]] ; then echo "DOMAIN should be live"; exit 1 ; fi
	./tools/emitVersion.sh > ${STATIC_DIR}/version.html

run: all build/lib/scala-library.jar
	./run.sh

clean:
	rm -rf ${OUT_DIR}
	make -C framework clean
	make -C ui clean
