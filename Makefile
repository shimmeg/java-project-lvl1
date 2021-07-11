install:
	./gradlew clean install

run-dist: install
	./build/install/app/bin/app

check-updates:
	./gradlew dependencyUpdates

lint:
	./gradlew checkstyleMain

build:
	./gradlew clean build
