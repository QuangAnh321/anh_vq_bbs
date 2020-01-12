package controllers

import play.api.test._
import play.api.test.Helpers._
import models.{Post, PostDAO}
import org.joda.time.DateTime
import org.specs2.mock.Mockito
import org.specs2.mutable._
import repository.PostRepository

import scala.util.Try

class PostControllerSpec extends Specification with Mockito with DBTesting.DBSettingTest {

  val postRepository = mock[PostRepository]
  val controller = new PostController(stubControllerComponents(), postRepository)
  "PostController listPosts GET" should {

    "render the allPosts page from a new instance of controller" in {

      val time: DateTime = DateTime.now()
      val post = new Post(1, "a", "bcd", time)
      postRepository.getAll() returns Try(List(Post(1, "a", "a", time)))
      val listPosts = controller.listPost().apply(FakeRequest(GET, "/listPosts"))
      status(listPosts) mustEqual  OK
      contentType(listPosts) mustEqual  Some("text/html")
    }

  }
}
