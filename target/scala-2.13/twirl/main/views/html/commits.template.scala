
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

object commits extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Models.CommitsResult,List[String],Map[String, Integer],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(results: Models.CommitsResult, keys: List[String], commitData: Map[String, Integer]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.87*/("""

"""),format.raw/*3.1*/("""<section style=" margin: 0;background: linear-gradient(45deg, #7ab1af, #aea7ec);font-family: sans-serif;font-weight: 100; padding-bottom: 40px">
  <div class="header" style="padding: 30px;
	  text-align: center;
	  background: #1abc9c;
	  color: white;
	  font-size: 30px;">
    
  		<h2> Repository Commit Statistics</h2>
	</div>
		  <div class="container" style="display: flex;justify-content: center; ">
			<div style="padding: 5px;margin: 20px;background-color:color:rgb(18, 105, 69);border-radius: 5px;">
			  <table style="
				border-collapse: collapse;
				box-shadow: 0 0 20px rgba(0,0,0,0.1);">
				  
				  <tbody style="background-color: #dee2e1; text-align: center;">
					<tr style="height: 50px ;border: 1px solid rgb(20, 107, 71);">
						<td style="background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Maximum no.of additions </td>
						<td style="background-color: #dee2e1;width: 200px;">"""),_display_(/*21.60*/results/*21.67*/.maxAdd),format.raw/*21.74*/("""</td>
  					</tr> 
  					<tr   style="height: 50px ;border: 1px solid rgb(20, 107, 71);">
						<td style="background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Minimum no.of additions</td>
						<td style="background-color: #dee2e1; width: 200px;">"""),_display_(/*25.61*/results/*25.68*/.minAdd),format.raw/*25.75*/("""</td>
					</tr>
					<tr  style="height: 50px ;border: 1px solid rgb(20, 107, 71);">
						<td style="background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Average no.of additions </td>
						<td style="background-color: #dee2e1;width: 200px;">"""),_display_(/*29.60*/results/*29.67*/.avgAdd),format.raw/*29.74*/("""</td>
					 </tr> 

					  <tr  style="height: 50px ;border: 1px solid rgb(20, 107, 71);">
						<td style="background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Maximum no.of deletions</td>
						<td style="background-color: #dee2e1;width: 200px;">"""),_display_(/*34.60*/results/*34.67*/.maxDel),format.raw/*34.74*/("""</td>
  					  </tr>
  					   <tr  style="height: 50px ;border: 1px solid rgb(20, 107, 71);">
						<td style="background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Minumum no.of deletions</td>
						<td style="background-color: #dee2e1; width: 200px;">"""),_display_(/*38.61*/results/*38.68*/.minDel),format.raw/*38.75*/("""</td>
						</tr>
						<tr  style="height: 50px ;border: 1px solid rgb(20, 107, 71);">
						<td style="background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Average no.of deletions</td>
						<td style="background-color: #dee2e1;width: 200px;">"""),_display_(/*42.60*/results/*42.67*/.avgDel),format.raw/*42.74*/("""</td>
					  </tr> 

 
				  </tbody> 
				</table>
			</div>

	
	
	 
    
      <div style="padding: 0px 40px 40px 40px;margin: 20px;background-color: rgb(211, 211, 211);border-radius: 5px;">
    <center>   <h3 style="margin-left: 25px; color:rgb(18, 105, 69);">Showing Top """),_display_(/*55.84*/keys/*55.88*/.size()),format.raw/*55.95*/(""" """),format.raw/*55.96*/("""users with highest no.of commits</h3> </center>
        <table style="width:800px;
          border-collapse: collapse;
          border: 1px solid #ddd;
          box-shadow: 0 0 20px rgba(0,0,0,0.1);">
            <thead style="background-color: #42a386; padding: 10px; height:50px ;">
              <tr>
                <th style="border: 1px solid rgb(211, 211, 211);">User name</th>
                <th  style="border: 1px solid rgb(211, 211, 211);">Commits count</th>
				<th  style="border: 1px solid rgb(211, 211, 211);">User profile link</th>
              </tr>
            </thead>
            <tbody style="background-color: #dee2e1; text-align: center;">
              
             """),_display_(/*69.15*/for(key<-keys) yield /*69.29*/{_display_(Seq[Any](format.raw/*69.30*/("""
					"""),format.raw/*70.6*/("""<tr style="height: 50px ">									
						<td style="border: 1px solid rgb(104, 207, 164);background-color: #dee2e1; padding: 30px;">"""),_display_(/*71.99*/key),format.raw/*71.102*/("""</td>
						<td style="border: 1px solid rgb(104, 207, 164);background-color: #dee2e1; padding: 30px;">"""),_display_(/*72.99*/commitData/*72.109*/.get(key)),format.raw/*72.118*/("""</td>	
						<td style="border: 1px solid rgb(104, 207, 164);background-color: #dee2e1; padding: 30px;"><a href='/user/"""),_display_(/*73.114*/key),format.raw/*73.117*/("""'>"""),_display_(/*73.120*/key),format.raw/*73.123*/("""</td>					
					</tr>				
				""")))}),format.raw/*75.6*/("""
               
            
            """),format.raw/*78.13*/("""</tbody> 
          </table>
        </div>
         </div>
	
		
</section>

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
	padding: 5px;" onclick="history.back()" title="Go Back"> ⬅ Back </button>
"""))
      }
    }
  }

  def render(results:Models.CommitsResult,keys:List[String],commitData:Map[String, Integer]): play.twirl.api.HtmlFormat.Appendable = apply(results,keys,commitData)

  def f:((Models.CommitsResult,List[String],Map[String, Integer]) => play.twirl.api.HtmlFormat.Appendable) = (results,keys,commitData) => apply(results,keys,commitData)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/commits.scala.html
                  HASH: 3c432fbfffeb026f3bad6da7e83c52486c52bb67
                  MATRIX: 957->1|1137->86|1167->90|2132->1028|2148->1035|2176->1042|2470->1309|2486->1316|2514->1323|2802->1584|2818->1591|2846->1598|3139->1864|3155->1871|3183->1878|3480->2148|3496->2155|3524->2162|3813->2424|3829->2431|3857->2438|4173->2727|4186->2731|4214->2738|4243->2739|4981->3450|5011->3464|5050->3465|5084->3472|5246->3607|5271->3610|5403->3715|5423->3725|5454->3734|5603->3855|5628->3858|5659->3861|5684->3864|5747->3897|5820->3942
                  LINES: 27->1|32->1|34->3|52->21|52->21|52->21|56->25|56->25|56->25|60->29|60->29|60->29|65->34|65->34|65->34|69->38|69->38|69->38|73->42|73->42|73->42|86->55|86->55|86->55|86->55|100->69|100->69|100->69|101->70|102->71|102->71|103->72|103->72|103->72|104->73|104->73|104->73|104->73|106->75|109->78
                  -- GENERATED --
              */
          