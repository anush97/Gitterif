// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_1: controllers.HomeController,
  // @LINE:11
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_1: controllers.HomeController,
    // @LINE:11
    Assets_0: controllers.Assets
  ) = this(errorHandler, HomeController_1, Assets_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ws""", """controllers.HomeController.ws"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """wsTopic""", """controllers.HomeController.wsTopic"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """username<[^/]+>""", """controllers.HomeController.users(username:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """topic/""" + "$" + """topicname<[^/]+>""", """controllers.HomeController.topics(topicname:String, request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """repo/""" + "$" + """query<[^/]+>/""" + "$" + """id<[^/]+>""", """controllers.HomeController.repoProfileRequestHandler(query:String, id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """statistics/""", """controllers.HomeController.issues()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """repos/""" + "$" + """ownerName<[^/]+>/""" + "$" + """repoName<[^/]+>/commits""", """controllers.HomeController.commits(ownerName:String, repoName:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.index(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_ws1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ws")))
  )
  private[this] lazy val controllers_HomeController_ws1_invoker = createInvoker(
    HomeController_1.ws,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "ws",
      Nil,
      "GET",
      this.prefix + """ws""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_wsTopic2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("wsTopic")))
  )
  private[this] lazy val controllers_HomeController_wsTopic2_invoker = createInvoker(
    HomeController_1.wsTopic,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "wsTopic",
      Nil,
      "GET",
      this.prefix + """wsTopic""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Assets_versioned3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned3_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Assets_at4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at4_invoker = createInvoker(
    Assets_0.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_HomeController_users5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("username", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_users5_invoker = createInvoker(
    HomeController_1.users(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "users",
      Seq(classOf[String]),
      "GET",
      this.prefix + """user/""" + "$" + """username<[^/]+>""",
      """ All Page Routes""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_HomeController_topics6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("topic/"), DynamicPart("topicname", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_topics6_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.topics(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "topics",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """topic/""" + "$" + """topicname<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_HomeController_repoProfileRequestHandler7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("repo/"), DynamicPart("query", """[^/]+""",true), StaticPart("/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_repoProfileRequestHandler7_invoker = createInvoker(
    HomeController_1.repoProfileRequestHandler(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "repoProfileRequestHandler",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """repo/""" + "$" + """query<[^/]+>/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_HomeController_issues8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("statistics/")))
  )
  private[this] lazy val controllers_HomeController_issues8_invoker = createInvoker(
    HomeController_1.issues(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "issues",
      Nil,
      "GET",
      this.prefix + """statistics/""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_HomeController_commits9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("repos/"), DynamicPart("ownerName", """[^/]+""",true), StaticPart("/"), DynamicPart("repoName", """[^/]+""",true), StaticPart("/commits")))
  )
  private[this] lazy val controllers_HomeController_commits9_invoker = createInvoker(
    HomeController_1.commits(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "commits",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """repos/""" + "$" + """ownerName<[^/]+>/""" + "$" + """repoName<[^/]+>/commits""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(
          req => HomeController_1.index(req))
      }
  
    // @LINE:7
    case controllers_HomeController_ws1_route(params@_) =>
      call { 
        controllers_HomeController_ws1_invoker.call(HomeController_1.ws)
      }
  
    // @LINE:8
    case controllers_HomeController_wsTopic2_route(params@_) =>
      call { 
        controllers_HomeController_wsTopic2_invoker.call(HomeController_1.wsTopic)
      }
  
    // @LINE:11
    case controllers_Assets_versioned3_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned3_invoker.call(Assets_0.versioned(path, file))
      }
  
    // @LINE:12
    case controllers_Assets_at4_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at4_invoker.call(Assets_0.at(path, file))
      }
  
    // @LINE:16
    case controllers_HomeController_users5_route(params@_) =>
      call(params.fromPath[String]("username", None)) { (username) =>
        controllers_HomeController_users5_invoker.call(HomeController_1.users(username))
      }
  
    // @LINE:17
    case controllers_HomeController_topics6_route(params@_) =>
      call(params.fromPath[String]("topicname", None)) { (topicname) =>
        controllers_HomeController_topics6_invoker.call(
          req => HomeController_1.topics(topicname, req))
      }
  
    // @LINE:18
    case controllers_HomeController_repoProfileRequestHandler7_route(params@_) =>
      call(params.fromPath[String]("query", None), params.fromPath[String]("id", None)) { (query, id) =>
        controllers_HomeController_repoProfileRequestHandler7_invoker.call(HomeController_1.repoProfileRequestHandler(query, id))
      }
  
    // @LINE:19
    case controllers_HomeController_issues8_route(params@_) =>
      call { 
        controllers_HomeController_issues8_invoker.call(HomeController_1.issues())
      }
  
    // @LINE:20
    case controllers_HomeController_commits9_route(params@_) =>
      call(params.fromPath[String]("ownerName", None), params.fromPath[String]("repoName", None)) { (ownerName, repoName) =>
        controllers_HomeController_commits9_invoker.call(HomeController_1.commits(ownerName, repoName))
      }
  }
}
