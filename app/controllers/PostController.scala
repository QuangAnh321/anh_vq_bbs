package controllers

import form.PostForm
import javax.inject.Inject
import models.Post
import play.api.mvc.{ BaseController, ControllerComponents }
import repository.PostRepository

class PostController @Inject() (val controllerComponents: ControllerComponents, val postRepository: PostRepository, val postForm: PostForm) extends BaseController {

  def listPost() = Action {
    val startContentIndex = 0;
    val endContentIndex = 3;
    postRepository.getAll().map((allPosts: List[Post]) => Ok(views.html.allPosts(allPosts, startContentIndex, endContentIndex))).get
  }
  def getPostById(id: Int) = Action {
    try {
      val post = postRepository.getById(id).get
      Ok(views.html.singlePost(post))
    } catch {
      case ex: NoSuchElementException => Redirect(routes.HomeController.error())
    }

  }

  def showCreatePostForm() = Action {
    val form = postForm.createPostForm
    Ok(views.html.createPost(form))
  }
  //  def createPost() = Action { implicit request =>
  //    postForm.createPostForm.bindFromRequest().fold(
  //      hasError => {
  //
  //      },
  //      success => {
  //
  //      }
  //    )
  //  }
}
