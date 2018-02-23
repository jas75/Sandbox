package controllers

import javax.inject._
import play.api.mvc._


@Singleton
class RestApiController @Inject()  extends Controller {

  def profile = Action {
    Ok()
  }

}
