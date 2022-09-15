
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[LinkedHashMap[String, ArrayList[Models.GithubResult]],List[String],play.mvc.Http.Request,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(results: LinkedHashMap[String, ArrayList[Models.GithubResult]], keys: List[String], request: play.mvc.Http.Request):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.118*/("""
	"""),format.raw/*2.2*/("""<script type='text/javascript' src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
	<script type='text/javascript' src='"""),_display_(/*3.39*/routes/*3.45*/.Assets.versioned("javascripts/index.js")),format.raw/*3.86*/("""'></script>  


<section data-ws-url=""""),_display_(/*6.24*/routes/*6.30*/.HomeController.ws.webSocketURL(request)),format.raw/*6.70*/("""" style=" margin: 0;background: linear-gradient(45deg, #7ab1af, #aea7ec);font-family: sans-serif;font-weight: 100; padding-bottom: 40px">
  <div class="header">
    
      <div style="border:dotted 0.1px white;text-align:center">
      		
      		<h1 style="font-size: 50px;" ><span style=" font-size: 50px; font-family: Georgia;">Gitterific</span> </h1>
      		<form name="search" id="form" action="/" method="GET">
	      	<input style="text-align: left;margin: 0 px 10px;padding: 15px; font-size: 20px;" id="user" name="search" type="text" placeholder="enter name">
	      	<button style="background-color: #42a386;
          border: none;
          color: white;
          padding: 17px 25px;
          text-align: center;
          text-decoration: none;
          display: inline-block;
          font-size: 16px;
          margin: 4px 2px;
          cursor: pointer;" type="submit">Search</button>
	      	</form>
      </div>
      
  </div>
  
  
  """),_display_(/*30.4*/if(!results.isEmpty())/*30.26*/ {_display_(Seq[Any](format.raw/*30.28*/("""
  """),format.raw/*31.3*/("""<h5 style="margin-left: 25px;">Showing """),_display_(/*31.43*/keys/*31.47*/.size()),format.raw/*31.54*/(""" """),format.raw/*31.55*/("""Results</h5>

  	
      """),_display_(/*34.8*/for(key <- keys) yield /*34.24*/{_display_(Seq[Any](format.raw/*34.25*/("""
      """),format.raw/*35.7*/("""<div class="container" style="display: flex;justify-content: center; ">
      <div style="padding: 0px 40px 40px 40px;margin: 20px;background-color: rgb(211, 211, 211);border-radius: 5px;">
       <center> <span>Showing Results of <h1 style="display:inline-block;margin-left: 10px;">"""),_display_(/*37.95*/key),format.raw/*37.98*/("""</h1> </span></center>
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
              
              """),_display_(/*52.16*/for(obj <- results.get(key) ) yield /*52.45*/{_display_(Seq[Any](format.raw/*52.46*/("""
                """),format.raw/*53.17*/("""<tr style="height: 50px ">
                <td id="Owner"""),_display_(/*54.31*/obj/*54.34*/.repoID),format.raw/*54.41*/("""" style="border: 1px solid rgb(104, 207, 164);"><a href="/user/"""),_display_(/*54.105*/obj/*54.108*/.ownerName),format.raw/*54.118*/("""">"""),_display_(/*54.121*/obj/*54.124*/.ownerName),format.raw/*54.134*/("""</a></td>
                <td  id="Name"""),_display_(/*55.31*/obj/*55.34*/.repoID),format.raw/*55.41*/("""" style="border: 1px solid rgb(104, 207, 164);"><a href="/repo/"""),_display_(/*55.105*/obj/*55.108*/.queryString),format.raw/*55.120*/("""/"""),_display_(/*55.122*/obj/*55.125*/.repoID),format.raw/*55.132*/("""">"""),_display_(/*55.135*/obj/*55.138*/.repoName),format.raw/*55.147*/("""</a></td>
                <td id="Topics"""),_display_(/*56.32*/obj/*56.35*/.repoID),format.raw/*56.42*/("""" style="border: 1px solid rgb(104, 207, 164);">
                  """),_display_(/*57.20*/for(topic <- obj.returnTopics()) yield /*57.52*/{_display_(Seq[Any](format.raw/*57.53*/("""
                   """),format.raw/*58.20*/("""<div style="display: inline-block;background-color: #0b7e5b;color: #dee2e1; border-radius:6px; padding: 4px; margin-right: 3px; margin-top: 3px;margin-bottom: 3px;"><a style="color :#dee2e1;" href="/topic/"""),_display_(/*58.226*/topic),format.raw/*58.231*/(""""> """),_display_(/*58.235*/topic),format.raw/*58.240*/("""</a> </div> 
                  """)))}),format.raw/*59.20*/("""
                """),format.raw/*60.17*/("""</td>
              </tr>
              """)))}),format.raw/*62.16*/("""
               
            
            """),format.raw/*65.13*/("""</tbody> 
          </table>
        </div>
         </div>
        
        """)))}),format.raw/*70.10*/("""

""")))}),format.raw/*72.2*/("""

"""),format.raw/*74.1*/("""</section>
<script>
  
  

  (function() """),format.raw/*79.15*/("""{"""),format.raw/*79.16*/("""
  """),format.raw/*80.3*/("""$(function() """),format.raw/*80.16*/("""{"""),format.raw/*80.17*/("""
    """),format.raw/*81.5*/("""var ws;
    console.log("Inside Custom Script");
    ws = new WebSocket($("section").data("ws-url"));
    return ws.onmessage = function(event) """),format.raw/*84.43*/("""{"""),format.raw/*84.44*/("""
      """),format.raw/*85.7*/("""var message;
      message = JSON.parse(event.data);
      if(message.status == "No-Change")"""),format.raw/*87.40*/("""{"""),format.raw/*87.41*/("""
        """),format.raw/*88.9*/("""console.log("No Change from last Update!");
        $('#time').append(message.status + "<br/>");
      """),format.raw/*90.7*/("""}"""),format.raw/*90.8*/("""else"""),format.raw/*90.12*/("""{"""),format.raw/*90.13*/("""
        """),format.raw/*91.9*/("""console.log(message.value);   
        var allChanges = JSON.parse(message.value);
        console.log("Updating "+ message.status + "Repositories" );
        for(var i =0; i< parseInt(message.status); i++)"""),format.raw/*94.56*/("""{"""),format.raw/*94.57*/("""                    
             """),format.raw/*95.14*/("""var githubResult = allChanges[i];
             console.log(githubResult);
             $("#Owner"+ githubResult.repoToChange).html("<a href='/user/"+ githubResult.ownerName + "'>"+ githubResult.ownerName+"</a>");
             $("#Name"+ githubResult.repoToChange).html("<a href='/repo/"+ githubResult.queryString+"/"+ githubResult.repoID +"'>" + githubResult.repoName+ "</a>");
             var data= '';
             var topics= githubResult.topics.substring(1, githubResult.topics.length-1).split(",");
             console.log("Topics :: "+topics+ " : " +topics.length);
             if(topics.length>1)"""),format.raw/*102.33*/("""{"""),format.raw/*102.34*/("""
              """),format.raw/*103.15*/("""console.log("Topics :: " +topics[4]);
               for(var j=0; j<topics.length; j++)"""),format.raw/*104.50*/("""{"""),format.raw/*104.51*/("""
                  """),format.raw/*105.19*/("""data += "<div style='display: inline-block;background-color: #0b7e5b;color: #dee2e1; border-radius:6px; padding: 4px; margin-right: 3px; margin-top: 3px;margin-bottom: 3px;'><a style='color :#dee2e1;' href='/topic/" + topics[j] + "'> " + topics[j] + "</a> </div> ";
               """),format.raw/*106.16*/("""}"""),format.raw/*106.17*/("""
               """),format.raw/*107.16*/("""$("#Topics"+ githubResult.repoToChange).html(data);
             """),format.raw/*108.14*/("""}"""),format.raw/*108.15*/("""
        """),format.raw/*109.9*/("""}"""),format.raw/*109.10*/("""
      """),format.raw/*110.7*/("""}"""),format.raw/*110.8*/("""
    """),format.raw/*111.5*/("""}"""),format.raw/*111.6*/(""";
  """),format.raw/*112.3*/("""}"""),format.raw/*112.4*/(""");

"""),format.raw/*114.1*/("""}"""),format.raw/*114.2*/(""").call(this);


</script>

"""))
      }
    }
  }

  def render(results:LinkedHashMap[String, ArrayList[Models.GithubResult]],keys:List[String],request:play.mvc.Http.Request): play.twirl.api.HtmlFormat.Appendable = apply(results,keys,request)

  def f:((LinkedHashMap[String, ArrayList[Models.GithubResult]],List[String],play.mvc.Http.Request) => play.twirl.api.HtmlFormat.Appendable) = (results,keys,request) => apply(results,keys,request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: 7e35748df8f45fefc33a04fc7a0ef117e7129564
                  MATRIX: 989->1|1201->117|1230->120|1386->250|1400->256|1461->297|1529->339|1543->345|1603->385|2613->1369|2644->1391|2684->1393|2715->1397|2782->1437|2795->1441|2823->1448|2852->1449|2906->1477|2938->1493|2977->1494|3012->1502|3325->1788|3349->1791|4059->2474|4104->2503|4143->2504|4189->2522|4274->2580|4286->2583|4314->2590|4406->2654|4419->2657|4451->2667|4482->2670|4495->2673|4527->2683|4595->2724|4607->2727|4635->2734|4727->2798|4740->2801|4774->2813|4804->2815|4817->2818|4846->2825|4877->2828|4890->2831|4921->2840|4990->2882|5002->2885|5030->2892|5126->2961|5174->2993|5213->2994|5262->3015|5496->3221|5523->3226|5555->3230|5582->3235|5646->3268|5692->3286|5766->3329|5839->3374|5953->3457|5988->3462|6019->3466|6093->3512|6122->3513|6153->3517|6194->3530|6223->3531|6256->3537|6431->3684|6460->3685|6495->3693|6617->3787|6646->3788|6683->3798|6815->3903|6843->3904|6875->3908|6904->3909|6941->3919|7178->4128|7207->4129|7270->4164|7912->4777|7942->4778|7987->4794|8104->4882|8134->4883|8183->4903|8494->5185|8524->5186|8570->5203|8665->5269|8695->5270|8733->5280|8763->5281|8799->5289|8828->5290|8862->5296|8891->5297|8924->5302|8953->5303|8987->5309|9016->5310
                  LINES: 27->1|32->1|33->2|34->3|34->3|34->3|37->6|37->6|37->6|61->30|61->30|61->30|62->31|62->31|62->31|62->31|62->31|65->34|65->34|65->34|66->35|68->37|68->37|83->52|83->52|83->52|84->53|85->54|85->54|85->54|85->54|85->54|85->54|85->54|85->54|85->54|86->55|86->55|86->55|86->55|86->55|86->55|86->55|86->55|86->55|86->55|86->55|86->55|87->56|87->56|87->56|88->57|88->57|88->57|89->58|89->58|89->58|89->58|89->58|90->59|91->60|93->62|96->65|101->70|103->72|105->74|110->79|110->79|111->80|111->80|111->80|112->81|115->84|115->84|116->85|118->87|118->87|119->88|121->90|121->90|121->90|121->90|122->91|125->94|125->94|126->95|133->102|133->102|134->103|135->104|135->104|136->105|137->106|137->106|138->107|139->108|139->108|140->109|140->109|141->110|141->110|142->111|142->111|143->112|143->112|145->114|145->114
                  -- GENERATED --
              */
          