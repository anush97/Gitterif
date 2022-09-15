
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.data._
import play.core.j.PlayFormsMagicForJava._
import scala.jdk.CollectionConverters._

object topic extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[HashMap[String, ArrayList[Models.GithubResult]],List[String],play.mvc.Http.Request,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(results: HashMap[String, ArrayList[Models.GithubResult]], keys: List[String],request: play.mvc.Http.Request):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.111*/("""
"""),format.raw/*2.1*/("""<script type='text/javascript' src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script type='text/javascript' src='"""),_display_(/*3.38*/routes/*3.44*/.Assets.versioned("javascripts/index.js")),format.raw/*3.85*/("""'></script>  

<section data-ws-url=""""),_display_(/*5.24*/routes/*5.30*/.HomeController.wsTopic.webSocketURL(request)),format.raw/*5.75*/("""" style=" margin: 0;background: linear-gradient(45deg, #7ab1af, #aea7ec);font-family: sans-serif;font-weight: 100; padding-bottom: 40px">
 
  """),_display_(/*7.4*/if(!results.isEmpty())/*7.26*/ {_display_(Seq[Any](format.raw/*7.28*/("""    	
      """),_display_(/*8.8*/for(key <- keys) yield /*8.24*/{_display_(Seq[Any](format.raw/*8.25*/("""
      """),format.raw/*9.7*/("""<div class="container" style="display: flex;justify-content: center; ">
      <div style="padding: 0px 40px 40px 40px;margin: 20px;background-color: rgb(211, 211, 211);border-radius: 5px;">
       <center> <span>Showing results for the topic: <h1 style="display:inline-block;margin-left: 10px;">"""),_display_(/*11.107*/key),format.raw/*11.110*/("""</h1> </span></center>
        <table style="width:800px;
          border-collapse: collapse;
          border: 1px solid #ddd;
          box-shadow: 0 0 20px rgba(0,0,0,0.1);">
            <thead style="background-color: #42a386; padding: 10px; height:50px ;">
              <tr>
                <th style="border: 1px solid rgb(211, 211, 211);">Owner</th>
                <th  style="border: 1px solid rgb(211, 211, 211);">Repository</th>
                <th  style="border: 1px solid rgb(211, 211, 211);">Topics</th>

              </tr>
            </thead>
            <tbody style="background-color: #dee2e1; text-align: center;">
              
              """),_display_(/*26.16*/for(obj <- results.get(key) ) yield /*26.45*/{_display_(Seq[Any](format.raw/*26.46*/("""
                """),format.raw/*27.17*/("""<tr style="height: 50px ">
                <td style="border: 1px solid rgb(104, 207, 164);">"""),_display_(/*28.68*/obj/*28.71*/.ownerName),format.raw/*28.81*/("""</td>
                <td style="border: 1px solid rgb(104, 207, 164);">"""),_display_(/*29.68*/obj/*29.71*/.repoName),format.raw/*29.80*/("""</td>
                <td style="border: 1px solid rgb(104, 207, 164);">
                  """),_display_(/*31.20*/for(topic <- obj.returnTopics()) yield /*31.52*/{_display_(Seq[Any](format.raw/*31.53*/("""
                   """),format.raw/*32.20*/("""<div style="display: inline-block;background-color: #0b7e5b;color: #dee2e1; border-radius:6px; padding: 3px; margin-right: 3px; margin-top: 3px;margin-bottom: 3px;"> """),_display_(/*32.187*/topic),format.raw/*32.192*/(""" """),format.raw/*32.193*/("""</div> 
                  """)))}),format.raw/*33.20*/("""
                """),format.raw/*34.17*/("""</td>
              </tr>
              """)))}),format.raw/*36.16*/("""
               
            
            """),format.raw/*39.13*/("""</tbody> 
          </table>
        </div>
         </div>
        
        """)))}),format.raw/*44.10*/("""

""")))}/*46.3*/else/*46.8*/{_display_(Seq[Any](format.raw/*46.9*/("""
  """),format.raw/*47.3*/("""<h1>Not Displaying</h1>
""")))}),format.raw/*48.2*/("""
 
"""),format.raw/*50.1*/("""</section>
"""))
      }
    }
  }

  def render(results:HashMap[String, ArrayList[Models.GithubResult]],keys:List[String],request:play.mvc.Http.Request): play.twirl.api.HtmlFormat.Appendable = apply(results,keys,request)

  def f:((HashMap[String, ArrayList[Models.GithubResult]],List[String],play.mvc.Http.Request) => play.twirl.api.HtmlFormat.Appendable) = (results,keys,request) => apply(results,keys,request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/topic.scala.html
                  HASH: b1ecf7117de11442ed39b5c3ae331bb3418e1909
                  MATRIX: 983->1|1188->110|1216->112|1371->241|1385->247|1446->288|1512->328|1526->334|1591->379|1761->524|1791->546|1830->548|1869->562|1900->578|1938->579|1972->587|2298->885|2323->888|3033->1571|3078->1600|3117->1601|3163->1619|3285->1714|3297->1717|3328->1727|3429->1801|3441->1804|3471->1813|3592->1907|3640->1939|3679->1940|3728->1961|3923->2128|3950->2133|3980->2134|4039->2162|4085->2180|4159->2223|4232->2268|4346->2351|4369->2357|4381->2362|4419->2363|4450->2367|4506->2393|4538->2398
                  LINES: 27->1|32->1|33->2|34->3|34->3|34->3|36->5|36->5|36->5|38->7|38->7|38->7|39->8|39->8|39->8|40->9|42->11|42->11|57->26|57->26|57->26|58->27|59->28|59->28|59->28|60->29|60->29|60->29|62->31|62->31|62->31|63->32|63->32|63->32|63->32|64->33|65->34|67->36|70->39|75->44|77->46|77->46|77->46|78->47|79->48|81->50
                  -- GENERATED --
              */
          