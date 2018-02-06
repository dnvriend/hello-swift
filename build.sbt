lazy val `hello-swift` = (project in file("."))
    .settings(
      unmanagedSourceDirectories in Compile += baseDirectory.value / "src" / "main" / "swift",
    )

lazy val swiftc = taskKey[Unit]("compile swift")
swiftc := {
  import sbt._
  import scala.sys.process._
  val log = streams.value.log
  val swiftTarget = target.value / "swift"
  sbt.IO.createDirectory(swiftTarget)
  val allSwiftFiles = ((Compile / unmanagedSourceDirectories).value ** "*.swift").get
  val cmd = s"swiftc ${allSwiftFiles.map(_.absolutePath).mkString(" ")} -o ${(swiftTarget / "Hello").absolutePath}"
  log.info(cmd)
  cmd ! log
}

lazy val swiftr = taskKey[Unit]("run swift")
swiftr := {
  import sbt._
  import scala.sys.process._
  val log = streams.value.log
  val swiftTarget = target.value / "swift"
  (swiftTarget / "Hello").absolutePath ! log
}

lazy val swift = taskKey[Unit]("compile and run swift")
swift := {
  Def.sequential(swiftc, swiftr).value
}