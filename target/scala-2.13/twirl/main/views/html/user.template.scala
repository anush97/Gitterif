
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

object user extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[HashMap[String, ArrayList[Models.GithubResult]],List[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(results: HashMap[String, ArrayList[Models.GithubResult]], keys: List[String]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.80*/("""

"""),format.raw/*3.1*/("""<section style=" margin: 0;background: linear-gradient(45deg, #7ab1af, #aea7ec);font-family: sans-serif;font-weight: 100; padding-bottom: 40px">
  <h1 style="text-align: center; font-size: 50px;">Details of owner Repositories</h1> 
  """),_display_(/*5.4*/if(!results.isEmpty())/*5.26*/ {_display_(Seq[Any](format.raw/*5.28*/("""    	
      """),_display_(/*6.8*/for(key <- keys) yield /*6.24*/{_display_(Seq[Any](format.raw/*6.25*/("""
      """),format.raw/*7.7*/("""<div class="container" style="display: flex;justify-content: center; ">
      <div style="padding: 0px 40px 40px 40px;margin: 20px;background-color: rgb(211, 211, 211);border-radius: 5px;">
       <center> <span>Showing results for the topic: <h1 style="display:inline-block;margin-left: 10px;">"""),_display_(/*9.107*/key),format.raw/*9.110*/("""</h1> </span></center>
        <table style="width:800px;
          border-collapse: collapse;
          border: 1px solid #ddd;
          box-shadow: 0 0 20px rgba(0,0,0,0.1);">
            <thead style="background-color: #42a386; padding: 10px; height:50px ;">
      
              <div style="border: 1px solid rgb(104, 207, 164); text-align: center;"><span style=" font-size: 40px; margin-right: 100px;">User - """),_display_(/*16.147*/key),format.raw/*16.150*/("""</span><img src=""""),_display_(/*16.168*/results/*16.175*/.get(key)/*16.184*/(0)/*16.187*/.ownerName),format.raw/*16.197*/("""" alt="Avatar" width="100" height="100"></div>
      
              <tr>
                
                <th style="border: 1px solid rgb(211, 211, 211);">Repositories</th>
                <th style="border: 1px solid rgb(211, 211, 211);">Description</th>
                <th style="border: 1px solid rgb(211, 211, 211);">Repo Topics</th>
                
              </tr>
            </thead>
            <tbody style="background-color: #dee2e1; text-align: center;">
              
              """),_display_(/*28.16*/for(obj <- results.get(key) ) yield /*28.45*/{_display_(Seq[Any](format.raw/*28.46*/("""
              """),format.raw/*29.15*/("""<tr style="height: 50px ">
                <td style="border: 1px solid rgb(104, 207, 164);"><a href="/">"""),_display_(/*30.80*/obj/*30.83*/.repoName),format.raw/*30.92*/("""</a></td>
                <td style="border: 1px solid rgb(104, 207, 164);">"""),_display_(/*31.68*/obj/*31.71*/.repoID),format.raw/*31.78*/("""</td>
                <td style="border: 1px solid rgb(104, 207, 164);">
                  """),_display_(/*33.20*/for(topic <- obj.returnTopics()) yield /*33.52*/{_display_(Seq[Any](format.raw/*33.53*/("""
                   """),format.raw/*34.20*/("""<div style="display: inline-block;background-color: #0b7e5b;color: #dee2e1; border-radius:6px; padding: 3px; margin-right: 3px; margin-top: 3px;margin-bottom: 3px;"> """),_display_(/*34.187*/topic),format.raw/*34.192*/(""" """),format.raw/*34.193*/("""</div> 
                  """)))}),format.raw/*35.20*/("""
                """),format.raw/*36.17*/("""</td>
              </tr>
              """)))}),format.raw/*38.16*/("""
               
            
            """),format.raw/*41.13*/("""</tbody> 
          </table>
        </div>
         </div>
        
        """)))}),format.raw/*46.10*/("""

""")))}/*48.3*/else/*48.8*/{_display_(Seq[Any](format.raw/*48.9*/("""
  """),format.raw/*49.3*/("""<h1>Not Displaying</h1>
""")))}),format.raw/*50.2*/("""
  
"""),format.raw/*52.1*/("""</section>
"""))
      }
    }
  }

  def render(results:HashMap[String, ArrayList[Models.GithubResult]],keys:List[String]): play.twirl.api.HtmlFormat.Appendable = apply(results,keys)

  def f:((HashMap[String, ArrayList[Models.GithubResult]],List[String]) => play.twirl.api.HtmlFormat.Appendable) = (results,keys) => apply(results,keys)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/user.scala.html
                  HASH: 8693c5424f8d1a4d4c79180f3a9e7f01d2793ee3
                  MATRIX: 960->1|1133->79|1163->83|1425->320|1455->342|1494->344|1533->358|1564->374|1602->375|1636->383|1961->681|1985->684|2436->1107|2461->1110|2507->1128|2524->1135|2543->1144|2556->1147|2588->1157|3130->1672|3175->1701|3214->1702|3258->1718|3392->1825|3404->1828|3434->1837|3539->1915|3551->1918|3579->1925|3700->2019|3748->2051|3787->2052|3836->2073|4031->2240|4058->2245|4088->2246|4147->2274|4193->2292|4267->2335|4340->2380|4454->2463|4477->2469|4489->2474|4527->2475|4558->2479|4614->2505|4647->2511
                  LINES: 27->1|32->1|34->3|36->5|36->5|36->5|37->6|37->6|37->6|38->7|40->9|40->9|47->16|47->16|47->16|47->16|47->16|47->16|47->16|59->28|59->28|59->28|60->29|61->30|61->30|61->30|62->31|62->31|62->31|64->33|64->33|64->33|65->34|65->34|65->34|65->34|66->35|67->36|69->38|72->41|77->46|79->48|79->48|79->48|80->49|81->50|83->52
                  -- GENERATED --
              */
          