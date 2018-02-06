# hello-swift
A small test project to see how the support would be when [Swift](https://swift.org/) was built with [sbt](https://www.scala-sbt.org/). 

## Findings
Having a `build.sbt` and sbt to build Swift, the two best editors for [Swift](https://swift.org/) being [XCode](https://developer.apple.com/xcode/) 
and [AppCode](https://www.jetbrains.com/objc/) don't work well with this strategy. Both XCode and AppCode need a dedicated directory that they will erase
if present because they need to manage the directories contents. 

Also, sbt (obviously) doesn't yet have support for compiling Swift, so settings and tasks must be added to support compiling and running swift code.
I have not yet looked into testing Swift code with sbt.

## Further work
I have decided to drop this project and move to [Cocoapods](https://cocoapods.org/), a build tool and dependency management tool for Swift, but it
needs ruby to install and maybe run. Alternatively there is [Carthage](https://github.com/Carthage/Carthage) and the [Swift Package Manager](https://swift.org/package-manager/) so there are a lot of options to look at and research.

## Available tasks
- `swift`: compile and run your swift code
- `swiftc`: compiles your swift code
- `swiftr`: run your swift code 

