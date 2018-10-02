[![Codacy Badge](https://api.codacy.com/project/badge/Grade/f8a7e6d5923648d480b33fb50561fcfa)](https://app.codacy.com/app/nikalomiris/Chess?utm_source=github.com&utm_medium=referral&utm_content=nikalomiris/Chess&utm_campaign=Badge_Grade_Dashboard)
[![Build Status](https://travis-ci.com/nikalomiris/Chess.svg?branch=master)](https://travis-ci.com/nikalomiris/Chess)
[![Average time to resolve an issue](http://isitmaintained.com/badge/resolution/nikalomiris/Chess.svg)](http://isitmaintained.com/project/nikalomiris/Chess "Average time to resolve an issue")
[![Percentage of issues still open](http://isitmaintained.com/badge/open/nikalomiris/Chess.svg)](http://isitmaintained.com/project/nikalomiris/Chess "Percentage of issues still open")
[![Open Source Helpers](https://www.codetriage.com/nikalomiris/chess/badges/users.svg)](https://www.codetriage.com/nikalomiris/chess)
[![codecov](https://codecov.io/gh/nikalomiris/Chess/branch/master/graph/badge.svg)](https://codecov.io/gh/nikalomiris/Chess)
[![license](https://img.shields.io/badge/license-GPL-blue.svg)](https://github.com/nikalomiris/Chess/blob/master/LICENSE)
[![version](https://img.shields.io/badge/version-1.0.0-brightgreen.svg)](https://github.com/nikalomiris/Chess/blob/master/pom.xml)
[![CII Best Practices](https://bestpractices.coreinfrastructure.org/projects/2247/badge)](https://bestpractices.coreinfrastructure.org/projects/2247)

# Chess

A simple CLI-based chess program.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
1.) Install JDK: https://www.oracle.com/technetwork/java/javase/downloads/index.html
2.) Install maven: http://maven.apache.org/download.cgi
3.) Install a Java IDE (Eclipse, IntelliJ IDEA, or Netbeans)
```

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

1.) Import the project in your IDE.
2.) Right click on the project, select maven clean and build.
3.) Once clean build is complete, select maven run.

```
mvn clean
mvn build
```

## Running the tests

```
mvn test
```



### Break down into end to end tests

Explain what these tests test and why

```
The tests test the various valid and invalid paths that can be taken by the chess pieces. For example, a rook cannot move to diagonal pieces, so a rook at position (3, 4) on the board cannot move to position (5, 6), but can move to position (3, 7).
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

- [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
- [Maven](https://maven.apache.org/) - Dependency Management
- [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

- **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

- Hat tip to anyone whose code was used
- Inspiration
- etc
