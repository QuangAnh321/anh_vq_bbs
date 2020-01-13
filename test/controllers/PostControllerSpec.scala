package controllers

import form.PostForm
import play.api.test._
import play.api.test.Helpers._
import models.Post
import org.joda.time.DateTime
import org.specs2.mock.Mockito
import org.specs2.mutable._
import repository.PostRepository

import scala.util.Try

class PostControllerSpec extends Specification with Mockito with DBTesting.DBSettingTest {

  val postRepository = mock[PostRepository]
  val postForm = mock[PostForm]
  val controller = new PostController(stubControllerComponents(), postRepository, postForm)
  "PostController listPosts GET" should {

    "render the allPosts page from a new instance of controller" in {

      val time: DateTime = DateTime.now()
      val post = new Post(1, "a", "bcdffffff", "abc@gmail.com", time)
      postRepository.getAll() returns Try(List(post))
      val listPosts = controller.listPost().apply(FakeRequest(GET, "/listPosts"))
      status(listPosts) mustEqual  OK
      contentType(listPosts) mustEqual  Some("text/html")
    }

  }
  "PostController post/:id GET" should {
    "render the post with the id: id from a new instance of controller" in {
      val postRepository = mock[PostRepository]
      val postForm = mock[PostForm]
      val controller = new PostController(stubControllerComponents(), postRepository, postForm)
      val time: DateTime = DateTime.now()
      val post = new Post(1, "a", "bcdffffff", "abc@gmail.com", time)
      postRepository.getById(1) returns Option(post)
      val postResult = controller.getPostById(1).apply(FakeRequest(GET, "/post/1"))
      status(postResult) mustEqual  OK
      contentType(postResult) mustEqual  Some("text/html")
    }
  }
}
