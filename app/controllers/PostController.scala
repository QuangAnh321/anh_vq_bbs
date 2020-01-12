package controllers

import form.PostForm
import javax.inject.Inject
import models.Post
import play.api.mvc.{BaseController, ControllerComponents}
import repository.PostRepository

class PostController @Inject()(controllerComponents: ControllerComponents, postRepository: PostRepository, postForm: PostForm) extends BaseController {

  def listPost() = Action {
    val startContentIndex = 0;
    val endContentIndex = 3;
    postRepository.getAll().map((allPosts: List[Post]) => Ok(views.html.allPosts(allPosts, startContentIndex, endContentIndex))).get
  }

  def getPostById(id: Int) = Action {
    postRepository.getById(id).map((post: Option[Post]) => Ok(views.html.singlePost(post))).get
  }

  def showCreatePostForm() = Action {
    val form =  postForm.createPostForm
    Ok(views.html.createPost(form))
  }
  def createPost() = Action { implicit request =>
    postForm.createPostForm.bindFromRequest().fold(
      hasError => {

      },
      success => {

      }
    )
  }
}
