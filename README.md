# kt-dojo

Ideas and exercises to practice Kotlin


### Basics

If you want to take a practical approach through the language basics, I'd recommend the following steps:

- Read up on Kotlin Basics: https://kotlinlang.org/docs/basic-syntax.html#program-entry-point
    - Get acquainted with the language, its syntax, features and overall building process. You do not need to learn all topics in this documentation (and trust me, you will consult it over and over again), but it is a great starting point for sure.
- Kotlin By Example: https://play.kotlinlang.org/byExample/01_introduction/01_Hello%20world
  - If reading is not your Jam, you can go point by point in the Kotlin by Example page. It contains snippets for many important language features. Create kotlin files in the basics package and experiment with every feature to acquaint yourself.
- Kotlin Koans: These are exercises written as failed unit tests that will test you in your syntax / feature knowledge in Kotlin.
  - You can go through Kotlin Koans either via the browser (at https://play.kotlinlang.org/koans/Introduction/Hello,%20world!/Task.kt)
  - Or go to *Preferences* -> *Plugins* -> Install *EduTools*. After restarting the IDE, go to File -> Learn and Teach -> And select the Kotlin Koans project

### Exercises

In the last dojo sessions we explored some of the following topics. Here are some suggestions to explore them further in code:

- Sealed Classes / Interfaces
    - Implement a stopwatch. Use sealed classes to determine the possible states of the application.
    - Tackle Day 12 of Advent of Code 2020 (https://adventofcode.com/2020/day/12). Personally, I found the construct very useful to model the solution

- Big Collections / Sequences
    - Generate a sequence with a few billion items. Fiddle around with the operators to figure out how to properly collect, map, filter, take, drop, in different formats.
    - Create an INFINITE sequence
    - Use an infinite sequence to generate fibonnacci numbers
    - Use an infinite sequence to find prime numbers

- Extension Functions
    - Experiment with extension function access: Write a private, package private, and public extension function in multiple packages.
    - Write an extension function with multiple receivers (inside of a class instance, for example)
    - Use extension functions to write your very own DSL (Domain Specific Language) to create an instance of a data class!

- Type Inference / Reified
    - Implement, without looking at the reference, the infamous fixture function (a function that takes a reified type argument and uses it as a parameter to return a new instance of that type)
    - Implement a dummy HTTP client GET function: Given a type parameter, use a JSON string to generate a kotlin data class based on the type parameter.

- Platform Types & Double Bang dangers
    - Import a Java library containing data structures (maybe at https://github.com/akullpp/awesome-java#data-structures). Create objects of those structures, and attempt to parse them into Plain old kotlin code. Then try to make NPEs occur

- Type Aliases & Inline Classes
    - Implement a type alias for complex types (such as a Map<Int, Map<String, Set<String>>>) or something of the sort. Use it in code to see how it feels like
    - Implement two different value classes, for different DTO domain IDs. Attempt to match them together

### Coroutines

If you want to level up your coroutines knowledge, I'd recommend the following steps:

- First and foremost, follow along (and experimenting with) the coroutines by example by Jetbrains: https://kotlinlang.org/docs/coroutines-guide.html

- If you need a crash course of coroutines, and a really great intro to Channels and Flows, I recommend [Roman Elizarov's talk in Kotlin Conf 2019](https://www.youtube.com/watch?v=tYcqn48SMT8)

- There's an official Coroutines sample project, if you like following somewhat lengthy tutorials, here: https://play.kotlinlang.org/hands-on/Introduction%20to%20Coroutines%20and%20Channels/01_Introduction

- There's the coroutines module. To experiment with the constructs and see how to approach a few ideas in the language, you can go in alphanumeric order through the files, and try to understand functionality through the code execution and comments. 
  - i_basics -> Package contains basic exploration of coroutine primitives and specific syntaxes, and some constructs that may be nice to play with!
  - ii_channels -> Some experiments with (Hot) channels. Normally, most of what one would want to use coroutines for, flows take care of it (or wrap channels for you already). But it is good to have a cursory look at this section to acquaint yourselves. There are a few "practical" constructs as well, such as a simple Worker Pool implementation in there.
  - iii_flow -> An exploration on flows, and many possible operations. There are some "practical" constructs at the end as well.
  - iii_flow_exercises -> Package contains exercises meant to acquaint you with Flows using RxJava or Reactor as a basis. You can find some code in the reactor or rxjava packages, and you have to replicate the code written there in the coroutines package. Solutions are provided in the solutions package.

This section will expand as soon as I find time to explore this further. Eagle eyed viewers may also notice that it borrows heavily from the coroutines by example provided by jetbrains. That is because the examples are pretty darn good!

There's also, in the coroutines section, a few tests using KoTest. This can be expanded to experiment with the library. Make sure you have the KoTest plugin installed in your intellij so you can run them directly using the gutter icons.
