
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

object issuesstats extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[ArrayList[Integer],ArrayList[String],Map[String, Integer],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(details:ArrayList[Integer],keys:ArrayList[String],stats:Map[String,Integer]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.79*/("""

"""),format.raw/*3.1*/("""<section style=" margin: 0;background: linear-gradient(45deg, #7ab1af, #aea7ec);font-family: sans-serif;font-weight: 100; padding-bottom: 40px">
  <div class="header" style="padding: 30px;
	  text-align: center;
	  background: #1abc9c;
	  color: white;
	  font-size: 30px;">
    
  		<h3> <b><u>Word Level Statistics 📝</u> </b></h3>

		  <div class="container" style="display: flex;justify-content: center; ">
			<div style="padding: 5px;margin: 20px;background-color: #dee2e1;;border-radius: 5px;">
			  <table style="
				border-collapse: collapse;
				box-shadow: 0 0 20px rgba(0,0,0,0.1);">
				
				  <tbody style="background-color: #dee2e1; text-align: center;">
					
				
					<tr style="height: 50px ">
					  <td style="background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Total Words: </td>
					  <td style="background-color: #dee2e1;width: 200px;"><b>"""),_display_(/*23.64*/details/*23.71*/.get(0)),format.raw/*23.78*/(""" """),format.raw/*23.79*/("""</b></td>

					  <td style="background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Total Words Repeated: </td>
					  <td style="background-color: #dee2e1;width: 200px;">"""),_display_(/*26.61*/details/*26.68*/.get(1)),format.raw/*26.75*/("""</td>

					  <td style="background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Total Character: 📑 </td>
					  <td style="background-color: #dee2e1;width: 200px;"><b style="">"""),_display_(/*29.73*/details/*29.80*/.get(2)),format.raw/*29.87*/("""</b></td>
					
					</tr>

					<tr style="height: 50px ">
						<td style="background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Unique words: </td>
						<td style="background-color: #dee2e1;width: 200px;">"""),_display_(/*35.60*/details/*35.67*/.get(3)),format.raw/*35.74*/("""</td>
  
						<td style="background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Maximum Word's Frequency :</td>
						<td style="background-color: #dee2e1; width: 200px;">"""),_display_(/*38.61*/details/*38.68*/.get(4)),format.raw/*38.75*/("""</td>

						<td style="background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Minimum Word's Frequency :   </td>
						<td style="background-color: #dee2e1; width: 200px;">"""),_display_(/*41.61*/details/*41.68*/.get(5)),format.raw/*41.75*/("""</td>
					  </tr> 

					 
				  </tbody> 
				</table>
	

			</div>

		</div>
     <div class="container" style="display: flex;justify-content: center; ">
      <div style="padding: 0px 40px 40px 40px;margin: 20px;background-color: rgb(211, 211, 211);border-radius: 5px;">
        <table style="width:800px;
          border-collapse: collapse;
          border: 1px solid #ddd;
          box-shadow: 0 0 20px rgba(0,0,0,0.1);">
            <thead style="background-color: #42a386; padding: 10px; height:50px ;">
			<tr>
				<th style="border: 1px solid rgb(211, 211, 211);">Word</th>
				<th  style="border: 1px solid rgb(211, 211, 211);">Count</th>	
				</tr>
			</thead>	
			  <tbody style="background-color: #dee2e1; text-align: center;">
				"""),_display_(/*65.6*/for(key<-keys) yield /*65.20*/{_display_(Seq[Any](format.raw/*65.21*/("""
					"""),format.raw/*66.6*/("""<tr style="height: 50px ">									
						<td style="border: 1px solid rgb(104, 207, 164);background-color: #dee2e1; padding: 30px;">"""),_display_(/*67.99*/key),format.raw/*67.102*/("""</td>

						<td style="border: 1px solid rgb(104, 207, 164);background-color: #dee2e1; padding: 30px;">"""),_display_(/*69.99*/stats/*69.104*/.get(key)),format.raw/*69.113*/("""</td>						
					</tr>				
				""")))}),format.raw/*71.6*/("""			  
			  """),format.raw/*72.6*/("""</tbody> 
			</table>
			</div>
		</div>
	  <button style="display: none;
	  position: fixed;
	  bottom: 20px;
	  right: 30px;
	  z-index: 99;
	  font-size: 15px;
	  border: none;
	  outline: none;
	  background-color: rgb(15, 43, 80);
	  color: rgb(247, 247, 247);
	  cursor: pointer;
	  padding: 10px;" onclick="topFunction()" id="myBtn" title="Go to top"> ⬆ Back to Display</button>

	<button style="display: block;
	position: fixed;
	top: 20px;
	left: 30px;
	z-index: 99;
	font-size: 15px;
	border: none;
	outline: none;
	background-color: rgb(218, 218, 218);
	color: rgb(7, 75, 18) ;
	cursor: pointer;
	padding: 5px;" onclick="window.location.href='/'" title="Go Back"> ⬅ Back to Home pg </button>

  
</section>
<script>
	//Get the button
	var mybutton = document.getElementById("myBtn");
	
	// When the user scrolls down 20px from the top of the document, show the button
	window.onscroll = function() """),format.raw/*109.31*/("""{"""),format.raw/*109.32*/("""scrollFunction()"""),format.raw/*109.48*/("""}"""),format.raw/*109.49*/(""";
	
	function scrollFunction() """),format.raw/*111.28*/("""{"""),format.raw/*111.29*/("""
	  """),format.raw/*112.4*/("""if (document.body.scrollTop > 150 || document.documentElement.scrollTop > 150) """),format.raw/*112.83*/("""{"""),format.raw/*112.84*/("""
		"""),format.raw/*113.3*/("""mybutton.style.display = "block";
	  """),format.raw/*114.4*/("""}"""),format.raw/*114.5*/(""" """),format.raw/*114.6*/("""else """),format.raw/*114.11*/("""{"""),format.raw/*114.12*/("""
		"""),format.raw/*115.3*/("""mybutton.style.display = "none";
	  """),format.raw/*116.4*/("""}"""),format.raw/*116.5*/("""
	"""),format.raw/*117.2*/("""}"""),format.raw/*117.3*/("""
	
	"""),format.raw/*119.2*/("""// When the user clicks on the button, scroll to the top of the document
	function topFunction() """),format.raw/*120.25*/("""{"""),format.raw/*120.26*/("""
	  """),format.raw/*121.4*/("""document.body.scrollTop = 0;
	  document.documentElement.scrollTop = 0;
	"""),format.raw/*123.2*/("""}"""),format.raw/*123.3*/("""
	"""),format.raw/*124.2*/("""</script>"""))
      }
    }
  }

  def render(details:ArrayList[Integer],keys:ArrayList[String],stats:Map[String, Integer]): play.twirl.api.HtmlFormat.Appendable = apply(details,keys,stats)

  def f:((ArrayList[Integer],ArrayList[String],Map[String, Integer]) => play.twirl.api.HtmlFormat.Appendable) = (details,keys,stats) => apply(details,keys,stats)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/issuesstats.scala.html
                  HASH: e729ebdccc2c4c01252a243e4fabe63c8c0240c3
                  MATRIX: 964->1|1136->78|1166->82|2091->980|2107->987|2135->994|2164->995|2376->1180|2392->1187|2420->1194|2638->1385|2654->1392|2682->1399|2936->1626|2952->1633|2980->1640|3193->1826|3209->1833|3237->1840|3451->2027|3467->2034|3495->2041|4295->2815|4325->2829|4364->2830|4398->2837|4560->2972|4585->2975|4719->3082|4734->3087|4765->3096|4829->3130|4868->3142|5843->4088|5873->4089|5918->4105|5948->4106|6010->4139|6040->4140|6073->4145|6181->4224|6211->4225|6243->4229|6309->4267|6338->4268|6367->4269|6401->4274|6431->4275|6463->4279|6528->4316|6557->4317|6588->4320|6617->4321|6651->4327|6778->4425|6808->4426|6841->4431|6944->4506|6973->4507|7004->4510
                  LINES: 27->1|32->1|34->3|54->23|54->23|54->23|54->23|57->26|57->26|57->26|60->29|60->29|60->29|66->35|66->35|66->35|69->38|69->38|69->38|72->41|72->41|72->41|96->65|96->65|96->65|97->66|98->67|98->67|100->69|100->69|100->69|102->71|103->72|140->109|140->109|140->109|140->109|142->111|142->111|143->112|143->112|143->112|144->113|145->114|145->114|145->114|145->114|145->114|146->115|147->116|147->116|148->117|148->117|150->119|151->120|151->120|152->121|154->123|154->123|155->124
                  -- GENERATED --
              */
          