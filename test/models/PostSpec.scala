package models

import org.specs2.mutable.Specification

class PostSpec extends Specification with DBTesting.DBSettingTest {
  val postDAO = new PostDAO
  initTestDB()
  "PostDao" should {
    "getAll() return a List with size greater than or equal to 1" in {
      val postList = postDAO.getAll().get
      postList.size should_== 1
    }
  }
}
