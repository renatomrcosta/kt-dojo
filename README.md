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
