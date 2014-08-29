package support {
  trait Config {
    val uiPort    = 9002
    val uiHost    = s"http://localhost:$uiPort"
  }
}
