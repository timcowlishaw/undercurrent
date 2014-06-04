package support {
  trait Config {
    val uiRoot    = "./ui"
    val uiCommand = "gulp cucumber"
    val uiPort    = 9002
    val uiHost    = s"http://localhost:$uiPort"
    val uiReadyMessage = "Server started"
  }
}
