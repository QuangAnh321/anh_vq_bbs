package DBTesting

import scalikejdbc.ConnectionPool
import scalikejdbc._
import config._
import play.api.db.{ Database, Databases }
import play.api.db.evolutions._

trait DBSettingTest {
  val driver = "com.mysql.jdbc.Driver"
  val url = "jdbc:mysql://127.0.0.1:3306/anh_vq_bbs"
  val username = "root"
  val password = "3574687a@"
  val database = Databases(
    driver = driver,
    url = url,
    name = "default",
    config = Map(
      "username" -> username,
      "password" -> password))

  def initTestDB(): Unit = {
    ConnectionPool.singleton(url, username, password)
    Evolutions.applyEvolutions(database)
  }

}
