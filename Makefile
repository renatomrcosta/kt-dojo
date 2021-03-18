.PHONY: test-basics
test-basics:
	./basics/gradlew -p ./basics check

.PHONY: test-coroutines
test-coroutines:
	./coroutines/gradlew -p ./coroutines check

.PHONY: test
test: test-basics test-coroutines
