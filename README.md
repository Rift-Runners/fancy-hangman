[![Build Status](https://travis-ci.org/matuella/fancy-hangman.svg?branch=master)](https://travis-ci.org/matuella/fancy-hangman)
[![Coverage Status](https://coveralls.io/repos/github/matuella/fancy-hangman/badge.svg?branch=master)](https://coveralls.io/github/matuella/fancy-hangman?branch=master)

# Fancy Hangman
---
## Introduction

This project main purpose is learning how to build a **hangman game** in a *"fancy" style*.
Meaning: Trying to use (most of time) XP as the development technology and a lot of frameworks.

---
### Frameworks/Tools

- [Maven](https://maven.apache.org/)
- [Mockito](https://mockito.org/)
- [Travis-CI](https://travis-ci.org/) / [Project-Travis](https://travis-ci.org/matuella/fancy-hangman)
- [Coveralls](https://coveralls.io/) / [Project-Coveralls](https://coveralls.io/github/matuella/fancy-hangman)

---
### Team

| Position      | Name                                              |
|:-------------:|:-------------------------------------------------:|
| Developer     | [Guilherme Matuella](https://github.com/matuella) |
| Developer     | [Diego Peixoto](https://github.com/dvpeixoto)     |

---
### Branches names meaning

| Term         | Meaning                                           |
|:------------:|:-------------------------------------------------:|
|ft            | Feature                                           |
|rf            | Refactor                                          |
|fix           | Fix/Hotfix                                        |

---

### Custom words and tips instructions

To add your custom words and its respective tips, you must access the folder [*"src/main/resources"*](https://github.com/matuella/fancy-hangman/tree/master/src/main/resources) and open the file called: **"wordsList.txt"**. After that, you must follow the pattern that the file uses to read a respective word and the tip.<br/>
**I.e.**: We want to read the words: *"foo"* and *"bar"*. And its tips: *"foo tip"* and *"bar tip"*.
<pre><code>foo;foo tip;
bar;bar tip;</pre></code>

And that's it, easy peasy! Also, you can modify the way it "reads" the pattern on the: [*"src/main/java/util/HangmanUtils.java"*](https://github.com/matuella/fancy-hangman/tree/master/src/main/java/util). :+1:
