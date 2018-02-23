package controllers

import javax.inject._
import play.api.mvc._


@Singleton
class AuthController @Inject()  extends Controller {

  def profile = Action {
    Ok()
  }

  def startSignUp = Action {
    Ok()
  }

  def handleStartSignUp = Action {
    Ok()
  }



}
