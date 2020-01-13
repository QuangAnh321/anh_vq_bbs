package models

import org.specs2.mutable.Specification
import repository.PostRepository

class PostSpec extends Specification with DBTesting.DBSettingTest {
  val postRepository = new PostRepository
  initTestDB()
  "PostRepository" should {
    "getAll() return a List with size greater than or equal to 1" in {
      val postList = postRepository.getAll().get
      postList.size should_== 1
    }
  }
  "PostRepository" should {
    "getById(id) return a post with the corresponding id" in {
      val post = postRepository.getById(1).get
      post.id must_===(1)
      post.content must_!==("")
      post.title must_!==("")
    }
  }
  "PostRepository" should {
    "getById(id) throw an exception" in {
      postRepository.getById(2) must throwA[Exception]
    }
  }
}
