
package models

import scalikejdbc.WrappedResultSet
import skinny.orm.{ SkinnyCRUDMapper, SkinnyMapper }

case class User(id: Int, email: String, password: String)

object User extends SkinnyCRUDMapper[User] {
  override lazy val defaultAlias = createAlias("u")
  override lazy val tableName = "user"

  override def extract(rs: WrappedResultSet, n: scalikejdbc.ResultName[User]): User = new User(
    id = rs.get(n.id),
    email = rs.get(n.email),
    password = rs.get(n.password)
  )
}

