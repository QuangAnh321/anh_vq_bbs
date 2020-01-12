package controllers

import javax.inject.Inject
import models.User
import play.api.mvc.{ BaseController, ControllerComponents }

class UserController @Inject() (val controllerComponents: ControllerComponents) extends BaseController {

  def listUser() = Action {
    val allUsers = User.findAll()
    Ok(views.html.showUser(allUsers))
  }
}
