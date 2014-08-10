package bhoot
import javax.servlet.http._

import Utils._
import UtilsServlet._

case class Scheme(name:String, colors:Array[String], background:String, statusBackground:String)

object CSS {

/*
      background      quickrt link,     "2c7385", modal overlay,
      "99a9a9",       "e7ffff",     "000",    aaa
      foregrnd bttn,  meta status,  hover ind,
      sel ind,        read ind,     "bfbfea", "900",
      modal bkg,    default_body
*/
  val ClassicScheme = Scheme("Classic",
    Array(
      "c8c8c8", "dbdbff", "707784", "fafafa",
      "999",    "fafafa", "a8b4c8", "444",
      "171717", "461446", "c8c8c8", "00004f",
      "aaa",    "900",    "f00",    "eee",
      "000",    "999",    "000",    "000"),
    "url('/images/noise2.jpg')", "")

  val SeaScheme = Scheme("The Sargasso Sea",
    Array(
      "0b486b", "f3ffff", "2c7385", "c9e8e8",
      "99a9a9", "e7ffff", "346179", "3f5059",
      "f3ffff", "0b486b", "c1d9d9", "0b486b",
      "aaa",    "900",    "f00",    "eee",
      "000",    "99a9a9", "346179", "000"),
    // "#d9f4f4")
    "url('/images/boating.png')", "")

  val SafariScheme = Scheme("African Safari",
    Array(
      "033649", "033649", "99773d", "fffaf0",
      "736a5a", "decdad", "034b65", "596982",
      "f3ffff", "183053", "d3c9b9", "033649",
      "aaa",    "900",    "f00",    "eee",
      "000",    "736a5a", "034b65", "000"),
    "#f0e5d2", "")

  val PapayaScheme = Scheme("Papaya Sundae",
    Array(
      "C4574E", "e5cada", "782e59", "fffaf0",
      "736a5a", "e7dcbe", "d88057", "E0CFA7",
      "f5e4b9", "8C004E", "E1DAC7", "1e1e44",
      "aaa",    "900",    "f00",    "eee",
      "000",    "736a5a", "782e59", "000"),
    "#F3EBD6", "")

  val SubwayScheme = Scheme("Subway",
    Array(
      "34532e", "1e1e44", "a12f1c", "000",
      "182615", "182615", "57994a", "182615",
      "f5e4b9", "366729", "351b1b", "B5E0AB",
      "533",    "f99",    "f00",    "34532e",
      "fff",    "d88057", "B5E0AB", "fff"),
    """url('/images/subway.jpg');
      -moz-background-size: 100% 100%;           /* Gecko 1.9.2 (Firefox 3.6) */
      -o-background-size: 100% 100%;           /* Opera 9.5 */
      -webkit-background-size: 100% 100%;           /* Safari 3.0 */
      -khtml-background-size: 100% 100%;           /* Konqueror 3.5.4 */
      -moz-border-image: url(/images/subway.jpg) 0;    /* Gecko 1.9.1 (Firefox 3.5) */""",
    """background: rgb(0, 0, 0);
       background: rgba(40, 10, 10, 0.8);""")

  val HelvetiScheme = Scheme("Helveti",
    Array(
      "eeeeee", "eeeeee", "888888", "eeeeee",
      "888888", "eeeeee", "888888", "eeeeee",
      "444444", "b70404", "d0d0d0", "444444",
      "eeeeee", "e91010", "e91010", "dddddd",
      "000",    "888888", "e91010", "b00404"),
    "#fbfbfb",
    "")

  val HelvetiBlueScheme = Scheme("Helveti Blue",
    Array(
      "eeeeee", "eeeeee", "888888", "eeeeee",
      "888888", "eeeeee", "888888", "eeeeee",
      "444444", "1533ad", "d0d0d0", "444444",
      "eeeeee", "1533ad", "1533ad", "dddddd",
      "000",    "888888", "1533ad", "1533ad"),
    "#fbfbfb",
    "")

  val impColors=12

  val schemeMap = Array (ClassicScheme,SeaScheme, SafariScheme, PapayaScheme, SubwayScheme, HelvetiScheme, HelvetiBlueScheme)

  val defaultScheme = 6

  def renderSchemePreview (scheme:Scheme) = {
    ("""<div style="padding:4px;background:%s;">""" format (scheme.background)) +
    scheme.colors.take(impColors).map(c => """<span style="font-size:60px;background:#%s;">&nbsp;</span>""" format c).mkString +
    """</div>"""
  }

  val htmlStdStr = """
   <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
  <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  """
  private val htmlBody1 = """
    <title>tDash.org | Twitter Dashboard</title>
    <meta content="Change the theme of the tDash Twitter interface" name="description" />
    <meta content="Twitter browser client theme color configure" name="keywords" />
    <link href="/css/common.css" type="text/css" rel="stylesheet" media="screen,projection" />
    <script type="text/javascript">
      function clickScheme(id) {
        if (top) {
          if (top.changeCSS) {
            top.changeCSS('/oauth/getCss?scheme_id='+id);
          }
        }
      }
    </script>

  </head>
  <body>
"""
  def getChooseTheme (request:Request, response:HttpServletResponse):String = {
    val (cookies,loginTokens) = WebApp.processLoginCookies(request.req)

    val prevSchemeId = cookies.get("scheme_id").map(_.toInt).getOrElse(defaultScheme)
    // val prevSchemeId = request.getIntParamOpt("scheme_id").getOrElse(0)

    val isEmbedded = request.getParamOpt("embed").isDefined

    val embeddedStr =
      if (isEmbedded)
        """<input type="hidden" name="embed" value="true"/>"""
      else ""

    htmlStdStr + htmlBody1 + """<form method="post" action="/oauth/themeSave">""" + embeddedStr + """
  <div style="float:right"><input style="margin:1em 2em;" type="submit" value="Save Theme"/></div>
  <div style="overflow-y:scroll;height:450px;"><table style="width:100%;"><tbody>""" +
    schemeMap.zipWithIndex.map(scheme =>
      """<tr><td style="margin:2px;"><input type="radio" onclick="clickScheme(%d);" name="scheme_id" id="choice_%d" value="%d" %s/><label for="choice_%d">%s</label></td><td style="margin:2px 6px;">%s</td></tr>""" format (
        scheme._2, scheme._2, scheme._2, if (scheme._2 == prevSchemeId) "checked" else "",
        scheme._2, scheme._1.name, renderSchemePreview(scheme._1)
      )
    ).mkString +
  """</tbody></table></div></form>
  </body>
</html>"""
  }

  def postThemeSave (request:Request, response:HttpServletResponse):String = {
    val newSchemeId = request.getIntParamOpt("scheme_id").getOrElse(defaultScheme)
    val isEmbedded = request.getParamOpt("embed").isDefined

    val embeddedStr =
      if (isEmbedded)
        """<p>You can now close this window."""
      else ""

    WebApp.setCookie("scheme_id", newSchemeId.toString, WebApp.seconds90days, response)

    htmlStdStr + """
      <link href="/css/common.css" type="text/css" rel="stylesheet" media="screen,projection" />
    </head>
    <body>
      <h1>Saved</h1>
      <p>Your chosen theme (%s) has been associated with this computer.</p>%s
    </body>
  </html>""" format (schemeMap(newSchemeId).name, embeddedStr)
  }
}

