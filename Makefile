install:
	./gradlew clean install

run-dist: install
	./app/build/install/app/bin/app

check-updates:
	./gradlew dependencyUpdates
