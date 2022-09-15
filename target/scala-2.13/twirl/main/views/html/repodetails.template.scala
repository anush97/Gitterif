
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

object repodetails extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Models.RepositoryProfile,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(Details: Models.RepositoryProfile):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.37*/("""

"""),format.raw/*3.1*/("""<head>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<section style=" margin: 0;background: linear-gradient(45deg, #7ab1af, #aea7ec);font-family: sans-serif;font-weight: 100; padding-bottom: 40px">
  <div class="header" style="padding: 30px;
	  text-align: center;
	  background: #1abc9c;
	  color: white;
	  font-size: 30px;">
    
  		<h2> Repository Details : <b>"""),_display_(/*14.35*/Details/*14.42*/.repoName),format.raw/*14.51*/("""</b></h2>

		  <div class="container" style="display: flex;justify-content: center; ">
			<div style="padding: 5px;margin: 20px;background-color: #dee2e1;;border-radius: 5px;">
			  <table style="
				border-collapse: collapse;
				box-shadow: 0 0 20px rgba(0,0,0,0.1);">
				 <!-- <thead style="background-color: #42a386; padding: 10px; height:50px ;">
					<tr>
					  <th style="border: 1px solid rgb(211, 211, 211);">Owner</th>
					  <th  style="border: 1px solid rgb(211, 211, 211);">Repository</th>
					  <th  style="border: 1px solid rgb(211, 211, 211);">Topics</th>
	  
					</tr>
				  </thead>  -->
				  <tbody style="background-color: #dee2e1; text-align: center;">
					
				
					<tr style="height: 50px ">
					  <td style="background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Repository Name 📂 </td>
					  <td style="background-color: #dee2e1;width: 200px;"><b >"""),_display_(/*34.65*/Details/*34.72*/.repoName),format.raw/*34.81*/(""" """),format.raw/*34.82*/("""</b></td>

					  <td style="background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Repository Owner 👨‍💻 </td>
					  <td style="background-color: #dee2e1;width: 200px;"><a href="/">"""),_display_(/*37.73*/Details/*37.80*/.ownerName),format.raw/*37.90*/("""</a></td>

					  <td style="background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Language 📑 </td>
					  <td style="background-color: #dee2e1;width: 200px;"><b style="">"""),_display_(/*40.73*/Details/*40.80*/.language),format.raw/*40.89*/("""</b></td>
					
					</tr>

					<tr style="height: 50px ">
						<td style="background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Open issues 📝 </td>
						<td style="background-color: #dee2e1;width: 200px;">"""),_display_(/*46.60*/Details/*46.67*/.issuesCount),format.raw/*46.79*/("""</td>
  
						<td style="background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Creation Date 📅 </td>
						<td style="background-color: #dee2e1; width: 200px;">"""),_display_(/*49.61*/Details/*49.68*/.created),format.raw/*49.76*/("""</td>

						<td style="background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Size 📦  </td>
						<td style="background-color: #dee2e1; width: 200px;">"""),_display_(/*52.61*/Details/*52.68*/.size),format.raw/*52.73*/(""" """),format.raw/*52.74*/("""<span>MB</span></td>
					  </tr> 

					  <tr style="height: 50px ">
						<td style="background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Star Count ⭐ </td>
						<td style="background-color: #dee2e1; width: 200px;">"""),_display_(/*57.61*/Details/*57.68*/.stars),format.raw/*57.74*/("""</td>

						<td style="background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Watch Count 👁‍🗨 </td>
						<td style="background-color: #dee2e1; width: 200px;">"""),_display_(/*60.61*/Details/*60.68*/.watch),format.raw/*60.74*/("""</td>

						<td style="background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Forks 📩 </td>
						<td style="background-color: #dee2e1; width: 200px;">"""),_display_(/*63.61*/Details/*63.68*/.watch),format.raw/*63.74*/("""</td>
					  </tr> 

 
				  </tbody> 
				</table>

				<table style="
				border-collapse: collapse;
				border: 1px solid #ddd;
				box-shadow: 0 0 20px rgba(0,0,0,0.1);">

				  	<tbody style="background-color: #dee2e1; text-align: center;">

						<tr style="height: 50px ">
							<td style="border: 1px solid rgb(20, 107, 71);background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Description 💭 </td>
							<td style="background-color: #dee2e1;width :80%;">"""),_display_(/*79.59*/Details/*79.66*/.description),format.raw/*79.78*/("""</td>
						</tr> 

					</tbody>
				</table>

				<table style="
				border-collapse: collapse;
				border: 1px solid #ddd;
				box-shadow: 0 0 20px rgba(0,0,0,0.1);">

				  	<tbody style="background-color: #dee2e1; text-align: center;">

						<tr style="height: 50px ">

							<td style="border: 1px solid rgb(20, 107, 71);background-color: rgb(20, 107, 71);color: #dee2e1;width: 200px;">Topics 🪧</td>
							<td style="background-color: #dee2e1;width :80%;">
								"""),_display_(/*96.10*/for(topic <- Details.getTopicsList()) yield /*96.47*/{_display_(Seq[Any](format.raw/*96.48*/("""
									"""),format.raw/*97.10*/("""<div style="display: inline-block;background-color: #0b7e5b;color: #dee2e1; border-radius:6px; padding: 4px; margin-right: 3px; margin-top: 3px;margin-bottom: 3px;"> """),_display_(/*97.177*/topic),format.raw/*97.182*/(""" """),format.raw/*97.183*/("""</div> 
								""")))}),format.raw/*98.10*/("""
							"""),format.raw/*99.8*/("""</td>
						</tr> 

					</tbody>
				</table>

			

			</div>

		</div>
      

		<center>
			<button
			onclick="window.location.href='#Issues';"
			style="background-color: #641515;
			border: none;
			color: white;
			padding: 17px 25px;
			text-align: center;
			text-decoration: none;
			display: inline-block;
			font-size: 16px;
			margin: 4px 2px;
			cursor: pointer;" > Issues 📜 </button>
	
			<button
			onclick="window.location.href='#Collaborator';"
			style="background-color: #223779;
			border: none;
			color: white;
			padding: 17px 25px;
			text-align: center;
			text-decoration: none;
			display: inline-block;
			font-size: 16px;
			margin: 4px 2px;
			cursor: pointer;" > Collaborators 👨‍💻 </button>
			
			<button
			onclick="onCommitsClicked()"
			style="background-color: #075c4e;
			border: none;
			color: white;
			padding: 17px 25px;
			text-align: center;
			text-decoration: none;
			display: inline-block;
			font-size: 16px;
			margin: 4px 2px;
			cursor: pointer;" > Commits 📥 </button>
	
			<button
			onclick="window.location.href='"""),_display_(/*153.36*/Details/*153.43*/.repoLink),format.raw/*153.52*/("""';"
			 style="background-color: #b9411c;
			border: none;
			color: white;
			padding: 17px 25px;
			text-align: center;
			text-decoration: none;
			display: inline-block;
			font-size: 16px;
			margin: 4px 2px;
			cursor: pointer;" > Code 📄 </button>

			<button
			onclick="window.location.href='/statistics/';"
			style="background-color: #344147;
			border: none;
			color: white;
			padding: 17px 25px;
			text-align: center;
			text-decoration: none;
			display: inline-block;
			font-size: 16px;
			margin: 4px 2px;
			cursor: pointer;" > Issue Statistics 📊 </button>
	
		  </center>
		

 	 </div>
 	 <section id="CommitsLoading" style="display:none; margin: 0;font-family: sans-serif;font-weight: 100;">
 		<center> <h3> <i class="fa fa-spinner fa-spin"></i> Loading  </h3> </center>
 	 </section>


  
	  <div  id="Issues" class="container" style="display: flex;justify-content: center; ">
		<div style="padding: 10px;margin: 20px;background-color: rgb(211, 211, 211);border-radius: 5px;">

			<center> <h3>Showing  <span style=" font-size: 30px; color:rgb(18, 105, 69)">"""),_display_(/*191.82*/Details/*191.89*/.issueList.size()),format.raw/*191.106*/(""" """),format.raw/*191.107*/("""</span>  Latest issues </h3></center>
			
		  <table style="
			border-collapse: collapse;
			border: 1px solid #ddd;
			box-shadow: 0 0 20px rgba(0,0,0,0.1);">

			<thead style="background-color: #42a386; padding: 10px; height:50px ;">

				<tr>
				<th style="border: 1px solid rgb(211, 211, 211);">Issue Number</th>
				<th style="border: 1px solid rgb(211, 211, 211);">Issue Title</th>
				<th  style="border: 1px solid rgb(211, 211, 211);">Raised Time</th>	 
				<th  style="border: 1px solid rgb(211, 211, 211);">State</th>
					
				</tr>

			</thead>	
			    
			  <tbody style="background-color: #dee2e1; text-align: center;">
				
			
			

			
					"""),_display_(/*216.7*/for(issue <- Details.issueList) yield /*216.38*/{_display_(Seq[Any](format.raw/*216.39*/("""
					"""),format.raw/*217.6*/("""<tr style="height: 50px ">
						<td style="border: 1px solid rgb(104, 207, 164);background-color: #dee2e1; padding: 30px;">"""),_display_(/*218.99*/issue/*218.104*/.issueNumber),format.raw/*218.116*/("""</td>

						<td style="border: 1px solid rgb(104, 207, 164);background-color: #dee2e1; padding: 30px;">"""),_display_(/*220.99*/issue/*220.104*/.issueTitle),format.raw/*220.115*/("""</td>

						<td style="border: 1px solid rgb(104, 207, 164);background-color: #dee2e1; padding: 30px;">"""),_display_(/*222.99*/issue/*222.104*/.issueCreatedDate),format.raw/*222.121*/(""" """),format.raw/*222.122*/("""</td>

						<td style="border: 1px solid rgb(104, 207, 164);background-color: #dee2e1; padding: 10px; "><span style="color: """),_display_(/*224.120*/issue/*224.125*/.stateColor),format.raw/*224.136*/(""" """),format.raw/*224.137*/("""; font-size: 25px;">"""),_display_(/*224.158*/issue/*224.163*/.issueState),format.raw/*224.174*/("""</span></td>
					</tr> 
					""")))}),format.raw/*226.7*/("""
			
			  
			  """),format.raw/*229.6*/("""</tbody> 
			</table>
		 </div>
		</div>
		<div id="Collaborator" class="container" style="display: flex;justify-content: center; ">
		 <div style="padding: 10px;margin: 20px;background-color: rgb(211, 211, 211);border-radius: 5px;">

			<center> <h3>Collaborators</h3></center>
		  <table style="
			border-collapse: collapse;
			border: 1px solid #ddd;
			box-shadow: 0 0 20px rgba(0,0,0,0.1);">

			<thead style="background-color: #42a386; padding: 10px; height:50px ;">

				<tr>
				<th style="border: 1px solid rgb(211, 211, 211); padding: 20px;"></th>
				<th style="border: 1px solid rgb(211, 211, 211); padding: 20px;">Name</th>
				<th  style="border: 1px solid rgb(211, 211, 211); padding: 20px;">ID</th>	 
				<th  style="border: 1px solid rgb(211, 211, 211); padding: 20px;">Contribution Count</th>
				<th style="border: 1px solid rgb(211, 211, 211); padding: 20px;"> </th>
					
				</tr>

			</thead>	
			    
			  <tbody style="background-color: #dee2e1; text-align: center;">
				
			
			

			
					"""),_display_(/*261.7*/for(Collaborator <- Details.collabList) yield /*261.46*/{_display_(Seq[Any](format.raw/*261.47*/("""
					"""),format.raw/*262.6*/("""<tr style="height: 50px ">
						<td style="border: 1px solid rgb(104, 207, 164);background-color: #dee2e1;padding: 20px; "> <img src="""),_display_(/*263.109*/Collaborator/*263.121*/.ContributorAvatarURL),format.raw/*263.142*/(""" """),format.raw/*263.143*/("""alt="Avatar" width="100" height="100"></td>

						<td style="border: 1px solid rgb(104, 207, 164);background-color: #dee2e1; padding: 20px;">"""),_display_(/*265.99*/Collaborator/*265.111*/.ContributorName),format.raw/*265.127*/("""</td>

						<td style="border: 1px solid rgb(104, 207, 164);background-color: #dee2e1; padding: 20px;">"""),_display_(/*267.99*/Collaborator/*267.111*/.ContributorID),format.raw/*267.125*/(""" """),format.raw/*267.126*/("""</td>

						<td style="border: 1px solid rgb(104, 207, 164);background-color: #dee2e1; padding: 20px;">"""),_display_(/*269.99*/Collaborator/*269.111*/.ContributorContributions),format.raw/*269.136*/("""</td>

						<td style="border: 1px solid rgb(104, 207, 164);background-color: #dee2e1; padding: 20px;">
						
							<button
							onclick="window.location.href='/user/"""),_display_(/*274.46*/Collaborator/*274.58*/.ContributorName),format.raw/*274.74*/("""'"
							style="background-color: #ca1d65;
							border: none;
							color: white;
							padding: 17px 25px;
							text-align: center;
							text-decoration: none;
							display: inline-block;
							font-size: 16px;
							margin: 4px 2px;
							cursor: pointer;" > Go to Profile 👨‍💻 </button>
						
						</td>
					</tr> 
					""")))}),format.raw/*288.7*/("""
			
			  
			  """),format.raw/*291.6*/("""</tbody> 
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
	  padding: 10px;" onclick="topFunction()" id="myBtn" title="Go to top"> ⬆ Back to Details</button>

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
	padding: 5px;" onclick="window.location.href='/'" title="Go Back"> ⬅ Back </button>

  
</section>
<script>
	//Get the button
	var mybutton = document.getElementById("myBtn");
	
	// When the user scrolls down 20px from the top of the document, show the button
	window.onscroll = function() """),format.raw/*330.31*/("""{"""),format.raw/*330.32*/("""scrollFunction()"""),format.raw/*330.48*/("""}"""),format.raw/*330.49*/(""";
	
	function scrollFunction() """),format.raw/*332.28*/("""{"""),format.raw/*332.29*/("""
	  """),format.raw/*333.4*/("""if (document.body.scrollTop > 150 || document.documentElement.scrollTop > 150) """),format.raw/*333.83*/("""{"""),format.raw/*333.84*/("""
		"""),format.raw/*334.3*/("""mybutton.style.display = "block";
	  """),format.raw/*335.4*/("""}"""),format.raw/*335.5*/(""" """),format.raw/*335.6*/("""else """),format.raw/*335.11*/("""{"""),format.raw/*335.12*/("""
		"""),format.raw/*336.3*/("""mybutton.style.display = "none";
	  """),format.raw/*337.4*/("""}"""),format.raw/*337.5*/("""
	"""),format.raw/*338.2*/("""}"""),format.raw/*338.3*/("""
	
	"""),format.raw/*340.2*/("""// When the user clicks on the button, scroll to the top of the document
	function topFunction() """),format.raw/*341.25*/("""{"""),format.raw/*341.26*/("""
	  """),format.raw/*342.4*/("""document.body.scrollTop = 0;
	  document.documentElement.scrollTop = 0;
	"""),format.raw/*344.2*/("""}"""),format.raw/*344.3*/("""
	
	"""),format.raw/*346.2*/("""//When Commits is Clicked 
	function onCommitsClicked() """),format.raw/*347.30*/("""{"""),format.raw/*347.31*/("""
	 """),format.raw/*348.3*/("""//Display Loader
		var commitLoader = document.getElementById("CommitsLoading");	
		commitLoader.style.display = "block";	
		window.location.href='/repos/"""),_display_(/*351.33*/Details/*351.40*/.ownerName),format.raw/*351.50*/("""/"""),_display_(/*351.52*/Details/*351.59*/.repoName),format.raw/*351.68*/("""/commits';
	"""),format.raw/*352.2*/("""}"""),format.raw/*352.3*/("""
	
	"""),format.raw/*354.2*/("""</script>"""))
      }
    }
  }

  def render(Details:Models.RepositoryProfile): play.twirl.api.HtmlFormat.Appendable = apply(Details)

  def f:((Models.RepositoryProfile) => play.twirl.api.HtmlFormat.Appendable) = (Details) => apply(Details)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/repodetails.scala.html
                  HASH: 8fa46b0ad51fa506be231387bc489f642e6b9fa2
                  MATRIX: 931->1|1061->36|1091->40|1573->495|1589->502|1619->511|2561->1426|2577->1433|2607->1442|2636->1443|2861->1641|2877->1648|2908->1658|3122->1845|3138->1852|3168->1861|3423->2089|3439->2096|3472->2108|3676->2285|3692->2292|3721->2300|3915->2467|3931->2474|3957->2479|3986->2480|4249->2716|4265->2723|4292->2729|4495->2905|4511->2912|4538->2918|4732->3085|4748->3092|4775->3098|5295->3591|5311->3598|5344->3610|5864->4103|5917->4140|5956->4141|5995->4152|6190->4319|6217->4324|6247->4325|6296->4343|6332->4352|7488->5480|7505->5487|7536->5496|8687->6619|8704->6626|8744->6643|8775->6644|9487->7329|9535->7360|9575->7361|9610->7368|9764->7494|9780->7499|9815->7511|9950->7618|9966->7623|10000->7634|10135->7741|10151->7746|10191->7763|10222->7764|10379->7892|10395->7897|10429->7908|10460->7909|10510->7930|10526->7935|10560->7946|10624->7979|10671->7998|11748->9048|11804->9087|11844->9088|11879->9095|12044->9231|12067->9243|12111->9264|12142->9265|12315->9410|12338->9422|12377->9438|12512->9545|12535->9557|12572->9571|12603->9572|12738->9679|12761->9691|12809->9716|13014->9893|13036->9905|13074->9921|13461->10277|13508->10296|14479->11238|14509->11239|14554->11255|14584->11256|14646->11289|14676->11290|14709->11295|14817->11374|14847->11375|14879->11379|14945->11417|14974->11418|15003->11419|15037->11424|15067->11425|15099->11429|15164->11466|15193->11467|15224->11470|15253->11471|15287->11477|15414->11575|15444->11576|15477->11581|15580->11656|15609->11657|15643->11663|15729->11720|15759->11721|15791->11725|15977->11883|15994->11890|16026->11900|16056->11902|16073->11909|16104->11918|16145->11931|16174->11932|16208->11938
                  LINES: 27->1|32->1|34->3|45->14|45->14|45->14|65->34|65->34|65->34|65->34|68->37|68->37|68->37|71->40|71->40|71->40|77->46|77->46|77->46|80->49|80->49|80->49|83->52|83->52|83->52|83->52|88->57|88->57|88->57|91->60|91->60|91->60|94->63|94->63|94->63|110->79|110->79|110->79|127->96|127->96|127->96|128->97|128->97|128->97|128->97|129->98|130->99|184->153|184->153|184->153|222->191|222->191|222->191|222->191|247->216|247->216|247->216|248->217|249->218|249->218|249->218|251->220|251->220|251->220|253->222|253->222|253->222|253->222|255->224|255->224|255->224|255->224|255->224|255->224|255->224|257->226|260->229|292->261|292->261|292->261|293->262|294->263|294->263|294->263|294->263|296->265|296->265|296->265|298->267|298->267|298->267|298->267|300->269|300->269|300->269|305->274|305->274|305->274|319->288|322->291|361->330|361->330|361->330|361->330|363->332|363->332|364->333|364->333|364->333|365->334|366->335|366->335|366->335|366->335|366->335|367->336|368->337|368->337|369->338|369->338|371->340|372->341|372->341|373->342|375->344|375->344|377->346|378->347|378->347|379->348|382->351|382->351|382->351|382->351|382->351|382->351|383->352|383->352|385->354
                  -- GENERATED --
              */
          