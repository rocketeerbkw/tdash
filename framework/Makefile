OBJ:=target/scala-2.9.1.final/tdash_2.9.1-0.2.jar

.PHONY : clean compile_obj compile

all: compile_obj
	@echo done.

compile_obj:
	./sbt.sh package

compile: all
	rm -rf ../build/ROOT/WEB-INF/
	mkdir -p ../build/ROOT/WEB-INF/
	mkdir -p ../build/ROOT/WEB-INF/lib/
	cp $(OBJ) ../build/ROOT/WEB-INF/lib/
	cp web_${DOMAIN}.xml ../build/ROOT/WEB-INF/web.xml
	cp project/boot/scala-2.9.1/lib/scala-library.jar ../build/ROOT/WEB-INF/lib/

clean:
	./sbt.sh clean
