package bhoot

object Config {
  val twitterDesktopOauthKey = "YOUR_KEY_HERE"
  val twitterDesktopOauthSecret = "YOUR_SECRET_HERE"
  val domainName = UtilsServlet.initParms.get("domainName").getOrElse("127.0.0.1")
  val port = UtilsServlet.initParms.get("port").getOrElse("8080")
  val baseUrl = "http://" + domainName + ":" + port + "/"
  val adminEmails = List("admin@localhost.dev")
  val smtpHost = "localhost"
  val smtpPort = 25
  val smtpUser = ""
  val smtpPass = ""
  val fromEmail = "noreply@" + domainName
  val dbName = "tdash"
  val dbUser = "postgres"
  val dbPass = "xyz"
}
