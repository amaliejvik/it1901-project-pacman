# Testing of the project

## Why is testing important to us?

Testing of the code is an important part of developing an application. It is closely related to code quality and therefore contributes to increasing the quality of our application. In both release 2 and even more in release 3, it has been a priority for us to gain an acceptable test coverage in all of our modules. It is important to test all modules properly, in order to ensure reliability, robustness and to make sure that all layers work as they should so they can successfully work together for the entire application.

## Our approach to testing

In order to test our code, we started by reviewing what our application is supposed to do. This helped us gain a clearer view on which elements of the code that needed to be tested.

### JUnit

To test our project, we chose to use JUnit, which is a widely used testing framework for Java Applications. All group members were familiar with JUnit from earlier Java projects and subjects,  therefore this was an easy choice.

### Jacoco

In release 2, we implemented Jacoco, which is a maven plug-in and a tool for checking test coverage. It generates reports on each module and each class, displaying a percentage corresponding with how much of our code is tested. This has been a very helpful tool along the way, and has made it easy seeing if some methods have been left out of the tests or if some classes need more testing.

### Final tests for Release 3

In release 3, it was necessary to write even more tests. This was due to our application having developed with new classes and methods connected to both new functionality and the RestAPI. Because of this, our test coverage had decreased. We therefore expanded the testing of each module.

A more detailed explanation on testing of each module is given at the bottom of the README for each module linked below.

[Approach to testing in Core](/gr2372/core/README.md#approach-to-testing-of-the-core-module)

[Approach to testing in UI](/gr2372/ui/README.md#approach-to-testing-of-the-ui-module)

[Approach to testing in Restserver](/gr2372/springboot/restserver/README.md#approach-to-testing-of-the-springbootrestserver-module)

